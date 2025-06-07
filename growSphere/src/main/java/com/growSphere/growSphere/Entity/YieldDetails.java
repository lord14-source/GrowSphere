//package com.growSphere.growSphere.Entity;
//import jakarta.persistence.*;
//import lombok.Data;
//import java.util.Date;
//
//@Entity
//@Table(name = "Yield_Details")
//@Data
//public class YieldDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer yieldId;
//
//    @ManyToOne
//    @JoinColumn(name = "cropId", nullable = false)
//   // private CropStaticDetails crop;
//
//    private Long yieldQty;
//    private Integer yieldContScore;
//    private Date yieldHarvestDt;
//}
//
