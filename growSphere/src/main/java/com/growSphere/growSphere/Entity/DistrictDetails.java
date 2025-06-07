package com.growSphere.growSphere.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "District_Details")
@Data
public class DistrictDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer districtId;

    @ManyToOne
    @JoinColumn(name = "stateId", nullable = false)
    private StateDetails state;

    @Column(nullable = false, length = 20)
    private String districtName;
}

