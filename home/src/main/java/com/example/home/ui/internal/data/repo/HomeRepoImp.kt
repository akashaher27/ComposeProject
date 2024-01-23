package com.example.home.ui.internal.data.repo

import com.example.home.ui.internal.data.api.HomeApi
import com.example.home.ui.internal.data.mapper.SectionMapper
import com.example.home.ui.internal.domain.model.SectionDomainModel
import com.example.home.ui.internal.domain.repo.HomeRepo
import javax.inject.Inject

internal class HomeRepoImp @Inject constructor(
    private val homeApi: HomeApi,
    private val sectionMapper: SectionMapper
) : HomeRepo {

    override suspend fun getSection(): List<SectionDomainModel> {
        return sectionMapper.map(homeApi.getSection())
    }

}