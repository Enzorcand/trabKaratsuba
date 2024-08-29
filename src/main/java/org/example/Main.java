package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            String n1 = "1000";
            String n2 = "11110";

            int diff = n1.length() - n2.length();
            if (diff > 0) {
                n2 = concatZeros(diff, n2);
            } else{
                n1 = concatZeros(-1 * diff, n1);
            }
            System.out.println(n1);

    }

    private static String concatZeros(int n, String s) {
        for (int i = 0; i < n; i++) {
            s = "0" + s;
        }
        return s;
    }
}
