package com.example.moviestack.api.pojo

import com.example.moviestack.utils.NetworkConstants
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("adult")
    var adult: Boolean = false,
    @SerializedName("backdrop_path")
    var backdropPath: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("genre_ids")
    var genreIds: List<Int> = listOf(),
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("original_language")
    var originalLanguage: String = "",
    @SerializedName("original_title")
    var originalTitle: String = "",
    @SerializedName("overview")
    var overview: String = "",
    @SerializedName("popularity")
    var popularity: Double = 0.0,
    @SerializedName("poster_path")
    var posterPath: String = "",
    @SerializedName("release_date")
    var releaseDate: String = "",
    @SerializedName("first_air_date")
    var first_air_date: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("video")
    var video: Boolean = false,
    @SerializedName("vote_average")
    var voteAverage: Double = 0.0,
    @SerializedName("vote_count")
    var voteCount: Int = 0
){
    fun getImage() : String{
        return NetworkConstants.baseImageUrl+posterPath
    }

    fun getYear():String{
        if(first_air_date.equals("")){
            val parts = releaseDate.split("-")
            return parts[0]
        }
        else{
            val parts = first_air_date.split("-")
            return parts[0]
        }

    }

    fun hasTitle():Boolean{
        if(title.equals(""))
            return false
        else
            return true
    }

    fun hasName():Boolean{
        if(name.equals(""))
            return false
        else
            return true
    }

}