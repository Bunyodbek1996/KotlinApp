package com.dasturchi.kotlinapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.dasturchi.kotlinapp.data.MyDatabase
import com.dasturchi.kotlinapp.data.entity.Note
import com.dasturchi.kotlinapp.util.DB_NAME

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private var notes = MutableLiveData<List<Note>>()

    fun getNotes() : LiveData<List<Note>>{
        return notes
    }

    fun readNote(){
        val db = Room.databaseBuilder(
            getApplication(),
            MyDatabase::class.java,
            DB_NAME
        ).allowMainThreadQueries().build()
        var list = db.getNoteDao().getAllNotes()
        notes.value = list
    }

}