package ua.cryptoapp.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ua.cryptoapp.service.CipherService;

@Service
@NoArgsConstructor
public class SimpleSubstitutionCipherService extends CipherService {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String encrypt(String text, String key) {
        text = text.toUpperCase();
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (ALPHABET.contains(String.valueOf(c))) {
                int index = ALPHABET.indexOf(c);
                result.append(key.charAt(index));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String text, String key) {
        text = text.toUpperCase();
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            int keyIndex = key.indexOf(c);
            if (keyIndex != -1) {
                result.append(ALPHABET.charAt(keyIndex));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }


}