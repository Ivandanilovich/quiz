package com.example.quiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    var questions = arrayListOf(
        "Хоббит, или Туда и ...",
        "Сколько всего существует колец?",
        "Имя главного антагониста трилогии «Властелин Колец»",
        "Имя Горлума до порабощения кольцом?",
        "Кто из участников братства умер во время пути?",
        "Где снимали фильм?",
        "Кто не уплыл с эльфами на Запад?",
        "С кем сражался Гендальф в Мории?",
        "Слуги Саурона?"
    )

    var ansvers = arrayListOf(
        arrayListOf("сюда", "обратно", "навсегда"),
        arrayListOf("20", "11", "1"),
        arrayListOf("Стентур", "Сатурн", "Саурон"),
        arrayListOf("Смеагол", "Гендальф", "Горлум"),
        arrayListOf("Фродо", "Боромир", "Никто"),
        arrayListOf("Сибирь", "Австралия", "Новая Зеландия"),
        arrayListOf("Бильбо", "Сем", "Гендальф"),
        arrayListOf("некромант", "призрак", "балрог"),
        arrayListOf("назгулы", "хоббиты", "говорящие осы")
    )

    var right = arrayListOf(2, 1, 3, 1, 2, 3, 2, 3, 1)

    var levCounter = 1
    var rightAnsvers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        loadLevel(levCounter)

        apply.setOnClickListener {
            var res: Int?
            when (ans.checkedRadioButtonId) {
                v1.id -> res = 1
                v2.id -> res = 2
                v3.id -> res = 3
                else -> res = null
            }
            ans.clearCheck()
            if (res != null) {
                if (res == right[levCounter - 1]) rightAnsvers++
                if (levCounter == right.size) {
                    var intent = Intent(this@GameActivity, Game2Activity::class.java)
                    intent.putExtra("count", rightAnsvers)
                    startActivity(intent)
                } else {
                    loadLevel(++levCounter)
                }
            }
        }
    }

    private fun loadLevel(i: Int) {
        text.text = questions[i - 1]
        v1.text = ansvers[i - 1][0]
        v2.text = ansvers[i - 1][1]
        v3.text = ansvers[i - 1][2]
    }
}
