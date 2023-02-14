package com.shoppi.shoppi.mysolelife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.shoppi.shoppi.mysolelife.auth.IntroActivity

class SplashActivity : AppCompatActivity() { 
    private lateinit var auth: FirebaseAuth

    
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
      // 스플레쉬 화면에서 firebase에 현재 uid 값이 있으면 이미 로그인한 사람이므로 바로 메인화면으로 이동
        if(auth.currentUser?.uid == null){
            Log.d("SplashActivity","null")
            Handler().postDelayed(
                {
                    startActivity(Intent(this, IntroActivity::class.java))
                    finish()
                }, 3000)
        }else{
            Log.d("SplashActivity","not null")
            Handler().postDelayed(
                {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }, 3000)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


    }
}