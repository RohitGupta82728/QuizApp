package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        window.requestFeature(Window.FEATURE_NO_TITLE)
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        nextBtn.setOnClickListener {
            if(input.text.toString().isEmpty())
            {
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent = Intent(this,QuestionActivity::class.java)
                intent.putExtra("${setData.name}",input.text.toString())
                startActivity(intent)
                finish()
            }
        }


    }
}