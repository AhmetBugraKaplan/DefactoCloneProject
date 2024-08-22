package com.example.mydefactocloneprojectt.adapters


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mydefactocloneprojectt.fragments.KidsHomePageFragment
import com.example.mydefactocloneprojectt.fragments.ManHomePageFragment
import com.example.mydefactocloneprojectt.fragments.ProductShopFragment
import com.example.mydefactocloneprojectt.fragments.WomenHomePageFragment

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0-> ManHomePageFragment()
            1 -> WomenHomePageFragment()
            2 -> KidsHomePageFragment()
            else -> Fragment()
        }
    }
}
