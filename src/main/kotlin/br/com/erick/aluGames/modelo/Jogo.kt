package br.com.erick.aluGames.modelo

import com.google.gson.annotations.Expose

data class Jogo(@Expose val titulo: String, @Expose val capa: String): Recomendavel {
    var descricao:String? = null
    var preco = 0.0
    private  val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }
    constructor(titulo: String, capa: String, preco: Double, descricao: String): this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }


    override fun toString(): String {
        return "Jogo:\n" +
                "Titulo:  $titulo \n" +
                "Capa:   $capa \n" +
                "Descrição: $descricao \n" +
                "Preço: $preco \n" +
                "Reputação: $media"
    }


}