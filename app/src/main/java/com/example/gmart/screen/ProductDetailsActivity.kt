package com.example.gmart.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.gmart.MainActivity
import com.example.gmart.R
import com.example.gmart.adapter.RecyclerProdColorAdapter
import com.example.gmart.databinding.ActivityProductDetailsBinding
import com.example.gmart.fragment.HomeFragmentViewModel
import com.example.gmart.model.ProductModel

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductDetailsBinding
    lateinit var viewModel: HomeFragmentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recViewColor.layoutManager=LinearLayoutManager(this@ProductDetailsActivity,LinearLayoutManager.HORIZONTAL,false)
        viewModel=ViewModelProvider(this@ProductDetailsActivity)[HomeFragmentViewModel::class.java]
        val productId=intent.getStringExtra("pId")
        Toast.makeText(this@ProductDetailsActivity, "$productId", Toast.LENGTH_SHORT).show()
        viewModel.getProductModel(productId!!.toInt()).observe(this@ProductDetailsActivity){prodModelList->
            binding.ppLayout.visibility= View.VISIBLE
            Log.d("list",prodModelList.toString())
            val imgBannerList=ArrayList<SlideModel>()
            val colorList=ArrayList<String>()
            for (imgBanners in prodModelList) {
                for (img in imgBanners.pBannerImg!!) {
                    imgBannerList.add(SlideModel(img, ScaleTypes.FIT))
                }
                for (color in imgBanners.prodColors!!){
                    colorList.add(color)

                }
                binding.imageSlider.setImageList(imgBannerList)
                binding.txtProductName.text=imgBanners.pName
                binding.txtProdAmount.text=imgBanners.pPrice

            }

            binding.recViewColor.adapter=RecyclerProdColorAdapter(this@ProductDetailsActivity,colorList)


        }



        binding.btnAddToCart.setOnClickListener {
            startActivity(Intent(this@ProductDetailsActivity,MyCartActivity::class.java))
        }
    }
}