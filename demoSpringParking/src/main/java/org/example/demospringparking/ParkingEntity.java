package org.example.demospringparking;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "parking_entity")
public class ParkingEntity {

    @Id
    private String parkingId;

    private String parkingName;
    
}