package com.cursos.dominio;

public class Email {

	private final String endereco;

	private Email(String endereco) {
		this.endereco = endereco;
	}

	public static Email of(String endereco) {
		if (isValidEmail(endereco)) {
			return new Email(endereco);
		} else {
			throw new IllegalArgumentException("Endereço de e-mail inválido.");
		}
	}

	public String getEndereco() {
		return endereco;
	}

	private static boolean isValidEmail(String email) {
		return email.contains("@");
	}
}