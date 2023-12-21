package br.com.erick.aluGames.servicos

import br.com.erick.aluGames.modelo.Gamer
import br.com.erick.aluGames.modelo.InfoJogoJson
import br.com.erick.aluGames.modelo.InfoGamerJson
import br.com.erick.aluGames.modelo.Jogo
import br.com.erick.aluGames.utilitario.criarGamer
import br.com.erick.aluGames.utilitario.criarJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    private fun consomeDados(endereco: String): String? {

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

         return  response.body()
    }
    fun buscaJogosJson(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consomeDados(endereco)
        val gson = Gson()
        val meuTipoJogo = object: TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogos: List<InfoJogoJson> = gson.fromJson(json, meuTipoJogo)
        val listaJogoConvertida = listaJogos.map { infoJogoJson -> infoJogoJson.criarJogo() }

        return listaJogoConvertida
    }

    fun buscaGamer(): List<Gamer?> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consomeDados(endereco)
        val gson = Gson()
        val meuGamerTipo = object: TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map {infoGamerJson -> infoGamerJson.criarGamer()}

        return listaGamerConvertida
    }
}