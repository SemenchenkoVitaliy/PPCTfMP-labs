package com.example.vitaliy.ppctfmplab2

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = fragmentManager
        val transaction = manager.beginTransaction()

        val selectFragment : Fragment = SelectFragment.newInstance()
        transaction.replace(R.id.frameLayout, selectFragment)

        val mainFragment : Fragment = MainFragment.newInstance()
        transaction.replace(R.id.frameLayout2, mainFragment)

        transaction.commit()

        buttonOK.setOnClickListener {
            var fragment1 = fragmentManager.findFragmentById(R.id.frameLayout) as SelectFragment
            var fragment2 = fragmentManager.findFragmentById(R.id.frameLayout2) as MainFragment
            fragment2.setResult(fragment1.getResult())
        }
    }
}