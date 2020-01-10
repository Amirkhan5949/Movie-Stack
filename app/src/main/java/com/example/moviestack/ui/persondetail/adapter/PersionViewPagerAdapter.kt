package com.example.moviestack.ui.persondetail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.moviestack.ui.common.movielist.simplelist.MovieListFragment
import com.example.moviestack.ui.common.movielist.MovieListType
import com.example.moviestack.ui.persondetail.info.PersonInfoFragment

class PersionViewPagerAdapter(fm : FragmentManager,var id :String) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                PersonInfoFragment.newInstance(id)
            }

            1 -> {
                var movieListType = MovieListType(data = id,type = MovieListType.Type.MOVIE_CREDITS);
                MovieListFragment.newInstance(movieListType)
            }

            2 -> {
                var movieListType = MovieListType(data = id,type = MovieListType.Type.TV_CREDITS);
                MovieListFragment.newInstance(movieListType)
            }

            else -> {
                PersonInfoFragment()
            }
        }
    }

    override fun getCount(): Int {
        return  3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 ->  "Info"
            1 ->  "Movies"
            2 ->  "Tv shows"
            else -> ""
        }
    }
}