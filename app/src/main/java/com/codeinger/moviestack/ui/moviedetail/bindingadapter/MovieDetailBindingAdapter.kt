package com.codeinger.moviestack.ui.moviedetail.bindingadapter


import android.util.Log
import androidx.databinding.BindingAdapter
import com.codeinger.moviestack.pojo.Videos
import com.codeinger.moviestack.utils.adapter.MainSliderAdapter
import com.codeinger.moviestack.utils.PicassoImageLoadingService
import com.google.android.material.appbar.CollapsingToolbarLayout
import ss.com.bannerslider.Slider

object MovieDetailBindingAdapter {
    @JvmStatic
    @BindingAdapter("slider")
    fun setSlider (slider : Slider, result : Videos?){
        Slider.init(PicassoImageLoadingService());
        if (result != null) {

            val arrayList = ArrayList<String>()
            if(result.results.size>0)
                arrayList.add(result.results.get(0).getImage())

            if(result.results.size>1)
                arrayList.add(result.results.get(1).getImage())

            if(result.results.size>2)
                arrayList.add(result.results.get(2).getImage())

            slider.setAdapter(
                MainSliderAdapter(
                    arrayList
                )
            )

            Log.i("sddhvgch","sdcvhsd 1111")
        }
        else{
            Log.i("sddhvgch","sdcvhsd")
        }

    }

    @JvmStatic
    @BindingAdapter("collapsingToolbarTitle")
    fun collapsingToolbarTitle (collapsingToolbarLayout: CollapsingToolbarLayout, result : String?){
        collapsingToolbarLayout.title = result
    }
}