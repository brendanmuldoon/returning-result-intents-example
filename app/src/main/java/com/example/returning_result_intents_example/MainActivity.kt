package com.example.returning_result_intents_example

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Toast
import com.example.returning_result_intents_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun displayOtherActivity(view : View) {
        val nextIntent = Intent(this,
        MyOtherActivity::class.java).apply {
            putExtra(Constants.MESSAGE.name, "Hello From Main")
        }
        startActivityForResult(nextIntent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val firstName = data?.getStringExtra(Constants.FIRST_NAME.name)
        val surname = data?.getStringExtra(Constants.SURNAME.name)


        if (resultCode== Activity.RESULT_OK && (firstName!=null && surname!=null)) {
            var name = "$firstName $surname"
            displayToast(name,
                Toast.LENGTH_SHORT)
        }
        else{
            displayToast("Nothing to display",
                Toast.LENGTH_SHORT)
        }

    }

    private fun displayToast(text: String, duration: Int) {
        val message = "Hello $text"
        Toast.makeText(this,
            message,
            duration).show()

    }
}