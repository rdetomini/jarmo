package com.jarmo.domain.entities;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "jogadas")
public class Jogada {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(length = 5)
	private String palavra;
	
	@NotNull
	@NotBlank
	private OffsetDateTime data_tentativa;
	
	@NotNull
	@NotBlank
	private Boolean acertou;
	
	@NotNull
	@NotBlank
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@NotNull
	@NotBlank
	@ManyToOne
	@JoinColumn(name = "configuracao_jogada_id")
	private ConfiguracaoJogada configuracao_jogada;
}
