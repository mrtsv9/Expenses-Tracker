package com.example.expensestracker.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.expensestracker.R
import com.example.expensestracker.categories.SingleCategory

class CategoriesAdapter(
    var context: Context,
    var list: ArrayList<SingleCategory>,
    ) : BaseAdapter() {


    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.single_category, null)
        val categoryText: TextView = view.findViewById(R.id.tvCategory)
        val categoryImage: ImageView = view.findViewById(R.id.ivCategory)
        val categoryBalance: TextView = view.findViewById(R.id.tvCategoryBalance)



        val listItem = list[position]
        categoryText.text = listItem.name
        categoryImage.setImageResource(listItem.image!!)
        categoryBalance.text = listItem.totalPrice.toString()

        return view
    }



}