package id.deval.masakapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import id.deval.masakapp.R
import id.deval.masakapp.databinding.FragmentListMealBinding
import id.deval.masakapp.ui.adapter.MealAdapter
import id.deval.masakapp.utils.BaseFragment
import id.deval.masakapp.utils.Constanta

class ListMealFragment : BaseFragment() {

    private lateinit var _binding: FragmentListMealBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = arguments?.getString(Constanta.CATEGORY, "")
        with(binding) {
            masakViewModel.getMealByCategory(category!!).observe(viewLifecycleOwner) {
                rvListmealMeal.apply {
                    val adapterMeal = MealAdapter(it.meals, requireContext(), mainNavController, "beranda")
                    adapterMeal.notifyDataSetChanged()
                    adapter = adapterMeal
                    layoutManager =
                        GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
                }
            }
        }
    }
}