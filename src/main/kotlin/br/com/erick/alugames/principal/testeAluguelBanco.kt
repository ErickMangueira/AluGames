package br.com.erick.alugames.principal

import br.com.erick.alugames.dados.AluguelDAO
import br.com.erick.alugames.dados.Banco
import br.com.erick.alugames.dados.GamersDAO
import br.com.erick.alugames.dados.JogosDAO
import br.com.erick.alugames.modelo.Periodo

fun  main() {
    val manager = Banco.getEntityManager()
    val jogosDAO = JogosDAO(manager)
    val gamersDAO = GamersDAO(manager)
    val aluguelDAO = AluguelDAO(manager)

    val gamer = gamersDAO.recuperarPeloId(1)
    val jogo = jogosDAO.recuperarPeloId(2)
    val aluguel = gamer.alugaJogo(jogo, Periodo())

    aluguelDAO.adicionar(aluguel)

    val  listaAluguel = aluguelDAO.getLista()
    println(listaAluguel)

    manager.close()
}