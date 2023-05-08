package com.example.driftecommerce.utils.ProgressBar

import android.graphics.Color
import com.github.razir.progressbutton.showProgress
import com.google.android.material.button.MaterialButton


fun MaterialButton.showProgress() {
    val button = this
    button.showProgress {
        progressColor = Color.WHITE
    }
}