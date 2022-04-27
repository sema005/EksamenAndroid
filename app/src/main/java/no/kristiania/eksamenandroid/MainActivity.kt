package no.kristiania.eksamenandroid

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_forside)

        fetchJson()

        val button1: Button = findViewById(R.id.button)
        button1.setOnClickListener{
            val leggTilBilde = LeggTilBilde()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()

            transaction.replace(R.id.fragmentContainerView, leggTilBilde)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener{
            val resultat = Resultat()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()

            transaction.replace(R.id.fragmentContainerView, resultat)
            transaction.addToBackStack(null)
            transaction.commit()

        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener{
            val lagretBilder = LagretBilder()
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()

            transaction.replace(R.id.fragmentContainerView, lagretBilder)
            transaction.addToBackStack(null)
            transaction.commit()
        }






    }
    fun fetchJson() {
        println("HEUEHEUEHUEHEU")

        val url ="http://api-edu.gtl.ai/api/v1/imagesearch/google?url=https://www.mario.png"

        val reguest = Request.Builder().url(url).build()

        println( url.toString())
        val client = OkHttpClient()
        client.newCall(reguest).enqueue(object : Callback{

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)
            }
            override fun onFailure(call: Call, e: IOException) {
                println("Dette gikk ikke")
            }


        })

    }


}

