package no.kristiania.eksamenandroid

import android.content.Intent
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment



class StartScreen : Fragment() {
    public lateinit var nameView: EditText
    public lateinit var surnameView: EditText
    public lateinit var image: CropImageView2

    public var imageUri: String? = null

    public var actualCropRect: Rect? = null

    interface OnImageSizeChangedListener {
        fun onImageSizeChanged(rec: Rect)
    }

    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(Globals.TAG, "Start screen onCreate")
        Toast.makeText(activity, "Start screen onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(Globals.TAG, "Start screen onCreateView")
        Toast.makeText(activity, "Start screen onCreateView", Toast.LENGTH_SHORT).show()

        var view = inflater.inflate(R.layout.fragment_start_screen, container, false)

        nameView = view.findViewById<EditText>(R.id.name)
        surnameView = view.findViewById<EditText>(R.id.surname)

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