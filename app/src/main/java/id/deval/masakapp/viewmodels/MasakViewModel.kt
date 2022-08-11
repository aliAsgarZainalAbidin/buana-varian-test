package id.deval.masakapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.deval.masakapp.db.Repository
import id.deval.masakapp.db.models.Category
import id.deval.masakapp.db.models.DetailMeal
import id.deval.masakapp.db.models.Meal
import id.deval.masakapp.utils.wrappers.WrapperCategori
import id.deval.masakapp.utils.wrappers.WrapperMeal
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class MasakViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){

    private lateinit var mutableAllCategories : MutableLiveData<WrapperCategori<Category>>
    private lateinit var mutableMeal : MutableLiveData<WrapperMeal<Meal>>
    private lateinit var mutableDetailMeal : MutableLiveData<WrapperMeal<DetailMeal>>
    private lateinit var mutableDetailMealName : MutableLiveData<WrapperMeal<Meal>>

    fun getAllCategories():LiveData<WrapperCategori<Category>>{
        mutableAllCategories = MutableLiveData()
        GlobalScope.launch {
            val response = repository.getAllCategories()
            mutableAllCategories.postValue(response)
        }
        return mutableAllCategories
    }

    fun getMealByCategory(query:String):LiveData<WrapperMeal<Meal>>{
        mutableMeal = MutableLiveData()
        GlobalScope.launch {
            val response = repository.getMealByCategory(query)
            mutableMeal.postValue(response)
        }
        return mutableMeal
    }

    fun getDetailMealById(query:String):LiveData<WrapperMeal<DetailMeal>>{
        mutableDetailMeal = MutableLiveData()
        GlobalScope.launch {
            val response = repository.getDetailMealById(query)
            mutableDetailMeal.postValue(response)
        }
        return mutableDetailMeal
    }

    fun searchMealByName(query:String):LiveData<WrapperMeal<Meal>>{
        mutableDetailMealName = MutableLiveData()
        GlobalScope.launch {
            val response = repository.searchMealByName(query)
            mutableDetailMealName.postValue(response)
        }
        return mutableDetailMealName
    }
}