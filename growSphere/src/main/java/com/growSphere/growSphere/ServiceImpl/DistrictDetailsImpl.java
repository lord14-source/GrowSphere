package com.growSphere.growSphere.ServiceImpl;

import com.growSphere.growSphere.Entity.DistrictDetails;
import com.growSphere.growSphere.Entity.StateDetails;
import com.growSphere.growSphere.Exceptions.ResourceNotFoundException;
import com.growSphere.growSphere.Repository.DistrictDetailsRepo;
import com.growSphere.growSphere.Repository.stateDetailsRepo;
import com.growSphere.growSphere.Service.DistrictDetailsSvc;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DistrictDetailsImpl implements DistrictDetailsSvc {
    @Autowired
    private DistrictDetailsRepo districtDetailsRepo;
    @Autowired
    private stateDetailsRepo stateDetailsRepo;
    @Override
    public DistrictDetails create(DistrictDetails districtDetails) {
        Optional<StateDetails>findState=stateDetailsRepo.findById(districtDetails.getState().getStateId());
        if(findState.isPresent()){

            districtDetails.getState().setStateName(findState.get().getStateName());
        return districtDetailsRepo.save(districtDetails);}
        else{
            throw new ServiceException("Given StateId is not present"+districtDetails.getState().getStateId());
        }
    }

    @Override
    public List<DistrictDetails> getAll() {
        return districtDetailsRepo.findAll();
    }

    @Override
    public DistrictDetails get(Integer id) {
        return districtDetailsRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("The Given id is not present"));
    }
}
