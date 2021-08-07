package com.johfloresm.lookify.services;

import com.johfloresm.lookify.models.Song;
import com.johfloresm.lookify.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService{

    @Autowired
    private SongRepository songRepository;

    public List<Song> getSongs(){
        return songRepository.findAll();
    }

    public Song createSong(Song b) {
        return songRepository.save(b);
    }

    public List<Song> getTop10Songs(){ return songRepository.findTop10ByOrderByRatingDesc();  }

    public Song getSongById(Long id){
        return songRepository.findById(id).orElse(null);
    }

    public List<Song> getSongsByArtist(String name){
        return songRepository.findAllByArtistContains(name);
    }

    public void deleteSongById(Long id){
        songRepository.deleteSongById(id);
    }

    public void updateSong(Song song){
        Song s = this.getSongById(song.getId());
        s.setArtist(song.getArtist());
        s.setTitle(song.getTitle());
        s.setRating(song.getRating());

        songRepository.save(s);
    }


}
