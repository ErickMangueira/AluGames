package br.com.erick.alugames.dados

import br.com.erick.alugames.modelo.Jogo
import br.com.erick.alugames.utilitario.toEntity
import br.com.erick.alugames.utilitario.toModel
import javax.persistence.EntityManager

class JogosDAO( manager: EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return entity.toModel()
    }
}