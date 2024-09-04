package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            String fator1 = args[0];
            String fator2 = args[1];

            System.out.println(karatsuba(fator1, fator2));
    }

    private static String karatsuba(String fator1, String fator2) {

        fator1 = fator1.replaceFirst("^0+(?!$)", "");
        fator2 = fator2.replaceFirst("^0+(?!$)", "");

        int diff = fator1.length() - fator2.length();

        if (diff < 0){
            fator1 = concatZeros(-diff,fator1);
        } else {
            fator2 = concatZeros(diff, fator2);
        }

        if (fator1.length()*fator2.length() == 1) {
            return Integer.toString((fator1.charAt(0) - '0') * (fator2.charAt(0) - '0'));
        }

        int tamanho = fator1.length()/2;

        String a1 = fator1.substring(0, fator1.length() - tamanho);
        String a2 = fator1.substring(fator1.length() - tamanho);

        String b1 = fator2.substring(0, fator2.length() - tamanho);
        String b2 = fator2.substring( fator2.length() - tamanho);

        String n1 = karatsuba(a1, b1);
        String n2 = karatsuba(somaBinaria(a1,a2), somaBinaria(b1,b2));
        String n3 = karatsuba(a2, b2);

        return somaKaratsuba(n1, n2, n3, tamanho).replaceFirst("^0+(?!$)", "");
    }

    private static String somaKaratsuba(String n1, String n2, String n3, int tamanho) {
        n2 = subtraBinaria(n2, somaBinaria(n1, n3));
        for (int i = 0; i < tamanho*2; i++) {
            n1 = n1 + '0';
        }
        for (int i = 0; i < tamanho; i++) {
            n2 = n2 + '0';
        }
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
            carry = switch (t) {
                case 96 -> {
                    result = "0" + result;
                    yield 0;
                }
                case 97 -> {
                    result = "1" + result;
                    yield 0;
                }
                case 98 -> {
                    result = "0" + result;
                    yield 1;
                }
                case 99 -> {
                    result = "1" + result;
                    yield 1;
                }
                default -> carry;
            };
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
