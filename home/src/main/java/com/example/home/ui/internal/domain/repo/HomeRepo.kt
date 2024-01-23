package com.example.home.ui.internal.domain.repo

import com.example.home.ui.internal.domain.model.SectionDomainModel

internal interface HomeRepo {

    suspend fun getSection(): List<SectionDomainModel>
}