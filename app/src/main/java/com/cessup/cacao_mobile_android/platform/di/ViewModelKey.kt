package com.cessup.cacao_mobile_android.platform.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * ViewModelKey is a custom annotation for multibinding ViewModels in a dependency injection setup.
 *
 * It is part of the pattern used to allow injecting different ViewModels into a Dagger map, so that they can be provided through a ViewModelFactory.
 *
 * @author
 *     Cessup
 * @since 1.0
 */
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)