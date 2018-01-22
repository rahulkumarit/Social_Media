package com.doctorappoinment.ws

import android.os.AsyncTask
import com.doctorappoinment.Utlis
import com.doctorappoinment.interfaces.GetResponse
import org.json.JSONObject
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import javax.net.ssl.HttpsURLConnection

/**
 * Created by Devrepublic-14 on 1/22/2018.
 */
class WsCalling {

    class SendUrlConnectionRequest(var codes: Int, var getResponse: GetResponse, var params: JSONObject) : AsyncTask<String, String, String>() {
        val getRespons: GetResponse = getResponse
        val paramValue: JSONObject = params
        val code: Int = codes
        //This is post
        override fun doInBackground(vararg url: String?): String {
            try {
                val url = URL(Utlis.BASEURL) // here is your URL path
                val conn = url.openConnection() as HttpURLConnection
                conn.readTimeout = 15000
                conn.connectTimeout = 15000
                conn.requestMethod = "POST"
                conn.doInput = true
                conn.doOutput = true
                //This is for passing parameter
                val os = conn.outputStream
                val writer = BufferedWriter(OutputStreamWriter(os, "UTF-8"))
                writer.write(getPostDataString(paramValue))
                writer.flush()
                writer.close()
                os.close()
                //This is for getting input connection
                val responseCode = conn.responseCode
                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    val buffer = BufferedReader(InputStreamReader(conn.inputStream))
                    val sb = StringBuffer("")
                    var line = buffer.readLine()
                    while ((line) != null) {
                        sb.append(line)
                        break
                    }
                    buffer.close()
                    return sb.toString()
                } else {
                    return "false : " + responseCode
                }
            } catch (e: Exception) {
                return "Exception: " + e.message
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (result != null) {
                getRespons.getResponse(code, result)
            }
        }
        //get jsonobject to string
        @Throws(Exception::class)
        fun getPostDataString(params: JSONObject): String {
            val result = StringBuilder()
            var first = true
            val itr = params.keys()
            while (itr.hasNext()) {
                val key = itr.next()
                val value = params.get(key)
                if (first)
                    first = false
                else
                    result.append("&")
                result.append(URLEncoder.encode(key, "UTF-8"))
                result.append("=")
                result.append(URLEncoder.encode(value.toString(), "UTF-8"))
            }
            return result.toString()
        }


    }


}