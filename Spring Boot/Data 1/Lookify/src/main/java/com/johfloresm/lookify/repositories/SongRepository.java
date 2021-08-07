package com.johfloresm.lookify.repositories;

import com.johfloresm.lookify.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.OrderBy;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SongRepository extends CrudRepository <Song, Long>{

    @OrderBy("rating desc")
    List<Song> findAll();

    List<Song> findAllByArtistContains(String name);

    @Transactional
    Long deleteSongById(Long id);

    List<Song> findTop10ByOrderByRatingDesc();

    //@OrderBy("rating desc")

}
