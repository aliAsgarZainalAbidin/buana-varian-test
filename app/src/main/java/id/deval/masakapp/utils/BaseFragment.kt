package id.deval.masakapp.utils

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import dagger.hilt.android.AndroidEntryPoint
import id.deval.masakapp.viewmodels.MasakViewModel

@AndroidEntryPoint
open class BaseFragment : Fragment() {
    lateinit var mainNavController: NavController
    lateinit var secNavController: NavController
    val masakViewModel: MasakViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainNavController = requireActivity().getMainNavController()
        secNavController = this.getSecNavController()
    }
}