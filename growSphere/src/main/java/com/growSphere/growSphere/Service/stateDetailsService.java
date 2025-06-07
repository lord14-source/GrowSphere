package com.growSphere.growSphere.Service;

import com.growSphere.growSphere.Entity.StateDetails;

import java.util.List;
import java.util.Optional;

public interface stateDetailsService {

    public StateDetails create(StateDetails stateDetails);
    public List<StateDetails> getAll();
    public StateDetails get(Integer id);


}
