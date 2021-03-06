package com.codeinger.moviestack.di.component

import android.content.Context
import com.codeinger.moviestack.api.NetworkConstants

class NetworkComponentFactory {
     companion object{
         fun create(context: Context) : NetworkComponent{
            return DaggerNetworkComponent.factory().create(NetworkConstants.baseUrl,context)
         }
     }
}