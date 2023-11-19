package com.example.gmart.repository

import androidx.lifecycle.MutableLiveData
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.gmart.model.CategoryModel
import com.example.gmart.model.ProductModel
import com.example.gmart.model.SubCatModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AppRepository {
companion object{
    val BANNER_COLLECTION="banners"
   val PRODUCTS_COLLECTION= "products"
    val CATEGORIES="categories"
    val SUB_CATEGORIES="subcat"
}
    val db=Firebase.firestore
    val bannerList=MutableLiveData<ArrayList<SlideModel>>()
    val productList= MutableLiveData<ArrayList<ProductModel>>()
    val productModelList=MutableLiveData<ArrayList<ProductModel>>()
    val categoryList= MutableLiveData<ArrayList<CategoryModel>>()
    val subCatList= MutableLiveData<ArrayList<SubCatModel>>()
    val productListBySubCat= MutableLiveData<ArrayList<ProductModel>>()
 fun getBanners():MutableLiveData<ArrayList<SlideModel>>{
     db.collection(BANNER_COLLECTION).get().addOnSuccessListener{
         val imageList=ArrayList<SlideModel>()
         for (data in it.documents){
             imageList.add(SlideModel(data.get("bImg").toString(),ScaleTypes.FIT))
         }
         bannerList.postValue(imageList)
     }
return bannerList
 }
    fun getProducts():MutableLiveData<ArrayList<ProductModel>>{
        db.collection(PRODUCTS_COLLECTION).get().addOnSuccessListener {
            val productsList=ArrayList<ProductModel>()
            for (data in it.documents){
                val productModel=data.toObject(ProductModel::class.java)
                productsList.add(productModel!!)
            }
            productList.postValue(productsList)
        }
        return productList
    }
    fun getProductsBySubCatId(subCatId: Int):MutableLiveData<ArrayList<ProductModel>>{
       db.collection(PRODUCTS_COLLECTION).whereEqualTo("subCatId","$subCatId").get().addOnSuccessListener {
           val prodListSubCat=ArrayList<ProductModel>()
           for (data in it.documents){
               val productModel=data.toObject(ProductModel::class.java)
               prodListSubCat.add(productModel!!)
           }
           productListBySubCat.postValue(prodListSubCat)
       }
        return productListBySubCat
    }
    fun getCategories():MutableLiveData<ArrayList<CategoryModel>>{
        db.collection(CATEGORIES).get().addOnSuccessListener {
            val categoriesList=ArrayList<CategoryModel>()
            for (data in it.documents){
                val categoryModel=data.toObject(CategoryModel::class.java)
                categoriesList.add(categoryModel!!)
            }
            categoryList.postValue(categoriesList)
        }
        return categoryList
    }
    fun getSubCategories(catId:Int):MutableLiveData<ArrayList<SubCatModel>>{
        val subCatLists=ArrayList<SubCatModel>()
        db.collection(SUB_CATEGORIES).whereEqualTo("catId","$catId").get().addOnSuccessListener {
            for (data in it.documents){
                val subCatModel=data.toObject(SubCatModel::class.java)
                subCatLists.add(subCatModel!!)
            }
            subCatList.postValue(subCatLists)
        }
        return subCatList
    }
    fun getProductDetailsById(pid:Int):MutableLiveData<ArrayList<ProductModel>>{
        db.collection("products").whereEqualTo("pId",pid.toString()).get().addOnSuccessListener {
            val prodModelList=ArrayList<ProductModel>()
            for (data in it.documents){
               val  productsModel= data.toObject(ProductModel::class.java)!!
                prodModelList.add(productsModel)
            }
            productModelList.value=prodModelList
        }
        return productModelList
    }

}