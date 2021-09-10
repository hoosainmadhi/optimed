package com.madhis.optimed.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(
        name = "Consult"
      )

public class Consult {
    @Id
    @SequenceGenerator(
            name = "consult_sequence",
            sequenceName = "consult_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "consult_sequence"
    )
    private Long consultId;
    private String consultDate;
    private String reservationNumber;
 
   //Define 1-Many  Relation consult has many dispense items 
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "consult_id",
            referencedColumnName = "consultId"
    )
    private List<Dispense> dispenses;// 1 consult has List of dispensed Items
   
    
    //https://techrocking.com/one-to-one-mapping-in-jpa/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "script_id")// this is a foreign key
	private Script script;
}