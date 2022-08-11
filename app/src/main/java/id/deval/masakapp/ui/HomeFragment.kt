package id.deval.masakapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.deval.masakapp.R
import id.deval.masakapp.databinding.FragmentHomeBinding
import id.deval.masakapp.utils.BaseFragment

class HomeFragment : BaseFragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            bnvHomeContainer.setOnItemSelectedListener {
                secNavController.popBackStack(
                    secNavController.currentDestination?.id ?: R.id.berandaFragment, true
                )

                when (it.itemId) {
                    R.id.beranda -> {
                        secNavController.navigate(R.id.berandaFragment)
                        true
                    }
                    R.id.searchMenu -> {
                        secNavController.navigate(R.id.searchFragment)
                        true
                    }
                    else -> true
                }
            }
        }
    }

}