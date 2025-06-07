package com.growSphere.growSphere.Repository;

import com.growSphere.growSphere.Entity.StateDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface stateDetailsRepo extends JpaRepository<StateDetails,Integer> {
}
