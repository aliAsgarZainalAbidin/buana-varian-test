package id.deval.masakapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.deval.masakapp.R
import id.deval.masakapp.databinding.FragmentDetailMealBinding
import id.deval.masakapp.utils.BaseFragment
import id.deval.masakapp.utils.Constanta
import id.deval.masakapp.utils.GlideApp


class DetailMealFragment : BaseFragment() {

    private lateinit var _binding: FragmentDetailMealBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString(Constanta.ID, "")
        with(binding) {
            masakViewModel.getDetailMealById(id!!).observe(viewLifecycleOwner) {
                val data = it.meals[0]
                GlideApp.with(requireContext())
                    .load(data.strMealThumb)
                    .into(ivDetailmealImage)

                mtvDetailmealName.text = data.strMeal
                mtvDetailmealCategory.text = data.strCategory
                mtvDetailmealCountry.text = data.strArea
                mtvDetailmealTag.text = data.strTags
                mtvDetailmealYt.text = data.strYoutube
                mtvDetailmealInstruction.text = data.strInstructions
                mtvDetailmealYt.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.strYoutube))
                    startActivity(intent)
                }
            }
        }
    }

}