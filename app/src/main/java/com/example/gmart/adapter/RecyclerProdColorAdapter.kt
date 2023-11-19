package com.example.gmart.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gmart.databinding.RowProdColorBinding
import com.example.gmart.model.ProdTypeModel

class RecyclerProdColorAdapter(val context: Context,val colorList:ArrayList<String>):RecyclerView.Adapter<RecyclerProdColorAdapter.ViewHolder>() {
class ViewHolder(val binding:RowProdColorBinding):RecyclerView.ViewHolder(binding.root){

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowProdColorBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
        return colorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

           holder.binding.colorView.setBackgroundColor(Color.parseColor(colorList[position]))

    }
}