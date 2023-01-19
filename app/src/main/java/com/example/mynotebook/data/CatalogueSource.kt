package com.example.mynotebook.data

import com.example.mynotebook.R
import com.example.mynotebook.model.Catalogue

class CatalogueSource {
    fun loadCatalogue() : List<Catalogue> {
        return listOf<Catalogue>(
            Catalogue(R.string.catalogue1),
            Catalogue(R.string.catalogue2)
        )
    }
}