package ua.cryptoapp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.cryptoapp.dto.CipherRequest;
import ua.cryptoapp.CipherType;

@Controller
@RequiredArgsConstructor
public class EncryptionPageController {
    private final CipherController cipherController;

    @GetMapping("/")
    public String showEncryptionPage(Model model) {
        model.addAttribute("cipherTypes", CipherType.values());
        return "encryption";
    }

    @PostMapping("/encrypt")
    public String encrypt(CipherRequest request, Model model) {
        try {
            // Convert to uppercase to match cipher implementation
            request.setText(request.getText().toUpperCase());
            if (request.getKey() != null) {
                request.setKey(request.getKey().toUpperCase());
            }

            // Call the existing encrypt method from CipherController
            String result = cipherController.encrypt(request);
            model.addAttribute("result", result);
        } catch (Exception e) {
            model.addAttribute("result", "Encryption failed: " + e.getMessage());
        }
        return "encryption";
    }
}