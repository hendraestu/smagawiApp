package com.hendra.smagawi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.hendra.smagawi.adapters.SekolahAdapter
import com.hendra.smagawi.databinding.ActivityMainBinding
import com.hendra.smagawi.models.Sekolah
import com.hendra.smagawi.models.DataSekolah

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var sekolahAdapter: SekolahAdapter
    private var listBerandaSekolah : ArrayList<Sekolah> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showSekolahRv()
        supportActionBar?.hide()
    }

    fun showSekolahRv(){
        listBerandaSekolah.addAll(DataSekolah.listBeranda)
        sekolahAdapter = SekolahAdapter(listBerandaSekolah, object : SekolahAdapter.onSekolahClick{
            override fun onItemCick(sekolah: Sekolah) {
                startActivity(Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra("nama", sekolah.name)
                    putExtra("gambar", sekolah.image)
                    putExtra("desc", sekolah.desc)
                })
            }
        })
        binding.RVSekolah.apply {
            val lm = GridLayoutManager(this@MainActivity, 2)
            layoutManager = lm
            adapter = sekolahAdapter
        }
    }
}