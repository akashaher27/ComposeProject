/*
 * Copyright (c) 2022 GxS. All rights reserved.
 * Last modified 21/12/22, 4:41 PM
 */

package com.example.ui_common.ui.extension

import android.app.Activity
import android.graphics.Color
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

fun Activity.toFullScreen(
    @ColorInt systemNavigationBarColor: Int? = null,
    handler: FullScreenInsetsHandler? = null,
    fitSystemWindows: Boolean = false
) {
    window.apply {
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        WindowCompat.setDecorFitsSystemWindows(window, fitSystemWindows)
        statusBarColor = Color.TRANSPARENT

        systemNavigationBarColor?.let { color ->
            navigationBarColor = color
        }

        if (!fitSystemWindows) {
            val rootView =
                (this.findViewById(android.R.id.content) as? ViewGroup)?.getChildAt(0) as? ViewGroup
                    ?: decorView.findViewById(android.R.id.content)
                    ?: (this.findViewById<ViewGroup>(android.R.id.content).rootView) as? ViewGroup

            rootView?.apply {
                ViewCompat.setOnApplyWindowInsetsListener(rootView) { _, insets ->
                    if (handler == null) {
                        val systemBarsInsets =
                            insets.getInsets(WindowInsetsCompat.Type.systemBars())
                        rootView.setPadding(0, 0, 0, systemBarsInsets.bottom)
                        insets
                    } else {
                        handler.execute(insets)
                    }
                }
            }
        }
    }
}

fun interface FullScreenInsetsHandler {
    fun execute(insets: WindowInsetsCompat): WindowInsetsCompat
}
