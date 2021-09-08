
package com.madhis.optimed.entity;

import ch.qos.logback.core.joran.spi.NoAutoStart;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
    @SequenceGenerator(
            name = "script_sequence",
            sequenceName = "script_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "script_sequence"
    )
    private Long scriptId;
    private String rightEye;
    private String leftEye;
    private	String addition;
    private String pd;
    
    @OneToOne(
    		cascade = CascadeType.ALL 
    )
    @JoinColumn(name = "consult_id",referencedColumnName = "consultId")
    private Consult consult;// 1 consult has 1 script  
    
}
