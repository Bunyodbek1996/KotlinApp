package com.dasturchi.kotlinapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dasturchi.kotlinapp.data.entity.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAllNotes(): List<Note>

    @Insert
    fun insertNote(note: Note)

    @Query("SELECT * FROM note WHERE id IN (:id)")
    fun getNotesById(id: IntArray) : List<Note>

    @Query("SELECT * FROM note WHERE title LIKE :s OR content LIKE :s")
    fun getNotesByTitleOrContent(s: String) : List<Note>

    @Delete
    fun deleteNote(note: Note)
}