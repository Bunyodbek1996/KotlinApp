package com.dasturchi.kotlinapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.dasturchi.kotlinapp.R
import com.dasturchi.kotlinapp.data.MyDatabase
import com.dasturchi.kotlinapp.data.entity.Note
import com.dasturchi.kotlinapp.util.DB_NAME
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter(
    private var notes: List<Note>
) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder
        = NoteHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false))

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        var view = holder.itemView
        var note = notes.get(position)
        view.tvTitleNote.setText(note.title)
        view.tvContentNote.setText(note.content)

        view.del.setOnClickListener {
            val  db = Room.databaseBuilder(
                it.context,
                MyDatabase::class.java,
                DB_NAME
            ).allowMainThreadQueries().build()
            db.getNoteDao().deleteNote(note)
        }
    }

    fun setNotes(list: List<Note>) {
        this.notes = list
    }

    class NoteHolder(view: View) : RecyclerView.ViewHolder(view)

}