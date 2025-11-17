package com.cineholic.spotlight.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cineholic.spotlight.entities.Filme;
import com.cineholic.spotlight.repositories.FilmeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	public void run(String... args) throws Exception{
		Filme filme1 = new Filme(
	            null, // id
	            "O Início", // titulo
	            "Ficção Científica/Ação", // genero
	            2.48, // duration (em horas, 2 horas e 28 minutos)
	            "Um ladrão que rouba segredos corporativos através de tecnologia de sonho é encarregado de plantar uma ideia na mente de um CEO.", // sinopse
	            "http://example.com/cartaz/inicio.jpg" // cartazUrl
	        );
	        
	        // Exemplo 2: Filme de Comédia Romântica
	        Filme filme2 = new Filme(
	            null, 
	            "Loucamente Apaixonados", 
	            "Comédia Romântica", 
	            1.75, // 1 hora e 45 minutos
	            "Dois estudantes universitários se apaixonam e lutam para manter seu relacionamento vivo depois que um deles é deportado.", 
	            "http://example.com/cartaz/apaixonados.png"
	        );
	        
	        // Exemplo 3: Filme de Animação/Aventura
	        Filme filme3 = new Filme(
	            null, 
	            "A Lenda do Tesouro Perdido", 
	            "Animação/Aventura", 
	            1.55, // 1 hora e 33 minutos
	            "Um jovem aventureiro e seus amigos embarcam em uma jornada épica para encontrar um tesouro lendário e proteger seu reino.", 
	            "http://example.com/cartaz/tesouro.gif"
	        );
	        
	        // Exemplo 4: Usando o construtor padrão e setters
	        Filme filme4 = new Filme();
	        filme4.setId(null);
	        filme4.setTitulo("Mistério na Mansão");
	        filme4.setGenero("Suspense/Drama");
	        filme4.setDuration(2.05); // 2 horas e 3 minutos
	        filme4.setSinopse("Um detetive investiga um assassinato misterioso que ocorre durante uma tempestade em uma mansão isolada.");
	        filme4.setCartazUrl("http://example.com/cartaz/misterio.webp");
	        
	        filmeRepository.saveAll(Arrays.asList(filme1, filme2, filme3, filme4));
	}
}
