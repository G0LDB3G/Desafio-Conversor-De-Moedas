package br.com.goldbeg.conversormoedas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoConversoes {

    private final List<String> historico = new ArrayList<>();
    private final String caminhoArquivo = "historico_conversoes.json";

    public void adicionarConversao(String conversao) {
        historico.add(conversao);
        salvarNoArquivo();
    }

    private void salvarNoArquivo() {
        try (FileWriter fileWriter = new FileWriter(caminhoArquivo)) {
            JsonArray jsonArray = new JsonArray();

            for (String conversao : historico) {
                JsonObject jsonConversao = new JsonObject();
                jsonConversao.addProperty("conversao", conversao);
                jsonArray.add(jsonConversao);
            }

            JsonObject historicoObject = new JsonObject();
            historicoObject.add("historico", jsonArray);

            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            String json = gson.toJson(historicoObject);

            fileWriter.write(json);
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

    public void exibirHistorico() {
        System.out.println("\nHistórico de Conversões:");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma conversão realizada ainda.");
        } else {
            for (String registro : historico) {
                System.out.println(registro);
            }
        }
    }
}