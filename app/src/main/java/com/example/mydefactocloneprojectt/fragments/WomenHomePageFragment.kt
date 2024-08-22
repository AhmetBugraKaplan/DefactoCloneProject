package com.example.mydefactocloneprojectt.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mydefactocloneprojectt.CategoriesImage
import com.example.mydefactocloneprojectt.R
import com.example.mydefactocloneprojectt.adapters.CategoriesImageAdapter
import com.example.mydefactocloneprojectt.adapters.SliderAdapter
import com.example.mydefactocloneprojectt.databinding.FragmentWomenHomePageBinding
import com.google.firebase.database.DatabaseReference
import com.smarteist.autoimageslider.SliderView


class WomenHomePageFragment : Fragment() {
    private lateinit var binding:FragmentWomenHomePageBinding
    private lateinit var imageurl:ArrayList<String>
    private lateinit var sliderView: SliderView
    private lateinit var sliderAdapter: SliderAdapter
    //Firebase
    //private lateinit var referenceProducts: DatabaseReference
    //RecyclerView
    private lateinit var categoriesImageList: ArrayList<CategoriesImage>
    private lateinit var categoriesImageAdapter: CategoriesImageAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWomenHomePageBinding.inflate(inflater,container,false)

        sliderView = binding.imageSlider
        imageurl = ArrayList()

        imageurl.add("android.resource://${requireContext().packageName}/${R.drawable.kadinslider1}")
        imageurl.add("android.resource://${requireContext().packageName}/${R.drawable.kadinslider2}")
        imageurl.add("android.resource://${requireContext().packageName}/${R.drawable.kadinslider3}")

        sliderAdapter = SliderAdapter(requireContext(),imageurl)
        sliderView.setSliderAdapter(sliderAdapter)

        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.scrollTimeInSec = 3
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()


        binding.recView.setHasFixedSize(true)
        binding.recView.layoutManager = StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL
        )

        categoriesImageList = ArrayList()
        val category1 = CategoriesImage("categories_kadinketen", "KElbise","Kadın")
        val category2 = CategoriesImage("categories_kadintisort", "KTişört","Kadın")
        val category3 = CategoriesImage("categories_kadinpantolon", "KPantolon","Kadın")
        val category4 = CategoriesImage("categories_kadinsort", "KŞort","Kadın")

        categoriesImageList.add(category1)
        categoriesImageList.add(category2)
        categoriesImageList.add(category3)
        categoriesImageList.add(category4)

        categoriesImageAdapter = CategoriesImageAdapter(requireContext(),categoriesImageList) { image ->
            val category = image.category
            val gender = image.gender
            if (category != null && gender != null ) {
                val action = FragmentEmptyDirections.emptyToproduct(category,gender)
                findNavController().navigate(action)
            }

        }

        binding.recView.adapter = categoriesImageAdapter


        return binding.root
    }
}