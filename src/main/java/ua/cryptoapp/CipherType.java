package ua.cryptoapp;

public enum CipherType {
    SIMPLE_SUBSTITUTION,
    PASSWORD_SUBSTITUTION,
    VIGENERE,
    PLAYFAIR,
    VERTICAL_TRANSPOSITION
}

/*
Завдання 1. Зашифрувати відкритий текст: KOZHUKHOVSKY над
латинським алфавітом за допомогою шифру однобуквеної заміни.
{
    "text": "KOZHUKHOVSKY",
    "cipherType": "SIMPLE_SUBSTITUTION",
     "key": "KWRHPTBNU_DOZEJFCYVGAIXMQLS"
}
Завдання 2. Зашифрувати відкритий текст KOZHUKHOVSKY над
латинським алфавітом за допомогою гаслового шифру.
{
    "text": "KOZHUKHOVSKY",
    "cipherType": "PASSWORD_SUBSTITUTION",
    "key": "SLOGAN_"
}
Завдання 3. Зашифрувати відкритий текст: KOZHUKHOVSKY над
латинським алфавітом за допомогою шифру Віженера з довільно вибраним
разовим ключем.
{
    "text": "KOZHUKHOVSKY",
    "cipherType": "VIGENERE",
    "key": "BITCOIN"
}
Завдання 4. Зашифрувати відкритий текст: KOZHUKHOVSKY над
латинським алфавітом за допомогою шифру Плейфера.
{
    "text": "KOZHUKHOVSKY",
    "cipherType": "PLAYFAIR",
    "key": "SECURITY"
}
Завдання 5. Зашифрувати шифром вертикальної перестановки з
ключем довжини 7 довільний відкритий текст довжиною не менше 50-и
символів на будь-якій європейській мові.
{
    "text": "KOZHUKHOVSKY YAROSLAV ALEKSANDROVICH",
    "cipherType": "VERTICAL_TRANSPOSITION",
    "key": "FOREVER"
}


* */