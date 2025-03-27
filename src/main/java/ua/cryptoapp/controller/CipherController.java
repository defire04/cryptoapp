package ua.cryptoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.cryptoapp.dto.CipherRequest;
import ua.cryptoapp.service.impl.*;

import java.util.Objects;

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
        request.setText(request.getText().toUpperCase());

        if(request.getKey() != null){
            request.setKey(request.getKey().toUpperCase());
        }

        return switch (request.getCipherType()) {
            case SIMPLE_SUBSTITUTION -> simpleSubstitutionCipherService.encrypt(request.getText(), request.getKey());
            case PASSWORD_SUBSTITUTION ->
                    passwordSubstitutionCipherService.encrypt(request.getText(), request.getKey());
            case VIGENERE -> vigenereCipherService.encrypt(request.getText(), request.getKey());
            case PLAYFAIR -> playfairCipherService.encrypt(request.getText(), request.getKey());
            case VERTICAL_TRANSPOSITION ->
                    verticalTranspositionCipherService.encrypt(request.getText(), Objects.requireNonNull(request.getKey()));
        };
    }
}