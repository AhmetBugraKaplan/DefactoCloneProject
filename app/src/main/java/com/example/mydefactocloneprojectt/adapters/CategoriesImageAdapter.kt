package com.example.mydefactocloneprojectt.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydefactocloneprojectt.CategoriesImage
import com.example.mydefactocloneprojectt.R

class CategoriesImageAdapter(private val mContext: Context,
                             private val imageList: List<CategoriesImage>,
                             private val itemClickListener : (CategoriesImage) -> Unit)
    :RecyclerView.Adapter<CategoriesImageAdapter.CategoriesViewHolder>(){

    inner class  CategoriesViewHolder(view : View) :RecyclerView.ViewHolder(view){
        val imageView : ImageView = view.findViewById(R.id.imageViewCategories)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.design_category,parent,false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val image = imageList[position]
        val resourceId = mContext.resources.getIdentifier(image.imageUrl, "drawable", mContext.packageName)

        if (resourceId != 0) { // Kaynak mevcutsa
            holder.imageView.setImageResource(resourceId)
        } else {
            holder.imageView.setImageResource(R.drawable.categories_polotisort) // Geçersiz kaynak durumunda bir placeholder kullanın
        }

        holder.imageView.setOnClickListener {
            Log.e("HATA","${image.category}")
            itemClickListener(image)
        }
    }

}
