package com.example.chapterempattopic3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chapterempattopic3.databinding.ItemProductBinding

class ProductAdapter(var listProduct: ArrayList<DataProduct>, val btnklik: MainActivity):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindproduct(itemProduct : DataProduct, btnklik: MainActivity){
            binding.product = itemProduct
            binding.btnklikdetail = btnklik
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindproduct(listProduct[position], btnklik)
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    fun setDataProduct(itemData : ArrayList<DataProduct>){
        this.listProduct = itemData
    }

    interface ItemClickListener{
        fun onItemClickListener(detail : DataProduct)
    }
}