package br.com.eloir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.eloir.service.ImportadorCsvService;

@SpringBootApplication
public class PioresFilmesAppApplication {

	@Autowired
	private ImportadorCsvService importer;
	
	public static void main(String[] args) {
		SpringApplication.run(PioresFilmesAppApplication.class, args);

	}

	@Bean
	String cargaArquivoCsv() {
	    importer.importCsvToDatabase();
		return "OK";
	}
	
}
