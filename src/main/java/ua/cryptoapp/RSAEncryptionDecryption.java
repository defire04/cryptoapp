package ua.cryptoapp;

import java.math.BigInteger;

public class RSAEncryptionDecryption {
    public static void main(String[] args) {
        // Вхідні дані
        String message = "Dmyt";
        int p = 23;
        int q = 59;
        int e = 17;

        System.out.println("Початкове повідомлення: " + message);
        System.out.println("\nПредставлення символів у ASCII:");
        int[] asciiCodes = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            asciiCodes[i] = message.charAt(i);
            System.out.println(message.charAt(i) + " = " + asciiCodes[i]);
        }

        int n = p * q;
        int phi = (p - 1) * (q - 1);


        System.out.println("\nПараметри RSA:");
        System.out.println("p = " + p);
        System.out.println("q = " + q);
        System.out.println("n = " + n);
        System.out.println("φ(n) = " + phi);
        System.out.println("e = " + e);
        System.out.println("\nВідкритий ключ KU = {" + e + ", " + n + "}");

        int[] encryptedValues = new int[message.length()];
        System.out.println("\nШифрування:");
        for (int i = 0; i < message.length(); i++) {
            BigInteger plaintext = BigInteger.valueOf(asciiCodes[i]);
            BigInteger ciphertext = plaintext.pow(e).mod(BigInteger.valueOf(n));
            encryptedValues[i] = ciphertext.intValue();
            System.out.println("C" + (i+1) + " = " + asciiCodes[i] + "^" + e + " mod " + n + " = " + encryptedValues[i]);
        }

        int d = calculatePrivateKey(e, phi);
        System.out.println("d = " + d);
        System.out.println("Закритий ключ KR = {" + d + ", " + n + "}");

        System.out.println("\nБлоки зашифрованого тексту: " + arrayToString(encryptedValues));

        int[] decryptedValues = new int[message.length()];
        System.out.println("\nДешифрування:");
        for (int i = 0; i < message.length(); i++) {
            BigInteger ciphertext = BigInteger.valueOf(encryptedValues[i]);
            BigInteger plaintext = ciphertext.modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
            decryptedValues[i] = plaintext.intValue();
            System.out.println("M" + (i+1) + " = " + encryptedValues[i] + "^" + d + " mod " + n + " = " + decryptedValues[i]);
        }



    }

    // Обчислення закритого ключа за допомогою розширеного алгоритму Евкліда
    public static int calculatePrivateKey(int e, int phi) {
        int d = extendedEuclidean(e, phi);
        if (d < 0) { //-75
            d += phi;
        }
        return d;
    }

    // Розширений алгоритм Евкліда для знаходження d такого, що (d * e) % phi = 1
    public static int extendedEuclidean(int a, int b) {
        int x0 = 1, x1 = 0, y0 = 0, y1 = 1;
        int q, temp;
        int iteration = 0;



        while (b != 0) {
            q = a / b;

            System.out.println("\nІтерація " + iteration + ":");
            System.out.println("q = a / b = " + a + " / " + b + " = " + q);

            temp = x1;
            x1 = x0 - q * x1;
            x0 = temp;

            temp = y1;
            y1 = y0 - q * y1;
            y0 = temp;

            temp = b;
            b = a % b;
            a = temp;

            iteration++;
        }

        return x0;
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
