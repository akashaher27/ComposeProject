package com.example.home.ui.internal.ui.dashboard

import androidx.lifecycle.ViewModel
import com.example.home.ui.internal.ui.dashboard.plugin.Plugin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


internal class DashBoardViewModel @Inject constructor(): ViewModel(){

    private val _dashboardViewState: MutableStateFlow<ViewState> =
        MutableStateFlow(ViewState.Loading)
    val dashboardViewState: StateFlow<ViewState> = _dashboardViewState

    fun onRetry() {}

}

internal sealed class ViewState {
    object Loading : ViewState()
    data class Success(
        val plugin: List<Plugin>
    ) : ViewState()

    object Error : ViewState()
}