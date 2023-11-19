package com.example.gmart.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gmart.R
import com.example.gmart.adapter.RecyclerSpecialForYou
import com.example.gmart.databinding.ActivityProductBinding
import com.example.gmart.fragment.HomeFragmentViewModel

class ProductActivity : AppCompatActivity() {
    lateinit var binding:ActivityProductBinding
    lateinit var viewModel:HomeFragmentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val subCatId=intent.getStringExtra("subCatId")
        viewModel=ViewModelProvider(this@ProductActivity)[HomeFragmentViewModel::class.java]
        viewModel.getProductsBySubCatId(subCatId!!.toInt()).observe(this@ProductActivity){
            binding.recViewProduct.layoutManager=GridLayoutManager(this@ProductActivity,2)
            binding.recViewProduct.adapter=RecyclerSpecialForYou(this@ProductActivity,it)
        }

    }
}