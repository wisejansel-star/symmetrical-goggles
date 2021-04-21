package uca.edu.reqres.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ReqresDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catEntity: ReqresCacheEntity): Long
    @Query("select * from reqres")
    suspend fun get(): List<ReqresCacheEntity>
}