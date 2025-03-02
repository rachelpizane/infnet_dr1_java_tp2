package edu.infnet.questao08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] lados = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.printf("Informe o valor do lado nº %d do triângulo: ", i + 1);
            String sLado = input.nextLine();
            
            if (!sLado.matches("^\\d+(\\.\\d+)?$") || Double.parseDouble(sLado) <= 0) {
                System.out.println("[ERRO] Entrada inválida");
                return;
            }

            lados[i] = Double.parseDouble(sLado);
        }
        
        String resposta = "O triângulo é ";
        String resultado = "inválido";

        if (verificarTriangulo(lados)) {
            resultado = classificarTriangulo(lados);
        }

        System.out.printf("\nClassificação do triângulo: %s%s.",resposta,resultado);
    }

    public static boolean verificarTriangulo(double[] lados) {
        return lados[0] + lados[1] > lados[2] && lados[0] + lados[2] > lados[1] && lados[1] + lados[2] > lados[0];
    }

    public static String classificarTriangulo(double[] lados) {
        if (lados[0] == lados[1] && lados[0] == lados[2]) {
            return "equilátero";
        } else if (lados[0] == lados[1] || lados[0] == lados[2] || lados[1] == lados[2]) {
            return "isósceles";
        } else {
            return "escaleno";
        }
    }
}