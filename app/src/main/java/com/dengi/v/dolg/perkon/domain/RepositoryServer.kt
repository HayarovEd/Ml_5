package com.dengi.v.dolg.perkon.domain

import com.dengi.v.dolg.perkon.data.Resource
import com.dengi.v.dolg.perkon.domain.model.basedto.BaseDto

interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseDto>
}