package com.example.framgianguyenhotiendat.kotlintodo.data.repository

import com.example.framgianguyenhotiendat.kotlintodo.data.models.Car
import com.example.framgianguyenhotiendat.kotlintodo.data.sources.DataSource

class CarRepository(val carsLocalDataSource: DataSource,
                    val carsRemoteDataSource: DataSource) : DataSource {

    /**
     * Map save cars are cached
     */
    var cachedCar: LinkedHashMap<Int, Car> = LinkedHashMap()

    /**
     * Marks cache state
     */
    var cacheIsDirty = false

    /**
     * get Car with received Id from cache, local or remote whichever is
     * available first
     */
    override fun getCar(carId: Int, callback: DataSource.LoadCarCallback) {

    }

    override fun getCars(callback: DataSource.LoadCarsCallback) {
        if (cachedCar.isNotEmpty() && !cacheIsDirty) {
            callback.onCarsLoaded(ArrayList(cachedCar.values))
            return
        }

        if (cacheIsDirty) {
            // If the cache is dirty we need to fetch new data from the network.
            //getTasksFromRemoteDataSource(callback)
        } else {
            // Query the local storage if available. If not, query the network.
            carsLocalDataSource.getCars(object : DataSource.LoadCarsCallback {
                override fun onCarsNotAvailable() {
                    getTasksFromRemoteDataSource(callback)
                }

                override fun onCarsLoaded(cars: MutableList<Car>) {
                    callback.onCarsLoaded(ArrayList(cachedCar.values))
                    refreshCache(cars)
                }

            })
        }
    }

    private fun refreshCache(cars: List<Car>) {

    }

    private fun getTasksFromRemoteDataSource(callback: DataSource.LoadCarsCallback) {
        carsRemoteDataSource.getCars(object : DataSource.LoadCarsCallback {
            override fun onCarsLoaded(cars: MutableList<Car>) {
                //refreshCache(cars)
                //refreshLocalDataSource(cars)
                callback.onCarsLoaded(ArrayList(cachedCar.values))
            }

            override fun onCarsNotAvailable() {
                callback.onCarsNotAvailable()
            }
        })
    }

    private fun getCarById(id: Int) = cachedCar.get(id)

}