package no.kristiania.eksamenandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import no.kristiania.eksamenandroid.fragments.adapters.viewPagerAdapter
import no.kristiania.eksamenandroid.fragments.reverseImageSearchResults
import no.kristiania.eksamenandroid.fragments.saveResults
import no.kristiania.eksamenandroid.fragments.selectUplodeShowimage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setUpTabs()
    }

    private fun setUpTabs(){
        val adapter = viewPagerAdapter(supportFragmentManager)
        adapter.addFragment(reverseImageSearchResults,"Reverse Image Search Result")
        adapter.addFragment(saveResults, "save result")
        adapter.addFragment(selectUplodeShowimage, "select Uplode IMG")
        viewPager.adapter = adapter
        tabs.setupWithVewpager(viewPager)

        tabs.getTabAT

    }
}