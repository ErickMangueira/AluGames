package br.com.erick.aluGames.utilitario

import br.com.erick.aluGames.modelo.Gamer
import br.com.erick.aluGames.modelo.InfoGamerJson

fun InfoGamerJson.criarGamer() : Gamer {
   return  Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}
