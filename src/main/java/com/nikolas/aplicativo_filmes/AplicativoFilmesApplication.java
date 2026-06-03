package com.nikolas.aplicativo_filmes;

import com.nikolas.aplicativo_filmes.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicativoFilmesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AplicativoFilmesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();

	}
}
