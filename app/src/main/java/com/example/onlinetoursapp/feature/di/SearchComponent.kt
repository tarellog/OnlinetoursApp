package com.example.onlinetoursapp.feature.di

import com.example.onlinetoursapp.feature.HotelFragment
import com.example.onlinetoursapp.feature.ToursSearchFragment
import com.example.onlinetoursapp.feature.dialogs.SearchFromDialog
import dagger.Component

@SearchScope
@Component(
    modules = [
        SearchFeatureModule::class
    ],
    dependencies = [
        SearchComponentDependencies::class
    ]
)
interface SearchComponent {

    fun inject(fragment: ToursSearchFragment)
    fun inject(dialog: SearchFromDialog)
    fun inject(fragment: HotelFragment)

    @Component.Factory
    interface Factory {
        fun create(appComponent: SearchComponentDependencies): SearchComponent
    }
}