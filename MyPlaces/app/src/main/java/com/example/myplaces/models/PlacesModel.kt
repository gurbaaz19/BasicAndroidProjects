package com.example.myplaces.models

data class PlacesModel(
    val id: Int,
    val title: String,
    val image: String,
    val description: String,
    val date: String,
    val location: String,
    val latitudes: Double,
    val longitude: Double
)
