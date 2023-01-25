package br.com.fundatec.myapplication

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:visibility")
fun View.visibility(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}