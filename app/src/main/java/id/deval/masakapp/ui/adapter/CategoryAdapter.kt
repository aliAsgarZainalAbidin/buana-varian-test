package id.deval.masakapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.deval.masakapp.R
import id.deval.masakapp.databinding.RvCategoryBinding
import id.deval.masakapp.db.models.Category
import id.deval.masakapp.utils.Constanta

class CategoryAdapter(
    private val listData: ArrayList<Category>,
    private val context: Context,
    private val navController: NavController
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(private val binding: RvCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Category, context: Context, navController: NavController) {
            with(binding) {
                Glide.with(context)
                    .load(data.strCategoryThumb)
                    .into(ivRvcategoryImage)

                mtvRvcategoryTitle.text = data.strCategory
                mtvRvcategoryDesc.text = data.strCategoryDescription
                clRvcategoryContainer.setOnClickListener {
                    val bundle = bundleOf()
                    bundle.putString(Constanta.CATEGORY, data.strCategory)
                    navController.navigate(R.id.action_homeFragment_to_listMealFragment, bundle)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = RvCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(listData[position], context, navController)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}