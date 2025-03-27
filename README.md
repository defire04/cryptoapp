# Encryption Tasks ReadMe

## Task 1: Simple Substitution Cipher
Encrypt the plaintext **KOZHUKHOVSKY** using a simple substitution cipher.

**Input:**
```json
{
    "text": "KOZHUKHOVSKY",
    "cipherType": "SIMPLE_SUBSTITUTION",
    "key": "KWRHPTBNU_DOZEFJCYVGAIXMQLS"
}
```

**Encrypted Text:**
```
DFLNADNFIVDQ
```

---

## Task 2: Password Substitution Cipher
Encrypt the plaintext **KOZHUKHOVSKY** using a password substitution cipher.

**Input:**
```json
{
    "text": "KOZHUKHOVSKY",
    "cipherType": "PASSWORD_SUBSTITUTION",
    "key": "SLOGAN_"
}
```

**Encrypted Text:**
```
EJYBTEBJUQEX
```

---

## Task 3: Vigenère Cipher
Encrypt the plaintext **KOZHUKHOVSKY** using the Vigenère cipher with a chosen key.

**Input:**
```json
{
    "text": "KOZHUKHOVSKY",
    "cipherType": "VIGENERE",
    "key": "BITCOIN"
}
```

**Encrypted Text:**
```
LWRJHSUPCKML
```

---

## Task 4: Playfair Cipher
Encrypt the plaintext **KOZHUKHOVSKY** using the Playfair cipher.

**Input:**
```json
{
    "text": "KOZHUKHOVSKY",
    "cipherType": "PLAYFAIR",
    "key": "SECURITY"
}
```

**Encrypted Text:**
```
R_CNP,RZXM,J
```

---

## Task 5: Vertical Transposition Cipher
Encrypt a plaintext message of at least 50 characters using a vertical transposition cipher with a key of length 7.

**Input:**
```json
{
    "text": "KOZHUKHOVSKY YAROSLAV ALEKSANDROVICH",
    "cipherType": "VERTICAL_TRANSPOSITION",
    "key": "FOREVER"
}
```

**Encrypted Text:**
```
HKLSI KYVNH KORLR OVOEO ZSSKV HAAD_ UYAAC
```



