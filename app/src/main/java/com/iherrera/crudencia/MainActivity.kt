package com.iherrera.crudencia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.iherrera.crudencia.Adapters.SaurceAdapter
import com.iherrera.crudencia.Interfaces.OnClicListener
import com.iherrera.crudencia.Models.Saurce
import com.iherrera.crudencia.databinding.ActivityMainBinding

class MainActivity : Activity(), OnClicListener {

    private lateinit var mAdapter: SaurceAdapter
    private lateinit var mGridLayoutManager: GridLayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _setupRecyclerView()

    }

    private fun _setupRecyclerView() {

        val saurces: MutableList<Saurce> = mutableListOf()
        saurces.add(Saurce(name = "Espagueti", price = 34.0))
        saurces.add(Saurce(name = "Camarones", price = 50.5))
        saurces.add(Saurce(name = "Rabioles", price = 70.0))
        saurces.add(Saurce(name = "Pizza", price = 90.0))
        saurces.add(Saurce(name = "Empanadas", price = 5.5))
        saurces.add(Saurce(name = "Hamburguesas", price = 35.5))
        saurces.add(Saurce(name = "Papas", price = 20.0))

        mAdapter = SaurceAdapter(saurces, this)
        mGridLayoutManager = GridLayoutManager(this, 1)

        binding.recyclerContainer.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayoutManager
            adapter = mAdapter
        }
    }

    override fun onClick(saurce: Saurce) {
        Log.i("MainActivity", "Platillo:${saurce.name} con precio de ${saurce.price}")

        val intent = Intent(this, SaurceSelected::class.java)
        intent.putExtra("name", saurce.name)
        intent.putExtra("price", saurce.price.toString())

        startActivity(intent)
    }
}