package ua.cryptoapp.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ua.cryptoapp.service.CipherService;

import java.util.Arrays;
import java.util.Comparator;

@Service
@NoArgsConstructor
public class VerticalTranspositionCipherService extends CipherService {

    @Override
    public String encrypt(String text, String key) {
        text = text.replace(" ", "");

        int rows = (int) Math.ceil((double) text.length() / key.length());
        char[][] matrix = new char[rows][key.length()];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (index < text.length()) {
                    matrix[i][j] = text.charAt(index++);
                } else {
                    matrix[i][j] = '_';
                }
            }
        }

        Integer[] columnOrder = new Integer[key.length()];
        for (int i = 0; i < key.length(); i++) {
            columnOrder[i] = i;
        }
        Arrays.sort(columnOrder, Comparator.comparingInt(key::charAt));

        StringBuilder result = new StringBuilder();
        for (int col : columnOrder) {
            for (int row = 0; row < rows; row++) {
                result.append(matrix[row][col]);
            }
        }

        return formatResult(result.toString(), text.length());
    }

    private String formatResult(String encryptedText, int originalLength) {
        int blockSize = calculateBlockSize(originalLength);
        StringBuilder formattedResult = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {
            formattedResult.append(encryptedText.charAt(i));
            if ((i + 1) % blockSize == 0 && i < encryptedText.length() - 1) {
                formattedResult.append(' ');
            }
        }

        return formattedResult.toString();
    }

    private int calculateBlockSize(int length) {
        if (length <= 21) {
            return 3;
        }
        return 5;
    }
}
