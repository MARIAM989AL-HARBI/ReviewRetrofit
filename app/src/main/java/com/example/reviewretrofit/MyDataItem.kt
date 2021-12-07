package com.example.reviewretrofit

import com.google.gson.annotations.SerializedName

data class MyDataItem(

    //@SerializedName  مو اكيد مرا بس اتوقع اذا في اختلاف كثيرا نستخدم !!!!:(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)