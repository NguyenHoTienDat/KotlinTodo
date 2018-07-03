package com.example.framgianguyenhotiendat.kotlintodo.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.framgianguyenhotiendat.kotlintodo.screen.home.CarAdapter

@BindingAdapter("visibleOrGone")
fun View.setVisibleOrGone(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("visible")
fun View.setVisible(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.INVISIBLE
}


@BindingAdapter("carAdapter")
fun setCarAdapter(view: RecyclerView, carAdapter: CarAdapter) {
    view.adapter = carAdapter
}

@BindingAdapter("imageSource")
fun setImageSource(view: ImageView, res: Int) {

}