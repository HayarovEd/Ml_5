package com.dengi.v.dolg.perkon.data

import android.util.Log
import com.dengi.v.dolg.perkon.domain.RepositoryServer
import javax.inject.Inject
import com.dengi.v.dolg.perkon.domain.model.basedto.BaseDto

class RepositoryServerImpl @Inject constructor(
    private val apiServer: ApiServer
) : RepositoryServer {
    override suspend fun getDataDb(): Resource<BaseDto> {
        return try {
            val folder = apiServer.getDataDb()
            Log.d("DATADB", "dATA DB:${folder.loans.first().id}")
            Resource.Success(
                data = folder
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error")
        }
    }
}