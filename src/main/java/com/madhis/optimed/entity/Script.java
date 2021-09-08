
package com.madhis.optimed.entity;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoAutoStart
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
    
    private long scriptId;
    private long consultId;
    private String rightEye;
    private String leftEye;
    private String addition;
    private String pd;
}   
    
