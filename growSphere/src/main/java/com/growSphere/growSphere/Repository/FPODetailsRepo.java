package com.growSphere.growSphere.Repository;

import com.growSphere.growSphere.Entity.FPODetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FPODetailsRepo extends JpaRepository<FPODetails,Integer> {
}
