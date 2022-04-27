package no.kristiania.eksamenandroid

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject


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







    }


}
