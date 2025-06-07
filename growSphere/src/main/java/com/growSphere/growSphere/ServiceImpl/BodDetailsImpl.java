package com.growSphere.growSphere.ServiceImpl;

import com.growSphere.growSphere.Entity.*;
import com.growSphere.growSphere.Exceptions.ResourceNotFoundException;
import com.growSphere.growSphere.Repository.*;
import com.growSphere.growSphere.Service.BodDetailsSvc;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodDetailsImpl implements BodDetailsSvc {
    @Autowired
    private DobRepo dobRepo;
    @Autowired
    private BlockDetailsRepo blockDetailsRepo;
    @Autowired
    private FPODetailsRepo fpoDetailsRepo;
    @Autowired
    private DistrictDetailsRepo districtDetailsRepo;
    @Autowired
    private stateDetailsRepo stateDetailsRepo;
    @Override
    public BoDDetails create(BoDDetails boDDetails) {
        Optional<FPODetails> find = fpoDetailsRepo.findById(boDDetails.getFpo().getFpoId());
        if (find.isPresent()) {
            Optional<BlockDetails> find1 = blockDetailsRepo.findById(find.get().getBlock().getBlockId());
            if (find1.isPresent()) {
                Optional<DistrictDetails> find2 = districtDetailsRepo.findById(find1.get().getDistrict().getDistrictId());
                if (find2.isPresent()) {
                    Optional<StateDetails> find3 = stateDetailsRepo.findById(find2.get().getState().getStateId());
                    return dobRepo.save(boDDetails);
                } else {
                    throw new ServiceException("this is not present" + find2.get().getState().getStateId());
                }
            } else {
                throw new ServiceException("this is not present" + find1.get().getDistrict().getDistrictId());

            }

        } else {
            throw new ServiceException("this is not present" + find.get().getBlock().getBlockId());

        }










    }

    @Override
    public List<BoDDetails> getAll() {
        return dobRepo.findAll();
    }

    @Override
    public BoDDetails get(Integer id) {
        return dobRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("This BOD is not present"));
    }
}
