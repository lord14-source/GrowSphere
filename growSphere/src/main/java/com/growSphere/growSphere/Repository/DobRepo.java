package com.growSphere.growSphere.Repository;

import com.growSphere.growSphere.Entity.BoDDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DobRepo extends JpaRepository<BoDDetails,Integer> {
}
