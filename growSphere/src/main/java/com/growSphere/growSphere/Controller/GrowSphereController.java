package com.growSphere.growSphere.Controller;


import com.growSphere.growSphere.Entity.*;
import com.growSphere.growSphere.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GrowSphere")
public class GrowSphereController {

   @Autowired
private stateDetailsService stateDetailsService;
   @Autowired
   private FarmerDetailsSvc farmerDetailsSvc;
   @Autowired
   private LandDetailsSvc landDetailsSvc;
   @Autowired
   private DistrictDetailsSvc districtDetailsSvc;
   @Autowired
   private BlockDetailsSvc blockDetailsSvc;
   @Autowired
   private FpoDetailsSvc fp;
   @Autowired
   private BodDetailsSvc bodDetailsSvc;

 @PostMapping
    public ResponseEntity<StateDetails>create(@RequestBody StateDetails stateDetails){
        return ResponseEntity.status(HttpStatus.CREATED).body(stateDetailsService.create(stateDetails));
    }
    @PostMapping("/GetStateDetails")
    public ResponseEntity<List<StateDetails>>getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(stateDetailsService.getAll());
    }
    @GetMapping("/GetStateDetailsId")
    public ResponseEntity<StateDetails>get( @RequestParam("id")String id){
     System.out.println(id);
     Integer Id=Integer.parseInt(id);
     return ResponseEntity.status(HttpStatus.OK).body(stateDetailsService.get(Id));
    }

  @PostMapping("/FarmerDetails")
  public ResponseEntity<FarmerDetails>create(@RequestBody FarmerDetails farmerDetails){
     return ResponseEntity.status(HttpStatus.CREATED).body(farmerDetailsSvc.create(farmerDetails));
  }
  @PostMapping("/LandDetails")
    public ResponseEntity<LandDetails>craete(@RequestBody LandDetails landDetails){
     return ResponseEntity.status(HttpStatus.CREATED).body(landDetailsSvc.create(landDetails));
  }
  @PostMapping("/DistrictDetails")
    public ResponseEntity<DistrictDetails>create(@RequestBody DistrictDetails districtDetails){
     return ResponseEntity.status(HttpStatus.CREATED).body(districtDetailsSvc.create(districtDetails));
  }
  @PostMapping("/BlockDetails")
    public ResponseEntity<BlockDetails> create(@RequestBody BlockDetails blockDetails){
     return ResponseEntity.status(HttpStatus.CREATED).body(blockDetailsSvc.crate(blockDetails));
  }
  @PostMapping("/FpoDetails")
    public ResponseEntity<FPODetails> create(@RequestBody FPODetails fpoDetails){
     return ResponseEntity.status(HttpStatus.CREATED).body(fp.create(fpoDetails));
  }
  @PostMapping("/BodDetails")
    public ResponseEntity<BoDDetails> create(@RequestBody BoDDetails boDDetails){
     return ResponseEntity.status(HttpStatus.CREATED).body(bodDetailsSvc.create(boDDetails));
  }
}
