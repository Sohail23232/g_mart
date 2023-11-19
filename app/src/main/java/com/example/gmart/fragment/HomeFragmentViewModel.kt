package com.example.gmart.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denzcoskun.imageslider.models.SlideModel
import com.example.gmart.model.CategoryModel
import com.example.gmart.model.ProductModel
import com.example.gmart.model.SubCatModel
import com.example.gmart.repository.AppRepository

class HomeFragmentViewModel:ViewModel() {
    val repo=AppRepository()
    var bannerList=MutableLiveData<ArrayList<SlideModel>>()
    var productList=MutableLiveData<ArrayList<ProductModel>>()
    var productModelList=MutableLiveData<ArrayList<ProductModel>>()
    var categoriesList= MutableLiveData<ArrayList<CategoryModel>>()
    var subCategoryList= MutableLiveData<ArrayList<SubCatModel>>()
    var prodListBySubCat= MutableLiveData<ArrayList<ProductModel>>()

    fun getBanners():MutableLiveData<ArrayList<SlideModel>>{
         bannerList= repo.getBanners()
        return bannerList
    }
    fun getProducts():MutableLiveData<ArrayList<ProductModel>>{
        productList= repo.getProducts()
        return productList
    }
    fun getProductModel(id:Int):MutableLiveData<ArrayList<ProductModel>>{
         productModelList=repo.getProductDetailsById(id)
        return productModelList
    }
    fun getCategories():MutableLiveData<ArrayList<CategoryModel>>{
       categoriesList=repo.getCategories()
        return categoriesList
    }
    fun getSubCategories(catId:Int):MutableLiveData<ArrayList<SubCatModel>>{
        subCategoryList=repo.getSubCategories(catId)
        return subCategoryList
    }
    fun getProductsBySubCatId(subCatId:Int):MutableLiveData<ArrayList<ProductModel>>{
        prodListBySubCat=repo.getProductsBySubCatId(subCatId)
        return prodListBySubCat
    }
}