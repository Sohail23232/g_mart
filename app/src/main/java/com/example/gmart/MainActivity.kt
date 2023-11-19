package com.example.gmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.gmart.databinding.ActivityMainBinding
import com.example.gmart.fragment.HomeFragment
import com.example.gmart.model.CategoryModel


class MainActivity : AppCompatActivity() {
    companion object{
    /*    val productColorList=ArrayList<ProdTypeModel>().apply {
            add(ProdTypeModel("Purple",R.color.purple,false))
            add(ProdTypeModel("NavyBlue",R.color.navy_blue,false))
            add(ProdTypeModel("Black",R.color.black,false))
            add(ProdTypeModel("Mustard",R.color.mustard,false))
        }*/
       /* val productCartList=ArrayList<ProductModel>().apply {
         add(ProductModel(R.drawable.tshirt,"T-shirt","Men Fashion","$52.00"))
            add(ProductModel(R.drawable.boat_first,"Headphone","Electronics","$100.00"))
            add(ProductModel(R.drawable.smartwatch,"SmartWatch","Electronics","$150.00"))
        }*/
     /*   val productCategoryList=ArrayList<CategoryModel>().apply {
            add(CategoryModel(0,R.drawable.mens_wears,"Men"))
            add(CategoryModel(1,R.drawable.women_wear,"Women"))
            add(CategoryModel(2,R.drawable.kids_wea,"Kids"))
            add(CategoryModel(3,R.drawable.makeup,"Beauty"))
            add(CategoryModel(4,R.drawable.jewellery,"Jewellery"))
            add(CategoryModel(5,R.drawable.foot_wear,"Footwear"))
            add(CategoryModel(6,R.drawable.gadget,"Gadgets"))
            add(CategoryModel(7,R.drawable.luggage,"Luggage"))
        }*/
       /* val productSpecialForYouList=ArrayList<ProductSpecialForYouModel>().apply {
            add(ProductSpecialForYouModel(1,"200",R.drawable.tshirt,"T-shirt", productColorList))
            add(ProductSpecialForYouModel(2,"300",R.drawable.boat_first,"Headphone", productColorList))
            add(ProductSpecialForYouModel(3,"500",R.drawable.smartwatch,"SmartWatch", productColorList))
            add(ProductSpecialForYouModel(4,"200",R.drawable.tshirt,"T-shirt", productColorList))
            add(ProductSpecialForYouModel(5,"300",R.drawable.boat_first,"Headphone", productColorList))
            add(ProductSpecialForYouModel(6,"500",R.drawable.smartwatch,"SmartWatch", productColorList))
            add(ProductSpecialForYouModel(7,"200",R.drawable.tshirt,"T-shirt", productColorList))
            add(ProductSpecialForYouModel(8,"300",R.drawable.boat_first,"Headphone", productColorList))
            add(ProductSpecialForYouModel(9,"500",R.drawable.smartwatch,"SmartWatch", productColorList))
        }*/
    }
    lateinit var binding:ActivityMainBinding
    lateinit var fm:FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fm=supportFragmentManager
        loadFrag(HomeFragment())
        binding.btnHome.setOnClickListener{
            loadFrag(HomeFragment())
        }
       // binding.bottomNavBar.background = null
        binding.btnDrawer.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }


    }
    fun loadFrag(fragment: Fragment){
        val ft=fm.beginTransaction()
        ft.replace(R.id.container,fragment)
        ft.commit()
    }
}