package br.com.goldbeg.conversormoedas;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverterMoedas {

    public String converter(int opcao, double valor) {
        String moedaOrigem = "";
        String moedaDestino = "";

        switch (opcao) {
            case 1 -> { moedaOrigem = "USD"; moedaDestino = "BRL"; }
            case 2 -> { moedaOrigem = "BRL"; moedaDestino = "ARS"; }
            case 3 -> { moedaOrigem = "BRL"; moedaDestino = "BOB"; }
            case 4 -> { moedaOrigem = "BRL"; moedaDestino = "CLP"; }
            case 5 -> { moedaOrigem = "BRL"; moedaDestino = "COP"; }
            case 6 -> { moedaOrigem = "BRL"; moedaDestino = "USD"; }
            default -> { return "Opção inválida."; }
        }

        try {
            String apiKey = "ca6365fc78acf352c652ae4d";
            String endereco = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaOrigem + "/" + moedaDestino;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            double taxaConversao = jsonObject.get("conversion_rate").getAsDouble();

            double valorConvertido = valor * taxaConversao;

            return String.format("%.2f %s = %.2f %s", valor, moedaOrigem, valorConvertido, moedaDestino);

        } catch (IOException | InterruptedException e) {
            return "Erro ao realizar a conversão: " + e.getMessage();
        }
    }
}