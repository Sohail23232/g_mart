package com.example.gmart.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gmart.MainActivity
import com.example.gmart.R
import com.example.gmart.adapter.RecyclerCartItemAdapter
import com.example.gmart.databinding.ActivityMyCartBinding

class MyCartActivity : AppCompatActivity() {
    lateinit var binding:ActivityMyCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMyCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recViewProduct.layoutManager=LinearLayoutManager(this)
      //  binding.recViewProduct.adapter=RecyclerCartItemAdapter(this,MainActivity.productCartList)
    }
}