package com.dasturchi.kotlinapp.data

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.dasturchi.kotlinapp.data.dao.NoteDao
import com.dasturchi.kotlinapp.data.entity.Note

@Database(entities = arrayOf(Note::class), version = 1)
abstract class MyDatabase: RoomDatabase(){
    abstract fun getNoteDao() : NoteDao
}