package com.example.home.ui.internal.domain.usecase

import com.example.core.util.resultOf
import com.example.home.ui.internal.domain.repo.HomeRepo
import javax.inject.Inject

internal class GetSectionUseCase @Inject constructor(
    private val homeRepo: HomeRepo
) {

    suspend operator fun invoke() = resultOf {
        homeRepo.getSection()
    }
}