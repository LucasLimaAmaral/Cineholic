package com.cineholic.spotlight.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cineholic.spotlight.entities.Customer;
import com.cineholic.spotlight.entities.Movie;
import com.cineholic.spotlight.entities.Room;
import com.cineholic.spotlight.entities.Seat;
import com.cineholic.spotlight.entities.Session;
import com.cineholic.spotlight.entities.Ticket;
import com.cineholic.spotlight.enums.Genre;
import com.cineholic.spotlight.repositories.CustomerRepository;
import com.cineholic.spotlight.repositories.MovieRepository;
import com.cineholic.spotlight.repositories.RoomRepository;
import com.cineholic.spotlight.repositories.SeatRepository;
import com.cineholic.spotlight.repositories.SessionRepository;
import com.cineholic.spotlight.repositories.TicketRepository;

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
		// 1. SALAS
		// ------------------------------------------
		Room sala1 = new Room(null, "Sala 01 (IMAX)", 100);
		Room sala2 = new Room(null, "Sala 02 (VIP)", 30);
		Room sala3 = new Room(null, "Sala 03 (Standard)", 60);

		salaRepository.saveAll(Arrays.asList(sala1, sala2, sala3));

		// ------------------------------------------
		// 2. FILMES
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
		// 3. USUÁRIOS
		// ------------------------------------------
		Customer u1 = new Customer(null, "Maria Silva", "maria@gmail.com", "123456");
		Customer u2 = new Customer(null, "Joao Souza", "joao@gmail.com", "123456");
		Customer u3 = new Customer(null, "Ana Clara", "ana@gmail.com", "123456");

		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));

		// ------------------------------------------
		// 4. ASSENTOS
		// ------------------------------------------
		// Lista para acumular todos os assentos antes de salvar
		List<Seat> todosAssentos = new ArrayList<>();

		// Assentos da Sala 1
		Seat s1_a1 = new Seat(); s1_a1.setNumber("A1"); s1_a1.setRoom(sala1);
		Seat s1_a2 = new Seat(); s1_a2.setNumber("A2"); s1_a2.setRoom(sala1);
		Seat s1_a3 = new Seat(); s1_a3.setNumber("A3"); s1_a3.setRoom(sala1);
		todosAssentos.addAll(Arrays.asList(s1_a1, s1_a2, s1_a3));
		
		// Assentos da Sala 2
		Seat s2_a1 = new Seat(); s2_a1.setNumber("A1"); s2_a1.setRoom(sala2);
		Seat s2_a2 = new Seat(); s2_a2.setNumber("A2"); s2_a2.setRoom(sala2);
		todosAssentos.addAll(Arrays.asList(s2_a1, s2_a2));

		// --- NOVO: Assentos da Sala 3 (Para o seu Teste) ---
		// Criando 10 cadeiras na sala 3 (IDs serão gerados sequencialmente)
		List<Seat> assentosSala3 = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			Seat s = new Seat();
			s.setNumber("A" + String.valueOf(i)); // Cadeira 1, 2, 3...
			s.setRoom(sala3);
			assentosSala3.add(s);
			todosAssentos.add(s);
		}

		assentoRepository.saveAll(todosAssentos);

		// ------------------------------------------
		// 5. SESSÕES
		// ------------------------------------------
		Session sessao1 = new Session(null, LocalDateTime.parse("2023-11-20T14:00:00"), 25.50, filme1, sala1);
		Session sessao2 = new Session(null, LocalDateTime.parse("2023-11-20T16:00:00"), 50.00, filme2, sala2);
		Session sessao3 = new Session(null, LocalDateTime.parse("2023-11-21T20:00:00"), 30.00, filme3, sala1);
		Session sessao4 = new Session(null, LocalDateTime.parse("2023-11-20T17:00:00"), 25.55, filme1, sala2);
		
		// --- NOVA SESSÃO PARA TESTE (Sala 3 - O Iluminado) ---
		Session sessaoTeste = new Session(null, LocalDateTime.parse("2023-12-30T20:00:00"), 40.00, filme4, sala3);

		sessaoRepository.saveAll(Arrays.asList(sessao1, sessao2, sessao3, sessao4, sessaoTeste));

		// ------------------------------------------
		// 6. INGRESSOS (Vendas já existentes)
		// ------------------------------------------
		Ticket i1 = new Ticket(null, sessao1, s1_a1, u1);
		Ticket i2 = new Ticket(null, sessao1, s1_a2, u2);
		Ticket i3 = new Ticket(null, sessao2, s2_a1, u3);

		ingressoRepository.saveAll(Arrays.asList(i1, i2, i3));
		
		// ------------------------------------------
		// 7. LOGS PARA O POSTMAN (Copie do Console)
		// ------------------------------------------
		System.out.println("\n--- DADOS PARA TESTE NO POSTMAN ---");
		System.out.println("URL: http://localhost:8080/purchases");
		System.out.println("METHOD: POST");
		System.out.println("JSON BODY SUGERIDO:");
		System.out.println("{");
		System.out.println("  \"sessionId\": " + sessaoTeste.getId() + ","); // ID da sessão limpa
		System.out.println("  \"customerId\": " + u3.getId() + ","); // ID da Ana Clara
		
		// Pega os IDs reais do banco dos dois primeiros assentos da sala 3
		Long idAssentoTeste1 = assentosSala3.get(0).getId();
		Long idAssentoTeste2 = assentosSala3.get(1).getId();
		
		System.out.println("  \"seatIds\": [" + idAssentoTeste1 + ", " + idAssentoTeste2 + "]");
		System.out.println("}");
		System.out.println("-----------------------------------\n");
	}
}