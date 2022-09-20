package com.example.chapterempattopic3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class Activity_detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getSerializableExtra("detail") as DataProduct
        tvDproduk.setImageResource(data.imgProduct)
        tvDNProduk.text = data.NameProduct
        tvhargaDProduct.text = data.hargaProduct
        tvdekripsi.text = data.descProduct

        tvbtnbeli.setOnClickListener {
            var intent = Intent()
            intent.setAction(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "halo, saya tertarik dengan produk "+data.NameProduct+" harga "+data.hargaProduct+"apa kah masih ada ?" )
            intent.setType("text/plain")
            intent.setPackage("com.whatsapp")
            startActivity(Intent.createChooser(intent,""))
            startActivity(intent)
        }
    }
}