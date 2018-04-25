package com.example.vitaliy.ppctfmplab2

import android.app.Fragment
import android.os.Bundle
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.select_fragment.*

class SelectFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.select_fragment, container, false)
    }

    fun getResult() :String{
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

    companion object {
        fun newInstance() = SelectFragment()
    }
}