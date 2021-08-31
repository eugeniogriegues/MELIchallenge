package com.example.melichallenge.model

import com.squareup.moshi.Json

data class ItemResponse  (

    @Json (name="results") val results: List<Item>


)