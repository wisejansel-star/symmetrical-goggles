package uca.edu.reqres.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uca.edu.reqres.retrofit.NetworkMapper
import uca.edu.reqres.retrofit.ReqresRetrofit
import uca.edu.reqres.room.CacheMapper
import uca.edu.reqres.room.ReqresDao
import uca.edu.reqres.utils.DataState
import java.net.UnknownHostException

class ReqresRepository constructor(
    private val reqresDao: ReqresDao,
    private val reqresRetrofit: ReqresRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getReqres(): Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val reqresData = reqresRetrofit.get()
            val reqresMap = networkMapper.mapFromEntityList(reqresData.data)
            for (tempReqres in reqresMap){
                reqresDao.insert(cacheMapper.mapToEntity(tempReqres))
            }
            val cacheReqres = reqresDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheReqres)))
        }catch (e: Exception){
            when (e){
                is UnknownHostException ->{
                    val cacheReqres = reqresDao.get()
                    if (cacheReqres.isEmpty()){
                        emit(DataState.Error(java.lang.Exception("La tabla Reqres se encuentra vacia, Conectece a internet ")))
                    }else{
                        emit(DataState.Success(cacheMapper.mapFromEntityList(cacheReqres)))
                    }
                }
            }
            //emit(DataState.Error(e))
        }
    }
}