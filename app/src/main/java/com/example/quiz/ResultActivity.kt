package com.example.quiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var count = intent.extras["count"]

        countText.text = count.toString() + "/10"

        when (count) {
            in 0..4 -> resText.text = "Плохо"
            in 5..7 -> resText.text = "Нормально"
            in 8..9 -> resText.text = "Хорошо"
            10 -> resText.text = "Великолепно"
        }

        btnReplay.setOnClickListener {
            startActivity(Intent(this@ResultActivity, GameActivity::class.java))
        }
        btnOutRes.setOnClickListener { this.finish() }
    }
}
