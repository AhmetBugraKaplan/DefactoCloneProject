package com.example.mydefactocloneprojectt.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.mydefactocloneprojectt.R
import com.example.mydefactocloneprojectt.adapters.FragmentAdapter
import com.example.mydefactocloneprojectt.databinding.FragmentEmptyBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class FragmentEmpty : Fragment() {
    private lateinit var binding : FragmentEmptyBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: FragmentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEmptyBinding.inflate(inflater,container,false)


        tabLayout = binding.tablayout
        viewPager2 = binding.viewpager
        adapter = FragmentAdapter(childFragmentManager, lifecycle)
        viewPager2.adapter = adapter




        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = when (position) {
                0   -> "Erkek"
                1   -> "Kadın"
                2   -> "Çocuk"
                else -> null
            }
        }.attach()



        return binding.root
    }
}