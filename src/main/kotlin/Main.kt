import com.google.gson.Gson
import java.lang.NullPointerException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite o código de jogo para buscar: ")
    val busca = leitura.nextLine()
    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

   val client: HttpClient  = HttpClient.newHttpClient()
   val request = HttpRequest.newBuilder()
       .uri(URI.create(endereco))
       .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()

    val gson = Gson()
    var meuJogo:Jogo? = null

    val resultado = runCatching {
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
         meuJogo = Jogo(
            meuInfoJogo.info.title,
            meuInfoJogo.info.thumb
        )
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