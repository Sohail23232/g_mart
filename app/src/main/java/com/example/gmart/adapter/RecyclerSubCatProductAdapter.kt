package com.example.gmart.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gmart.databinding.RowSubCatProdBinding
import com.example.gmart.model.SubCatModel
import com.example.gmart.screen.ProductActivity
import com.example.gmart.screen.ProductDetailsActivity

class RecyclerSubCatProductAdapter(val context: Context,val prodList:ArrayList<SubCatModel>):RecyclerView.Adapter<RecyclerSubCatProductAdapter.ViewHolder>(){
    class ViewHolder(val binding: RowSubCatProdBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowSubCatProdBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
     return  prodList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val intent=Intent(context,ProductActivity::class.java)
            intent.putExtra("subCatId",prodList[position].subCatId)
            context.startActivity(intent)
        }
    holder.binding.txtSubCat.text=prodList[position].subCatName
        Glide.with(context).load(prodList[position].subCatImg).into(holder.binding.imgSubCat)
    }
}