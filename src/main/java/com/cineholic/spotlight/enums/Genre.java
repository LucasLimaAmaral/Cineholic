package com.cineholic.spotlight.enums;

public enum Genre {
	FICCAO_CIENTIFICA(1),
    ANIMACAO(2),
    DRAMA(3),
    TERROR(4),
    ACAO(5),
    COMEDIA(6);
	
	private int code;
	
	private Genre(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Genre valueOf(int code) {
		for(Genre value : Genre.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid Genero code");
	}
}
