package com.growSphere.growSphere.Repository;

import com.growSphere.growSphere.Entity.FarmerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerDetailsRepo extends JpaRepository<FarmerDetails,Integer> {
}
