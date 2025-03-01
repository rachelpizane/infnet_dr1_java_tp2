package edu.infnet.questao05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int DESCONTO_10 = 10;
        final int DESCONTO_5 = 5;

        System.out.print("Informe o valor da compra: ");
        String sValor = input.nextLine();

        if (!sValor.matches("^\\d+(\\.\\d+)?$") || Double.parseDouble(sValor) <= 0) {
            System.out.println("[ERRO] Entrada inválida");
            return;
        }

        double valor = Double.parseDouble(sValor);

        double valorFinal = 0;
        int descontoFinal = 0;

        if(valor < 500){
            valorFinal = valor;
        } else if (valor <= 1000) {
            descontoFinal = DESCONTO_5;
            valorFinal = calcularDesconto(valor, DESCONTO_5);
        } else {
            descontoFinal = DESCONTO_10;
            valorFinal = calcularDesconto(valor, DESCONTO_10);
        }

        System.out.println("** CALCULADORA DE DESCONTO **");
        System.out.println(">> Valor original: R$ " + valor);
        System.out.println(">> Desconto aplicado: " + descontoFinal + "%");
        System.out.println(">> Valor final: R$ " + valorFinal);
    }

    public static double calcularDesconto(double valor, int desconto) {
        return valor - (valor * desconto / 100);
    }
}
