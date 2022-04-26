package no.kristiania.eksamenandroid

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_first)

        Log.i(Globals.TAG, "Activity 1 onCreate")
        Toast.makeText(this, "Activity onCreate", Toast.LENGTH_SHORT).show()
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

    fun switchFragment(v: View) {
        fragmentManager = supportFragmentManager

        if(Integer.parseInt(v.getTag().toString()) == 1) {
            fragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragment_main,
                    SavedImages(),
                    "fragment_saved_images"
                )
                .commit()
        }else{
            fragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragment_main,
                    StartScreen(),
                    "fragment_start_screen"
                )
                .commit()
        }





    }


    }
