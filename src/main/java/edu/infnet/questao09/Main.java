package edu.infnet.questao09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        System.out.print("Informe a senha: ");
        String senha = input.nextLine();

        if(senha.isEmpty()){
            System.out.println("[ERRO] Senha inválida.");
            return;
        }

        boolean ehIgual = false;
        String senhaConfirmacao;
        do {
            System.out.print("Informe a senha novamente: ");
            senhaConfirmacao = input.nextLine();

            ehIgual = senha.equals(senhaConfirmacao);

            if (!ehIgual) {
                System.out.println("As senhas não são iguais. Tente novamente.");
            }

        } while (!ehIgual);

        System.out.println("[SUCESSO] Senha cadastrada!");
    }
}
