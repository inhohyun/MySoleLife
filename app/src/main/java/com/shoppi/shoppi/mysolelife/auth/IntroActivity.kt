package com.shoppi.shoppi.mysolelife.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.shoppi.shoppi.mysolelife.R
import com.shoppi.shoppi.mysolelife.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding : ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)


        binding.loginBtn.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.JoinBtn.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }
        binding.noAccountBtn.setOnClickListener {

        }
    }
}