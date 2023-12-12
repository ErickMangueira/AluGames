package br.com.erick.AluGames.principal

import br.com.erick.AluGames.modelo.Jogo
import br.com.erick.AluGames.servicos.ConsumoApi
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite o código de jogo para buscar: ")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        val informacaoJogo = buscaApi.buscaJogo(busca)
        if (informacaoJogo != null) {
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }
    }
    resultado.onFailure {
        println("Jogo inexistente. Tente outro jogo")
    }
    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = leitura.nextLine()
        if (opcao.equals("s", true)) {
            println("Insira a descrição personalizada para o jogo:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }

        println(meuJogo)
    }


}