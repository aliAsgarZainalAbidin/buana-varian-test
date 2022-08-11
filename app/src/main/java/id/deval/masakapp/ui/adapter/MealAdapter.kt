package id.deval.masakapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.deval.masakapp.R
import id.deval.masakapp.databinding.RvMealsBinding
import id.deval.masakapp.db.models.Meal
import id.deval.masakapp.utils.Constanta

class MealAdapter(
    private val listData: ArrayList<Meal>,
    private val context: Context,
    private val navController: NavController
) : RecyclerView.Adapter<MealAdapter.MealViewHolder>() {
    class MealViewHolder(private val binding: RvMealsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Meal, context: Context, navController: NavController) {
            with(binding) {
                Glide.with(context)
                    .load(data.strMealThumb)
                    .into(ivRvcategoryImage)

                mtvRvcategoryTitle.text = data.strMeal
                clRvcategoryContainer.setOnClickListener {
                    val bundle = bundleOf()
                    bundle.putString(Constanta.ID, data.idMeal)
                    navController.navigate(R.id.action_listMealFragment_to_detailMealFragment, bundle)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = RvMealsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(listData[position], context, navController)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}