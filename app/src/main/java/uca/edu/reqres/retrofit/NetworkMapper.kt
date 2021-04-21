package uca.edu.reqres.retrofit

import uca.edu.reqres.model.Reqres
import uca.edu.reqres.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<ReqresNetworkEntity, Reqres> {
    override fun mapFromEntity(entity: ReqresNetworkEntity): Reqres {
        return Reqres(
            id = entity.id,
            email = entity.email,
            first_name = entity.first_name,
            last_name = entity.last_name,
            avatar = entity.avatar
        )
    }


    override fun mapToEntity(domainModel: Reqres): ReqresNetworkEntity {
        return ReqresNetworkEntity(
            id = domainModel.id,
            email = domainModel.email,
            first_name = domainModel.first_name,
            last_name = domainModel.last_name,
            avatar = domainModel.avatar
        )
    }
    fun mapFromEntityList(entities: List<ReqresNetworkEntity>): List<Reqres>{
        return entities.map { mapFromEntity(it) }
    }
}