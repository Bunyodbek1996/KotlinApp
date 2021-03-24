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

class MainViewModel(app: Application) : AndroidViewModel(app){

    private val notes = MutableLiveData<List<Note>>()
    private var c = 0;

    fun notes() : LiveData<List<Note>>{
        return notes
    }

    fun readData(){
        val db = Room.databaseBuilder(
            getApplication(),
            MyDatabase::class.java,
            DB_NAME
        ).allowMainThreadQueries().build()
        var list = db.getNoteDao().getAllNotes()
        notes.value = list
    }

}