package br.com.texoit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProducerInterval {

	private String produtor;
    private int intervalo;
    private int primeiroPremio;
    private int ultimoPremio;
    	
}