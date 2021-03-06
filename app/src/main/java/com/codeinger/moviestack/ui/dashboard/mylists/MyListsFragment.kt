package com.codeinger.moviestack.ui.dashboard.mylists


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.codeinger.moviestack.R
import com.codeinger.moviestack.pojo.MyList
import com.codeinger.moviestack.ui.dashboard.MainActivity
import com.codeinger.moviestack.ui.dashboard.mylists.mylistdetail.MyListDetailFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_my_lists.view.*

/**
 * A simple [Fragment] subclass.
 */
class MyListsFragment : Fragment() {

    private lateinit var mView : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar!!.show()
        (activity as MainActivity).bottomNavigationView.menu.getItem(2).isChecked = true

        mView = inflater.inflate(R.layout.fragment_my_lists, container, false)


        mView.tabLayout.addTab(mView.tabLayout.newTab().setText("Movie"))
        mView.tabLayout.addTab(mView.tabLayout.newTab().setText("Tv Show"))

        mView.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                return when(tab.position){
                    0 -> replace(MyListDetailFragment.newInstance(MyList.Type.MOVIE))
                    1 ->  replace(MyListDetailFragment.newInstance(MyList.Type.TV_SHOW))
                    else -> replace(MyListDetailFragment())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        replace(MyListDetailFragment.newInstance(MyList.Type.MOVIE))



        return mView
    }

    fun replace(fragment: Fragment){
        val transaction =  childFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
    }




}
