package edu.infnet.questao11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mensagemErro = "[ERRO] Entrada inválida.";

        System.out.print("Informe o valor inicial da sequência: ");
        String sValorInicial = input.nextLine();

        if(!validar(sValorInicial)){
            System.out.println(mensagemErro);
            return;
        }

        System.out.print("Informe o incremento da sequência: ");
        String sIncremento = input.nextLine();

        if(!validar(sIncremento)){
            System.out.println(mensagemErro);
            return;
        }

        int valorInicial = converterStringParaInteiro(sValorInicial);
        int incremento = converterStringParaInteiro(sIncremento);

        List<String> sequencia = new ArrayList<>();
        int valorIncrementado = valorInicial;

        while(valorIncrementado <= 100){
            if(valorIncrementado == valorInicial){
                sequencia.add(converterInteiroParaString(valorInicial));
            }

            valorIncrementado += incremento;

            sequencia.add(converterInteiroParaString(valorIncrementado));
        }

        System.out.println("SEQUÊNCIA GERADA:");
        System.out.println(">> " + String.join(", ", sequencia));
    }

    public static int converterStringParaInteiro(String sNumero) {
        return Integer.parseInt(sNumero);
    }

    public static String converterInteiroParaString(int numero) {
        return Integer.toString(numero);
    }

    public static boolean validar(String entrada) {
        return entrada.matches("^\\d+$") && converterStringParaInteiro(entrada) >= 0;
    }

}
