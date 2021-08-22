package com.johfloresm.eventos.repositories;

import com.johfloresm.eventos.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location,Long>{

    List<Location> getLocationByStateId(Long id);
}
