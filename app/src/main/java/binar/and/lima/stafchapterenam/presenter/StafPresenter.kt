package binar.and.lima.stafchapterenam.presenter

import binar.and.lima.stafchapterenam.model.GetAllStafResponseItem
import binar.and.lima.stafchapterenam.network.ApiClientStaf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StafPresenter ( val viewstaf : StafView){

    fun getDataStaf(){
        ApiClientStaf.instance.getAllStaf()
            .enqueue(object : Callback<List<GetAllStafResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllStafResponseItem>>,
                    response: Response<List<GetAllStafResponseItem>>
                ) {
                    if (response.isSuccessful){
                        viewstaf.onSuccess(response.message(),response.body()!!)

                    }else{
                        viewstaf.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetAllStafResponseItem>>, t: Throwable) {
                    viewstaf.onError(t.message!!)
                }

            })
    }
}