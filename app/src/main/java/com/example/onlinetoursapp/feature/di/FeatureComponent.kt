package com.example.onlinetoursapp.feature.di

import com.example.onlinetoursapp.feature.HotelFragment
import com.example.onlinetoursapp.feature.ToursSearchFragment
import com.example.onlinetoursapp.feature.dialogs.SearchFromDialog
import dagger.Component

@FeatureScope
@Component(
    modules = [
        FeatureModule::class
    ],
    dependencies = [
        FeatureComponentDependencies::class
    ]
)
interface FeatureComponent {

    fun inject(fragment: ToursSearchFragment)
    fun inject(dialog: SearchFromDialog)
    fun inject(fragment: HotelFragment)

    @Component.Factory
    interface Factory {
        fun create(appComponent: FeatureComponentDependencies): FeatureComponent
    }
}