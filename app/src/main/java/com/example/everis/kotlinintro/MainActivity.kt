package com.example.everis.kotlinintro

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.everis.kotlinintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /* findViewById<Button>(R.id.btnDone).setOnClickListener {
             addNickname(it)
         }
         */
        binding.btnDone.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        //val etNickname = findViewById<EditText>(R.id.etNickName)
        //val tvNickname = findViewById<TextView>(R.id.tvNickName)
        binding.apply {
            binding.tvNickName.text = binding.etNickName.text
            binding.etNickName.visibility = View.GONE
            binding.btnDone.visibility = View.GONE
            binding.tvNickName.visibility = View.VISIBLE
        }
        /*
        tvNickname.text = etNickname.text
        etNickname.visibility = View.GONE
        view.visibility = View.GONE
        tvNickname.visibility = View.VISIBLE
        */


        //Ocultamos el teclado
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
