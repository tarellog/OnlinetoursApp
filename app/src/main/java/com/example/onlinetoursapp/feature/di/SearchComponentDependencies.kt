package com.example.onlinetoursapp.feature.di

import android.content.Context
import com.example.onlinetoursapp.common.network.SearchApi

interface SearchComponentDependencies {
    val context: Context
    val searchApi: SearchApi
}