package edu.infnet.questao12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Informe uma frase: ");
        String frase = input.nextLine();

        if(frase.isBlank()){
            System.out.println("[ERRO] Frase inválida.");
            return;
        }

        String[] palavras = frase.split(" ");

        int quantidadePalavras = 0;
        
        for (String palavra : palavras) {
            if(!palavra.isBlank()){
                quantidadePalavras++;
            }
        }

        System.out.println("Quantidade de palavras na frase: " + quantidadePalavras );
    }
}
