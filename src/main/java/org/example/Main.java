package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            String fator1 = "1000";
            String fator2 = "11110";



    }

    private static String karatsuba(String fator1, String fator2) {

        //concatenação de zeros do menor numero para igualar os lenghts
//        {
//            int diff = fator1.length() - fator2.length();
//            if (diff > 0) {
//                fator2 = concatZeros(diff, fator2);
//            } else {
//                fator1 = concatZeros(-1 * diff, fator1);
//            }
//        }

        String a1 = fator1.substring(0, fator1.length()/2);
        String a2 = fator1.substring(fator1.length()/2);

        String b1 = fator2.substring(0, fator2.length()/2);
        String b2 = fator2.substring(fator2.length()/2);

        String n1 = karatsuba(a1, b1);
        String n2 = karatsuba(somaBinaria(a1,a2), somaBinaria(b1,b2));
        String n3 = karatsuba(a2, b2);


        return somaKaratsuba(n1, n2, n3);
    }
    //TODO: Realiza a seguinte operação em binario: (n1 << + (n2 - n1 - n3) < + n3
    private static String somaKaratsuba(String n1, String n2, String n3) {
        return null;
    }


    //TODO: Realiza uma soma simples binaria entre 2 strings de mesmo tamanho
    private static String somaBinaria(String b1, String b2) {
        return null;
    }

    private static String concatZeros(int n, String s) {
        for (int i = 0; i < n; i++) {
            s = "0" + s;
        }
        return s;
    }
}
