package com.johfloresm.lookify.controllers;

import com.johfloresm.lookify.models.Song;
import com.johfloresm.lookify.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class SongsController{
    @Autowired
    private SongService songService;

    @RequestMapping("")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("/dashboard")
    public String dashboard(Model model){
        List<Song> songs = songService.getSongs();
        model.addAttribute("songs", songs);

        return "dashboard.jsp";
    }

    @RequestMapping("/search/{artist}")
    public String filterArtist(@PathVariable("artist") String artist,Model model){
        List<Song> songs = songService.getSongsByArtist(artist);
        model.addAttribute("songs", songs);
        model.addAttribute("artist",artist);

        return "filterArtist.jsp";
    }


    @RequestMapping("/topTen")
    public String songsTop(Model model){
        List<Song> songs = songService.getTop10Songs();
        model.addAttribute("songs",songs);
        return "topTen.jsp";
    }

    @RequestMapping("songs/{id}")
    public String show(@PathVariable Long id, Model model){
        Song song = songService.getSongById(id);
        model.addAttribute("song", song);

        return "show.jsp";
    }

    @RequestMapping("songs/new")
    public String newSong (@ModelAttribute("song") Song song){
        return "new.jsp";
    }

    @RequestMapping(value = "songs", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("song") Song song, BindingResult result){
        if (result.hasErrors()) {
            return "new.jsp";
        }
        songService.createSong(song);

        return "redirect:/dashboard";
    }

    @RequestMapping(value="songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSongById(id);
        return "redirect:/dashboard";
    }

}
