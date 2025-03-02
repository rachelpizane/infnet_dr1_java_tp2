package edu.infnet.questao10;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int numeroSorteado = random.nextInt(100) + 1;

        int tentativas = 1;
        boolean acertou = false;

        do {
            System.out.print("[Tentativa nº " + tentativas + "] ");
            System.out.print("Informe um número inteiro entre 1 e 100: ");
            String sPalpite = input.nextLine();

            if (!validarPalpite(sPalpite)) {
                System.out.println("[ERRO] Número inválido. Tente novamente.");
                continue;
            }

            int palpite = converterParaInteiro(sPalpite);

            String resposta = ">> ";

            if  (palpite > numeroSorteado) {
                resposta += "O número sorteado é menor";

            } else if (palpite < numeroSorteado) {
               resposta += "O número sorteado é maior";

            } else {
                acertou = true;
            }

            if(!acertou){
                System.out.println(resposta + ". Tente novamente.\n");
                tentativas++;
            }

        } while (!acertou);

        System.out.println("\nParabéns! Você acertou o número sorteado em " + tentativas + " tentativa(s).");
        System.out.println("Fim do jogo.");
    }

    public static boolean validarPalpite(String palpite) {
        return palpite.matches("^\\d+$") && converterParaInteiro(palpite) > 0 && converterParaInteiro(palpite) <= 100;
    }

    public static int converterParaInteiro(String sNumero) {
        return Integer.parseInt(sNumero);
    }
}
