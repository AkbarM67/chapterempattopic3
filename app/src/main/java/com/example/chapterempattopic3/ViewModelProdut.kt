package com.example.chapterempattopic3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProdut : ViewModel() {

    val list = arrayListOf(
        DataProduct("baju", R.drawable.ic_android_black_24dp, "$30", "desripstion"),
        DataProduct("celana", R.drawable.ic_android_black_24dp, "$20", "desripstion"),
        DataProduct("sendal", R.drawable.ic_android_black_24dp, "$12", "desripstion"),

    )



    // bikin livedata
    val product : MutableLiveData<List<DataProduct>> = MutableLiveData()

    // set data ke liveData
    fun getProduct(){
        product.value = list
    }
}