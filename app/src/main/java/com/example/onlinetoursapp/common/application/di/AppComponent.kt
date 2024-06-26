package com.example.onlinetoursapp.common.application.di

import android.app.Application
import com.example.onlinetoursapp.common.application.ToursApplication
import com.example.onlinetoursapp.feature.di.FeatureComponentDependencies
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        ApiModule::class
    ]
)
interface AppComponent : FeatureComponentDependencies {

    fun inject(app: ToursApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}