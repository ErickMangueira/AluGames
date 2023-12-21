package br.com.erick.aluGames.utilitario

import br.com.erick.aluGames.modelo.InfoGamerJson
import br.com.erick.aluGames.modelo.InfoJogoJson
import br.com.erick.aluGames.modelo.Jogo

fun InfoJogoJson.criarJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}