package com.growSphere.growSphere.Entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "Farmer_Crop_Inp_Details")
@Data
public class FarmerCropInputDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cropInpId;

    @ManyToOne
    @JoinColumn(name = "landId", nullable = false)
    private LandDetails land;

    private Long cropArea;
    private Date cropSownDt;
    private Integer cropSeedlingQty;
}
