package br.com.erick.alugames.dados

import br.com.erick.alugames.modelo.Plano
import br.com.erick.alugames.utilitario.toEntity
import br.com.erick.alugames.utilitario.toModel
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {

    override fun toEntity(plano: Plano): PlanoEntity {
        return plano.toEntity()
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return entity.toModel()
    }
}