package ua.cryptoapp.dto;

import lombok.Data;
import ua.cryptoapp.CipherType;

@Data
public class CipherRequest {
    private String key;
    private String text;
    private CipherType cipherType;

}