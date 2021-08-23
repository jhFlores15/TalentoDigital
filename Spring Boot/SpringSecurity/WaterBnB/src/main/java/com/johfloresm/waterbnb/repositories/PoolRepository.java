package com.johfloresm.waterbnb.repositories;

import com.johfloresm.waterbnb.models.Pool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoolRepository extends CrudRepository<Pool,Long>{

    List<Pool> findAllByAddressContains(String location);

    List<Pool> findAllByHostId(Long hostId);

    List<Pool> findAll();
}
