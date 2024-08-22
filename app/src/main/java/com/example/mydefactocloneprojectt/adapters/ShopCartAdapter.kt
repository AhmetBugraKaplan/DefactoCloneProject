package com.example.mydefactocloneprojectt.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.mydefactocloneprojectt.Products
import com.example.mydefactocloneprojectt.R
import com.example.mydefactocloneprojectt.ViewModel.ViewModell

class ShopCartAdapter(private val mContext: Context,
                      private val shopCartList : List<Products>,
                      private val itemClickListener: (Products) -> Unit)
    :RecyclerView.Adapter<ShopCartAdapter.shopCartViewHolder>() {


    inner class shopCartViewHolder(view:View) : RecyclerView.ViewHolder(view){

        var imageView : ImageView
        var textViewName : TextView
        var textViewPrice : TextView
        var textViewRemove : TextView = view.findViewById(R.id.textViewRemoveCart)

        init {
         imageView = view.findViewById(R.id.imageViewProductss)
         textViewName = view.findViewById(R.id.textViewProductNameee)
         textViewPrice = view.findViewById(R.id.textViewPriceee)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): shopCartViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.design_shop_cart,parent,false)
        return shopCartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shopCartList.size
    }

    override fun onBindViewHolder(holder: shopCartViewHolder, position: Int) {

        val shopCartProduct = shopCartList[position]

        holder.imageView.setImageResource(
            mContext.resources.getIdentifier(shopCartProduct.imageUrl,"drawable",mContext.packageName))

        holder.textViewPrice.text = shopCartProduct.price.toString()

        holder.textViewName.text = shopCartProduct.productName

        holder.textViewRemove.setOnClickListener {

        }

    }


}