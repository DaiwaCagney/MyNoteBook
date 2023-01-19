package com.example.mynotebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotebook.data.CatalogueSource

class NoteMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_main)
        val myCatalogue = CatalogueSource().loadCatalogue()
        val catalogueRecycler = findViewById<RecyclerView>(R.id.recyclerView)
        catalogueRecycler.adapter = MyAdapter(this, myCatalogue)
    }
}