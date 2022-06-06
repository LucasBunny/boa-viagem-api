package br.com.etechoracio.boa_viagem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.etechoracio.boa_viagem.enums.TipoViagemEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_VIAGEM")
public class Viagem {
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VIAGEM")
	private Long id;

	@NotBlank(message = "Insira um destino!")
	@Column(name = "TX_DESTINO")
	private String destino;

	@NotNull(message = "Preencha o tipo da viagem!")
	@Enumerated(EnumType.STRING)
	@Column(name = "TP_VIAGEM")
	private TipoViagemEnum tipo;

	@NotNull(message = "Preencha a data de chegada!")
	@Future
	@Column(name = "DT_CHEGADA")
	private LocalDate chegada;

	@NotNull(message = "Preencha a data de saída!")
	@FutureOrPresent
	@Column(name = "DT_SAIDA")
	private LocalDate saida;

	@NotNull(message = "Preencha um valor mínimo!")
	@DecimalMin(value = "0.01")
	@Column(name = "VLR_ORCAMENTO")
	private Double orcamento;

	@NotNull(message = "Preencha a quantidade de pessoas!")
	@Min(value = 1)
	@Column(name = "QTD_PESSOAS")
	private Integer pessoas;
}
