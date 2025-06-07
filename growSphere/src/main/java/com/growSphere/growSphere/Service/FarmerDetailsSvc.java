package com.growSphere.growSphere.Service;

import com.growSphere.growSphere.Entity.FarmerDetails;

import java.util.List;

public interface FarmerDetailsSvc {
    public FarmerDetails create(FarmerDetails farmerDetails);
    public List<FarmerDetails>getAll();
    public FarmerDetails get(Integer id);
}
