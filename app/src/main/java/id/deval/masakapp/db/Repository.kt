package id.deval.masakapp.db

import id.deval.masakapp.db.models.Category
import id.deval.masakapp.db.models.DetailMeal
import id.deval.masakapp.db.models.Meal
import id.deval.masakapp.utils.wrappers.WrapperCategori
import id.deval.masakapp.utils.wrappers.WrapperMeal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val database: Database,
    private val apiInterface: ApiInterface
) {

    suspend fun getAllCategories(): WrapperCategori<Category> {
        return apiInterface.getAllCategories()
    }

    suspend fun getMealByCategory(query: String): WrapperMeal<Meal>{
        return apiInterface.getMealByCategori(query)
    }
    suspend fun getDetailMealById(query: String): WrapperMeal<DetailMeal>{
        return apiInterface.getDetailMealById(query)
    }
    suspend fun searchMealByName(query: String): WrapperMeal<Meal>{
        return apiInterface.searchMealByName(query)
    }

}