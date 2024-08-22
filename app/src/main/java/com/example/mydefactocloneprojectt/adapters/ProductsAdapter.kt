package com.example.mydefactocloneprojectt.adapters


import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.mydefactocloneprojectt.Products
import com.example.mydefactocloneprojectt.R
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController.ClickListener

class ProductsAdapter(private val mContext: Context,
                      private val ProductsList:List<Products>,
                      private val itemClickListener: (Products) -> Unit)
    :RecyclerView.Adapter<ProductsAdapter.productsViewHolder>(){


        private lateinit var viewModel: ViewModel

    inner class productsViewHolder(view:View) : RecyclerView.ViewHolder(view){

        var imageView : ImageView
        var imageViewAdd : ImageView
        var textViewPrice : TextView
        var textViewProductName : TextView

        init {
            imageView = view.findViewById(R.id.imageViewProducts)
            imageViewAdd = view.findViewById(R.id.imageViewAdd)
            textViewPrice = view.findViewById(R.id.textViewPrice)
            textViewProductName = view.findViewById(R.id.textViewProductName)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productsViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.design_products,parent,false)
        return productsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ProductsList.size
    }

    override fun onBindViewHolder(holder: productsViewHolder, position: Int) {

        val product = ProductsList[position]

        holder.imageView.setImageResource(
            mContext.resources.getIdentifier(product.imageUrl,"drawable",mContext.packageName))
        holder.textViewPrice.text = product.price.toString()
        holder.textViewProductName.text  =product.productName

        holder.textViewProductName.gravity = Gravity.CENTER

        holder.imageViewAdd.setOnClickListener {
            itemClickListener(product)
        }


    }



}