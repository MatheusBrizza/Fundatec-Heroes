package br.com.fundatec.components

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.showToast() {
    Toast.makeText(this, "Olá!", Toast.LENGTH_SHORT).show()
}

fun Context.showSnack(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}