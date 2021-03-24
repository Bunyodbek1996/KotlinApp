package com.dasturchi.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dasturchi.kotlinapp.adapter.NoteAdapter
import com.dasturchi.kotlinapp.dialog.AddNoteDialog
import com.dasturchi.kotlinapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter : NoteAdapter
    private lateinit var viewmodel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "salom dunyo", Toast.LENGTH_SHORT).show()

        viewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewmodel.getNotes().observe(this, Observer {
            mAdapter = NoteAdapter(it)
            Toast.makeText(applicationContext, "${it.size}", Toast.LENGTH_SHORT).show()
            recyclerNote.adapter = mAdapter
        })

        btnAddNote.setOnClickListener {
            var dialog = AddNoteDialog(viewmodel)
            dialog.show(supportFragmentManager,"TAG")
        }
        viewmodel.readNote()
    }
}