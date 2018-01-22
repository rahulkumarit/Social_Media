package com.doctorappoinment.activities

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.doctorappoinment.R
import com.doctorappoinment.Utlis
import com.doctorappoinment.interfaces.GetResponse
import com.doctorappoinment.ws.WsCalling
import kotlinx.android.synthetic.main.activity_test.*
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
 * Created by Devrepublic-14 on 1/17/2018.
 */
class WsRequestActivity : BaseActivity(), GetResponse {

    override fun getResponse(code: Int, response: String) {
        when (code) {
            Utlis.REQUEST_CATEGORY -> Toast.makeText(this, "Respone Category: " + response, Toast.LENGTH_SHORT).show()
            Utlis.REQUEST_CATEGORY -> Toast.makeText(this, "Respone SubCategory: " + response, Toast.LENGTH_SHORT).show()
            else -> { // Note the block
                Toast.makeText(this, "Respone SubCategory: " + response, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        try {
            initComponents()
        } catch (e: Exception) {    
        }
    }

    override fun initComponents() {
        btnCheck.setOnClickListener {
            // SendPostRequest().execute()
            val postDataParams = JSONObject()
            postDataParams.put("device_token", "APA91bHragrdMYyI40osi9XJj3PmsNOSqlXbtNlwFvdNX_TwUQ7XmrtgKduoJaR-Xra1irMWla5rSn7PPcxEp-Ny-JkvEBq91mydFuwlNnn5CmCSmoMJqMM")
            postDataParams.put("email_id", "kumar123@gmail.com")
            postDataParams.put("password", "123456")
            Log.e("params", postDataParams.toString())
            WsCalling.SendUrlConnectionRequest(Utlis.REQUEST_CATEGORY, this, postDataParams).execute()
        }
    }


    inner class SendPostRequest : AsyncTask<String, Void, String>() {

        override fun onPreExecute() {}

        override fun doInBackground(vararg arg0: String): String {
            try {

                val url = URL("https://studytutorial.in/post.php") // here is your URL path
                val postDataParams = JSONObject()
                postDataParams.put("name", "abc")
                postDataParams.put("email", "abc@gmail.com")
                Log.e("params", postDataParams.toString())
                val conn = url.openConnection() as HttpURLConnection

                conn.readTimeout = 15000
                conn.connectTimeout = 15000
                conn.requestMethod = "POST"
                conn.doInput = true
                conn.doOutput = true

                //This is for passing parameter
                val os = conn.outputStream
                val writer = BufferedWriter(OutputStreamWriter(os, "UTF-8"))
                writer.write(getPostDataString(postDataParams))
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

        override fun onPostExecute(result: String) {
            Toast.makeText(applicationContext, result,
                    Toast.LENGTH_LONG).show()
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