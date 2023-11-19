package com.example.gmart.model

data class ProductModel(
  var prodColors:ArrayList<String> ?=null,
  var pId:String="" ,
    var subCatId:String="",
    var catId:String="",
    var pName:String="",
    var pDescription:String="",
    var pPrice:String="",
    var pDiscountPer:String="",
    var pImg:String="",
    var pBannerImg:ArrayList<String>?=null,
    var pType:ArrayList<ProdTypeModel>?=null
)
