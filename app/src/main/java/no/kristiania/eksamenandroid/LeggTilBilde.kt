package no.kristiania.eksamenandroid

import android.content.Intent
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException


class LeggTilBilde : Fragment() {

    public lateinit var image: CropImageView2

    public var imageUri: String? = null

    public var actualCropRect: Rect? = null


    interface OnImageSizeChangedListener {
        fun onImageSizeChanged(rec: Rect)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(Globals.TAG, "Legg til bilde onCreate")
        Toast.makeText(activity, "Legg til bilde onCreate", Toast.LENGTH_SHORT).show()



    }

    /*
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_legg_til_bilde, container, false)
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(Globals.TAG, "Legg til bilde onCreateView")
        Toast.makeText(activity, "Legg til bilde onCreateView", Toast.LENGTH_SHORT).show()

        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_legg_til_bilde, container, false)


        fun getDataFromSearchMotor() {
            class MainActivity : AppCompatActivity() {

                private val client = OkHttpClient()

                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    setContentView(R.layout.fragment_legg_til_bilde)

                    run(url = "http://api-edu.gtl.ai/api/v1/imagesearch/google?url=https://www.mariokart.png%22")
                }

                fun run(url: String) {
                    val request = Request.Builder()
                        .url(url)
                        .build()

                    client.newCall(request).enqueue(object : Callback {
                        override fun onFailure(call: Call, e: IOException) {}
                        override fun onResponse(call: Call, response: Response) =
                            println(response.body?.string())
                    })
                }
            }
        }



        val uploadImageButton = view.findViewById<Button>(R.id.uploadImageButton)
        uploadImageButton.setOnClickListener{
            Log.e("Success", "${getDataFromSearchMotor()}")


        }



        image = view.findViewById<CropImageView2>(R.id.image)
        image.setListeners(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                var i = Intent()

                i.action = Intent.ACTION_GET_CONTENT
                i.type = "*/*"

                startForResult.launch(i)
            }
        }, object: OnImageSizeChangedListener{
            override fun onImageSizeChanged(rec: Rect) {
                Log.i(Globals.TAG, rec.flattenToString())

                actualCropRect = rec
            }

        })

        return view
    }

    var startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        imageUri = it.data?.data.toString()

        var bitmap_image = getBitmap(requireContext(), null, imageUri, ::UriToBitmap)

        image.layoutParams = image.layoutParams.apply {

            width = bitmap_image.width
            height = bitmap_image.height
        }

        image.setImageBitmap(bitmap_image)
        image.background = BitmapDrawable(resources, bitmap_image)
    }


}