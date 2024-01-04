package br.com.erick.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoEntity(
    @Column(name = "tipo")
    val tipo: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int = 0
)

@Entity
@DiscriminatorValue("Avulso")
class PlanoAvulsoEntity(
    tipo: String = "Plano avulso",
    id: Int
) : PlanoEntity(tipo = tipo)

@Entity
@DiscriminatorValue("Assinatura")
class PlanoAssinaturaEntity(
    tipo: String = "Plano assinatura",

    @Column(name = "mensalidade")
    val mensalidade: Double = 0.0,

    @Column(name = "jogos_incluidos")
    val jogosIncluidos: Int = 0,

    @Column(name = "percentual_desconto_reputacao")
    val percentualDescontoReputacao: Double = 0.0,
    id: Int = 0) : PlanoEntity(tipo = tipo, id)
