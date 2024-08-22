package com.example.mydefactocloneprojectt.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mydefactocloneprojectt.Products
import com.example.mydefactocloneprojectt.R
import com.example.mydefactocloneprojectt.ViewModel.ViewModell
import com.example.mydefactocloneprojectt.adapters.ShopCartAdapter
import com.example.mydefactocloneprojectt.databinding.FragmentShopCartBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ShopCartFragment : Fragment() {
    private lateinit var binding : FragmentShopCartBinding
    private lateinit var shopCartAdapter: ShopCartAdapter
    private lateinit var reference: DatabaseReference

    private val viewModel : ViewModell by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = FragmentShopCartBinding.inflate(inflater,container,false)

        binding.recView.setHasFixedSize(true)
        binding.recView.layoutManager = StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL
        )


        //Şu anda liste boş amacımız listeyi doldurmak
        shopCartAdapter = ShopCartAdapter(requireContext(),viewModel.sepettekiUrunlerListesi){shopCartProduct->

        }

        binding.recView.adapter = shopCartAdapter









        return binding.root
    }

}