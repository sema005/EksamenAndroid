package no.kristiania.eksamenandroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class Resultat() : Fragment() {

     val imageArrayList = arrayOf("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmfTNwlywv21jkT8pFSCn7ug2xSsS84SQoCWQO3sKIZ8m4oYJvmYKoqg9tWA&s", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqkVmie6BekmRXfTy-6s9vPMn_57cZ1mnGrFrd240gE3uEMEXiKZuuHIpeWw&s", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo0xGtkreX0SxdnNqDpj1QLs3cr2R9eBK941c70mZ89VV0arvMTDnxRyaEgg&s", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQklFynskrArT6vkBOzLwNJCHwOiTQi4zhlUKMmxW8eoHDdXBCOqGRR7eNwLQ&s", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRN2ZFK7onoO7kfKsxYZEJIHxIRFA3M_I7hrxLz2rEpogKCKy2NZBSY9aXqJg&s" )

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_resultat, container, false)

        val showImages = view.findViewById<Button>(R.id.showImages)
        showImages.setOnClickListener{
            Log.e("NO", "YES")
            for(i in imageArrayList){
                Log.e("Image=", i)
            }
        }


        return view

    }



}
