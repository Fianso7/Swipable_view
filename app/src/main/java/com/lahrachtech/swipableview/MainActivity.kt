package com.lahrachtech.swipableview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf<Int>(
            R.drawable.name2,
            R.drawable.name3,
            R.drawable.name5,
            R.drawable.name6,
            R.drawable.name8,
            R.drawable.name10,
            R.drawable.name11,
            R.drawable.name12,
            R.drawable.name13,
        )
        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter


        TabLayoutMediator(tabayout,viewPager){tab ,position ->
            tab.text = "tab ${position+1}"
        }.attach()

        tabayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"Reselected${tab?.text}",Toast.LENGTH_SHORT).show()

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"Unselected${tab?.text}",Toast.LENGTH_SHORT).show()

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"Selected${tab?.text}",Toast.LENGTH_SHORT).show()
            }
        })

        }
    }
