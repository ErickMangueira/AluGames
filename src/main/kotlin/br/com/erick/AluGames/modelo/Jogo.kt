package br.com.erick.AluGames.modelo

data class Jogo(val titulo: String, val capa: String) {
    var descricao:String? = null

    override fun toString(): String {
        return "Meu br.com.erick.AluGames.modelo.Jogo:\n" +
                "Titulo:  $titulo \n" +
                "Capa:   $capa \n" +
                "Descrição: $descricao "
    }


}