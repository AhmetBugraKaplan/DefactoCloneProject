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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mydefactocloneprojectt.Products
import com.example.mydefactocloneprojectt.ViewModel.ViewModell
import com.example.mydefactocloneprojectt.adapters.ProductsAdapter
import com.example.mydefactocloneprojectt.databinding.FragmentProductShopBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ProductShopFragment : Fragment() {
    private lateinit var binding : FragmentProductShopBinding
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var productList : ArrayList<Products>
    private lateinit var referenceProduct: DatabaseReference




    private lateinit var shopCartList : ArrayList<Products>
    private  val viewModel : ViewModell by activityViewModels()


    //private var category: String? = null  // Category'yi nullable yapıyoruz

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProductShopBinding.inflate(inflater,container,false)

        binding.recView.setHasFixedSize(true)
        binding.recView.layoutManager = StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL
        )

        productList = ArrayList()
        productsAdapter = ProductsAdapter(requireContext(),productList){ product ->
//            if (imageUrl != null && genderr != null){
//                val action = ProductShopFragmentDirections.prouctToShopCart(imageUrl , genderr)
//                findNavController().navigate(action)
//            }

           val p1 = Products(product.imageUrl,product.productName,product.category,product.gender,product.price)

            viewModel.sepettekiUrunlerListesi.add(p1)

        }

        binding.recView.adapter = productsAdapter

        val database = FirebaseDatabase.getInstance()

        if (args.gender != null){
            when(args.gender){
                "Erkek" -> referenceProduct = database.getReference("productsMan")
                "Kadın" -> referenceProduct = database.getReference("productsWomen")
                "Çocuk" -> referenceProduct = database.getReference("productsChildren")
            }
        }




        getAllProducts()


        return binding.root
    }

    private val args: ProductShopFragmentArgs by navArgs()

    private fun getAllProducts() {
        referenceProduct.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                productList.clear()
                val gelenCategory = args.category
                val gelenGender = args.gender
                for (c in snapshot.children) {
                    val product = c.getValue(Products::class.java)
                    if (product != null && gelenCategory == product.category && gelenGender == product.gender) {
                        productList.add(product)
                    }
                }
                productsAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Hata yönetimi
            }
        })
    }

    fun addToList(p1:Products){

        Log.e("DENEME2","${p1.productName}")




    }


}