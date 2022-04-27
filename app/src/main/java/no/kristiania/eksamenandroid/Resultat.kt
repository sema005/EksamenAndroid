package no.kristiania.eksamenandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView


class Resultat(val imagesIncoming: ArrayList<ImagesIncoming>) : Fragment() {
    var itemAdapter: ItemAdapter? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(Globals.TAG, "Resultat onCreateView")
        Toast.makeText(activity, "Resultat onCreateView", Toast.LENGTH_SHORT).show()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_resultat, container, false)

        val recyclerView: RecyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        //Alternatively to defining manager in XML: recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)

        var onItemClickListener = object: View.OnClickListener {
            override fun onClick(view: View?) {

                val position: Int = view?.tag.toString().toInt()
                imagesIncoming.removeAt(position)

                itemAdapter?.notifyDataSetChanged()
            }
        }

        var onItemEditListener = object: View.OnClickListener {
            override fun onClick(view: View?) {

                val position: Int = view?.tag.toString().toInt()
                val selectedStudent: ImagesIncoming = imagesIncoming.get(position)
                selectedStudent.position = position

                val intent: Intent = Intent(activity, EditActivity::class.java)
                intent.putExtra("selected_student", selectedStudent)
                startForResult.launch(intent)
            }
        }

        itemAdapter = ItemAdapter(imagesIncoming, onItemClickListener, onItemEditListener)
        recyclerView.setAdapter(itemAdapter)

        return view
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val updatedStudentInfo: ImagesIncoming = (intent?.getSerializableExtra("selected_student") as ImagesIncoming)

            imagesIncoming.set(updatedStudentInfo.position, updatedStudentInfo)

            itemAdapter?.notifyDataSetChanged()
        }
    }

}