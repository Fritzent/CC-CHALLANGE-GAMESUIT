package com.example.codechallange_gamesuit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallange_gamesuit.R
import com.example.codechallange_gamesuit.database.DatabaseMemo
import com.example.codechallange_gamesuit.database.Memo
import com.example.codechallange_gamesuit.view.AddMemo
import com.example.codechallange_gamesuit.view.ProfileActivity
import kotlinx.android.synthetic.main.item_profile_memo.view.*

class MemoAdapter (val listMemo: List<Memo>): RecyclerView.Adapter<MemoAdapter.ViewHolder>() {
    private lateinit var db:DatabaseMemo

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile_memo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMemo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_tanggal_memo.text = listMemo[position].tanggal
        holder.itemView.tv_isi_memo.text = listMemo[position].memo

        DatabaseMemo.getInstance(holder.itemView.context)?.let{
            db = it
        }

        //TODO ADD CODE HERE TO HANDLE UPDATE AND DELETE MEMO
        //THING HOW TO CLICK MEMO AND OPEN THE DIALOG
        holder.itemView.cl_memo.setOnClickListener {
            (it.context as ProfileActivity).editMemo(listMemo[position].tanggal, listMemo[position].memo, listMemo[position])
        }
    }
}