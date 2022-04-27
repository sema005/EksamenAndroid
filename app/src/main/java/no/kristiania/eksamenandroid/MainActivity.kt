package no.kristiania.eksamenandroid

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private var IMGInfo = ArrayList<StudentInfo>()

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


    override fun onStart() {
        super.onStart()
        Log.i(Globals.TAG, "Activity 1 onStart")
        Toast.makeText(this, "Activity onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i(Globals.TAG, "Activity 1 onResume")
        Toast.makeText(this, "Activity onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i(Globals.TAG, "Activity 1 onPause")
        Toast.makeText(this, "Activity onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i(Globals.TAG, "Activity 1 onStop")
        Toast.makeText(this, "Activity onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(Globals.TAG, "Activity 1 onRestart")
        Toast.makeText(this, "Activity onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(Globals.TAG, "Activity 1 onDestroy")
        Toast.makeText(this, "Activity onDestroy", Toast.LENGTH_SHORT).show()
    }


    fun submit(view: View) {
        var nameViewText =
            (fragmentManager.findFragmentByTag("Fragment1") as Fragment1).nameView.text.toString()
        var imageUri =
            (fragmentManager.findFragmentByTag("Fragment1") as Fragment1).imageUri.toString()

        var rect = (fragmentManager.findFragmentByTag("Fragment1") as Fragment1).actualCropRect!!
        var imgW = (fragmentManager.findFragmentByTag("Fragment1") as Fragment1).image.width
        var imgH = (fragmentManager.findFragmentByTag("Fragment1") as Fragment1).image.height

        val newPicture: IMGInfo = IMGInfo(
            nameViewText,
            imageUri,
            rect.left.toInt(),
            rect.top.toInt(),
            rect.right.toInt(),
            rect.bottom.toInt(),
            imgW.toInt(),
            imgH.toInt()
        )

        IMGInfo.add(newPicture)

        dbHelper?.writableDatabase?.insert("students", null, ContentValues().apply {
            put("name", newStudent.name)
            put(
                "image",
                bitmapTobyteArray(
                    getBitmap(
                        applicationContext,
                        null,
                        newPicture.imageUri,
                        ::UriToBitmap
                    )
                ).toByteArray()
            )
        })

        Toast.makeText(this, "Added New Student", Toast.LENGTH_SHORT).show()
    }
}

