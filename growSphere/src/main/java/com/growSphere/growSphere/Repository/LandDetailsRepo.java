package com.growSphere.growSphere.Repository;

import com.growSphere.growSphere.Entity.LandDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandDetailsRepo extends JpaRepository<LandDetails,Integer> {
}
