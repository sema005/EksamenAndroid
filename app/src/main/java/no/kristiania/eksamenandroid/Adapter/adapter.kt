package no.kristiania.eksamenandroid.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import no.kristiania.eksamenandroid.fragments.reverseImageSearchResults
import no.kristiania.eksamenandroid.fragments.saveResults
import no.kristiania.eksamenandroid.fragments.selectUplodeShowimage

internal class adapter(var context: Context, fm: FragmentManager, var totalTabs: Int) :
    FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                reverseImageSearchResults()
            }
            1 -> {
              saveResults()
            }
            2 -> {
                selectUplodeShowimage()
            }
            else -> getItem(position)
        }


    }

    override fun getCount(): Int {
        return totalTabs
    }


}