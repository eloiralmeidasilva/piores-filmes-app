package br.com.eloir;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.eloir.repository.PremioRepository;
import br.com.eloir.service.ImportadorCsvService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PioresFilmesAppApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private ImportadorCsvService importer;
	
	@Autowired
	private PremioRepository premioRepository;
	
	@Test
	void verificaCargaArquivoCsv() {
		importer.importCsvToDatabase();
		
		int size = premioRepository.findAll().size();
		
		Assertions.assertTrue(size > 0);
	}
	
	@Test
    public void testIntervalosEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/premios/intervalos"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.min[0].produtor").value("Yoram Globus and Menahem Golan"))
               .andExpect(jsonPath("$.min[0].intervalo").value(1))
               .andExpect(jsonPath("$.min[0].primeiroPremio").value(1986))
               .andExpect(jsonPath("$.min[0].ultimoPremio").value(1987))
               .andExpect(jsonPath("$.max[0].produtor").value("Jerry Weintraub"))
               .andExpect(jsonPath("$.max[0].intervalo").value(9))
               .andExpect(jsonPath("$.max[0].primeiroPremio").value(1980))
               .andExpect(jsonPath("$.max[0].ultimoPremio").value(1989));
    }

}
