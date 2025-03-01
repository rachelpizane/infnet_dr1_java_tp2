package edu.infnet.questao02;
import java.util.Scanner;

public class Main {
   
    public static void main(String[] args) {
        final int QNTD_NOTAS = 4;
        double[] notas = new double[QNTD_NOTAS];
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < QNTD_NOTAS; i++){
            String sNota;
            double nota;

            System.out.printf("Informe a %dª nota: ", i + 1);
            sNota = input.nextLine();

            if (sNota.matches("^\\d+(\\.\\d+)?$")) {
                nota = Double.parseDouble(sNota);

                if(nota >= 0 && nota <= 10){
                    notas[i] = nota;
                    continue;
                }
            }

            System.out.println("[ERRO] Nota inválida");
            return;
        }

        double somaNotas = 0;

        for(double nota : notas){
            somaNotas += nota;
        }

        double mediaNotas = somaNotas / QNTD_NOTAS;

        String resultado;

        if(mediaNotas < 5){
            resultado = "Reprovado";
        } else if(mediaNotas < 7){
            resultado = "Recuperação";
        } else {
            resultado = "Aprovado";
        }

        System.out.println("\nResultado: ");
        System.out.printf("Média: %.2f \nStatus: %s", mediaNotas, resultado);
    }
}
