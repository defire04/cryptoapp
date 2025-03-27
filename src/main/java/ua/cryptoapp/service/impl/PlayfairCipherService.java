package ua.cryptoapp.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ua.cryptoapp.service.CipherService;
@Service
@NoArgsConstructor
public class PlayfairCipherService extends CipherService {
    private char[][] keyMatrix = new char[6][5];

    private void generateKeyMatrix(String key) {
        // Предопределенная матрица 6x5 с алфавитом и символами
        keyMatrix = new char[][]{
                {'K', 'W', 'R', 'H', ','},
                {'P', 'T', 'B', 'N', 'U'},
                {'_', 'D', 'O', 'Z', 'E'},
                {'J', 'F', '.', 'C', 'Y'},
                {'V', 'G', 'A', 'I', 'X'},
                {'M', '-', 'Q', 'L', 'S'}
        };
    }

    private int[] findPosition(char c) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyMatrix[i][j] == c ||
                        (c == 'I' && keyMatrix[i][j] == 'J') ||
                        (c == 'J' && keyMatrix[i][j] == 'I')) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    @Override
    public String encrypt(String text, String key) {
        generateKeyMatrix(key);
        text = text.toUpperCase().replace(" ", "_");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char first = text.charAt(i);
            char second = (i + 1 < text.length()) ? text.charAt(i + 1) : '_';

            // Заменяем J на I
            first = (first == 'J') ? 'I' : first;
            second = (second == 'J') ? 'I' : second;

            int[] pos1 = findPosition(first);
            int[] pos2 = findPosition(second);

            if (pos1 == null || pos2 == null) {
                // Если символ не найден, добавляем как есть
                result.append(first).append(second);
                continue;
            }

            if (pos1[0] == pos2[0]) {  // одна строка
                result.append(keyMatrix[pos1[0]][(pos1[1] + 1) % 5]);
                result.append(keyMatrix[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) {  // один столбец
                result.append(keyMatrix[(pos1[0] + 1) % 6][pos1[1]]);
                result.append(keyMatrix[(pos2[0] + 1) % 6][pos2[1]]);
            } else {  // прямоугольник
                result.append(keyMatrix[pos1[0]][pos2[1]]);
                result.append(keyMatrix[pos2[0]][pos1[1]]);
            }
        }

        return result.toString();
    }

    @Override
    public String decrypt(String text, String key) {
        generateKeyMatrix(key);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char first = text.charAt(i);
            char second = text.charAt(i + 1);

            int[] pos1 = findPosition(first);
            int[] pos2 = findPosition(second);

            if (pos1 == null || pos2 == null) {
                // Если символ не найден, добавляем как есть
                result.append(first).append(second);
                continue;
            }

            if (pos1[0] == pos2[0]) {  // одна строка
                result.append(keyMatrix[pos1[0]][(pos1[1] - 1 + 5) % 5]);
                result.append(keyMatrix[pos2[0]][(pos2[1] - 1 + 5) % 5]);
            } else if (pos1[1] == pos2[1]) {  // один столбец
                result.append(keyMatrix[(pos1[0] - 1 + 6) % 6][pos1[1]]);
                result.append(keyMatrix[(pos2[0] - 1 + 6) % 6][pos2[1]]);
            } else {  // прямоугольник
                result.append(keyMatrix[pos1[0]][pos2[1]]);
                result.append(keyMatrix[pos2[0]][pos1[1]]);
            }
        }

        return result.toString();
    }
}