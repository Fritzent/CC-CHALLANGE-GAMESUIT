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
import kotlinx.android.synthetic.main.add_memo_layout.view.*
import kotlinx.android.synthetic.main.update_memo_layout.*
import kotlinx.android.synthetic.main.update_memo_layout.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateMemo: DialogFragment() {
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
        val view: View = inflater.inflate(R.layout.update_memo_layout, container,false)
        val cancelButton = view.findViewById<Button>(R.id.btn_cancel_memo_update)
        val updateButton = view.findViewById<Button>(R.id.btn_update_memo)
        val deleteButton = view.findViewById<Button>(R.id.btn_delete_memo_update)

        view.et_tanggal_memo_update.setText(tanggal)
        view.et_isi_memo_update.setText(isiMemo)

        DatabaseMemo.getInstance(view.context)?.let {
            db = it
        }

        cancelButton.setOnClickListener { dismiss() }

        updateButton.setOnClickListener { //here code to add the memo to recyclerview
            listMemo.apply {
                tanggal = et_tanggal_memo_update.text.toString()
                isiMemo =  et_isi_memo_update.text.toString()
            }

            GlobalScope.launch {
                val memoSaved = db.memoDao().add(listMemo)

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

        deleteButton.setOnClickListener {
            GlobalScope.launch {
                val delete = db.memoDao().delete(listMemo)
                dismiss()
                (activity as ProfileActivity).fetchData()
            }
        }

        return view
    }

    companion object {
        lateinit var tanggal: String
        lateinit var isiMemo: String
        lateinit var listMemo: Memo
        fun newInstance(date: String, memo: String, list: Memo): UpdateMemo {
            tanggal = date
            isiMemo = memo
            listMemo = list
            return UpdateMemo()
        }
    }
}