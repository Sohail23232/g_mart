package com.example.gmart.model

data class ProductSpecialForYouModel(
    var id:Int,
    var prodPrice:String,
    var imgProd:Int,
    var txtProd:String,
    var colorList:ArrayList<ProdTypeModel>
)
