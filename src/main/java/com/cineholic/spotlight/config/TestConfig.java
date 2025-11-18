package com.cineholic.spotlight.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cineholic.spotlight.entities.Filme;
import com.cineholic.spotlight.enums.Genero;
import com.cineholic.spotlight.repositories.FilmeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	public void run(String... args) throws Exception{
		// Exemplo 1: Ficção Científica
		Filme filme1 = new Filme(
		    1L,
		    "A Origem",
		    Genero.FICCAO_CIENTIFICA,
		    148,
		    "Um ladrão que rouba segredos corporativos através do uso de tecnologia de compartilhamento de sonhos.",
		    "https://img.cinema.com/posters/a-origem.jpg"
		);

		// Exemplo 2: Animação
		Filme filme2 = new Filme(
		    2L,
		    "O Rei Leão",
		    Genero.ANIMACAO,
		    88,
		    "O príncipe leão Simba e seu pai são alvos de seu tio amargo, que quer ascender ao trono.",
		    "https://img.cinema.com/posters/rei-leao.jpg"
		);

		// Exemplo 3: Drama/Crime
		Filme filme3 = new Filme(
		    3L,
		    "O Poderoso Chefão",
		    Genero.DRAMA,
		    175,
		    "O patriarca idoso de uma dinastia do crime organizado transfere o controle de seu império clandestino para seu filho relutante.",
		    "https://img.cinema.com/posters/godfather.jpg"
		);

		// Exemplo 4: Terror
		Filme filme4 = new Filme(
		    4L,
		    "O Iluminado",
		    Genero.TERROR,
		    146,
		    "Uma família se dirige a um hotel isolado para o inverno, onde uma presença maligna influencia o pai à violência.",
		    "https://img.cinema.com/posters/shining.jpg"
		);
	        
	        filmeRepository.saveAll(Arrays.asList(filme1, filme2, filme3, filme4));
	}
}
