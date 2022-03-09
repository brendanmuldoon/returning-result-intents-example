package com.example.returning_result_intents_example

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.returning_result_intents_example.databinding.ActivityOtherMyBinding

class MyOtherActivity : AppCompatActivity() {

    private lateinit var binding : ActivityOtherMyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOtherMyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val message = intent.getStringExtra(Constants.MESSAGE.name)
        binding.showMessageTextView.text = message
    }

    fun returnToMainActivity(view: View){
        val thisIntent = Intent(this,
            MyOtherActivity::class.java).apply {
            putExtra(Constants.FIRST_NAME.name,
                binding.firstNameEditText.text.toString())
            putExtra(Constants.SURNAME.name,
                binding.surnameEditText.text.toString())
        }
        setResult(Activity.RESULT_OK, thisIntent)
        finish()
    }


}