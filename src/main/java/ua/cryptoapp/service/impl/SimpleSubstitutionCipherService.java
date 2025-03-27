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

}