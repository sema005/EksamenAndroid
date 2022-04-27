package no.kristiania.eksamenandroid

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.net.URL

class ServerCon {

    private val client = OkHttpClient()

    fun run() {
        val request = Request.Builder()
            .url("http://api-edu.gtl.ai/api/v1/imagesearch/google/www.mario.png")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            for ((name, value) in response.headers) {
                println("$name: $value")
            }

            println(response.body!!.string())
        }
    }
}