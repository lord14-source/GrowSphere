package com.growSphere.growSphere.Service;

import com.growSphere.growSphere.Entity.LandDetails;

import java.util.List;

public interface LandDetailsSvc {
    public LandDetails create(LandDetails landDetails);
    public List<LandDetails>getAll();
    public LandDetails get(Integer id);
}
