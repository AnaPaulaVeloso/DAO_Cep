package com.example.dao_cep.dao

data class Endereco(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String
) {
     override fun toString(): String {
        return "CEP: $cep, Logradouro: $logradouro, Complemento: $complemento, Bairro: $bairro, Localidade: $localidade, UF: $uf"
    }
}
