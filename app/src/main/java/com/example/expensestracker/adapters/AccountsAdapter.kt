package com.example.expensestracker.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.expensestracker.R
import com.example.expensestracker.accounts.SingleAccount

class AccountsAdapter(
    var context: Context,
    var list: ArrayList<SingleAccount>
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
        val view: View = View.inflate(context, R.layout.single_account, null)
        val accountName: TextView = view.findViewById(R.id.tvAccountName)
        val accountImage: ImageView = view.findViewById(R.id.ivAccount)
        val accountBalance: TextView = view.findViewById(R.id.tvAccountBalance)

        val listItem = list[position]

        accountName.text = listItem.name
        accountImage.setImageResource(listItem.image!!)
        accountBalance.text = listItem.balance.toString()

        return view
    }

}