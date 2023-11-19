package com.example.gmart.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gmart.R
import com.example.gmart.adapter.RecyclerSubCatProductAdapter
import com.example.gmart.databinding.ActivitySubCategoryBinding
import com.example.gmart.fragment.HomeFragmentViewModel

class SubCategoryActivity : AppCompatActivity() {
    lateinit var binding:ActivitySubCategoryBinding
    lateinit var viewModel: HomeFragmentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySubCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val catId=intent.getStringExtra("catId")
        viewModel=ViewModelProvider(this@SubCategoryActivity)[HomeFragmentViewModel::class.java]
        viewModel.getSubCategories(catId!!.toInt()).observe(this@SubCategoryActivity){
            binding.recViewSubCat.layoutManager=GridLayoutManager(this@SubCategoryActivity,2)
            binding.recViewSubCat.adapter=RecyclerSubCatProductAdapter(this@SubCategoryActivity,it)
        }

    }
}