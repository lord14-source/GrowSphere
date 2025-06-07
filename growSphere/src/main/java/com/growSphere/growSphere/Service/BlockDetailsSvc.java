package com.growSphere.growSphere.Service;

import com.growSphere.growSphere.Entity.BlockDetails;
import org.springframework.cglib.core.Block;

import java.util.List;

public interface BlockDetailsSvc {

    public BlockDetails crate(BlockDetails blockDetails);
    public List<BlockDetails> getAll();
    public BlockDetails get(Integer id);

}
