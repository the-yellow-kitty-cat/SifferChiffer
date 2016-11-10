package Itello;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter n string");
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
//    private static int swedishLettersSwitch (char originalAscii) {
//        switch (originalAscii) {
//            case 'Å':
//                return 27;
//            case 'å':
//                return 27;
//            case 'Ä':
//                return 28;
//            case 'ä':
//                return 28;
//            case 'Ö':
//                return 29;
//            case 'ö':
//                return 29;
//            default:
//                return originalAscii;
//        }
//    }
//
//    static String getNumberEncryption(String a) {
//        StringBuilder encryptedSentence = new StringBuilder();
//
//        for (int currentLetter = 0; currentLetter < a.length(); currentLetter++) {
//
//            char originalAscii = a.charAt(currentLetter);
//            boolean isBigLetter = originalAscii >= 65 && originalAscii <= 90;
//            boolean isSmallLetter = originalAscii >= 97 && originalAscii <= 122;
//            boolean isBigSwedish = originalAscii == 'Å' || originalAscii == 'Ä' || originalAscii == 'Ö';
//            boolean isSmallSwedish = originalAscii == 'å' || originalAscii == 'ä' || originalAscii == 'ö';
//            boolean isNumber = originalAscii >= 48 && originalAscii <= 57;
//            if (!(isBigLetter || isBigSwedish || isSmallLetter || isSmallSwedish)) {
//                encryptedSentence.append(originalAscii);
//                continue;
//            }
//            int letterCode;
//            int lengthOfAlphabet;
//
//            if (isBigLetter || isSmallLetter||isBigSwedish || isSmallSwedish) {
//                lengthOfAlphabet = 30;
//            }
//
//            if (isBigLetter||isBigSwedish) {
//                letterCode = 64;
//            } else if (isSmallLetter||isSmallSwedish) {
//                letterCode = 96;
//            } else {
//                letterCode = 48;
//            }
//            originalAscii = transformToNewAscii(originalAscii);
//            char newAscii = (char) (lengthOfAlphabet - (originalAscii - letterCode) + letterCode);
//            newAscii = transformToOldAscii (newAscii);
//            encryptedSentence.append(newAscii);
//        }
//        return encryptedSentence.toString();
//    }
//
//    private static char transformToOldAscii(char newAscii) {
//        switch (newAscii) {
//            case 'å':
//                return 27;
//            case 'ä':
//                return 28;
//            case 'ö':
//                return 29;
//            case 'Å':
//                return 27;
//            case 'Ä':
//                return 28;
//            case 'Ö':
//                return 29;
//            default:
//                return newAscii;
//        }
//    }
//
//    private static char transformToNewAscii(char originalAscii) {
//        switch (originalAscii){
//            case 'å':
//                return '{';
//            case  'ä':
//                return '|';
//            case 'ö':
//                return '}';
//            case 'Å':
//                return '[';
//            case 'Ä':
//                return '\\';
//            case 'Ö':
//                return ']';
//            default:
//                return originalAscii;
//        }
//    }
//
//}
//


}