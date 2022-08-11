package id.deval.masakapp.db

import id.deval.masakapp.db.models.Category
import id.deval.masakapp.db.models.DetailMeal
import id.deval.masakapp.db.models.Meal
import id.deval.masakapp.utils.wrappers.WrapperCategori
import id.deval.masakapp.utils.wrappers.WrapperMeal
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("categories.php")
    suspend fun getAllCategories() : WrapperCategori<Category>

    @GET("filter.php")
    suspend fun getMealByCategori(
        @Query("c")
        category: String
    ) : WrapperMeal<Meal>

    @GET("lookup.php")
    suspend fun getDetailMealById(
        @Query("i")
        id: String
    ) : WrapperMeal<DetailMeal>

    @GET("search.php")
    suspend fun searchMealByName(
        @Query("s")
        id: String
    ) : WrapperMeal<Meal>
}