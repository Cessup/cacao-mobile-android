package com.cessup.cacao_mobile_android.data

import com.cessup.cacao_mobile_android.data.source.remote.MealService
import com.cessup.domain.models.eatable.meal.Baked
import com.cessup.domain.models.eatable.meal.Bakery
import com.cessup.domain.models.eatable.meal.Bread
import com.cessup.domain.models.eatable.meal.Dessert
import com.cessup.domain.models.eatable.meal.Main
import com.cessup.domain.models.eatable.meal.Pasta
import com.cessup.domain.models.eatable.meal.Rice
import com.cessup.domain.models.eatable.meal.Salad
import com.cessup.domain.models.eatable.meal.Sandwich
import com.cessup.domain.models.eatable.meal.Side
import com.cessup.domain.models.eatable.meal.Soup
import com.cessup.domain.models.eatable.meal.Starter
import com.cessup.domain.models.eatable.meal.Wrap
import com.cessup.domain.repositories.eatable.MealRepository
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val api: MealService
): MealRepository {
    override suspend fun insertBaked(baked: Baked): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateBaked(baked: Baked): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBaked(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getBakeds(): List<Baked> {
        TODO("Not yet implemented")
    }

    override suspend fun insertBakery(bakery: Bakery): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateBakery(bakery: Bakery): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBakery(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getBakeries(): List<Bakery> {
        TODO("Not yet implemented")
    }

    override suspend fun insertBread(bread: Bread): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateBread(bread: Bread): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBread(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getBreads(): List<Bread> {
        TODO("Not yet implemented")
    }

    override suspend fun insertDessert(dessert: Dessert): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateDessert(dessert: Dessert): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDessert(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getDesserts(): List<Dessert> {
        TODO("Not yet implemented")
    }

    override suspend fun insertMain(main: Main): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateMain(main: Main): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMain(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getMains(): List<Main> {
        TODO("Not yet implemented")
    }

    override suspend fun insertPasta(pasta: Pasta): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updatePasta(pasta: Pasta): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deletePasta(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getPastas(): List<Pasta> {
        TODO("Not yet implemented")
    }

    override suspend fun insertRice(rice: Rice): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateRice(rice: Rice): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteRice(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getRices(): List<Rice> {
        TODO("Not yet implemented")
    }

    override suspend fun insertSalad(salad: Salad): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateSalad(salad: Salad): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSalad(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getSalads(): List<Salad> {
        TODO("Not yet implemented")
    }

    override suspend fun insertSandwich(sandwich: Sandwich): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateSandwich(sandwich: Sandwich): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSandwich(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getSandwiches(): List<Sandwich> {
        TODO("Not yet implemented")
    }

    override suspend fun insertSide(side: Side): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateSide(side: Side): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSide(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getSides(): List<Side> {
        TODO("Not yet implemented")
    }

    override suspend fun insertSoup(soup: Soup): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateSoup(soup: Soup): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSoup(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getSoups(): List<Soup> {
        TODO("Not yet implemented")
    }

    override suspend fun insertStarter(starter: Starter): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateStarter(starter: Starter): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStarter(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getStarters(): List<Starter> {
        TODO("Not yet implemented")
    }

    override suspend fun insertWrap(wrap: Wrap): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateWrap(wrap: Wrap): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWrap(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getWraps(): List<Wrap> {
        TODO("Not yet implemented")
    }
}