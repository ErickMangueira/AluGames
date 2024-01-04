package br.com.erick.alugames.principal

import br.com.erick.alugames.dados.Banco
import br.com.erick.alugames.dados.GamersDAO
import br.com.erick.alugames.dados.PlanosDAO
import br.com.erick.alugames.modelo.Gamer

fun main(){
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Banco.getEntityManager()
    val gamerDAO = GamersDAO(manager)
    val planosDAO = PlanosDAO(manager)

    gamer.plano = planosDAO.recuperarPeloId(3)


    val listaGamersBanco = gamerDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}