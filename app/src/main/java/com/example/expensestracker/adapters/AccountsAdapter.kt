package com.example.expensestracker.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensestracker.R
import com.example.expensestracker.database.AccountEntity


class AccountsAdapter : RecyclerView.Adapter<AccountsAdapter.MyViewHolder>() {

    private var list = emptyList<AccountEntity>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val ivAccount: ImageView = itemView.findViewById(R.id.ivAccount)
        private val tvAccountName: TextView = itemView.findViewById(R.id.tvAccountName)
        private val tvAccountBalance: TextView = itemView.findViewById(R.id.tvAccountBalance)

        fun bind(item: AccountEntity) {
            item.image?.let { ivAccount.setImageResource(it) }
            tvAccountName.text = item.name
            tvAccountBalance.text = item.balance.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_account, parent, false))
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setData(account: List<AccountEntity>) {
        this.list = account
        notifyDataSetChanged()
    }

}