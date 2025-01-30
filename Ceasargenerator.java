
import java.util.Scanner;

public class Ceasargenerator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        System.out.println("Enter a shift value (1-25):");
        int shift = scanner.nextInt();
        scanner.nextLine();

        String encryptedMessage = encrypt(message, shift);
        System.out.println("Encrypted message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, shift);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    public static String encrypt(String message, int shift) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                encryptedMessage.append((char) ((c - base + shift) % 26 + base));
            } else {
                encryptedMessage.append(c);
            }
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String message, int shift) {
        return encrypt(message, 26 - shift);
    }
}
