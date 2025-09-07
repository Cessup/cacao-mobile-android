package com.cessup.cacao_mobile_android.platform.ui.eatable

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cessup.domain.models.eatable.drink.Beer
import com.cessup.domain.repositories.eatable.DrinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(
    repository: DrinkRepository
) : ViewModel() {

    private val _beers = MutableStateFlow<List<Beer>>(emptyList())
    val beers: StateFlow<List<Beer>> = _beers

    init {
        viewModelScope.launch {
            repository.getBeers().collect { beerList ->
                _beers.value = beerList
            }
        }
    }
}