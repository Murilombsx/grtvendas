package br.com.grtvendas.utilitarios;

import java.security.MessageDigest;

import org.jboss.security.Base64Encoder;

public class CriptografiaService {
	
	public String criptografar(String senha) {
        try {
            byte[] digest = MessageDigest.getInstance("sha-256").digest(senha.getBytes());
            return Base64Encoder.encode(digest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

