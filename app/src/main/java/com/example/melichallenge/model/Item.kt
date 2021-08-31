package com.example.melichallenge.model

import com.squareup.moshi.Json

data class Item (

    @Json (name="price") val price: Int,
    @Json (name="thumbnail") val thumbnail: String,
    @Json (name="title") val title: String
)

