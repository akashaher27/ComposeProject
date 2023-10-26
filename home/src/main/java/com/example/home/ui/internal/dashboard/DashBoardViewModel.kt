package com.example.home.ui.internal.dashboard

import com.example.home.ui.internal.dashboard.plugin.Plugin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


internal class DashBoardViewModel @Inject constructor() {

    private val _dashboardViewState: MutableStateFlow<ViewState> =
        MutableStateFlow(ViewState.DEFAULT)
    val dashboardViewState: StateFlow<ViewState> = _dashboardViewState

    fun initPlugin(plugin: List<Plugin>) {
        if (_dashboardViewState.value.isPluginEmpty) {
            _dashboardViewState.update {
                it.copy(
                    plugin = plugin,
                    isLoading = false
                )
            }
        }
    }

}

internal data class ViewState(
    val plugin: List<Plugin>,
    val isLoading: Boolean
) {
    companion object {
        val DEFAULT = ViewState(
            plugin = emptyList(),
            isLoading = true
        )
    }

    val isPluginEmpty: Boolean
        get() = plugin.isEmpty()
}