package com.example.reviewretrofit

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMyData()
    }

    private fun getMyData() {
        val retrofilBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(Apilnterface::class.java)
        val retrofitData = retrofilBuilder.getData()
retrofitData.enqueue(object : Callback<List<MyDataItem>?> {  // ctrl+shift+مسافة
    override fun onResponse(call: Call<List<MyDataItem>?>, response: Response<List<MyDataItem>?>) {
        val responseBody = response.body()!!
        val myStringBuilder = StringBuilder()
        for (myData in responseBody) {
            myStringBuilder.append(myData.id)
            myStringBuilder.append("\n")

        }
         txtId.text = myStringBuilder
    }


    override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
        Log.d("MainActivity","onFailure"+t.message)
    }
})

    }
}