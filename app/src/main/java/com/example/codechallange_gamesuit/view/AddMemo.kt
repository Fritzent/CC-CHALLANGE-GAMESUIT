package com.example.codechallange_gamesuit.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.codechallange_gamesuit.R
import com.example.codechallange_gamesuit.database.DatabaseMemo
import com.example.codechallange_gamesuit.database.Memo
import kotlinx.android.synthetic.main.add_memo_layout.*
import kotlinx.android.synthetic.main.add_memo_layout.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddMemo: DialogFragment() {

    private lateinit var db: DatabaseMemo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.add_memo_layout, container,false)
        val cancelButton = view.findViewById<Button>(R.id.btn_cancel_memo)
        val addButton = view.findViewById<Button>(R.id.btn_tambah_memo)

        DatabaseMemo.getInstance(view.context)?.let {
            db = it
        }

        cancelButton.setOnClickListener { dismiss() }

        addButton.setOnClickListener { //here code to add the memo to recyclerview
            val memo = Memo(
                null,
                view.et_tanggal_memo.text.toString(),
                view.et_isi_memo.text.toString()
//                et_tanggal_memo.text.toString(),
//                et_isi_memo.text.toString()
            )

            GlobalScope.launch {
                val memoSaved = db.memoDao().add(memo)

                activity?.runOnUiThread {
                    if(memoSaved > 0) {
                        Toast.makeText(it.context, "Memo telah disimpan", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(it.context, "Memo gagal disimpan", Toast.LENGTH_LONG).show()
                    }
                }
            }
            dismiss()
            (activity as ProfileActivity).fetchData()
        }

        return view
    }
}