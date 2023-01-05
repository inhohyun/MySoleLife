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
import com.shoppi.shoppi.mysolelife.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        auth = Firebase.auth

        binding.loginBtn.setOnClickListener {
            val email = binding.emailArea.text.toString()
            val password = binding.passwordArea.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                      Toast.makeText(this,"로그인 성공", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, MainActivity::class.java)
                        //인텐트 후 기존의 정보를 날림(뒤로가기 시 회원가입으로 돌아오지 않도록)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)


                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this,"로그인 실패", Toast.LENGTH_SHORT).show()

                    }
                }
        }
    }
}