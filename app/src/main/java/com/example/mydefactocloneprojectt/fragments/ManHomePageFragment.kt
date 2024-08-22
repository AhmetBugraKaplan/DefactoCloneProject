package com.example.mydefactocloneprojectt.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.mydefactocloneprojectt.CategoriesImage
import com.example.mydefactocloneprojectt.R
import com.example.mydefactocloneprojectt.adapters.CategoriesImageAdapter
import com.example.mydefactocloneprojectt.adapters.FragmentAdapter
import com.example.mydefactocloneprojectt.adapters.SliderAdapter
import com.example.mydefactocloneprojectt.databinding.FragmentManHomePageBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.smarteist.autoimageslider.SliderView

class ManHomePageFragment : Fragment() {
    private lateinit var binding : FragmentManHomePageBinding
    private lateinit var imageurl:ArrayList<String>
    private lateinit var sliderView:SliderView
    private lateinit var sliderAdapter: SliderAdapter
    //Firebase
    private lateinit var referenceProducts: DatabaseReference
    //RecyclerView
    private lateinit var categoriesImageList: ArrayList<CategoriesImage>
    private lateinit var categoriesImageAdapter: CategoriesImageAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentManHomePageBinding.inflate(inflater, container, false)

        sliderView = binding.imageSlider
        imageurl = ArrayList()

        imageurl.add("android.resource://${requireContext().packageName}/${R.drawable.slider1}")
        imageurl.add("android.resource://${requireContext().packageName}/${R.drawable.slider2}")
        imageurl.add("android.resource://${requireContext().packageName}/${R.drawable.slider3}")

        sliderAdapter = SliderAdapter(requireContext(),imageurl)
        sliderView.setSliderAdapter(sliderAdapter)

        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.scrollTimeInSec = 3
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()


        //Recycler View
        binding.recView.setHasFixedSize(true)
        binding.recView.layoutManager = StaggeredGridLayoutManager(
            2,StaggeredGridLayoutManager.VERTICAL
        )


        //Firebase
        val database = FirebaseDatabase.getInstance()
        referenceProducts = database.getReference("productsMan")



        categoriesImageList = ArrayList()
        val category1 = CategoriesImage("categories_atlet", "EAtlet","Erkek")
        val category2 = CategoriesImage("categories_polotisort", "EPolo Yaka Tisort","Erkek")
        val category3 = CategoriesImage("categories_sort", "EŞort","Erkek")
        val category4 = CategoriesImage("categories_tisort", "ETisort","Erkek")

        categoriesImageList.add(category1)
        categoriesImageList.add(category2)
        categoriesImageList.add(category3)
        categoriesImageList.add(category4)

        categoriesImageAdapter = CategoriesImageAdapter(requireContext(),categoriesImageList) { image ->
            val category = image.category
            val gender = image.gender
            if (category != null) {
//                 action = ManHomePageFragmentDirections.manToProduct(category,gender)
//                findNavController().navigate(action)

                val action = FragmentEmptyDirections.emptyToproduct(category,gender)

                findNavController().navigate(action)
            }
        }




        binding.recView.adapter = categoriesImageAdapter

        return binding.root
    }


}