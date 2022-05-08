package binar.and.lima.stafchapterenam.network

import binar.and.lima.stafchapterenam.model.GetAllStafResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceStaf {
    @GET("staf")
    fun getAllStaf() : Call<List<GetAllStafResponseItem>>
}