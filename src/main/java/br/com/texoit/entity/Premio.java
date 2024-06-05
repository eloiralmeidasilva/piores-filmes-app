package br.com.texoit.entity;



import br.com.texoit.dto.ProducerInterval;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NamedNativeQuery(name = "Premio.buscarProdutorDemorouMaisEMaisRapido_Named",
			query = " SELECT produtor, (ultimo_premio - primeiro_premio) as intervalo, primeiro_premio as primeiroPremio, ultimo_premio as ultimoPremio "
					+ " FROM (SELECT produtor, ano as primeiro_premio, LEAD(ano) OVER (PARTITION BY produtor ORDER BY ano) as ultimo_premio FROM premio) as t "
					+ " WHERE T.ultimo_premio IS NOT NULL "
					+ " AND (ultimo_premio - primeiro_premio) = :intervalo "
					+ " ORDER BY intervalo ASC",
			resultSetMapping = "Mapping.ProducerInterval")
@SqlResultSetMapping(name = "Mapping.ProducerInterval",
			classes = @ConstructorResult(targetClass = ProducerInterval.class,
					columns = {@ColumnResult(name = "produtor"),
							@ColumnResult(name = "intervalo"),
							@ColumnResult(name = "primeiroPremio"),
							@ColumnResult(name = "ultimoPremio")}))
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Premio")
public class Premio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "ano")
    private int year;
    
	@Column(name = "titulo")
	private String title;
	
	@Column(name = "estudio")
    private String studios;
	
	@Column(name = "produtor")
    private String producers;
	
	@Column(name = "vencedor")
    private boolean winner;

	public Premio(int year, String title, String studios, String producers, boolean winner) {
		super();
		this.year = year;
		this.title = title;
		this.studios = studios;
		this.producers = producers;
		this.winner = winner;
	}

}
