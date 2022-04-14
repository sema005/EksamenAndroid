package no.kristiania.eksamenandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

import com.google.android.material.tabs.TabLayout
import no.kristiania.eksamenandroid.Adapter.adapter

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("reverseImageSearchResult"))
        tabLayout.addTab(tabLayout.newTab().setText("saveResult"))
        tabLayout.addTab(tabLayout.newTab().setText("SelectUplodeShowimage"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapteren = adapter(this, supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapteren

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }



    }
