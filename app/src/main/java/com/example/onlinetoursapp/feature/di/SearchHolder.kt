package com.example.onlinetoursapp.feature.di

import com.example.onlinetoursapp.common.application.ToursApplication

object SearchHolder {
    private var component: SearchComponent? = null

    fun createComponent(): SearchComponent {
        if (component == null) {
            component =
                DaggerSearchComponent.factory()
                    .create(
                         ToursApplication.appComponent,
                    )
        }
        return component!!
    }

    fun clear() {
        component = null
    }

}