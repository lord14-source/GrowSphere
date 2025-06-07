package com.growSphere.growSphere.ServiceImpl;

import com.growSphere.growSphere.Entity.BlockDetails;
import com.growSphere.growSphere.Entity.DistrictDetails;
import com.growSphere.growSphere.Entity.FPODetails;
import com.growSphere.growSphere.Entity.StateDetails;
import com.growSphere.growSphere.Exceptions.ResourceNotFoundException;
import com.growSphere.growSphere.Repository.BlockDetailsRepo;
import com.growSphere.growSphere.Repository.DistrictDetailsRepo;
import com.growSphere.growSphere.Repository.FPODetailsRepo;
import com.growSphere.growSphere.Repository.stateDetailsRepo;
import com.growSphere.growSphere.Service.FpoDetailsSvc;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FpoDetailsImpl implements FpoDetailsSvc {
    @Autowired
    private BlockDetailsRepo blockDetailsRepo;
    @Autowired
    private FPODetailsRepo fpoDetailsRepo;
    @Autowired
    private DistrictDetailsRepo districtDetailsRepo;
    @Autowired
    private stateDetailsRepo stateDetailsRepo;
    @Override
    public FPODetails create(FPODetails fpoDetails) {

        Optional<BlockDetails>find=blockDetailsRepo.findById(fpoDetails.getBlock().getBlockId());

        System.out.println(find);
        if(find.isPresent()){
            System.out.println("wdedewf");

            Optional<DistrictDetails>find1=districtDetailsRepo.findById(find.get().getDistrict().getDistrictId());
            System.out.println(find1);
            if(find1.isPresent()){
                System.out.println(find1);
                Optional<StateDetails>find2=stateDetailsRepo.findById(find1.get().getState().getStateId());
                if(find2.isPresent()){
            return fpoDetailsRepo.save(fpoDetails);}
            else{
                    throw new ServiceException("This Block Id is not present"+fpoDetails.getBlock().getBlockId());

                }}

            else{
                throw new ServiceException("This Block Id is not present"+fpoDetails.getBlock().getBlockId());

            }}

        else{
            throw new ServiceException("This Block Id is not present"+fpoDetails.getBlock().getBlockId());
        }

    }

    @Override
    public List<FPODetails> getAll() {
        return fpoDetailsRepo.findAll();
    }

    @Override
    public FPODetails get(Integer id) {
        return fpoDetailsRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("this fpo id is not present"));
    }
}
