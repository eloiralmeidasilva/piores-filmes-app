package br.com.texoit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.texoit.dto.ProducerIntervalsDTO;
import br.com.texoit.service.PremioService;

@RestController
@RequestMapping("/premios")
public class ProdutorController {

	@Autowired
	private PremioService movieService;
	
    @GetMapping("/intervalos")
    public ResponseEntity<ProducerIntervalsDTO> getProducerIntervals() throws Exception {

        return ResponseEntity.ok(movieService.getProducerIntervals());
    }
	
}
