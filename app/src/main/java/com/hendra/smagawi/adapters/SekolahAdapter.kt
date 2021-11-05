package com.hendra.smagawi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hendra.smagawi.databinding.ListBerandaBinding
import com.hendra.smagawi.models.Sekolah

class SekolahAdapter(private val listBeranda : ArrayList<Sekolah>,
                        private val listener : onSekolahClick): RecyclerView.Adapter<SekolahAdapter.SekolahViewholder>() {

    inner class SekolahViewholder(val binding: ListBerandaBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SekolahViewholder {
        return SekolahViewholder(ListBerandaBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SekolahViewholder, position: Int) {
        holder.binding.apply {
            Glide.with(holder.itemView.context)
                    .load(listBeranda[position].image)
                    .into(holder.binding.Tumbnail)

            Title.text = listBeranda[position].name
        }
        holder.itemView.setOnClickListener {
            listener.onItemCick(listBeranda[position])
        }
    }

    override fun getItemCount(): Int {
        return listBeranda.size
    }

    interface onSekolahClick{
        fun onItemCick(sekolah : Sekolah)
    }
}