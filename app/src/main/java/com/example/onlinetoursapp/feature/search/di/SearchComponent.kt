package com.example.onlinetoursapp.feature.search.di

import com.example.onlinetoursapp.common.application.di.AppComponent
import com.example.onlinetoursapp.feature.search.ToursSearchFragment
import com.example.onlinetoursapp.feature.search.dialogs.SearchFromDialog
import dagger.Component

@SearchScope
@Component(
    modules = [
        SearchFeatureModule::class
    ],
    dependencies = [AppComponent::class]
)
interface SearchComponent {

    fun inject(fragment: ToursSearchFragment)
    fun inject(dialog: SearchFromDialog)

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): SearchComponent
    }
}