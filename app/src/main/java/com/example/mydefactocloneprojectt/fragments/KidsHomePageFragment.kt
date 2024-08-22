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
import com.example.mydefactocloneprojectt.databinding.FragmentKidsHomePageBinding
import com.google.firebase.database.DatabaseReference
import com.smarteist.autoimageslider.SliderView

class KidsHomePageFragment : Fragment() {
    private lateinit var binding:FragmentKidsHomePageBinding
    private lateinit var imageurl:ArrayList<String>
    private lateinit var sliderView: SliderView
    private lateinit var sliderAdapter: SliderAdapter
    //Firebase
    private lateinit var referenceProducts: DatabaseReference
    //RecyclerView
    private lateinit var categoriesImageList: ArrayList<CategoriesImage>
    private lateinit var categoriesImageAdapter: CategoriesImageAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKidsHomePageBinding.inflate(inflater,container,false)


        sliderView = binding.imageSlider
        imageurl = ArrayList()

        imageurl.add("android.resource://${requireContext().packageName}/${R.drawable.slidercocuk1}")
        imageurl.add("android.resource://${requireContext().packageName}/${R.drawable.slidercocuk2}")
        imageurl.add("android.resource://${requireContext().packageName}/${R.drawable.slidercocuk3}")

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
        val category1 = CategoriesImage("categories_cocuketek", "CEtek","Çocuk")
        val category2 = CategoriesImage("categories_cocukpantolon", "CPantolon","Çocuk")
        val category3 = CategoriesImage("categories_cocuksort", "CŞort","Çocuk")
        val category4 = CategoriesImage("categories_cocuktisort", "CTişört","Çocuk")

        categoriesImageList.add(category1)
        categoriesImageList.add(category2)
        categoriesImageList.add(category3)
        categoriesImageList.add(category4)

        categoriesImageAdapter = CategoriesImageAdapter(requireContext(),categoriesImageList) { image ->
            val category = image.category
            val gender = image.gender
            if(category != null &&gender != null){
                val action = FragmentEmptyDirections.emptyToproduct(category,gender)
                findNavController().navigate(action)
            }

        }

        binding.recView.adapter = categoriesImageAdapter



        return binding.root
    }

}