package br.com.erick.alugames.utilitario

import br.com.erick.alugames.dados.PlanoAssinaturaEntity
import br.com.erick.alugames.dados.PlanoAvulsoEntity
import br.com.erick.alugames.dados.PlanoEntity
import br.com.erick.alugames.modelo.Plano
import br.com.erick.alugames.modelo.PlanoAssinatura
import br.com.erick.alugames.modelo.PlanoAvulso

fun Plano.toEntity(): PlanoEntity {
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(
            this.tipo,
            this.mensalidade,
            this.jogosIncluidos,
            this.percentualDescontoreputacao,
            this.id
        )
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}

fun PlanoEntity.toModel(): Plano {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
    } else {
        PlanoAvulso(this.tipo, this.id)
    }
}