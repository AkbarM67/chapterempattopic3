package com.example.chapterempattopic3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapterempattopic3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProductAdapter.ItemClickListener {

    lateinit var vmProduct: ViewModelProdut
    lateinit var adapterProdut: ProductAdapter
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // init viewadapter dan adapter
        vmProduct = ViewModelProvider(this).get(ViewModelProdut::class.java)
        adapterProdut = ProductAdapter(ArrayList(), this)
        //observe livedata
        vmProduct.getProduct()
        vmProduct.product.observe(this, Observer { adapterProdut.setDataProduct(it as ArrayList<DataProduct>)
        })

       binding.tvproduck.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.tvproduck.adapter = adapterProdut
    }

    override fun onItemClickListener(detail: DataProduct) {
        var pindah = Intent(this, Activity_detail::class.java)
        pindah.putExtra("detail", detail)
        startActivity(pindah)
    }

}