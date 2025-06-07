package com.growSphere.growSphere.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Block_Details")
@Data
public class BlockDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blockId;

    @ManyToOne
    @JoinColumn(name = "districtId", nullable = false)
    private DistrictDetails district;

    @Column(nullable = false, length = 200)
    private String blockName;
}

