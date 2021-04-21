package uca.edu.reqres.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName =  "reqres")
class ReqresCacheEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "email")
    var email: String,
    @ColumnInfo(name = "first_name")
    var first_name: String,
    @ColumnInfo(name = "last_name")
    var last_name: String,
    @ColumnInfo(name = "avatar")
    var avatar: String
)