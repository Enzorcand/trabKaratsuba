package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            String fator1 = "11110";
            String fator2 = "11100";
            String fator3 = "1111000";


            System.out.println(complemento2(fator2));
            System.out.println(somaBinaria(fator1, fator2));
            System.out.println(subtraBinaria(fator1, fator2));
            System.out.println(somaKaratsuba(fator1, fator3, fator2));
    }

    private static String karatsuba(String fator1, String fator2) {

        //concatenação de zeros do menor numero para igualar os lenghts

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
        n2 = subtraBinaria(n2, somaBinaria(n1, n3));
        n1 = n1 + "00";
        n2 = n2 + "0";

        return somaBinaria(n1, somaBinaria(n2, n3));
    }

    private static String subtraBinaria(String n1, String n2) {
        String result = "";
        n2 = complemento2(n2);
        result = somaBinaria(n1, n2);
        result = result.replaceFirst("1", "");
        return result;
    }

    private static String complemento2(String n2) {
        String result = "";
        for (char c : n2.toCharArray()) {
            if(c == '1'){
                result = result + '0';
            } else {
                result = result + '1';
            }
        }
        result = somaBinaria(result, "1");
        return result;
    }


    private static String somaBinaria(String b1, String b2) {
        String result = "";
        int carry = 0;
        if (b1.length() != b2.length()) {
            int diff = b1.length() - b2.length();
            if (diff > 0) {
                b2 = concatZeros(diff, b2);
            } else {
                b1 = concatZeros(-1 * diff, b1);
            }
        }
        for (int i = b1.length() - 1; i >= 0; i--) {
            int t = (int) b1.charAt(i) + (int) b2.charAt(i) + carry;
            switch (t) {
                case 96:
                    result = "0" + result;
                    carry = 0;
                    break;
                case 97:
                    result = "1" + result;
                    carry = 0;
                    break;
                case 98:
                    result = "0" + result;
                    carry = 1;
                    break;
                case 99:
                    result = "1" + result;
                    carry = 1;
            }
        }
        if (carry == 1) {
            result = "1" + result;
        }
        return result;
    }

    private static String concatZeros(int n, String s) {
        for (int i = 0; i < n; i++) {
            s = "0" + s;
        }
        return s;
    }
}
