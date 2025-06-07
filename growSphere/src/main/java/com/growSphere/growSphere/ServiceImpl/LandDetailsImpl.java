package com.growSphere.growSphere.ServiceImpl;

import com.growSphere.growSphere.Entity.FarmerDetails;
import com.growSphere.growSphere.Entity.LandDetails;
import com.growSphere.growSphere.Exceptions.ResourceNotFoundException;
import com.growSphere.growSphere.Repository.FarmerDetailsRepo;
import com.growSphere.growSphere.Repository.LandDetailsRepo;
import com.growSphere.growSphere.Service.LandDetailsSvc;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandDetailsImpl implements LandDetailsSvc {
    @Autowired
    private FarmerDetailsRepo farmerDetailsRepo;
    @Autowired
    private LandDetailsRepo landDetailsRepo;

    @Override
    public LandDetails create(LandDetails landDetails) {
        Optional<FarmerDetails>find=farmerDetailsRepo.findById(landDetails.getFarmer().getFarmerId());
        if(find.isPresent()){
        return landDetailsRepo.save(landDetails) ;}
        else{
            throw new ServiceException("FarmerId is not present"+landDetails.getFarmer().getFarmerId());
        }
    }

    @Override
    public List<LandDetails> getAll() {
        return landDetailsRepo.findAll();
    }

    @Override
    public LandDetails get(Integer id) {
        return landDetailsRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("This id is not present"));
    }
}
