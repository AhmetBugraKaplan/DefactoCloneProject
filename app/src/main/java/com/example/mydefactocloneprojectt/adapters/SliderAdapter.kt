package com.example.mydefactocloneprojectt.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mydefactocloneprojectt.R
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(mContext: Context, imageurl:ArrayList<String>):SliderViewAdapter<SliderAdapter.SliderViewHolder>() {


    var sliderimage:ArrayList<String>  =imageurl

   class SliderViewHolder(itemView:View):SliderViewAdapter.ViewHolder(itemView){

       var imageView: ImageView = itemView.findViewById(R.id.myimage)

   }



    override fun getCount(): Int {
        return sliderimage.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapter.SliderViewHolder {
        var inflater:View = LayoutInflater.from(parent!!.context).inflate(R.layout.slideritem,null)
        return SliderViewHolder(inflater)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapter.SliderViewHolder?, position: Int) {
        if (viewHolder != null)
            Glide.with(viewHolder.itemView).load(sliderimage.get(position)).into(viewHolder.imageView)

    }
}