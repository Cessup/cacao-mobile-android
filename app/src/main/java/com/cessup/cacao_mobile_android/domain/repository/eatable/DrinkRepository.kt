package com.cessup.domain.repositories.eatable

import com.cessup.domain.models.eatable.drink.Beer
import com.cessup.domain.models.eatable.drink.Chocolate
import com.cessup.domain.models.eatable.drink.Cocktail
import com.cessup.domain.models.eatable.drink.Coffee
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
import kotlinx.coroutines.flow.Flow

/**
 * Drink Repository have every data about the drinks.
 *
 * This class is a interface with all functions about food information
 * There are actions that user can perform
 *
 * @author
 *     Cessup
 * @since 1.0
 */
interface DrinkRepository {

    /*Functions about Beer Collection*/

    /**
     * This function insert a new beer in the database
     *
     * @param beer the beer is the object with the information about it
     * @return a beer
     */
    suspend fun insertBeer(beer: Beer): Boolean

    /**
     * This function update a beer document in the collection
     *
     * @param beer the beerEntity is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateBeer(beer: Beer): Boolean

    /**
     * This function delete a beer in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteBeer(id: String): Boolean

    /**
     * This function gives all beers
     *
     * @return a list of beers
     */
    suspend fun getBeers(): Flow<List<Beer>>

    /*Functions about Chocolate Collection*/

    /**
     * This function insert a new Chocolate in the database
     *
     * @param chocolate the ChocolateEntity is the object with the information about it
     * @return a Chocolate
     */
    suspend fun insertChocolate(chocolate: Chocolate): Boolean

    /**
     * This function update a Chocolate document in the collection
     *
     * @param chocolate the ChocolateEntity is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateChocolate(chocolate: Chocolate): Boolean

    /**
     * This function delete a Chocolate in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteChocolate(id: String): Boolean

    /**
     * This function gives all Chocolates
     *
     * @return a list of Chocolates
     */
    suspend fun getChocolates(): List<Chocolate>

    /*Functions about Cocktail Collection*/

    /**
     * This function insert a new Cocktail in the database
     *
     * @param cocktail the CocktailEntity is the object with the information about it
     * @return a Cocktail
     */
    suspend fun insertCocktail(cocktail: Cocktail): Boolean

    /**
     * This function update a Cocktail document in the collection
     *
     * @param cocktail the CocktailEntity is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateCocktail(cocktail: Cocktail): Boolean

    /**
     * This function delete a Cocktail in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteCocktail(id: String): Boolean

    /**
     * This function gives all Cocktails
     *
     * @return a list of Cocktails
     */
    suspend fun getCocktails(): List<Cocktail>

    /*Functions about Coffee Collection*/

    /**
     * This function insert a new Coffee in the database
     *
     * @param coffee the CoffeeEntity is the object with the information about it
     * @return a Coffee
     */
    suspend fun insertCoffee(coffee: Coffee): Boolean

    /**
     * This function update a Coffee document in the collection
     *
     * @param coffee the CoffeeEntity is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateCoffee(coffee: Coffee): Boolean

    /**
     * This function delete a Coffee in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteCoffee(id: String): Boolean

    /**
     * This function gives all Coffees
     *
     * @return a list of Coffees
     */
    suspend fun getCoffees(): List<Coffee>

    /*Functions about Juice Collection*/

    /**
     * This function insert a new Juice in the database
     *
     * @param juice the JuiceEntity is the object with the information about it
     * @return a Juice
     */
    suspend fun insertJuice(juice: Juice): Boolean

    /**
     * This function update a Juice document in the collection
     *
     * @param juice the JuiceEntity is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateJuice(juice: Juice): Boolean

    /**
     * This function delete a Juice in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteJuice(id: String): Boolean

    /**
     * This function gives all Juices
     *
     * @return a list of Juices
     */
    suspend fun getJuices(): List<Juice>

    /*Functions about Liqueur Collection*/

    /**
     * This function insert a new Liqueur in the database
     *
     * @param liqueur the LiqueurEntity is the object with the information about it
     * @return a Liqueur
     */
    suspend fun insertLiqueur(liqueur: Liqueur): Boolean

    /**
     * This function update a Liqueur document in the collection
     *
     * @param liqueur the LiqueurEntity is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateLiqueur(liqueur: Liqueur): Boolean

    /**
     * This function delete a Liqueur in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteLiqueur(id: String): Boolean

    /**
     * This function gives all Liqueurs
     *
     * @return a list of Liqueurs
     */
    suspend fun getLiqueurs(): List<Liqueur>

    /*Functions about Mocktail Collection*/

    /**
     * This function insert a new Mocktail in the database
     *
     * @param mocktail the MocktailEntity is the object with the information about it
     * @return a Mocktail
     */
    suspend fun insertMocktail(mocktail: Mocktail): Boolean

    /**
     * This function update a Mocktail document in the collection
     *
     * @param mocktail the MocktailEntity is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateMocktail(mocktail: Mocktail): Boolean

    /**
     * This function delete a Mocktail in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteMocktail(id: String): Boolean

    /**
     * This function gives all Mocktails
     *
     * @return a list of Mocktails
     */
    suspend fun getMocktails(): List<Mocktail>

    /*Functions about Smoothie Collection*/

    /**
     * This function insert a new Smoothie in the database
     *
     * @param smoothie the smoothie is the object with the information about it
     * @return a Smoothie
     */
    suspend fun insertSmoothie(smoothie: Smoothie): Boolean

    /**
     * This function update a Smoothie document in the collection
     *
     * @param smoothie the smoothie is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateSmoothie(smoothie: Smoothie): Boolean

    /**
     * This function delete a Smoothie in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteSmoothie(id: String): Boolean

    /**
     * This function gives all Smoothies
     *
     * @return a list of Smoothies
     */
    suspend fun getSmoothies(): List<Smoothie>

    /*Functions about Soda Collection*/

    /**
     * This function insert a new Soda in the database
     *
     * @param soda the soda is the object with the information about it
     * @return a Soda
     */
    suspend fun insertSoda(soda: Soda): Boolean

    /**
     * This function update a Soda document in the collection
     *
     * @param soda the soda is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateSoda(soda: Soda): Boolean

    /**
     * This function delete a Soda in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteSoda(id: String): Boolean

    /**
     * This function gives all Sodas
     *
     * @return a list of Sodas
     */
    suspend fun getSodas(): List<Soda>

    /*Functions about Spirit Collection*/

    /**
     * This function insert a new Spirit in the database
     *
     * @param spirit the spirit is the object with the information about it
     * @return a Spirit
     */
    suspend fun insertSpirit(spirit: Spirit): Boolean

    /**
     * This function update a Spirit document in the collection
     *
     * @param spirit the spirit is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateSpirit(spirit: Spirit): Boolean

    /**
     * This function delete a Spirit in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteSpirit(id: String): Boolean

    /**
     * This function gives all Spirits
     *
     * @return a list of Spirits
     */
    suspend fun getSpirits(): List<Spirit>

    /*Functions about Tea Collection*/

    /**
     * This function insert a new Tea in the database
     *
     * @param tea the tea is the object with the information about it
     * @return a Tea
     */
    suspend fun insertTea(tea: Tea): Boolean

    /**
     * This function update a Tea document in the collection
     *
     * @param tea the tea is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateTea(tea: Tea): Boolean

    /**
     * This function delete a Tea in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteTea(id: String): Boolean

    /**
     * This function gives all Teas
     *
     * @return a list of Teas
     */
    suspend fun getTeas(): List<Tea>

    /*Functions about Tequila Collection*/

    /**
     * This function insert a new Tequila in the database
     *
     * @param tequila the tequila is the object with the information about it
     * @return a Tequila
     */
    suspend fun insertTequila(tequila: Tequila): Boolean

    /**
     * This function update a Tequila document in the collection
     *
     * @param tequila the tequila is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateTequila(tequila: Tequila): Boolean

    /**
     * This function delete a Tequila in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteTequila(id: String): Boolean

    /**
     * This function gives all Tequilas
     *
     * @return a list of Tequilas
     */
    suspend fun getTequilas(): List<Tequila>

    /*Functions about Water Collection*/

    /**
     * This function insert new Water in the database
     *
     * @param water the water is the object with the information about it
     * @return a Water
     */
    suspend fun insertWater(water: Water): Boolean

    /**
     * This function update Water document in the collection
     *
     * @param water the water is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateWater(water: Water): Boolean

    /**
     * This function delete Water in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteWater(id: String): Boolean

    /**
     * This function gives all Waters
     *
     * @return a list of Waters
     */
    suspend fun getWaters(): List<Water>

    /*Functions about Wine Collection*/

    /**
     * This function insert a new Wine in the database
     *
     * @param wine the WineEntity is the object with the information about it
     * @return a Wine
     */
    suspend fun insertWine(wine: Wine): Boolean

    /**
     * This function update a Wine document in the collection
     *
     * @param wine the wine is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateWine(wine: Wine): Boolean

    /**
     * This function delete a Wine in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteWine(id: String): Boolean

    /**
     * This function gives all Wines
     *
     * @return a list of Wines
     */
    suspend fun getWines(): List<Wine>
}