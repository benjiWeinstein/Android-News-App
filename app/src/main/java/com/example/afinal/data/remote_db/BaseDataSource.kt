package com.example.afinal.data.remote_db

import android.util.Log
import android.widget.Toast
import com.example.afinal.utils.Resource
import kotlinx.coroutines.withContext
import retrofit2.Response
import kotlin.coroutines.coroutineContext


abstract class BaseDataSource {

    protected suspend fun <T> getResult(call : suspend () -> Response<T>) : Resource<T> {

        try {
            Log.d("Retro", "Entered")
            val result  = call()
            Log.d("Retro called", result.toString())

            if(result.isSuccessful) {
//                result.
                val body = result.body()
                if(body != null) {
                    Log.d("Retro API", body.toString())
                    return Resource.success(body)
                }
            }
            return Resource.error("Network call has failed for the following reason: " +
                    "${result.message()} ${result.code()}")
        }catch (e : Exception) {
            return Resource.error("Network call has failed for the following reason: "
                    + (e.localizedMessage ?: e.toString()))
        }
    }
}