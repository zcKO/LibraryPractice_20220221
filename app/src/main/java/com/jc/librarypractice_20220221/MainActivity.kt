package com.jc.librarypractice_20220221

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpEvents()
        setValues()

    }

    fun setUpEvents() {

//        전화걸기
        btnCall.setOnClickListener {

            // 실제로 권한을 물어본다.
            TedPermission.create()
                .setPermissionListener(getPermissionListener())
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }


//        버튼 이외의, TextView, ImageView, LinearLayout 등등 setOnClickListener 로 이벤트 처리가 가능하다.
        imgProfile.setOnClickListener {
//            사진을 크게 보는 액티비티로 이동
            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)
        }

    }

    fun setValues() {

    }

    fun getPermissionListener(): PermissionListener {
//        권한 승인 여부에 따른, 행동 방안을 작성해서 pl 변수에 담아 둔다.
        val permissionListener = object : PermissionListener {
            override fun onPermissionGranted() {
//                승인이 OK 일 때 할 행동
                val myUri = Uri.parse("tel:0103333777")
                val myIntent = Intent(Intent.ACTION_CALL, myUri)
                startActivity(myIntent)
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                거절 되었을 때 할 행동
                Toast.makeText(this@MainActivity, "권한이 거절되어, 통화가 불가능 합니다.", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        return permissionListener

    }


}