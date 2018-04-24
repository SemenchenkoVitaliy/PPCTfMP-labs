package com.example.vitaliy.ppctfmplab2

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonOK.setOnClickListener {
            textView.text = getText()
        }
    }

    private fun getText(): String {
        var str = "Result:\n"
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
        return str
    }
}

