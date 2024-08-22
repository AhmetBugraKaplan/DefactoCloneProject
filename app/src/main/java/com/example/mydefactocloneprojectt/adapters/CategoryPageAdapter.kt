package com.example.mydefactocloneprojectt.adapters

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydefactocloneprojectt.CategoriesImage
import com.example.mydefactocloneprojectt.CategoryPage
import com.example.mydefactocloneprojectt.R

class CategoryPageAdapter(private val mContext: Context,
            private val ProductNameList:List<CategoryPage>
            ,private val itemClickListener : (CategoryPage) -> Unit)

    :RecyclerView.Adapter<CategoryPageAdapter.categorypageViewHolder>(){

        inner class categorypageViewHolder(view: View) : RecyclerView.ViewHolder(view){

            var textView:TextView
            var imageView: ImageView

            init {
                textView = view.findViewById(R.id.textViewProductNamee)
                imageView = view.findViewById(R.id.imageViewOk)
            }


        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categorypageViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.design_categoriespage,parent,false)
        return categorypageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ProductNameList.size
    }

    override fun onBindViewHolder(holder: categorypageViewHolder, position: Int) {
        val category = ProductNameList[position]

        holder.textView.text = category.ProductName

        holder.imageView.setOnClickListener {
            itemClickListener(category)
        }
    }


}