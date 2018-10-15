package br.com.grtvendas.utilitarios;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class LoginService {

	public LoginService() {
	}

	public String geraToken(Integer id, String email, String nome, Integer expiraEmDias) {

		SignatureAlgorithm algoritmoAssinatura = SignatureAlgorithm.HS512;

		Date agora = new Date();

		Calendar expira = Calendar.getInstance();
		expira.add(Calendar.DAY_OF_MONTH, expiraEmDias);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("segredo");
		SecretKeySpec key = new SecretKeySpec(apiKeySecretBytes, algoritmoAssinatura.getJcaName());

		JwtBuilder construtor = Jwts.builder().claim("id", id).claim("nome", nome).claim("email", email)
				.setIssuedAt(agora).signWith(algoritmoAssinatura, key).setExpiration(expira.getTime());

		return construtor.compact();
	}

	public Claims validaToken(String token) {
		try {
			Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("segredo"))
					.parseClaimsJws(token).getBody();

			System.out.println(claims.getIssuer());

			return claims;

		} catch (Exception ex) {
			throw ex;
		}
	}

}
