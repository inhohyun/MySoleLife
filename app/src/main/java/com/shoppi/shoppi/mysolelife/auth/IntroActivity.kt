package com.shoppi.shoppi.mysolelife.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.shoppi.shoppi.mysolelife.MainActivity
import com.shoppi.shoppi.mysolelife.R
import com.shoppi.shoppi.mysolelife.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    private lateinit var binding : ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)
        auth = Firebase.auth

        //로그인 버튼 클릭시
        binding.loginBtn.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        //회원가입 버튼 클릭시
        binding.JoinBtn.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }
        //비회원 로그인 클릭시
        binding.noAccountBtn.setOnClickListener {
            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, MainActivity::class.java)
                        //인텐트 후 기존의 정보를 날림(뒤로가기 시 회원가입으로 돌아오지 않도록)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()

                    }
                }


        }
    }
}