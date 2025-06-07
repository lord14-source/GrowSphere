package com.growSphere.growSphere.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "State_Details")
@Data
public class StateDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stateId;

    @Column(nullable = false, length = 20)
    private String stateName;
}
