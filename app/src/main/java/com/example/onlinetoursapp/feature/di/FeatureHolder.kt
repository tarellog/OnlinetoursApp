package com.example.onlinetoursapp.feature.di

import com.example.onlinetoursapp.common.application.ToursApplication

object FeatureHolder {
    private var component: FeatureComponent? = null

    fun createComponent(): FeatureComponent {
        if (component == null) {
            component =
                DaggerFeatureComponent.factory()
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