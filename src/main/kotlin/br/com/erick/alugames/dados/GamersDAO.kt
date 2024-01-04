package br.com.erick.alugames.dados

import br.com.erick.alugames.modelo.Gamer
import br.com.erick.alugames.utilitario.toEntity
import br.com.erick.alugames.utilitario.toModel
import javax.persistence.EntityManager

class GamersDAO( manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(objeto: Gamer): GamerEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plano = entity.plano.toModel() }
   }
}