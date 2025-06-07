package com.growSphere.growSphere.ServiceImpl;

import com.growSphere.growSphere.Entity.FarmerDetails;
import com.growSphere.growSphere.Exceptions.ResourceNotFoundException;
import com.growSphere.growSphere.Repository.FarmerDetailsRepo;
import com.growSphere.growSphere.Service.FarmerDetailsSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerDetailsImpl implements FarmerDetailsSvc {
    @Autowired
    private FarmerDetailsRepo farmerDetailsRepo;
    @Override
    public FarmerDetails create(FarmerDetails farmerDetails) {
        return farmerDetailsRepo.save(farmerDetails);

    }

    @Override
    public List<FarmerDetails> getAll() {
        return farmerDetailsRepo.findAll();
    }

    @Override
    public FarmerDetails get(Integer id) {
        return farmerDetailsRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("The given id is not present"));
    }
}
