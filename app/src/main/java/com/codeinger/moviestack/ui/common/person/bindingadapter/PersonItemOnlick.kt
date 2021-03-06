package com.codeinger.moviestack.ui.common.person.bindingadapter

import android.content.Intent
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.codeinger.moviestack.ui.persondetail.PersonDetailActivity

object PersonItemOnlick {

    @JvmStatic
    @BindingAdapter("setCreditItemOnlick","setCreditTitle","setCreditImage")
    fun setCreditItemOnlick (layout : ConstraintLayout, result : String?,title : String?,image : String?){

        layout.setOnClickListener{
            Log.i("sdjbcsj","${result} ${title} ${image}")
            val intent = Intent(layout.context, PersonDetailActivity::class.java)
            intent.putExtra("id", "${result}")
            intent.putExtra("title", "${title}")
            intent.putExtra("image", "${image}")
            layout.context.startActivity(intent)
        }

    }

}