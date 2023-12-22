package br.com.erick.aluGames.dados

import javax.persistence.*

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoEntity(
    val tipo: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0)
@Entity
@DiscriminatorValue("Avulso")
class PlanoAvulsoEntity(tipo: String = "Plano avulso", id: Int = 0): PlanoEntity(tipo, id)
@Entity
@DiscriminatorValue("Assinatura")
class PlanoAssinaturaEntity(
    tipo: String = "Plano assinatura",
    id: Int = 0,
    val mensalidade: Double = 0.0,
    val jogosIncluidos: Int = 0,
    val percentualDescontoReputacao: Double = 0.0 ): PlanoEntity(tipo, id)