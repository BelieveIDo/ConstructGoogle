package com.example.constructdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.constructdemo.R
import com.example.constructdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingUtil: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUtil=DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}