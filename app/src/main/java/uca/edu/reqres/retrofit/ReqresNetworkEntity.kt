package uca.edu.reqres.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ReqresNetworkEntity (
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("first_name")
    @Expose
    var first_name: String,
    @SerializedName("last_name")
    @Expose
    var last_name: String,
    @SerializedName("avatar")
    @Expose
    var avatar: String,

    )

data class PokemonsAPIResponse(
    @SerializedName("page")
    @Expose
    val page : Integer,

    @SerializedName("data")
    @Expose
    val data: List<ReqresNetworkEntity>
)