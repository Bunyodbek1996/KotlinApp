package com.dasturchi.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dasturchi.kotlinapp.adapter.NoteAdapter
import com.dasturchi.kotlinapp.dialog.AddNoteDialog
import com.dasturchi.kotlinapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private var mAdapter = NoteAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "salom dunyo", Toast.LENGTH_SHORT).show()

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        recyclerNote.apply {
            adapter = mAdapter
        }

        btnAddNote.setOnClickListener {
            var dialog  =  AddNoteDialog(viewModel)
            dialog.show(supportFragmentManager,"TAG")
        }

        viewModel.notes().observe(this, Observer {
            mAdapter.setNotes(it)
        })

        viewModel.readData()
    }
}
