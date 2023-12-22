package br.com.erick.aluGames.dados

import br.com.erick.aluGames.modelo.Plano
import br.com.erick.aluGames.modelo.PlanoAssinatura
import br.com.erick.aluGames.modelo.PlanoAvulso
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {

    override fun toEntity(plano: Plano): PlanoEntity {
        return if (plano is PlanoAssinatura) {
            PlanoAssinaturaEntity(plano.tipo, plano.id, plano.mensalidade, plano.jogosIncluidos, plano.percentualDescontoreputacao)
        } else {
            PlanoAvulsoEntity(plano.tipo, plano.id)
        }
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return  if (entity is PlanoAssinaturaEntity) {
            PlanoAssinatura(entity.tipo,  entity.mensalidade, entity.jogosIncluidos, entity.percentualDescontoReputacao, entity.id,)
        } else {
            PlanoAvulso(entity.tipo, entity.id)
        }
    }
}