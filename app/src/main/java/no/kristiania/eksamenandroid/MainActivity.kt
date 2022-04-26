package no.kristiania.eksamenandroid

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_forside)


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


        /*val button4: Button = findViewById(R.id.button4)
        val image = getFileStreamPath("mario_clip_art_5.png")
        button4.setOnClickListener{
            UploadUtility(this).uploadFile(image)
        }*/



    }





    }
