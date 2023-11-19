package com.example.gmart.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gmart.databinding.RowCartRecyclerBinding
import com.example.gmart.model.ProductModel

class RecyclerCartItemAdapter(val context: Context,val prodList:ArrayList<ProductModel>):RecyclerView.Adapter<RecyclerCartItemAdapter.ViewHolder>() {
    class ViewHolder(val binding:RowCartRecyclerBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(RowCartRecyclerBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*with(holder.binding) {
            imgProduct.setImageResource(prodList[position].prodImage)
            txtProductName.text=prodList[position].prodName
        txtProductCategory.text=prodList[position].prodType
            txtProductAmount.text=prodList[position].prodAmount
        }*/
    }

    override fun getItemCount(): Int {
        return prodList.size
    }




}