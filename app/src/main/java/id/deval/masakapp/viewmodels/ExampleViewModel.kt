package id.deval.masakapp.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.deval.masakapp.db.Repository
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){

}