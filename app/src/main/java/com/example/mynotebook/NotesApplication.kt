package com.example.mynotebook

import android.app.Application
import com.example.mynotebook.database.NotesDatabase

class NotesApplication : Application() {
    val database: NotesDatabase by lazy { NotesDatabase.getDatabase(this) }
}