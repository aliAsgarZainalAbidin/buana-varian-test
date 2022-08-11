package id.deval.masakapp.ui

import android.app.SearchManager
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.deval.masakapp.R
import id.deval.masakapp.databinding.FragmentBerandaBinding
import id.deval.masakapp.db.models.Category
import id.deval.masakapp.ui.adapter.CategoryAdapter
import id.deval.masakapp.ui.adapter.MealAdapter
import id.deval.masakapp.utils.BaseFragment

@AndroidEntryPoint
class BerandaFragment : BaseFragment() {

    private lateinit var _binding: FragmentBerandaBinding
    private val binding get() = _binding
    private lateinit var listData: ArrayList<Category>
    private var isAscending = false
    private lateinit var adapterCategory: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBerandaBinding.inflate(inflater)
        return binding.root
    }

    fun selector(data: Category): String = data.strCategory.toString()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listData = arrayListOf()

        with(binding) {
            masakViewModel.getAllCategories().observe(viewLifecycleOwner) {
                listData.addAll(it.categories)
                adapterCategory = CategoryAdapter(listData, requireContext(), mainNavController)
                refreshRecyclerViewCategory(listData)
            }

            svSeacrhSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    svSeacrhSearch.clearFocus()
                    refreshRecyclerViewCategory(listData)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    val newList = arrayListOf<Category>()

                    listData.forEach {
                        val isValid = it.strCategory!!.contains(newText.toString(), true)
                        if (isValid) {
                            newList.add(it)
                        }
                    }
                    refreshRecyclerViewCategory(newList)
                    return false
                }

            })

            mtBerandaToolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.sort -> {
                        if (isAscending) {
                            listData.sortBy { data ->
                                selector(data)
                            }
                            isAscending = false
                        } else {
                            listData.sortByDescending { data ->
                                selector(data)
                            }
                            isAscending = true
                        }
                        refreshRecyclerViewCategory(listData)
                        true
                    }
                    else -> false
                }
            }
        }
    }

    fun refreshRecyclerViewCategory(listCategory: ArrayList<Category>) {
        with(binding) {
            rvBerandaCategori.apply {
                adapterCategory = CategoryAdapter(listCategory, requireContext(), mainNavController)
                adapterCategory.notifyDataSetChanged()
                adapter = adapterCategory
                layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
        }
    }

}