package com.example.birthdaywishingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    fun createWishingpage(view: View) {

        val name= NameInputt.editableText.toString()
        Toast.makeText(this,"Creating for you $name", Toast.LENGTH_LONG).show()

    }    }
}
