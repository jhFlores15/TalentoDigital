package com.johfloresm.dojosninjas.repositories;

import com.johfloresm.dojosninjas.models.Dojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DojoRepository extends PagingAndSortingRepository<Dojo, Long>{

    List<Dojo> findAll();

    Dojo findFirstById(Long id);

    @Query("SELECT d, n FROM Dojo d JOIN d.ninjas n")
    Page<Object[]> joinDojosAndNinjas(PageRequest pageRequest);
}
