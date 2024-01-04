package br.com.erick.alugames.utilitario

import br.com.erick.alugames.dados.JogoEntity
import br.com.erick.alugames.modelo.InfoJogoJson
import br.com.erick.alugames.modelo.Jogo

fun InfoJogoJson.criarJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}
fun Jogo.toEntity(): JogoEntity {
    return JogoEntity(this.titulo, this.capa, this.preco, this.descricao, this.id)
}

fun JogoEntity.toModel(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao.toString(), this.id)
}