package uca.edu.reqres.room

import uca.edu.reqres.model.Reqres
import uca.edu.reqres.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():
    EntityMapper<ReqresCacheEntity, Reqres> {
    override fun mapFromEntity(entity: ReqresCacheEntity): Reqres {
        return Reqres(
            id = entity.id,
            email = entity.email,
            first_name = entity.first_name,
            last_name = entity.last_name,
            avatar = entity.avatar
        )
    }

    override fun mapToEntity(domainModel: Reqres): ReqresCacheEntity {
        return ReqresCacheEntity(
            id = domainModel.id,
            email = domainModel.email,
            first_name = domainModel.first_name,
            last_name = domainModel.last_name,
            avatar = domainModel.avatar
        )
    }

    fun mapFromEntityList(entities: List<ReqresCacheEntity>): List<Reqres>{
        return entities.map { mapFromEntity(it) }
    }
}
