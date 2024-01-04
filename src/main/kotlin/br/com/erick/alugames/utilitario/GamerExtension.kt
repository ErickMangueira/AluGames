package br.com.erick.alugames.utilitario

import br.com.erick.alugames.dados.GamerEntity
import br.com.erick.alugames.modelo.Gamer
import br.com.erick.alugames.modelo.InfoGamerJson

fun InfoGamerJson.criarGamer() : Gamer {
   return  Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}
fun Gamer.toEntity(): GamerEntity {
   return GamerEntity(this.id, this.nome, this.email, this.dataNascimento, this.usuario, this.plano.toEntity())
}

fun GamerEntity.toModel(): Gamer {
   return  Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}
