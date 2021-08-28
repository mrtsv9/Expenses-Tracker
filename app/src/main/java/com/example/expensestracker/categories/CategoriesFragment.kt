package com.example.expensestracker.categories

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import com.example.expensestracker.R
import com.example.expensestracker.adapters.CategoriesAdapter
import com.example.expensestracker.databinding.FragmentCategoriesBinding

class CategoriesFragment() : Fragment() {

    private var binding: FragmentCategoriesBinding? = null
    private var categoriesList: ArrayList<SingleCategory>? = null
    private var categoriesAdapter: CategoriesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gridView = binding?.gvCategories
        categoriesList = ArrayList()
        categoriesList = CategoriesFactory.createCategories(categoriesList!!)
        categoriesAdapter = activity?.applicationContext?.let { CategoriesAdapter(it,
            categoriesList!!) }

        gridView?.adapter = categoriesAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}