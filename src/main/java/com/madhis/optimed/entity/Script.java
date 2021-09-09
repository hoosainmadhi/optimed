
package com.madhis.optimed.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Script {
	@Id
	private Long scriptId;
	private String rightEye;
	private String leftEye;
	private String addition;
	private String pd;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "consult_id")
	private Consult consult;

}   

