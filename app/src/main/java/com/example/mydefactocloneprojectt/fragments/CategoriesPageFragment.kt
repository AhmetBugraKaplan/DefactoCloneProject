package com.example.mydefactocloneprojectt.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydefactocloneprojectt.CategoryPage
import com.example.mydefactocloneprojectt.R
import com.example.mydefactocloneprojectt.adapters.CategoryPageAdapter
import com.example.mydefactocloneprojectt.databinding.FragmentCategoriesPageBinding


class CategoriesPageFragment : Fragment() {
    private lateinit var binding : FragmentCategoriesPageBinding
    private lateinit var categoryPageAdapter:CategoryPageAdapter
    private lateinit var categoryNameList: ArrayList<CategoryPage>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCategoriesPageBinding.inflate(inflater,container,false)


        binding.recView.setHasFixedSize(true)
        binding.recView.layoutManager = LinearLayoutManager(requireContext())


        val categories = listOf(
            CategoryPage("Erkek Tişört","ETisort","Erkek"),
            CategoryPage("Erkek Polo Yaka Tişört","EPolo Yaka Tisort","Erkek"),
            CategoryPage("Erkek Şort","EŞort","Erkek"),
            CategoryPage("Erkek Atlet","EAtlet","Erkek"),
            CategoryPage("Kadın Elbise","KElbise","Kadın"),
            CategoryPage("Kadın Tişört","KTişört","Kadın"),
            CategoryPage("Kadın Pantolon","KPantolon","Kadın"),
            CategoryPage("Kadın Şort","KŞort","Kadın"),
            CategoryPage("Çocuk Tişört","CTişört","Çocuk"),
            CategoryPage("Çocuk Etek","CEtek","Çocuk"),
            CategoryPage("Çocuk Şort","CŞort","Çocuk"),
            CategoryPage("Çocuk Pantolon","CPantolon","Çocuk")
        )

        val categoryNameList = ArrayList<CategoryPage>()

        for (category in categories) {
            categoryNameList.add(category)
        }

        categoryPageAdapter = CategoryPageAdapter(requireContext(),categoryNameList) { category ->

            val kategori = category.categoryName
            val cinsiyet = category.genderr

            if(kategori != null && cinsiyet != null){
                val action = CategoriesPageFragmentDirections.categoriesToProduct(kategori,cinsiyet)
                findNavController().navigate(action)
            }


        }
        binding.recView.adapter = categoryPageAdapter


        return binding.root
    }


}