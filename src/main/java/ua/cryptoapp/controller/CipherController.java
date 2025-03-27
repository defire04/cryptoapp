package ua.cryptoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.cryptoapp.dto.CipherRequest;
import ua.cryptoapp.service.impl.*;

@RestController
@RequestMapping("/api/v1/cipher")
@RequiredArgsConstructor
public class CipherController {
    private final SimpleSubstitutionCipherService simpleSubstitutionCipherService;
    private final PasswordSubstitutionCipherService passwordSubstitutionCipherService;
    private final VigenereCipherService vigenereCipherService;
    private final PlayfairCipherService playfairCipherService;
    private final VerticalTranspositionCipherService verticalTranspositionCipherService;

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody CipherRequest request) {
        return switch (request.getCipherType()) {
            case SIMPLE_SUBSTITUTION -> simpleSubstitutionCipherService.encrypt(request.getText(), request.getKey());
            case PASSWORD_SUBSTITUTION -> passwordSubstitutionCipherService.encrypt(request.getText(), request.getKey());
            case VIGENERE -> vigenereCipherService.encrypt(request.getText(), request.getKey());
            case PLAYFAIR -> playfairCipherService.encrypt(request.getText(), request.getKey());
            case VERTICAL_TRANSPOSITION -> verticalTranspositionCipherService.encrypt(request.getText(), request.getKey());
        };
    }


    @PostMapping("/decrypt")
    public String decrypt(@RequestBody CipherRequest request) {
        return switch (request.getCipherType()) {
            case SIMPLE_SUBSTITUTION -> simpleSubstitutionCipherService.decrypt(request.getText(), request.getKey());
            case PASSWORD_SUBSTITUTION -> passwordSubstitutionCipherService.decrypt(request.getText(), request.getKey());
            case VIGENERE -> vigenereCipherService.decrypt(request.getText(), request.getKey());
            case PLAYFAIR -> playfairCipherService.decrypt(request.getText(), request.getKey());
            case VERTICAL_TRANSPOSITION -> verticalTranspositionCipherService.decrypt(request.getText(), request.getKey());
        };
    }
}