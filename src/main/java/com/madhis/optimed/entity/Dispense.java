package com.madhis.optimed.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Dispense {
    @Id
    @SequenceGenerator(
            name = "dispense_sequence",
            sequenceName = "dispense_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dispense_sequence"
    )

    private Long dispenseId;
    private String icd10;
    private String tariffCode;
    private String dispenseItem;
    private float price;
}
