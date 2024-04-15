package com.example.onlinetoursapp.feature.di

import android.content.Context
import com.example.onlinetoursapp.common.network.SearchApi

interface FeatureComponentDependencies {
    val context: Context
    val searchApi: SearchApi
}