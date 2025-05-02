package br.com.goldbeg.conversormoedas;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private final ConverterMoedas conversor;
    private final HistoricoConversoes historico;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        this.conversor = new ConverterMoedas();
        this.historico = new HistoricoConversoes();
    }

    public void iniciar() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1. Dólar (USD) -> Real (BRL)");
            System.out.println("2. Real (BRL) -> Peso Argentino (ARS)");
            System.out.println("3. Real (BRL) -> Boliviano (BOB)");
            System.out.println("4. Real (BRL) -> Peso Chileno (CLP)");
            System.out.println("5. Real (BRL) -> Peso Colombiano (COP)");
            System.out.println("6. Real (BRL) -> Dólar (USD)");
            System.out.println("7. Exibir Histórico de Conversões");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 6) {
                System.out.print("Digite o valor que deseja converter: ");
                double valor = scanner.nextDouble();
                String resultado = conversor.converter(opcao, valor);
                System.out.println(resultado);
                historico.adicionarConversao(resultado);
            } else if (opcao == 7) {
                historico.exibirHistorico();
            } else if (opcao != 0) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        System.out.println("Programa encerrado. Até logo!");
    }
}