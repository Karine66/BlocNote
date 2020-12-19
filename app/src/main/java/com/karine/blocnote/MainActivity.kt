package com.karine.blocnote

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.karine.blocnote.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
    }

    @SuppressLint("SetTextI18n")
    fun addButtonTouched(button: View) {
        val userInput = mainBinding.userField.text
        val existingText =  mainBinding.fullTextView.text
         mainBinding.fullTextView.text ="$existingText\n$userInput"
        mainBinding.userField.text = null
    }
}

