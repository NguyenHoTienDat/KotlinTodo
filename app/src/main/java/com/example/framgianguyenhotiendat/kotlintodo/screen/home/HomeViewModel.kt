package com.example.framgianguyenhotiendat.kotlintodo.screen.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.databinding.ObservableField
import android.util.Log
import com.example.framgianguyenhotiendat.kotlintodo.data.models.Car
import com.example.framgianguyenhotiendat.kotlintodo.data.repository.CarRepository
import com.example.framgianguyenhotiendat.kotlintodo.data.sources.DataSource

class HomeViewModel(context: Application,
                    private val carRepository: CarRepository) :
        AndroidViewModel(context), HomeContract.ViewModel, LifecycleObserver {

    private val context: Context = context.applicationContext

    var carAdapter = ObservableField<CarAdapter>()

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onStop() {
        //do something if HomeActivity stop
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onStart() {
        var cars: List<Car> = emptyList()
        carAdapter.set(CarAdapter(context, cars,this))
        getCars()
    }

    override fun getCars() {
        carRepository.getCars(object : DataSource.LoadCarsCallback {
            override fun onCarsNotAvailable() {
                //do some thing if get data failed
            }

            override fun onCarsLoaded(cars: MutableList<Car>) {
                carAdapter.get()?.updateData(cars)
            }

        })
    }
}