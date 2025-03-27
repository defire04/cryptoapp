package ua.cryptoapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ua.cryptoapp.CipherType;

@NoArgsConstructor
public class CipherRequest {
    private String key;
    private String text;
    private CipherType cipherType;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CipherType getCipherType() {
        return cipherType;
    }

    public void setCipherType(CipherType cipherType) {
        this.cipherType = cipherType;
    }
}