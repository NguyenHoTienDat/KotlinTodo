package com.example.framgianguyenhotiendat.kotlintodo.data.sources.local

import com.example.framgianguyenhotiendat.kotlintodo.R
import com.example.framgianguyenhotiendat.kotlintodo.data.models.Car
import com.example.framgianguyenhotiendat.kotlintodo.data.sources.DataSource


class CarLocalDataSource : DataSource {

    override fun getCar(carId: Int, callback: DataSource.LoadCarCallback) {

    }

    override fun getCars(callback: DataSource.LoadCarsCallback) {
        var cars: MutableList<Car> = mutableListOf<Car>()
        cars.add(Car(1,"BMW", R.drawable.bmw))
        cars.add(Car(2,"Audi",R.drawable.audi))
        cars.add(Car(3,"Bentley",R.drawable.bentley))
        cars.add(Car(4,"Ferrari",R.drawable.ferarri))
        callback.onCarsLoaded(cars)
    }

}
