package ua.cryptoapp.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ua.cryptoapp.service.CipherService;

@Service
@NoArgsConstructor
public class PasswordSubstitutionCipherService extends CipherService {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_";

    @Override
    public String encrypt(String text, String key) {

        StringBuilder alphabet = new StringBuilder(key);
        for (char c : ALPHABET.toCharArray()) {
            if (!alphabet.toString().contains(String.valueOf(c))) {
                alphabet.append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int index = ALPHABET.indexOf(c);
            if (index != -1) {
                result.append(alphabet.charAt(index));
            }
        }

        return result.toString();
    }

    @Override
    public String decrypt(String text, String key) {


        StringBuilder alphabet = new StringBuilder(key);
        for (char c : ALPHABET.toCharArray()) {
            if (!alphabet.toString().contains(String.valueOf(c))) {
                alphabet.append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int index = alphabet.toString().indexOf(c);
            if (index != -1) {
                result.append(ALPHABET.charAt(index));
            }
        }

        return result.toString();
    }
}