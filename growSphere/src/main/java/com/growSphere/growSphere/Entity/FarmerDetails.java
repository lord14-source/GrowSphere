package com.growSphere.growSphere.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Farmer_Details")
@Data
public class FarmerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer farmerId;

    @Column(nullable = false, length = 120)
    private String farmerName;

    @Column(nullable = false, unique = true, length = 10)
    private Long farmerMobileNo;

    @Column(unique = true, length = 10)
    private String farmerPanNo;

    private String farmerAddressPlotNo;
    private String farmerAddressVillageName;
    private String farmerAddressBlockName;
    private String farmerAddressDistrictName;
    private String farmerAddressStateName;

    @Column(length = 6)
    private Integer farmerAddressPinCode;

    @Column(length = 1)
    private String farmerIsShareholder;

    @Column(length = 1)
    private String farmerIsBoD;

    @Column(length = 1)
    private String farmerIsCEO;
}

