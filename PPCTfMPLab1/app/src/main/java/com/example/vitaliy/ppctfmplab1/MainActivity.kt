package com.example.vitaliy.ppctfmplab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onBtnOkClick(v: View){
        var str: String = "Result:\n"
        if (checkBox.isChecked){
            str += "Area\n"
        }
        if (checkBox2.isChecked) {
            str += "Perimeter\n"
        }
        if (radioButton.isChecked) {
            str += "Circle"
        }
        if (radioButton2.isChecked) {
            str += "Square"
        }
        if (radioButton4.isChecked) {
            str += "Triangle"
        }
        textView.text = str
    }

}
