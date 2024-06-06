package br.com.eloir.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProducerIntervalsDTO {
	
	private List<ProducerInterval> min;
    private List<ProducerInterval> max;

}
