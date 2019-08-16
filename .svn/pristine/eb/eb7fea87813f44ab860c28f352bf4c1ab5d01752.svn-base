package Controlador;

import Modelo.EncryptionModel;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncriptionController {

    public String ValorAEncriptar(String valor) {
        String resultado = "";
        String data = valor;
        String k = "Bar12345Bar12345";
        try {
            SecretKey key = new SecretKeySpec(k.getBytes(), "AES");
            EncryptionModel encrypter = new EncryptionModel(key);
            resultado = encrypter.encrypt(data);
        } catch (Exception e) {
            System.out.println("Controlador.Encryption.Encriptar()" + e.getMessage());
        }
        return resultado;
    }

    public String ValorADesencriptar(String valor) {
        String resultado = "";
        String data = valor;
        String k = "Bar12345Bar12345";
        try {
            SecretKey key = new SecretKeySpec(k.getBytes(), "AES");
            EncryptionModel encrypter = new EncryptionModel(key);
            resultado = encrypter.decrypt(valor);
        } catch (Exception e) {
            System.out.println("Controlador.Encryption.Encriptar()" + e.getMessage());
        }
        return resultado;
    }
}
