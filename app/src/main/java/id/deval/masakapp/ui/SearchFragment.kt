package id.deval.masakapp.ui

import android.app.SearchManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import id.deval.masakapp.R
import id.deval.masakapp.databinding.FragmentSearchBinding
import id.deval.masakapp.ui.adapter.MealAdapter
import id.deval.masakapp.utils.BaseFragment
import id.deval.masakapp.utils.GlideApp

class SearchFragment : BaseFragment() {

    private lateinit var _binding: FragmentSearchBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            svSeacrhSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    getData(p0.toString())
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    getData(p0.toString())
                    return true
                }

            })
        }
    }

    fun getData(p0:String){
        with(binding){
            masakViewModel.searchMealByName(p0).observe(viewLifecycleOwner) {
                rvSearchMeal.apply {
                    val adapter = MealAdapter(it.meals, requireContext(), mainNavController)
                    adapter.notifyDataSetChanged()
                    this.adapter = adapter
                    layoutManager =
                        GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
                }
            }
        }
    }

}