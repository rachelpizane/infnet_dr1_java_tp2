package edu.infnet.questao01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mensagemErro = "[ERRO] Entrada inválida";

        System.out.print("Informe o seu nome completo: ");
        String nomeCompleto = input.nextLine();

        System.out.print("Informe a sua idade: ");
        String sIdade = input.nextLine();

        if(!sIdade.matches("[0-9]*")){
            System.out.println(mensagemErro);
            return;
        } 

        int idade = Integer.parseInt(sIdade);
        
        if(idade <= 0){
            System.out.println(mensagemErro);
            return;
        } 

        System.out.print("Informe o nome da sua mãe: ");
        String nomeMae = input.nextLine();

        System.out.print("Informe o nome do pai: ");
        String nomePai = input.nextLine();

        String nome = nomeCompleto.split(" ")[0];
        boolean comparadorTamanho = nome.length() > nomeMae.length() || nome.length() > nomePai.length();

        String resultadoComparacaoTamanho = "O nome do usuário não tem mais letras que o nome da mãe ou do pai.";
        if(comparadorTamanho){
            resultadoComparacaoTamanho = "O nome do usuário tem mais letras que o nome da mãe ou do pai.";
        }

        System.out.println("\n== INFORMAÇÕES DO USUÁRIO ========================================================");
        System.out.printf("Nome Completo: %s \nIdade: %d \nNome da mãe: %s \nNome do pai: %s\n", nomeCompleto, idade, nomeMae, nomePai);
        System.out.println("OBS: " + resultadoComparacaoTamanho);
        System.out.println("===================================================================================");
    }
}