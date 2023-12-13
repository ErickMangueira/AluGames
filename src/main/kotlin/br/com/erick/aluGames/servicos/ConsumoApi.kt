package br.com.erick.aluGames.servicos

import br.com.erick.aluGames.modelo.Gamer
import br.com.erick.aluGames.modelo.InfoJogo
import br.com.erick.aluGames.modelo.InfoGamerJson
import br.com.erick.aluGames.utilitario.criarGamer
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
    fun buscaJogo(id: String): InfoJogo? {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consomeDados(endereco)

        val gson = Gson()
        return gson.fromJson(json, InfoJogo::class.java)
    }

    fun buscaGamer(): List<Gamer?> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consomeDados(endereco)
        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map {infoGamerJson -> infoGamerJson.criarGamer()}

        return listaGamerConvertida
    }
}