package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    private var name:String?=null
    private var score:Int=0

    private var currentPosition: Int = 1
    private var questionList: ArrayList<QuestionData>? = null
    private var selectedOption: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        //setData.getQuestion()

        name = intent.getStringExtra(setData.name)


        questionList = setData.getQuestion()
        setQuestion()

        opt_1.setOnClickListener {

            selectedOptionStyle(opt_1, 1)

        }
        opt_2.setOnClickListener {

            selectedOptionStyle(opt_2, 2)

        }
        opt_3.setOnClickListener {

            selectedOptionStyle(opt_3, 3)

        }
        opt_4.setOnClickListener {

            selectedOptionStyle(opt_4, 4)

        }

        submit.setOnClickListener {

            if (selectedOption != 0) {
                var question = questionList!![currentPosition - 1]
                if (selectedOption != question.correctAns) {
                    setColor(selectedOption, R.drawable.wrong_question_option)
                }
                else
                {
                    score++
                }
                setColor(question.correctAns, R.drawable.correct_question_option)
                if (currentPosition == questionList!!.size) {
                    submit.text = "Finish"
                } else {
                    submit.text = "Go To Next"
                }
            } else {
                currentPosition++
                when {
                    currentPosition <= questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        var intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(setData.name,name.toString())
                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("Total size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }

            }
            selectedOption = 0


        }


    }

    private fun setColor(opt: Int, color: Int) {
        when (opt) {
            1 -> opt_1.background = ContextCompat.getDrawable(this, color)
            2 -> opt_2.background = ContextCompat.getDrawable(this, color)
            3 -> opt_3.background = ContextCompat.getDrawable(this, color)
            4 -> opt_4.background = ContextCompat.getDrawable(this, color)
        }
    }

    private fun setQuestion() {
        val question = questionList!![currentPosition - 1]

        setOptionStyle()

        progressBar.progress = currentPosition
        progressBar.max = questionList!!.size
        progress_text.text = "${currentPosition}/${questionList!!.size}"
        questionTv.text = question.question
        opt_1.text = question.optionOne
        opt_2.text = question.optionTwo
        opt_3.text = question.optionThree
        opt_4.text = question.optionFour
    }

    fun setOptionStyle() {
        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0, opt_1)
        optionList.add(1, opt_2)
        optionList.add(2, opt_3)
        optionList.add(3, opt_4)

        for (op in optionList) {
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView, opt: Int) {
        setOptionStyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}