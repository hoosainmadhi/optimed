package com.madhis.optimed.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "Patient"
//        uniqueConstraints = @UniqueConstraint(
//                name="patient_number_unique",
//                columnNames="patientNumber"
//        )
)
public class Patient {
    
    @Id
    @SequenceGenerator( 
            name="patient_sequence",
            sequenceName="patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    private Long patientId;
    
    @Column(name = "patientNumber",
            nullable = false,
            unique = true
    )
    private String patientNumber;

    @NotEmpty(message = "Patient Name cannot be empty.")
    private String patientName;
    
    private String medicalAid;
    private String medicalAidNumber;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message="That's not possible")
    private Date dob;
    
    private String postalAddress;
    private String telNo;
    private String principalMember;
    
    @Email
    private String email;
    
    // Define 1-Many Relation Patient can come for many consults.
    @OneToMany(
	    cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
	    orphanRemoval = true
    )
    @JoinColumn(
            name = "patient_id",
            referencedColumnName = "patientId"
    )
    private List<Consult> consults;// Patient can  have many List of Consults
    
}
