package br.com.grupo_pica_pau.compilador.lexico;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PpScanner {

	private char[] content;
	private int estado;
	private int pos;
	
	public PpScanner (String filename) {
		try {
			String txtConteudo;
			txtConteudo = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
			System.out.println("DEBUG ----");
			System.out.println(txtConteudo);
			content = txtConteudo.toCharArray();
			pos = 0;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public Token nextToken() {
		if(isEOF()) {
			return null;
		}
		estado = 0;
		while (true) {
			switch(estado) {
			case 0:
			}
		}
	}
	
	private boolean isFloat (char c, char v) {
		return (c >= '0' && c <='9') && (v >= '0' && v <= '9');
	}
	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
	private boolean isChar(char c) {
		return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
	}
	
	private boolean isOp_Rel(char c) {
		return c == '<'|| c == '>' || c == '=' || c == '!';
	}
	
	private boolean isOp_Ari(char c) {
		return c == '+' || c == '-' || c == '*' || c == '=';
	}
	private boolean isCaracter_esp (char c) {
		return c == ')' || c == '(' || c == '{' || c == '}' || c == ',' || c == ';';
	}
	private char nextChar() {
		return content[pos++];
	}
	private boolean isEOF() {
		return pos == content.length;
	}
	private void back() {
		pos--;
	}
	
}
