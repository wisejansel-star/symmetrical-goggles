package uca.edu.reqres.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ReqresCacheEntity::class], version = 1)
abstract class ReqresDatabase : RoomDatabase() {
    companion object{
        val DATABASE_NAME = "ReqresDB"
    }
    abstract fun reqresDao(): ReqresDao
}