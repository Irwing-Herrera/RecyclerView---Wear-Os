package com.iherrera.crudencia

import android.app.Activity
import android.os.Bundle
import com.iherrera.crudencia.databinding.ActivitySaurceSelectedBinding

class SaurceSelected : Activity() {

    private lateinit var binding: ActivitySaurceSelectedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySaurceSelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _getIntent()

    }

    private fun _getIntent() {
        val name:String = intent.getStringExtra("name").toString()
        val price:String = intent.getStringExtra("price").toString()

        binding.NameSelectedtextView.text = name
        binding.PriceSelectedTextView.text = "$ ${price}"
    }
}