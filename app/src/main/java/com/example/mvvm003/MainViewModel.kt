package com.example.mvvm003

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel(){
    private var mainViewData = MainViewData("")
    val liveData =MutableLiveData<MainViewData>()

    fun onInputChange(str:String){
        mainViewData =mainViewData.copy(str =str)
        liveData.postValue(mainViewData)
    }
}




