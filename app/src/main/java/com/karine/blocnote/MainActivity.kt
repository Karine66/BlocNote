package com.karine.blocnote

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.karine.blocnote.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    var fullText = ""
    val SETTINGS_FILE_NAME = "com.karine.blocnote"
    val FULLTEXT_SETTINGS_KEY = "fullText"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        val preferencesReader = getSharedPreferences( SETTINGS_FILE_NAME, MODE_PRIVATE)
        fullText = preferencesReader.getString(FULLTEXT_SETTINGS_KEY, "").toString()
        mainBinding.fullTextView.text = fullText
    }

    @SuppressLint("SetTextI18n")
    fun addButtonTouched(button: View) {
        val userInput = mainBinding.userField.text
        fullText = "$fullText\n$userInput"
        saveTextToSharedPref()
        mainBinding.fullTextView.text = fullText
        mainBinding.userField.text = null
    }

    fun saveTextToSharedPref() {
        val sharedPreferences = getSharedPreferences(SETTINGS_FILE_NAME, MODE_PRIVATE).edit()
        sharedPreferences.putString(FULLTEXT_SETTINGS_KEY, fullText)
        sharedPreferences.apply()
    }
}

