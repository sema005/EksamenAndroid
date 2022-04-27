package no.kristiania.eksamenandroid

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_legg_til_bilde)

        val oldSelectedStudent :ImagesIncoming = (intent.getSerializableExtra("selected_student") as ImagesIncoming)


        val imageView: CropImageView2 = findViewById<CropImageView2>(R.id.image)

        var image: Bitmap = if (oldSelectedStudent.imageUri != null)
            getBitmap(this, null, oldSelectedStudent.imageUri, ::UriToBitmap) else getBitmap(this, R.drawable.ic_launcher_foreground, null, ::VectorDrawableToBitmap)

        image = Bitmap.createScaledBitmap(image, oldSelectedStudent.imageH, oldSelectedStudent.imageW, false)

        if (oldSelectedStudent.imageUri != null) {
            image = Bitmap.createBitmap(
                image,
                oldSelectedStudent.x,
                oldSelectedStudent.y,
                oldSelectedStudent.w,
                oldSelectedStudent.h
            )

            image = Bitmap.createScaledBitmap(
                image,
                (resources.displayMetrics.density * 200).toInt(),
                (resources.displayMetrics.density * 200).toInt(),
                false
            )
        }
        imageView.setImageBitmap(image)


}

}
