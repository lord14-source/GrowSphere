package com.growSphere.growSphere.ServiceImpl;

import com.growSphere.growSphere.Entity.StateDetails;
import com.growSphere.growSphere.Exceptions.ResourceNotFoundException;

import com.growSphere.growSphere.Repository.stateDetailsRepo;
import com.growSphere.growSphere.Service.stateDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class stateDetailsServiceImpl implements stateDetailsService {

    @Autowired
    private stateDetailsRepo  stateDetailsRepo;

    @Override
    public StateDetails create(StateDetails stateDetails) {




        return stateDetailsRepo.save(stateDetails);
    }

    @Override
    public List<StateDetails> getAll() {
        return stateDetailsRepo.findAll();
    }

    @Override
    public StateDetails get(Integer id) {
        return stateDetailsRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("This id is not present"));
    }



}
