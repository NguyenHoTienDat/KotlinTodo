package com.example.framgianguyenhotiendat.kotlintodo.data.sources

import com.example.framgianguyenhotiendat.kotlintodo.data.models.Car

interface DataSource {

    interface LoadCarsCallback {
        fun onCarsLoaded (cars: MutableList<Car>)

        fun onCarsNotAvailable ()
    }

    interface LoadCarCallback {
        fun onCarLoaded (car: Car)

        fun onCarsNotAvailable ()
    }

    fun getCars(callback: LoadCarsCallback)

    fun getCar(carId: Int, callback: LoadCarCallback)
}