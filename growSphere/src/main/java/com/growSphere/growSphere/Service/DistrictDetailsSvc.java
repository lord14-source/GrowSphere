package com.growSphere.growSphere.Service;

import com.growSphere.growSphere.Entity.DistrictDetails;

import java.util.List;

public interface DistrictDetailsSvc {

    public DistrictDetails create(DistrictDetails districtDetails);
    public List<DistrictDetails> getAll();
    public DistrictDetails get(Integer id);
}
