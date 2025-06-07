package com.growSphere.growSphere.ServiceImpl;

import com.growSphere.growSphere.Entity.BlockDetails;
import com.growSphere.growSphere.Entity.DistrictDetails;
import com.growSphere.growSphere.Entity.StateDetails;
import com.growSphere.growSphere.Exceptions.ResourceNotFoundException;
import com.growSphere.growSphere.Repository.BlockDetailsRepo;
import com.growSphere.growSphere.Repository.DistrictDetailsRepo;
import com.growSphere.growSphere.Repository.stateDetailsRepo;
import com.growSphere.growSphere.Service.BlockDetailsSvc;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlockDetailsImpl implements BlockDetailsSvc {
    @Autowired
    private DistrictDetailsRepo districtDetailsRepo;
    @Autowired
    private BlockDetailsRepo blockDetailsRepo;
    @Autowired
    private stateDetailsRepo stateDetailsRepo;
    @Override
    public BlockDetails crate(BlockDetails blockDetails) {
        Optional<DistrictDetails>find=districtDetailsRepo.findById(blockDetails.getDistrict().getDistrictId());
        if(find.isPresent()){
            System.out.println("hello"+blockDetails.getDistrict());
            Optional<StateDetails>find1=stateDetailsRepo.findById(blockDetails.getDistrict().getState().getStateId());
System.out.println(find1.get().getStateName());
            blockDetails.getDistrict().setDistrictId(find.get().getDistrictId());
            blockDetails.getDistrict().setDistrictName(find.get().getDistrictName());
            if(find1.isPresent()) {
                blockDetails.getDistrict().getState().setStateName(find1.get().getStateName());
            }
            else{
                blockDetails.getDistrict().getState().setStateName(null);

            }
            return blockDetailsRepo.save(blockDetails);
        }
        else{
            throw new ServiceException("This district is not present"+find.get().getDistrictId());
        }


    }

    @Override
    public List<BlockDetails> getAll() {
        return blockDetailsRepo.findAll();
    }

    @Override
    public BlockDetails get(Integer id) {
        return blockDetailsRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("this id is not present"));
     }
}
