package com.jarmo.domain.entities;

import java.time.OffsetDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "configuracoes_jogadas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConfiguracaoJogada {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	@Column(length = 5)
	private String palavra;
	
	@NotBlank
	@NotNull
	private OffsetDateTime dataCadastro;
	
	@OneToMany(mappedBy = "configuracao_jogada")
	private List<Jogada> jogadas;

	public void gerarPalavra() {
		setPalavra("teste");
	}
}
