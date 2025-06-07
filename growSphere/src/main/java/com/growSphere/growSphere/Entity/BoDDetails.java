package com.growSphere.growSphere.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BoD_Details")
@Data
public class BoDDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bodId;

    @ManyToOne
    @JoinColumn(name = "fpoId", nullable = false)
    private FPODetails fpo;

    private String bodName;
    private String bodDIN;
}
