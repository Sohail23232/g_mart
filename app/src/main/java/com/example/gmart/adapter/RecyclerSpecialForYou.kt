package com.example.gmart.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gmart.databinding.RowSpecialForYouBinding

import com.example.gmart.model.ProductModel
import com.example.gmart.screen.ProductDetailsActivity

class RecyclerSpecialForYou(val context: Context, val prodList: ArrayList<ProductModel>):RecyclerView.Adapter<RecyclerSpecialForYou.ViewHolder>() {
    class ViewHolder(val binding:RowSpecialForYouBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(RowSpecialForYouBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
Glide.with(context).load(prodList[position].pImg).into(holder.binding.imgProduct)
        holder.binding.txtProduct.text=prodList[position].pName
        holder.binding.txtAmount.text=prodList[position].pPrice
        holder.itemView.setOnClickListener {
            val intent=Intent(context,ProductDetailsActivity::class.java)
            intent.putExtra("pId",prodList[position].pId)
            context.startActivity(intent)
        }
        holder.binding.recViewColor.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        holder.binding.recViewColor.adapter=RecycleProdColorSpecialForYou(context,prodList[position].prodColors!!)
    }


    override fun getItemCount(): Int {
        return prodList.size
    }




}