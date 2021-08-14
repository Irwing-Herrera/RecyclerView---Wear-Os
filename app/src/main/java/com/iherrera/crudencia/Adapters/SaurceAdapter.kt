package com.iherrera.crudencia.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iherrera.crudencia.Interfaces.OnClicListener
import com.iherrera.crudencia.Models.Saurce
import com.iherrera.crudencia.R
import com.iherrera.crudencia.databinding.ActivitySaucerItemBinding

class SaurceAdapter(
    private var saurces: MutableList<Saurce>,
    private var listener: OnClicListener
): RecyclerView.Adapter<SaurceAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ActivitySaucerItemBinding.bind(view)

        fun setListner(saurce: Saurce) {
            binding.root.setOnClickListener {
                listener.onClick(saurce)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(
            R.layout.activity_saucer_item,
            parent,
            false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val saurce = saurces.get(position)

        with(holder) {
            setListner(saurce)
            binding.nameTextView.text = saurce.name
            binding.moneyTextView.text = "$ ${saurce.price}"
        }
    }

    override fun getItemCount(): Int = saurces.size
}