package id.deval.masakapp.utils.wrappers

import com.google.gson.annotations.SerializedName
import id.deval.masakapp.db.models.Category

data class WrapperMeal<T>(
    @field:SerializedName("meals")
    val meals: ArrayList<T>
)
