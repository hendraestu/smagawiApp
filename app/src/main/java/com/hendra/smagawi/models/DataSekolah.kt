package com.hendra.smagawi.models

import com.hendra.smagawi.R

object DataSekolah {

    private val KeteranganName = arrayOf(

    )

    private val KeteranganDesc = arrayOf(

    )

    private val KeteranganImg = arrayOf(

    )


    val listBeranda : ArrayList<Sekolah>
        get() {
            val list = arrayListOf<Sekolah>()
            for (position in KeteranganName.indices){
                val sekolah = Sekolah()
                sekolah.name = KeteranganName[position]
                sekolah.desc = KeteranganDesc[position]
                sekolah.image = KeteranganImg[position]
                list.add(sekolah)
            }
            return list
        }

}