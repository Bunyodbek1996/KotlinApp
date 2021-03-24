package com.dasturchi.kotlinapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note(
    @PrimaryKey(autoGenerate = true) var id : Int,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "content") var content: String?
)