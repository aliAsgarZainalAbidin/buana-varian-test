package id.deval.masakapp.utils.wrappers

import com.google.gson.annotations.SerializedName
import id.deval.masakapp.db.models.Category

data class WrapperCategori<T>(
    @field:SerializedName("categories")
    val categories: ArrayList<T>
)
