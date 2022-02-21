package com.jc.librarypractice_20220221

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpEvents()
        setValues()

    }

    fun setUpEvents() {

//        버튼 이외의, TextView, ImageView, LinearLayout 등등 setOnClickListener 로 이벤트 처리가 가능하다.
        imgProfile.setOnClickListener {
//            사진을 크게 보는 액티비티로 이동
            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)
        }

    }

    fun setValues() {

    }

}