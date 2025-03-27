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
        text = text.toUpperCase().replace(" ", "");
        key = key.toUpperCase();

        int rows = (int) Math.ceil((double) text.length() / key.length());
        char[][] matrix = new char[rows][key.length()];

        // Заполнение матрицы
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

        // Определение порядка столбцов по алфавиту
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

        // Добавление пробелов для групп по 5 символов
        StringBuilder formattedResult = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            formattedResult.append(result.charAt(i));
            if ((i + 1) % 5 == 0 && i < result.length() - 1) {
                formattedResult.append(' ');
            }
        }

        return formattedResult.toString();
    }

    @Override
    public String decrypt(String text, String key) {
        key = key.toUpperCase();

        int rows = (int) Math.ceil((double) text.length() / key.length());
        char[][] matrix = new char[rows][key.length()];

        // Определение порядка столбцов
        Integer[] columnOrder = new Integer[key.length()];
        for (int i = 0; i < key.length(); i++) {
            columnOrder[i] = i;
        }
        String finalKey = key;
        Arrays.sort(columnOrder, Comparator.comparingInt(finalKey::charAt));

        // Заполнение матрицы
        int index = 0;
        for (int col : columnOrder) {
            for (int row = 0; row < rows; row++) {
                matrix[row][col] = text.charAt(index++);
            }
        }

        // Чтение расшифрованного текста
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < key.length(); col++) {
                result.append(matrix[row][col]);
            }
        }

        return result.toString();
    }
}