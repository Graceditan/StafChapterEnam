package binar.and.lima.stafchapterenam.presenter

import binar.and.lima.stafchapterenam.model.GetAllStafResponseItem

interface StafView {
    fun onSuccess(pesan: String , staf: List<GetAllStafResponseItem>){

    }

    fun onError(pesan : String)
}