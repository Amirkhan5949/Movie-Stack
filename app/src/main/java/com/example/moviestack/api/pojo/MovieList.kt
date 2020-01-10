package com.example.moviestack.api.pojo



import com.example.moviestack.utils.NetworkConstants
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("page")
    var page: Int = 0,
    @SerializedName("results")
    var results: List<Result> = listOf(),
    @SerializedName("total_pages")
    var totalPages: Int = 0,
    @SerializedName("total_results")
    var totalResults: Int = 0
)