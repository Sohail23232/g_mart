package com.example.gmart.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gmart.databinding.RowSpecialForYouColorBinding
import com.example.gmart.model.ProdTypeModel
import com.google.firebase.database.collection.R

class RecycleProdColorSpecialForYou(val context: Context,val colorList:ArrayList<String>):RecyclerView.Adapter<RecycleProdColorSpecialForYou.ViewHolder>() {
    class ViewHolder(val binding:RowSpecialForYouColorBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowSpecialForYouColorBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
        return colorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            colorView.setBackgroundColor(Color.parseColor(colorList[position]))
        }
    }
}