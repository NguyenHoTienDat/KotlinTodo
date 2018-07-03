package com.example.framgianguyenhotiendat.kotlintodo.screen.home

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.framgianguyenhotiendat.kotlintodo.R
import com.example.framgianguyenhotiendat.kotlintodo.data.models.Car
import com.example.framgianguyenhotiendat.kotlintodo.databinding.ItemCarBinding

class CarAdapter(
        private val context: Context,
        private var cars: List<Car>,
        private val homeViewModel: HomeViewModel
) : RecyclerView.Adapter<CarHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CarHolder {
        val binding: ItemCarBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_car, p0, false)
        return CarHolder(binding)
    }

    override fun getItemCount(): Int {
        return cars?.size ?: 0
    }

    override fun onBindViewHolder(p0: CarHolder, p1: Int) {
        p0.setData(cars.get(p1))
    }

    fun updateData(cars: List<Car>) {
        this.cars = cars
        notifyDataSetChanged()
    }
}

class CarHolder(private val itemBinding: ItemCarBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    fun setData(car: Car) {
        itemBinding.viewModel = ItemCarViewModel(car)
        itemBinding.executePendingBindings()
    }
}