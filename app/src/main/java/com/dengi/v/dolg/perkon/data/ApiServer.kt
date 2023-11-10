package com.dengi.v.dolg.perkon.data

import com.dengi.v.dolg.perkon.domain.model.basedto.BaseDto
import retrofit2.http.GET

interface ApiServer {
    @GET ("522/db.json")
    suspend fun getDataDb () : BaseDto
}