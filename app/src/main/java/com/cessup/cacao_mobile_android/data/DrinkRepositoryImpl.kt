package com.cessup.cacao_mobile_android.data

import com.cessup.cacao_mobile_android.data.entities.eatable.BrandEntity
import com.cessup.cacao_mobile_android.data.entities.eatable.EnergyEntity
import com.cessup.cacao_mobile_android.data.entities.eatable.drink.BeerEntity
import com.cessup.cacao_mobile_android.data.entities.eatable.drink.DrinkEntity
import com.cessup.cacao_mobile_android.data.source.remote.DrinkService
import com.cessup.domain.models.eatable.Brand
import com.cessup.domain.models.eatable.Energy
import com.cessup.domain.models.eatable.drink.Beer
import com.cessup.domain.models.eatable.drink.Chocolate
import com.cessup.domain.models.eatable.drink.Cocktail
import com.cessup.domain.models.eatable.drink.Coffee
import com.cessup.domain.models.eatable.drink.Drink
import com.cessup.domain.models.eatable.drink.Juice
import com.cessup.domain.models.eatable.drink.Liqueur
import com.cessup.domain.models.eatable.drink.Mocktail
import com.cessup.domain.models.eatable.drink.Smoothie
import com.cessup.domain.models.eatable.drink.Soda
import com.cessup.domain.models.eatable.drink.Spirit
import com.cessup.domain.models.eatable.drink.Tea
import com.cessup.domain.models.eatable.drink.Tequila
import com.cessup.domain.models.eatable.drink.Water
import com.cessup.domain.models.eatable.drink.Wine
import com.cessup.domain.repositories.eatable.DrinkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class DrinkRepositoryImpl @Inject constructor(
    private val api: DrinkService
): DrinkRepository {
    override suspend fun insertBeer(beer: Beer): Boolean {
        val beerEntity = BeerEntity(
            beer.id,
            beer.description,
            beer.imgURL,
            BrandEntity(
                beer.brand.id,
                beer.brand.name,
                beer.brand.description,
                beer.brand.img,
            ),
            DrinkEntity(
                beer.drink.id,
                beer.drink.name,
                beer.drink.temperature,
                beer.drink.isAlcoholic,
                beer.drink.millilitres,
                EnergyEntity(
                    beer.drink.energy.id,
                    beer.drink.energy.energyContent,
                    beer.drink.energy.perServing,
                    beer.drink.energy.protein,
                    beer.drink.energy.totalFat,
                    beer.drink.energy.saturatedFat,
                    beer.drink.energy.transFat,
                    beer.drink.energy.carbohydrates,
                    beer.drink.energy.sugars,
                    beer.drink.energy.addedSugars,
                    beer.drink.energy.dietaryFiber,
                    beer.drink.energy.sodium,
                    beer.drink.energy.ingredients,
                )
            )
        )

        return api.newBeer(beerEntity).isSuccessful
    }

    override suspend fun updateBeer(beer: Beer): Boolean {
        val beerEntity = BeerEntity(
            beer.id,
            beer.description,
            beer.imgURL,
            BrandEntity(
                beer.brand.id,
                beer.brand.name,
                beer.brand.description,
                beer.brand.img,
            ),
            DrinkEntity(
                beer.drink.id,
                beer.drink.name,
                beer.drink.temperature,
                beer.drink.isAlcoholic,
                beer.drink.millilitres,
                EnergyEntity(
                    beer.drink.energy.id,
                    beer.drink.energy.energyContent,
                    beer.drink.energy.perServing,
                    beer.drink.energy.protein,
                    beer.drink.energy.totalFat,
                    beer.drink.energy.saturatedFat,
                    beer.drink.energy.transFat,
                    beer.drink.energy.carbohydrates,
                    beer.drink.energy.sugars,
                    beer.drink.energy.addedSugars,
                    beer.drink.energy.dietaryFiber,
                    beer.drink.energy.sodium,
                    beer.drink.energy.ingredients,
                )
            )
        )

        return api.updateBeer(beerEntity).isSuccessful
    }

    override suspend fun deleteBeer(id: String): Boolean {
        return api.deleteBeer(id).isSuccessful
    }

    override suspend fun getBeers(): Flow<List<Beer>> {
        var list: List<Beer> = arrayListOf()
        val response = api.getBeers()

        if (response.body() != null) {
            list = response.body().let { list ->
                list?.map { beerEntity ->
                    Beer(
                        beerEntity.id,
                        beerEntity.description,
                        beerEntity.imgURL,
                        Brand(
                            beerEntity.brandEntity.id,
                            beerEntity.brandEntity.name,
                            beerEntity.brandEntity.description,
                            beerEntity.brandEntity.img,
                        ),
                        Drink(
                            beerEntity.drinkEntity.id,
                            beerEntity.drinkEntity.name,
                            beerEntity.drinkEntity.temperature,
                            beerEntity.drinkEntity.isAlcoholic,
                            beerEntity.drinkEntity.millilitres,
                            Energy(
                                beerEntity.drinkEntity.energyEntity.id,
                                beerEntity.drinkEntity.energyEntity.energyContent,
                                beerEntity.drinkEntity.energyEntity.perServing,
                                beerEntity.drinkEntity.energyEntity.protein,
                                beerEntity.drinkEntity.energyEntity.totalFat,
                                beerEntity.drinkEntity.energyEntity.saturatedFat,
                                beerEntity.drinkEntity.energyEntity.transFat,
                                beerEntity.drinkEntity.energyEntity.carbohydrates,
                                beerEntity.drinkEntity.energyEntity.sugars,
                                beerEntity.drinkEntity.energyEntity.addedSugars,
                                beerEntity.drinkEntity.energyEntity.dietaryFiber,
                                beerEntity.drinkEntity.energyEntity.sodium,
                                beerEntity.drinkEntity.energyEntity.ingredients,
                            )
                        )
                    )
                } ?: arrayListOf()
            }
        }
        return flow { emit(list) }
    }

    override suspend fun insertChocolate(chocolate: Chocolate): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateChocolate(chocolate: Chocolate): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteChocolate(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getChocolates(): List<Chocolate> {
        TODO("Not yet implemented")
    }

    override suspend fun insertCocktail(cocktail: Cocktail): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateCocktail(cocktail: Cocktail): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCocktail(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getCocktails(): List<Cocktail> {
        TODO("Not yet implemented")
    }

    override suspend fun insertCoffee(coffee: Coffee): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateCoffee(coffee: Coffee): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCoffee(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getCoffees(): List<Coffee> {
        TODO("Not yet implemented")
    }

    override suspend fun insertJuice(juice: Juice): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateJuice(juice: Juice): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteJuice(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getJuices(): List<Juice> {
        TODO("Not yet implemented")
    }

    override suspend fun insertLiqueur(liqueur: Liqueur): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateLiqueur(liqueur: Liqueur): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteLiqueur(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getLiqueurs(): List<Liqueur> {
        TODO("Not yet implemented")
    }

    override suspend fun insertMocktail(mocktail: Mocktail): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateMocktail(mocktail: Mocktail): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMocktail(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getMocktails(): List<Mocktail> {
        TODO("Not yet implemented")
    }

    override suspend fun insertSmoothie(smoothie: Smoothie): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateSmoothie(smoothie: Smoothie): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSmoothie(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getSmoothies(): List<Smoothie> {
        TODO("Not yet implemented")
    }

    override suspend fun insertSoda(soda: Soda): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateSoda(soda: Soda): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSoda(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getSodas(): List<Soda> {
        TODO("Not yet implemented")
    }

    override suspend fun insertSpirit(spirit: Spirit): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateSpirit(spirit: Spirit): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSpirit(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getSpirits(): List<Spirit> {
        TODO("Not yet implemented")
    }

    override suspend fun insertTea(tea: Tea): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateTea(tea: Tea): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTea(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getTeas(): List<Tea> {
        TODO("Not yet implemented")
    }

    override suspend fun insertTequila(tequila: Tequila): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateTequila(tequila: Tequila): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTequila(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getTequilas(): List<Tequila> {
        TODO("Not yet implemented")
    }

    override suspend fun insertWater(water: Water): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateWater(water: Water): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWater(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getWaters(): List<Water> {
        TODO("Not yet implemented")
    }

    override suspend fun insertWine(wine: Wine): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateWine(wine: Wine): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWine(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getWines(): List<Wine> {
        TODO("Not yet implemented")
    }
}