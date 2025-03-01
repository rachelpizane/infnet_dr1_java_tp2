package edu.infnet.questao03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mensagemErro = "[ERRO] Entrada inválida";

        final double cotacaoDolar = 5.84;
        final double cotacaoEuro = 6.08;
        final double cotacaoLibra = 7.40;

        System.out.print("Informe o valor em reais que deseja converter: ");
        String sValor = input.nextLine();

        if (!sValor.matches("^\\d+(\\.\\d+)?$")) {
            System.out.println(mensagemErro);
            return;
        }

        double valor = Double.parseDouble(sValor);

        if(valor <= 0){
            System.out.println(mensagemErro);
            return;
        }
        
        System.out.println("Escolha a moeda para conversão: ");
        System.out.println("1 - Dólar");
        System.out.println("2 - Euro");
        System.out.println("3 - Libra");

        System.out.print("Opção escolhida: ");
        String opcao = input.nextLine();

        double valorConvertido = 0;
        String cotacaoEscolhida = "";
        switch (opcao) {
            case "1":
                valorConvertido = convertor(valor, cotacaoDolar);
                cotacaoEscolhida = "Dólar";
                break;
            case "2":
                valorConvertido = convertor(valor, cotacaoEuro);
                cotacaoEscolhida = "Euro";
                break;
            case "3":
                valorConvertido = convertor(valor, cotacaoLibra);
                cotacaoEscolhida = "Libra";
                break;
            default:
                System.out.println("Opção inválida");
                return;
        }

        
        System.out.printf("\nCONVERSOR DE MOEDAS (Real para %s)\n", cotacaoEscolhida);
        System.out.printf(">> Valor convertido: %.2f", valorConvertido);

    }

    public static double convertor(double valor, double valorCotacao){
        return valor / valorCotacao;
    }
}
