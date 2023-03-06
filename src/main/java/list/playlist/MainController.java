package list.playlist;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import list.playlist.domain.PlayList;
import list.playlist.domain.Song;
import list.playlist.service.PlaylistService;
import list.playlist.service.SongService;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/pl")
public class MainController {

	private final PlaylistService playlistService;
	private final SongService songService;

    @GetMapping("/main")
    public String list(Model model, @RequestParam(value="page" , defaultValue="0") int page,
    		 @RequestParam(value = "kw", defaultValue = "") String kw) {
        //List<PlayList> playList = this.playlistService.getlist(); //레퍼지토리를 바로 불러와서 쓰지않고 서비스를 통해서 사용하도록 작성
        //model.addAttribute("playList2", playList);
    	
    	System.out.println("***************************");
    	System.out.println(page);
    	System.out.println(kw);
    	System.out.println("***************************");
    	
    	if("".compareTo(kw) == 0) {
    		Page<PlayList> paging = this.playlistService.getlist(page);
    		model.addAttribute("paging",paging);
        	model.addAttribute("kw", kw);
            return "Pl_main";
    	}else {
    		Page<PlayList> paging = this.playlistService.getlistkeyword(page,kw);
    		model.addAttribute("paging",paging);
        	model.addAttribute("kw", kw);
            return "Pl_main";
    	}
    
    }

    
    @GetMapping("/main/detail/{id}")
    public String pldetail(Model model, @PathVariable("id") Long id) {
    	PlayList playlist = this.playlistService.getPlayList(id);
    	model.addAttribute("playList22",playlist);
    	
    	Song song = this.songService.getSong(id);
    	model.addAttribute("song22",song);
    	return "Pl_detail";
    }
}
