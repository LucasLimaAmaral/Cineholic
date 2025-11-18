package com.cineholic.spotlight.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cineholic.spotlight.entities.Assento;
import com.cineholic.spotlight.entities.Filme;
import com.cineholic.spotlight.entities.Ingresso;
import com.cineholic.spotlight.entities.Sala;
import com.cineholic.spotlight.entities.Sessao;
import com.cineholic.spotlight.entities.Usuario;
import com.cineholic.spotlight.enums.Genero;
import com.cineholic.spotlight.repositories.AssentoRepository;
import com.cineholic.spotlight.repositories.FilmeRepository;
import com.cineholic.spotlight.repositories.IngressoRepository;
import com.cineholic.spotlight.repositories.SalaRepository;
import com.cineholic.spotlight.repositories.SessaoRepository;
import com.cineholic.spotlight.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private SalaRepository salaRepository;

	@Autowired
	private AssentoRepository assentoRepository;

	@Autowired
	private SessaoRepository sessaoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private IngressoRepository ingressoRepository;

	@Override
	public void run(String... args) throws Exception {

		// ------------------------------------------
		// 1. SALAS (Criar salas primeiro para por assentos)
		// ------------------------------------------
		Sala sala1 = new Sala(null, "Sala 01 (IMAX)", 100);
		Sala sala2 = new Sala(null, "Sala 02 (VIP)", 30);
		Sala sala3 = new Sala(null, "Sala 03 (Standard)", 60);

		salaRepository.saveAll(Arrays.asList(sala1, sala2, sala3));

		// ------------------------------------------
		// 2. FILMES (Seus exemplos)
		// ------------------------------------------
		Filme filme1 = new Filme(null, "A Origem", Genero.FICCAO_CIENTIFICA, 148,
				"Um ladrão que rouba segredos...", "https://img.cinema.com/posters/a-origem.jpg");
		Filme filme2 = new Filme(null, "O Rei Leão", Genero.ANIMACAO, 88, 
				"O príncipe leão Simba...", "https://img.cinema.com/posters/rei-leao.jpg");
		Filme filme3 = new Filme(null, "O Poderoso Chefão", Genero.DRAMA, 175, 
				"O patriarca idoso...", "https://img.cinema.com/posters/godfather.jpg");
		Filme filme4 = new Filme(null, "O Iluminado", Genero.TERROR, 146, 
				"Uma família se dirige a um hotel...", "https://img.cinema.com/posters/shining.jpg");

		filmeRepository.saveAll(Arrays.asList(filme1, filme2, filme3, filme4));

		// ------------------------------------------
		// 3. USUÁRIOS (Clientes)
		// ------------------------------------------
		Usuario u1 = new Usuario(null, "Maria Silva", "maria@gmail.com", "123456");
		Usuario u2 = new Usuario(null, "Joao Souza", "joao@gmail.com", "123456");
		Usuario u3 = new Usuario(null, "Ana Clara", "ana@gmail.com", "123456");

		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));

		// ------------------------------------------
		// 4. ASSENTOS (Ligados às Salas)
		// ------------------------------------------
		// Assentos da Sala 1 (Criando apenas alguns para teste)
		Assento s1_a1 = new Assento(); s1_a1.setNumero(1); s1_a1.setSala(sala1);
		Assento s1_a2 = new Assento(); s1_a2.setNumero(2); s1_a2.setSala(sala1);
		Assento s1_a3 = new Assento(); s1_a3.setNumero(3); s1_a3.setSala(sala1);
		
		// Assentos da Sala 2
		Assento s2_a1 = new Assento(); s2_a1.setNumero(1); s2_a1.setSala(sala2);
		Assento s2_a2 = new Assento(); s2_a2.setNumero(2); s2_a2.setSala(sala2);

		assentoRepository.saveAll(Arrays.asList(s1_a1, s1_a2, s1_a3, s2_a1, s2_a2));

		// ------------------------------------------
		// 5. SESSÕES (Ligando Filme + Sala + Horário)
		// ------------------------------------------
		// A Origem na Sala 1 hoje às 14:00
		Sessao sessao1 = new Sessao(null, LocalDateTime.parse("2023-11-20T14:00:00"), 25.50, filme1, sala1, null);
		
		// O Rei Leão na Sala 2 hoje às 16:00
		Sessao sessao2 = new Sessao(null, LocalDateTime.parse("2023-11-20T16:00:00"), 50.00, filme2, sala2, null);
		
		// O Poderoso Chefão na Sala 1 amanhã às 20:00
		Sessao sessao3 = new Sessao(null, LocalDateTime.parse("2023-11-21T20:00:00"), 30.00, filme3, sala1, null);

		sessaoRepository.saveAll(Arrays.asList(sessao1, sessao2, sessao3));

		// ------------------------------------------
		// 6. INGRESSOS (Vendas Realizadas)
		// ------------------------------------------
		// Maria comprou ingresso para A Origem (Sessao 1), cadeira 1
		Ingresso i1 = new Ingresso(null, sessao1, s1_a1, u1);
		
		// Joao comprou ingresso para A Origem (Sessao 1), cadeira 2
		Ingresso i2 = new Ingresso(null, sessao1, s1_a2, u2);
		
		// Ana comprou ingresso para O Rei Leão (Sessao 2), cadeira 1
		Ingresso i3 = new Ingresso(null, sessao2, s2_a1, u3);

		ingressoRepository.saveAll(Arrays.asList(i1, i2, i3));
		
		System.out.println("--- BANCO DE DADOS POPULADO COM SUCESSO ---");
	}
}
