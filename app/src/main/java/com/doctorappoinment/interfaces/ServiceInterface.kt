package com.rnd.kotlintest.interfaces

import org.json.JSONObject

/**
 * Created by Devrepublic-14 on 10/31/2017.
 */
interface ServiceInterface {

    fun getStringResult(path: String, params: String, completionHandler: (response: String?) -> Unit)
    fun get(path: String, params: JSONObject, completionHandler: (response: JSONObject?) -> Unit)
    fun post(path: String, params: JSONObject, completionHandler: (response: JSONObject?) -> Unit)
    fun postMap(path: String, params: Map<String, String>, completionHandler: (response: JSONObject?) -> Unit)


}