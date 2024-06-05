package br.com.texoit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.texoit.dto.ProducerIntervalsDTO;
import br.com.texoit.repository.PremioRepository;

@Service
public class PremioService {

	@Autowired
	private PremioRepository premioRepository;
	
	public ProducerIntervalsDTO getProducerIntervals() throws Exception {
			
		int menorIntervalo = premioRepository.buscarMenorTempoParaGanharPremio();
		int maiorIntervalo = premioRepository.buscarMaiorTempoParaGanharPremio();
		
        ProducerIntervalsDTO intervalsDTO = new ProducerIntervalsDTO();
        intervalsDTO.setMin(premioRepository.buscarProdutorDemorouMaisEMaisRapido_Named(menorIntervalo));
        intervalsDTO.setMax(premioRepository.buscarProdutorDemorouMaisEMaisRapido_Named(maiorIntervalo));
        
        return intervalsDTO;
	}
	
}
