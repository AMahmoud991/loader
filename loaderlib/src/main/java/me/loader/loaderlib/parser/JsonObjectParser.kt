package me.loader.loaderlib.parser

import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class JsonObjectParser :  BaseParser<JSONObject> {
    override fun parse(inputStream: InputStream): JSONObject {
        val responseStrBuilder = StringBuilder()
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))

        var inputStr: String
        try {
            inputStr = bufferedReader.readLine()
            while (inputStr != null) {
                responseStrBuilder.append(inputStr)
            }
            inputStream.close()
        } catch (e: JSONException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return JSONObject(responseStrBuilder.toString())
    }
}