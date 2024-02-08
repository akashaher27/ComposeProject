package com.example.home.intenal.ui.dashboard

import com.example.core.test.BaseUnitTest
import com.example.home.ui.internal.ui.dashboard.DashBoardViewModel
import com.example.home.ui.internal.ui.dashboard.plugin.WelcomeBannerPlugin
import com.example.home.ui.internal.ui.dashboard.plugin.WelcomeBannerViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
internal class DashBoardViewModelTest() : BaseUnitTest() {

    private lateinit var viewModel: DashBoardViewModel

    @Mock
    private lateinit var welcomeBannerViewModel: WelcomeBannerViewModel


    @Before
    override fun setup() {
        viewModel = DashBoardViewModel()
    }

    @Test
    fun `Given input When called initPlugin Then verify correct ui state`() {
        val mockInput = listOf(WelcomeBannerPlugin(welcomeBannerViewModel))
        viewModel.initPlugin(mockInput)
        assertEquals(false, viewModel.dashboardViewState.value.isPluginEmpty)
    }

}