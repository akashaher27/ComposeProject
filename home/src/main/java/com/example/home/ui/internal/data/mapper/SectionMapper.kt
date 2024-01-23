package com.example.home.ui.internal.data.mapper

import com.example.home.ui.internal.data.model.Section
import com.example.home.ui.internal.domain.model.SectionDomainModel
import javax.inject.Inject

internal class SectionMapper @Inject constructor() {
    fun map(sections: List<Section>): List<SectionDomainModel> {
        return emptyList()
    }
}