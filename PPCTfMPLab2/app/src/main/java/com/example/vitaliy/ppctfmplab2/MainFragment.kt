package com.example.vitaliy.ppctfmplab2

import android.app.Fragment
import android.os.Bundle
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.main_fragment, container, false)
    }

    fun setResult(res: String){
        textView.text = res
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}