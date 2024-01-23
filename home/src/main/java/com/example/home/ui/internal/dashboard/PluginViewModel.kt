package com.example.home.ui.internal.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.util.launch
import com.example.home.ui.internal.domain.usecase.GetSectionUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "PluginViewModel"

internal class PluginViewModel @Inject constructor(
    private val getSectionUseCase: GetSectionUseCase
) : ViewModel() {

    init {
        getSection()
    }

    private fun getSection() = launch {
        getSectionUseCase()
            .onSuccess {
                Log.d(TAG, "getSection: ")
            }
            .onFailure {e ->
                Log.d(TAG, "get Section api failure: $e")
            }
    }
}