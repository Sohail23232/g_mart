package com.example.gmart.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gmart.databinding.RowProdCatBinding
import com.example.gmart.model.CategoryModel
import com.example.gmart.screen.SubCategoryActivity

class RecyclerProdCategory(val context: Context,val productList: ArrayList<CategoryModel>):RecyclerView.Adapter<RecyclerProdCategory.ViewHolder>() {
 class ViewHolder(val  binding: RowProdCatBinding):RecyclerView.ViewHolder(binding.root){

 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowProdCatBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
       return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
val intent=Intent(context,SubCategoryActivity::class.java)
            intent.putExtra("catId",productList[position].catId)
            context.startActivity(intent)
        }
      Glide.with(context).load(productList[position].catImgP).into(holder.binding.imgCat)
        holder.binding.txtCat.text=productList[position].catName
    }
}
