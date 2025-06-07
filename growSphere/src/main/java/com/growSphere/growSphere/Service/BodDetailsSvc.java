package com.growSphere.growSphere.Service;

import com.growSphere.growSphere.Entity.BoDDetails;

import java.util.List;

public interface BodDetailsSvc {
    public BoDDetails create(BoDDetails boDDetails);
    public List<BoDDetails>getAll();
    public BoDDetails get(Integer id);
}
