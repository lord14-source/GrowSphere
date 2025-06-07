package com.growSphere.growSphere.Repository;

import com.growSphere.growSphere.Entity.BlockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockDetailsRepo extends JpaRepository<BlockDetails,Integer> {
}
