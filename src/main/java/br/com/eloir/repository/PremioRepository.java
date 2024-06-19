package br.com.eloir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eloir.dto.ProducerInterval;
import br.com.eloir.entity.Premio;

public interface PremioRepository extends JpaRepository<Premio, Long> {
		
	@Query(value = " SELECT (ultimo_premio - primeiro_premio) as intervalo "
			+ " FROM (SELECT produtor, ano as primeiro_premio, LEAD(ano) OVER (PARTITION BY produtor ORDER BY ano) as ultimo_premio FROM premio where vencedor is true) as t "
			+ " WHERE T.ultimo_premio IS NOT NULL "
			+ " ORDER BY intervalo ASC LIMIT 1"
			, nativeQuery = true)
	int buscarMenorTempoParaGanharPremio();
	
	@Query(value = " SELECT (ultimo_premio - primeiro_premio) as intervalo "
			+ " FROM (SELECT produtor, ano as primeiro_premio, LEAD(ano) OVER (PARTITION BY produtor ORDER BY ano) as ultimo_premio FROM premio where vencedor is true) as t "
			+ " WHERE T.ultimo_premio IS NOT NULL "
			+ " ORDER BY intervalo DESC LIMIT 1"
			, nativeQuery = true)
	int buscarMaiorTempoParaGanharPremio();
	
	@Query(nativeQuery = true)
	List<ProducerInterval> buscarProdutorDemorouMaisEMaisRapido_Named(int intervalo);
	
}
