package com.example.onlinetoursapp.common.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinetoursapp.common.activity.di.DaggerMainActivityComponent
import com.example.onlinetoursapp.common.application.ToursApplication
import com.example.onlinetoursapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding ?: throw NullPointerException("Binding is not initialized")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainActivityComponent.factory().create(ToursApplication.appComponent).inject(this)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}