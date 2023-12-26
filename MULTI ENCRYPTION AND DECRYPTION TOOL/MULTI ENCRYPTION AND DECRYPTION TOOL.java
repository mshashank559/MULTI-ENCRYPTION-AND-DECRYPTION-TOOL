import java.util.HashMap;
import java.util.Map;

public class TextEncryption {

    private static Map<Character, String> MORSE_CODE_DICT = new HashMap<>();

    static {
        MORSE_CODE_DICT.put('A', ".-");
        MORSE_CODE_DICT.put('B', "-...");
        MORSE_CODE_DICT.put('C', "-.-.");
        // ... (continue with the rest of the MORSE_CODE_DICT entries)
    }

    public static void main(String[] args) {
        // Example usage
        String inputText = "Hello, World!";
        String morseCode = textToMorse(inputText.toUpperCase());
        System.out.println("Original text: " + inputText);
        System.out.println("Morse code: " + morseCode);
    }

    private static String textToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (MORSE_CODE_DICT.containsKey(c)) {
                morseCode.append(MORSE_CODE_DICT.get(c)).append(' ');
            } else if (c == '\n') {
                morseCode.append('\n');
            }
        }
        return morseCode.toString();
    }

    // Implement other encryption/decryption methods as needed

    // Caesar Cipher
    private static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) (((c - base + shift) % 26 + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Vigenere Cipher
    private static String vigenereEncrypt(String plaintext, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;
        for (char c : plaintext.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c + key.charAt(keyIndex) - 2 * base) % 26 + base));
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Vigenere Decrypt
    private static String vigenereDecrypt(String ciphertext, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;
        for (char c : ciphertext.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - key.charAt(keyIndex) + 26) % 26 + base));
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Atbash Cipher
    private static String atbashCipher(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) (25 - (c - base) + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    
    // ... Implement other encryption/decryption methods as needed
}
