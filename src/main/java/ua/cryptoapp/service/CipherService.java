package ua.cryptoapp.service;

public abstract class CipherService {
    public abstract String encrypt(String text, String key);

    public abstract String decrypt(String text, String key);
}