package ua.cryptoapp.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ua.cryptoapp.service.CipherService;

@Service
@NoArgsConstructor
public class VigenereCipherService extends CipherService {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_";

    @Override
    public String encrypt(String text, String key) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char textChar = text.charAt(i);
            char keyChar = key.charAt(i % key.length());

            int textIndex = ALPHABET.indexOf(textChar);
            int keyIndex = ALPHABET.indexOf(keyChar);

            if (textIndex != -1) {
                int encryptedIndex = (textIndex + keyIndex) % ALPHABET.length();
                result.append(ALPHABET.charAt(encryptedIndex));
            }
        }

        return result.toString();
    }

}