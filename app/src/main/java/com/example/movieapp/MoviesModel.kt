package com.example.movieapp

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class MoviesModel (

    @SerializedName("Title"      ) var Title      : String?            = null,
    @SerializedName("Year"       ) var Year       : Int?               = null,
    @SerializedName("Rated"      ) var Rated      : String?            = null,
    @SerializedName("Released"   ) var Released   : String?            = null,
    @SerializedName("Runtime"    ) var Runtime    : String?            = null,
    @SerializedName("Genre"      ) var Genre      : String?            = null,
    @SerializedName("Director"   ) var Director   : String?            = null,
    @SerializedName("Writer"     ) var Writer     : String?            = null,
    @SerializedName("Actors"     ) var Actors     : String?            = null,
    @SerializedName("Plot"       ) var Plot       : String?            = null,
    @SerializedName("Language"   ) var Language   : String?            = null,
    @SerializedName("Country"    ) var Country    : String?            = null,
    @SerializedName("Awards"     ) var Awards     : String?            = null,
    @SerializedName("Poster"     ) var Poster     : String?            = null,
    @SerializedName("Ratings"    ) var Ratings    : ArrayList<Ratings> = arrayListOf(),
    @SerializedName("Metascore"  ) var Metascore  : Int?               = null,
    @SerializedName("imdbRating" ) var imdbRating : Double?            = null,
    @SerializedName("imdbVotes"  ) var imdbVotes  : String?            = null,
    @SerializedName("imdbID"     ) var imdbID     : String?            = null,
    @SerializedName("Type"       ) var Type       : String?            = null,
    @SerializedName("DVD"        ) var DVD        : String?            = null,
    @SerializedName("BoxOffice"  ) var BoxOffice  : String?            = null,
    @SerializedName("Production" ) var Production : String?            = null,
    @SerializedName("Response"   ) var Response   : String?            = null

)

data class Ratings (

    @SerializedName("Source" ) var Source : String? = null,
    @SerializedName("Value"  ) var Value  : String? = null

)