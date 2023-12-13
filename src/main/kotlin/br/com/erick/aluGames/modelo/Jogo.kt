package br.com.erick.aluGames.modelo

data class Jogo(val titulo: String, val capa: String) {
    var descricao:String? = null

    override fun toString(): String {
        return "Jogo:\n" +
                "Titulo:  $titulo \n" +
                "Capa:   $capa \n" +
                "Descrição: $descricao "
    }


}