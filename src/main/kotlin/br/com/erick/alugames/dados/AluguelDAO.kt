package br.com.erick.alugames.dados

import br.com.erick.alugames.modelo.Aluguel
import br.com.erick.alugames.utilitario.toEntity
import br.com.erick.alugames.utilitario.toModel
import javax.persistence.EntityManager

class AluguelDAO(manager: EntityManager): DAO<Aluguel, AluguelEntity>(manager, AluguelEntity::class.java) {
    override fun toEntity(objeto: Aluguel): AluguelEntity {
        return AluguelEntity(objeto.gamer.toEntity(), objeto.jogo.toEntity(), objeto.periodo).apply {
            valorDoAluguel = objeto.valorDoAluguel
        }.apply { id = objeto.id }
    }

    override fun toModel(entity: AluguelEntity): Aluguel {
       return  Aluguel(entity.gamer.toModel(), entity.jogo.toModel(), entity.periodo).apply { id = entity.id }
    }
}