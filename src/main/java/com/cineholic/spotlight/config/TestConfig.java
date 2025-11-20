package com.cineholic.spotlight.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cineholic.spotlight.entities.Seat;
import com.cineholic.spotlight.entities.Movie;
import com.cineholic.spotlight.entities.Ticket;
import com.cineholic.spotlight.entities.Room;
import com.cineholic.spotlight.entities.Session;
import com.cineholic.spotlight.entities.Customer;
import com.cineholic.spotlight.enums.Genre;
import com.cineholic.spotlight.repositories.SeatRepository;
import com.cineholic.spotlight.repositories.MovieRepository;
import com.cineholic.spotlight.repositories.TicketRepository;
import com.cineholic.spotlight.repositories.RoomRepository;
import com.cineholic.spotlight.repositories.SessionRepository;
import com.cineholic.spotlight.repositories.CustomerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private MovieRepository filmeRepository;

	@Autowired
	private RoomRepository salaRepository;

	@Autowired
	private SeatRepository assentoRepository;

	@Autowired
	private SessionRepository sessaoRepository;

	@Autowired
	private CustomerRepository usuarioRepository;

	@Autowired
	private TicketRepository ingressoRepository;

	@Override
	public void run(String... args) throws Exception {

		// ------------------------------------------
		// 1. SALAS (Criar salas primeiro para por assentos)
		// ------------------------------------------
		Room sala1 = new Room(null, "Sala 01 (IMAX)", 100);
		Room sala2 = new Room(null, "Sala 02 (VIP)", 30);
		Room sala3 = new Room(null, "Sala 03 (Standard)", 60);

		salaRepository.saveAll(Arrays.asList(sala1, sala2, sala3));

		// ------------------------------------------
		// 2. FILMES (Seus exemplos)
		// ------------------------------------------
		Movie filme1 = new Movie(null, "A Origem", Genre.FICCAO_CIENTIFICA, 148,
				"Um ladrão que rouba segredos...", "https://img.cinema.com/posters/a-origem.jpg");
		Movie filme2 = new Movie(null, "O Rei Leão", Genre.ANIMACAO, 88, 
				"O príncipe leão Simba...", "https://img.cinema.com/posters/rei-leao.jpg");
		Movie filme3 = new Movie(null, "O Poderoso Chefão", Genre.DRAMA, 175, 
				"O patriarca idoso...", "https://img.cinema.com/posters/godfather.jpg");
		Movie filme4 = new Movie(null, "O Iluminado", Genre.TERROR, 146, 
				"Uma família se dirige a um hotel...", "https://img.cinema.com/posters/shining.jpg");

		filmeRepository.saveAll(Arrays.asList(filme1, filme2, filme3, filme4));

		// ------------------------------------------
		// 3. USUÁRIOS (Clientes)
		// ------------------------------------------
		Customer u1 = new Customer(null, "Maria Silva", "maria@gmail.com", "123456");
		Customer u2 = new Customer(null, "Joao Souza", "joao@gmail.com", "123456");
		Customer u3 = new Customer(null, "Ana Clara", "ana@gmail.com", "123456");

		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));

		// ------------------------------------------
		// 4. ASSENTOS (Ligados às Salas)
		// ------------------------------------------
		// Assentos da Sala 1 (Criando apenas alguns para teste)
		Seat s1_a1 = new Seat(); s1_a1.setNumber(1); s1_a1.setRoom(sala1);
		Seat s1_a2 = new Seat(); s1_a2.setNumber(2); s1_a2.setRoom(sala1);
		Seat s1_a3 = new Seat(); s1_a3.setNumber(3); s1_a3.setRoom(sala1);
		
		// Assentos da Sala 2
		Seat s2_a1 = new Seat(); s2_a1.setNumber(1); s2_a1.setRoom(sala2);
		Seat s2_a2 = new Seat(); s2_a2.setNumber(2); s2_a2.setRoom(sala2);

		assentoRepository.saveAll(Arrays.asList(s1_a1, s1_a2, s1_a3, s2_a1, s2_a2));

		// ------------------------------------------
		// 5. SESSÕES (Ligando Filme + Sala + Horário)
		// ------------------------------------------
		// A Origem na Sala 1 hoje às 14:00
		Session sessao1 = new Session(null, LocalDateTime.parse("2023-11-20T14:00:00"), 25.50, filme1, sala1);
		Session sessao4 = new Session(null, LocalDateTime.parse("2023-11-20T17:00:00"), 25.55, filme1, sala2);
		
		// O Rei Leão na Sala 2 hoje às 16:00
		Session sessao2 = new Session(null, LocalDateTime.parse("2023-11-20T16:00:00"), 50.00, filme2, sala2);
		
		// O Poderoso Chefão na Sala 1 amanhã às 20:00
		Session sessao3 = new Session(null, LocalDateTime.parse("2023-11-21T20:00:00"), 30.00, filme3, sala1);

		sessaoRepository.saveAll(Arrays.asList(sessao1, sessao2, sessao3, sessao4));

		// ------------------------------------------
		// 6. INGRESSOS (Vendas Realizadas)
		// ------------------------------------------
		// Maria comprou ingresso para A Origem (Sessao 1), cadeira 1
		Ticket i1 = new Ticket(null, sessao1, s1_a1, u1);
		
		// Joao comprou ingresso para A Origem (Sessao 1), cadeira 2
		Ticket i2 = new Ticket(null, sessao1, s1_a2, u2);
		
		// Ana comprou ingresso para O Rei Leão (Sessao 2), cadeira 1
		Ticket i3 = new Ticket(null, sessao2, s2_a1, u3);

		ingressoRepository.saveAll(Arrays.asList(i1, i2, i3));
		
		System.out.println("--- BANCO DE DADOS POPULADO COM SUCESSO ---");
	}
}
