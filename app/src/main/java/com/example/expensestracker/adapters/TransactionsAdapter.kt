package com.example.expensestracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensestracker.R
import com.example.expensestracker.database.AccountEntity
import com.example.expensestracker.database.TransactionEntity

class TransactionsAdapter: RecyclerView.Adapter<TransactionsAdapter.MyViewHolder>() {

    private var list = emptyList<TransactionEntity>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvDisplayCategory : TextView = itemView.findViewById(R.id.tvDisplayCategory)
        private val tvDisplayAccount : TextView = itemView.findViewById(R.id.tvDisplayAccount)
        private val tvDisplayBalance : TextView = itemView.findViewById(R.id.tvDisplayBalance)

        fun bind(item: TransactionEntity) {
            tvDisplayCategory.text = item.category
            tvDisplayAccount.text = item.account
            tvDisplayBalance.text = item.amount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.single_transaction, parent, false))
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setData(transaction: List<TransactionEntity>) {
        this.list = transaction
        notifyDataSetChanged()
    }

}