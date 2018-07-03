package com.example.framgianguyenhotiendat.kotlintodo.screen.home

import com.example.framgianguyenhotiendat.kotlintodo.screen.BaseView
import com.example.framgianguyenhotiendat.kotlintodo.screen.BaseViewModel

interface HomeContract {
    interface View: BaseView{

    }

    interface ViewModel: BaseViewModel {
        fun getCars()
    }
}