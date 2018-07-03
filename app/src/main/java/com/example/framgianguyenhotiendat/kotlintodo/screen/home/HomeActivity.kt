package com.example.framgianguyenhotiendat.kotlintodo.screen.home

import android.arch.lifecycle.LifecycleOwner
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.framgianguyenhotiendat.kotlintodo.R
import com.example.framgianguyenhotiendat.kotlintodo.data.repository.CarRepository
import com.example.framgianguyenhotiendat.kotlintodo.data.sources.local.CarLocalDataSource
import com.example.framgianguyenhotiendat.kotlintodo.data.sources.remote.CarRemoteDataSource
import com.example.framgianguyenhotiendat.kotlintodo.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity(), HomeContract.View, LifecycleOwner {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var carRepository: CarRepository
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        carRepository = CarRepository(CarLocalDataSource(), CarRemoteDataSource())
        homeViewModel = HomeViewModel(application, carRepository)
        binding.viewModel = homeViewModel
        obseverLifecycle()
    }

    override fun obseverLifecycle() {
        lifecycle.addObserver(homeViewModel)
    }
}
