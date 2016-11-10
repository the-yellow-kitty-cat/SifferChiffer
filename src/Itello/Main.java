package Itello;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string");
        String n = in.nextLine();
        if (n.equals("")) {
            System.out.println(n);
        } else {
            String encryptionToString = getNumberEncryption(n);
            System.out.println(encryptionToString);
        }
    }

    static String getNumberEncryption(String n) {
        StringBuilder encryptedSentence = new StringBuilder();
        for (int currentLetter = 0; currentLetter < n.length(); currentLetter++) {
            char originalAscii = n.charAt(currentLetter);
            boolean isBigLetter = isBigLetter(originalAscii);
            boolean isSmallLetter = isSmallLetter(originalAscii);
            int letterCode;

            if (isBigLetter) {
                letterCode = 64;
            } else if (isSmallLetter) {
                letterCode = 96;
            } else if (originalAscii == 'å') {
                letterCode = 202;
            } else if (originalAscii == 'Å') {
                letterCode = 170;
            } else if (originalAscii == 'ä') {
                letterCode = 200;
            } else if (originalAscii == 'Ä') {
                letterCode = 168;
            } else if (originalAscii == 'ö') {
                letterCode = 217;
            } else if (originalAscii == 'Ö') {
                letterCode = 185;
            } else {
                letterCode = 0;
                char newAscii = (char) (originalAscii - letterCode);
                encryptedSentence.append(newAscii);
                continue;
            }

            int newAscii = (originalAscii - letterCode);
            encryptedSentence.append(newAscii);

            boolean isItFinished = (currentLetter + 1 >= n.length());
            if (!isItFinished) {
                char nextLetter = n.charAt(currentLetter + 1);
                boolean isNextNoLetter = !(isBigLetter(nextLetter) || isSmallLetter(nextLetter) || isSwedishLetter(nextLetter));
                if (isNextNoLetter) {
                    continue;
                }
                encryptedSentence.append('-');
            }

        }
        return encryptedSentence.toString();
    }

    private static boolean isSmallLetter(char originalAscii) {
        return originalAscii >= 97 && originalAscii <= 122;
    }

    private static boolean isBigLetter(char originalAscii) {
        return originalAscii >= 65 && originalAscii <= 90;
    }

    private static boolean isSwedishLetter(char originalAscii) {
        return originalAscii == 'å' || originalAscii == 'Å' || originalAscii == 'ä' || originalAscii == 'Ä' || originalAscii == 'ö' || originalAscii == 'Ö';
    }
}