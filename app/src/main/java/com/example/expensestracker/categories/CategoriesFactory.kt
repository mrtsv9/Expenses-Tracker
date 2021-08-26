package com.example.expensestracker.categories

import com.example.expensestracker.R

class CategoriesFactory {

    fun createCategories(list: ArrayList<SingleCategory>): ArrayList<SingleCategory> {
        list.add(SingleCategory("Products", R.drawable.ic_shopping_basket, 300))
        list.add(SingleCategory("Cafe", R.drawable.ic_coffee_cup, 300))
        list.add(SingleCategory("Movies", R.drawable.ic_movie, 300))
        list.add(SingleCategory("Transport", R.drawable.ic_public_transport, 300))
        list.add(SingleCategory("Health", R.drawable.ic_shopping_basket, 300))
        list.add(SingleCategory("Gifts", R.drawable.ic_shopping_basket, 300))
        list.add(SingleCategory("Family", R.drawable.ic_shopping_basket, 300))
        list.add(SingleCategory("Shopping", R.drawable.ic_shopping_basket, 300))
        list.add(SingleCategory("Sport", R.drawable.ic_shopping_basket, 300))
        list.add(SingleCategory("Home things", R.drawable.ic_shopping_basket, 300))
        list.add(SingleCategory("Investment", R.drawable.ic_shopping_basket, 300))
        list.add(SingleCategory("Internet", R.drawable.ic_shopping_basket, 300))
        return list
    }

}