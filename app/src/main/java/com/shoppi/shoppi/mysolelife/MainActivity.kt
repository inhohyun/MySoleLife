package com.shoppi.shoppi.mysolelife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.shoppi.shoppi.mysolelife.auth.IntroActivity

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.logoutBtn).setOnClickListener {
        auth.signOut()
            val intent = Intent(this, IntroActivity::class.java)
            //인텐트 후 기존의 정보를 날림(뒤로가기 시 회원가입으로 돌아오지 않도록)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}