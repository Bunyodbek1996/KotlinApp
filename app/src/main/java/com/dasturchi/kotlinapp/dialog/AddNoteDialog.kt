package com.dasturchi.kotlinapp.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import com.dasturchi.kotlinapp.MainActivity
import com.dasturchi.kotlinapp.R
import com.dasturchi.kotlinapp.data.MyDatabase
import com.dasturchi.kotlinapp.data.entity.Note
import com.dasturchi.kotlinapp.util.DB_NAME
import com.dasturchi.kotlinapp.viewmodel.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_add_note.view.*

class AddNoteDialog(
    private var viewModel: MainViewModel
) : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.dialog_add_note,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.btnAdd.setOnClickListener {
            var title = view.edtTitleNote.text.toString()
            var content = view.edtContentNote.text.toString()
            if (title.isNullOrEmpty() || content.isNullOrEmpty()) return@setOnClickListener

            val db = Room.databaseBuilder(
                this.requireContext(),
                MyDatabase::class.java,
                DB_NAME
            ).allowMainThreadQueries().build()

            val note = Note(0,title,content)
            db.getNoteDao().insertNote(note)
            viewModel.readNote()
            this.dismiss()
        }
    }
}