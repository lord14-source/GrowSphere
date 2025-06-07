package com.growSphere.growSphere.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Land_Details")
@Data
public class LandDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer landId;

    @ManyToOne
    @JoinColumn(name = "farmerId", nullable = false)
    private FarmerDetails farmer;

    private String landIdLong;
    private String landIdLat;
    private Long landArea;
}
