package edu.infnet.questao06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nVERIFICADOR DO ANO BISSEXTO:\n");

        System.out.print("Informe o ano que será verificado: ");
        String sAno = input.nextLine();

        if(!sAno.matches("^\\d+$") || Integer.parseInt(sAno) <= 0){
            System.out.println("[ERRO] Entrada inválida");
            return;
        }

        int ano = Integer.parseInt(sAno);
        boolean ehBissexto = verificarAnoBissexto(ano);
        String resultado = "O ano não é bissexto.";

        if(ehBissexto){
            resultado = "O ano é bissexto.";
        }


        System.out.printf("Ano informado: %d\n", ano);
        System.out.printf("Resultado: %s\n", resultado);
    }

    public static boolean verificarAnoBissexto(int ano){
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }
}
