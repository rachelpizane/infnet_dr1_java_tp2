package edu.infnet.questao04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.print("Informe a sua data de nascimento [dd/MM/yyyy]: ");
        String sDataNascimento = input.nextLine();

        if(!sDataNascimento.matches("^\\d{2}/\\d{2}/\\d{4}$")){
            System.out.println("[ERRO] Data inválida");
            return;
        }

        LocalDate dataNascimento = LocalDate.parse(sDataNascimento , formatador);
        LocalDate dataAtual = LocalDate.now();
        
        long diferencaDatas = ChronoUnit.DAYS.between(dataNascimento, dataAtual);

        System.out.println("\n== CALCULADORA DE IDADE EM DIAS ==");
        System.out.println(">> Diferença de dias: " + diferencaDatas);
    }
}
