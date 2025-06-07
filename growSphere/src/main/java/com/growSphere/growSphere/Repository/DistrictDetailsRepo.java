package com.growSphere.growSphere.Repository;

import com.growSphere.growSphere.Entity.DistrictDetails;
import com.growSphere.growSphere.Entity.FarmerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictDetailsRepo extends JpaRepository<DistrictDetails,Integer> {
}
