package me.loader.loaderlib.request


import android.util.Log
import io.reactivex.Single
import java.net.HttpURLConnection
import java.net.URL

class RequestCall<T>(private val request: Request<T>) {
    fun getData(): Single<T> = Single.fromCallable {
        var urlConnection: HttpURLConnection? = null
        Log.d("Url", request.url)

        var data: T? = null
        try {

            val uri = URL(request.url)
            urlConnection = uri.openConnection() as HttpURLConnection
            urlConnection.readTimeout = 15000
            urlConnection.connectTimeout = 15000
            urlConnection.requestMethod = request.method


            var inputStream = urlConnection.inputStream


            inputStream?.let {

                data = request.parser.parse(it)

            }
        } catch (e: Exception) {
            Single.error<java.lang.Exception>(e)
            urlConnection!!.disconnect()
        } finally {
            urlConnection?.disconnect()
        }
        data?.apply {
            data
        }
    }
}



