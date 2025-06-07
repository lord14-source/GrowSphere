package com.growSphere.growSphere.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FPO_Details")
@Data
public class FPODetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fpoId;

    @ManyToOne
    @JoinColumn(name = "blockId", nullable = false)
    private BlockDetails block;

    @Column(nullable = false, length = 120)
    private String fpoName;

    private String fpoAddress;
    private String cinId;
    private String gstId;
    private String emailId;
    private String enamId;
    private String uniqId1;
    private String uniqId2;
}
