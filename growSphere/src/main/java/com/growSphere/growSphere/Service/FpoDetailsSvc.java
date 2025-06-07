package com.growSphere.growSphere.Service;

import com.growSphere.growSphere.Entity.FPODetails;

import java.util.List;

public interface FpoDetailsSvc {

    public FPODetails create(FPODetails fpoDetails);
    public List<FPODetails> getAll();
    public FPODetails get(Integer id);

}
