package edu.infnet.questao07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu salário bruto anual: R$ ");
        String sSalarioBruto = input.nextLine();

        if (!sSalarioBruto.matches("^\\d+(\\.\\d+)?$") || Double.parseDouble(sSalarioBruto) <= 0) {
            System.out.println("[ERRO] Entrada inválida");
            return;
        }

        double salarioBruto = Double.parseDouble(sSalarioBruto);
        double imposto = calcularImposto(salarioBruto);

        double salarioLiquido = salarioBruto - imposto;

        System.out.printf("Imposto a pagar: R$ %.2f%n", imposto);
        System.out.printf("Salário líquido anual: R$ %.2f%n", salarioLiquido);
    }

    public static double calcularImposto(double salarioAnual) {
        double baseCalculoIsento =  26963.20;
        double baseCalculo7_5 = 33919.80;
        double baseCalculo15 = 45012.60;
        double baseCalculo22_5 = 55976.16;

        double aliquota7_5 = 0.075;
        double aliquota15 = 0.15;
        double aliquota22_5 = 0.225;
        double aliquota27_5 = 0.275;

        double imposto = 0.0;

        if (salarioAnual <= baseCalculoIsento) {
            imposto = 0;  
        } else if (salarioAnual <= baseCalculo7_5) {
            imposto = calcularImpostoFaixa(salarioAnual, baseCalculoIsento, aliquota7_5);

        } else if (salarioAnual <= baseCalculo15) {
            imposto = calcularImpostoFaixa(salarioAnual, baseCalculo7_5, aliquota15) + calcularImpostoFaixa(baseCalculo7_5, baseCalculoIsento, aliquota7_5);

        } else if (salarioAnual <= baseCalculo22_5) {
            imposto = calcularImpostoFaixa(salarioAnual, baseCalculo15, aliquota22_5) + calcularImpostoFaixa(baseCalculo15, baseCalculo7_5, aliquota15) + calcularImpostoFaixa(baseCalculo7_5, baseCalculoIsento, aliquota7_5);

        } else {
            imposto = calcularImpostoFaixa(salarioAnual, baseCalculo22_5, aliquota27_5) + calcularImpostoFaixa(baseCalculo22_5, baseCalculo15, aliquota22_5) + calcularImpostoFaixa(baseCalculo15, baseCalculo7_5, aliquota15) + calcularImpostoFaixa(baseCalculo7_5, baseCalculoIsento, aliquota7_5);
        }

        return imposto;
    }

    public static double calcularImpostoFaixa(double faixaFinal, double faixaInicial, double aliquota) {
        return (faixaFinal - faixaInicial) * aliquota;
    }
}
