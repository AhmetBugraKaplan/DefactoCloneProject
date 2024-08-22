package com.example.mydefactocloneprojectt.ViewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydefactocloneprojectt.Products

class ViewModell : ViewModel() {


    var gender = ""
    var image = ""
    var price = 0.0
    var name = ""
    var category = ""

    var sepettekiUrunlerListesi = ArrayList<Products>()



}