package com.example.quiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*

class Game2Activity : AppCompatActivity() {

    var questions = arrayListOf(
        "Что это за замок?"
    )

    var ansvers = arrayListOf(
        arrayListOf("Дол Гулдур", "Гондор", "Изенгард")
    )

    var right = arrayListOf(1)

    var levCounter = 1
    var rightAnsvers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2)
        loadLevel(levCounter)

        rightAnsvers = intent.extras["count"] as Int

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
                    var intent = Intent(this@Game2Activity, ResultActivity::class.java)
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
