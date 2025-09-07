package com.cessup.domain.repositories.eatable

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

/**
 * Meal Repository have every data about the meal.
 *
 * This class is a interface with all functions about food information
 * There are actions that user can perform
 *
 * @author
 *     Cessup
 * @since 1.0
 */
interface MealRepository {
    /* MEAL STARTED HERE */

    /*Functions about Baked Collection*/

    /**
     * This function insert a new Baked in the database
     *
     * @param baked the Baked is the object with the information about it
     * @return a Baked
     */
    suspend fun insertBaked(baked: Baked): Boolean

    /**
     * This function update a Baked document in the collection
     *
     * @param baked the Baked is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateBaked(baked: Baked): Boolean

    /**
     * This function delete a Baked in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteBaked(id: String): Boolean

    /**
     * This function gives all Bakeds
     *
     * @return a list of Bakeds
     */
    suspend fun getBakeds(): List<Baked>

    /*Functions about Bakery Collection*/

    /**
     * This function insert a new Bakery in the database
     *
     * @param bakery the Bakery is the object with the information about it
     * @return a Bakery
     */
    suspend fun insertBakery(bakery: Bakery): Boolean

    /**
     * This function update a Bakery document in the collection
     *
     * @param bakery the Bakery is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateBakery(bakery: Bakery): Boolean

    /**
     * This function delete a Bakery in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteBakery(id: String): Boolean

    /**
     * This function gives all Bakeries
     *
     * @return a list of Bakeries
     */
    suspend fun getBakeries(): List<Bakery>

    /*Functions about Breads Collection*/

    /**
     * This function insert a new Breads in the database
     *
     * @param Bread the Breads is the object with the information about it
     * @return a Breads
     */
    suspend fun insertBread(bread: Bread): Boolean

    /**
     * This function update a Breads document in the collection
     *
     * @param Bread the Breads is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateBread(bread: Bread): Boolean

    /**
     * This function delete a Breads in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteBread(id: String): Boolean

    /**
     * This function gives all Breadss
     *
     * @return a list of Breadss
     */
    suspend fun getBreads(): List<Bread>

    /*Functions about Dessert Collection*/

    /**
     * This function insert a new Dessert in the database
     *
     * @param Dessert the Dessert is the object with the information about it
     * @return a Dessert
     */
    suspend fun insertDessert(dessert: Dessert): Boolean

    /**
     * This function update a Dessert document in the collection
     *
     * @param Dessert the Dessert is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateDessert(dessert: Dessert): Boolean

    /**
     * This function delete a Dessert in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteDessert(id: String): Boolean

    /**
     * This function gives all Desserts
     *
     * @return a list of Desserts
     */
    suspend fun getDesserts(): List<Dessert>

    /*Functions about Main Collection*/

    /**
     * This function insert a new Main in the database
     *
     * @param Main the Main is the object with the information about it
     * @return a Main
     */
    suspend fun insertMain(main: Main): Boolean

    /**
     * This function update a Main document in the collection
     *
     * @param Main the Main is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateMain(main: Main): Boolean

    /**
     * This function delete a Main in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteMain(id: String): Boolean

    /**
     * This function gives all Mains
     *
     * @return a list of Mains
     */
    suspend fun getMains(): List<Main>

    /*Functions about Pasta Collection*/

    /**
     * This function insert a new Pasta object in the database
     *
     * @param Pasta the Pasta is the object with the information about it
     * @return a Pasta
     */
    suspend fun insertPasta(pasta: Pasta): Boolean

    /**
     * This function update a Pasta document in the collection
     *
     * @param Pasta the Pasta is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updatePasta(pasta: Pasta): Boolean

    /**
     * This function delete a Pasta object in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deletePasta(id: String): Boolean

    /**
     * This function gives all Pastas
     *
     * @return a list of Pastas
     */
    suspend fun getPastas(): List<Pasta>

    /*Functions about Rice Collection*/

    /**
     * This function insert a new Rice in the database
     *
     * @param Rice the Rice is the object with the information about it
     * @return a Rice
     */
    suspend fun insertRice(rice: Rice): Boolean

    /**
     * This function update a Rice document in the collection
     *
     * @param Rice the Rice is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateRice(rice: Rice): Boolean

    /**
     * This function delete a Rice in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteRice(id: String): Boolean

    /**
     * This function gives all Rices
     *
     * @return a list of Rices
     */
    suspend fun getRices(): List<Rice>

    /*Functions about Salad Collection*/

    /**
     * This function insert a new Salad in the database
     *
     * @param Salad the Salad is the object with the information about it
     * @return a Salad
     */
    suspend fun insertSalad(salad: Salad): Boolean

    /**
     * This function update a Salad document in the collection
     *
     * @param Salad the Salad is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateSalad(salad: Salad): Boolean

    /**
     * This function delete a Salad in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteSalad(id: String): Boolean

    /**
     * This function gives all Salads
     *
     * @return a list of Salads
     */
    suspend fun getSalads(): List<Salad>

    /*Functions about Sandwich Collection*/

    /**
     * This function insert a new Sandwich in the database
     *
     * @param Sandwich the Sandwich is the object with the information about it
     * @return a Sandwich
     */
    suspend fun insertSandwich(sandwich: Sandwich): Boolean

    /**
     * This function update a Sandwich document in the collection
     *
     * @param Sandwich the Sandwich is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateSandwich(sandwich: Sandwich): Boolean

    /**
     * This function delete a Sandwich in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteSandwich(id: String): Boolean

    /**
     * This function gives all Sandwichs
     *
     * @return a list of Sandwichs
     */
    suspend fun getSandwiches(): List<Sandwich>

    /*Functions about Side Collection*/

    /**
     * This function insert a new Side in the database
     *
     * @param Side the Side is the object with the information about it
     * @return a Side
     */
    suspend fun insertSide(side: Side): Boolean

    /**
     * This function update a Side document in the collection
     *
     * @param Side the Side is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateSide(side: Side): Boolean

    /**
     * This function delete a Side in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteSide(id: String): Boolean

    /**
     * This function gives all Sides
     *
     * @return a list of Sides
     */
    suspend fun getSides(): List<Side>

    /*Functions about Soup Collection*/

    /**
     * This function insert a new Soup in the database
     *
     * @param Soup the Soup is the object with the information about it
     * @return a Soup
     */
    suspend fun insertSoup(soup: Soup): Boolean

    /**
     * This function update a Soup document in the collection
     *
     * @param Soup the Soup is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateSoup(soup: Soup): Boolean

    /**
     * This function delete a Soup in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteSoup(id: String): Boolean

    /**
     * This function gives all Soups
     *
     * @return a list of Soups
     */
    suspend fun getSoups(): List<Soup>

    /*Functions about Starter Collection*/

    /**
     * This function insert a new Starter in the database
     *
     * @param Starter the Starter is the object with the information about it
     * @return a Starter
     */
    suspend fun insertStarter(starter: Starter): Boolean

    /**
     * This function update a Starter document in the collection
     *
     * @param Starter the Starter is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateStarter(starter: Starter): Boolean

    /**
     * This function delete a Starter in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteStarter(id: String): Boolean

    /**
     * This function gives all Starters
     *
     * @return a list of Starters
     */
    suspend fun getStarters(): List<Starter>

    /*Functions about Wrap Collection*/

    /**
     * This function insert a new Wrap in the database
     *
     * @param Wrap the Wrap is the object with the information about it
     * @return a Wrap
     */
    suspend fun insertWrap(wrap: Wrap): Boolean

    /**
     * This function update a Wrap document in the collection
     *
     * @param Wrap the Wrap is the object with the information about it
     * @return a boolean that is the result about the process in database
     */
    suspend fun updateWrap(wrap: Wrap): Boolean

    /**
     * This function delete a Wrap in the database
     *
     * @param id the id is the identifier to find it
     * @return a boolean that is the result about the process in database
     */
    suspend fun deleteWrap(id: String): Boolean

    /**
     * This function gives all Wraps
     *
     * @return a list of Wraps
     */
    suspend fun getWraps(): List<Wrap>
}