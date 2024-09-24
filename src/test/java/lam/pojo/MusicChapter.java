package lam.pojo;

import java.util.ArrayList;
import java.util.List;

public abstract class MusicChapter {
    final List<Artist> artists;
    final List<Album> albums;

    public MusicChapter(){
        artists=new ArrayList<>();
        albums=new ArrayList<>();
        loadData("");
    }

    private void loadData(String file){

    }
}
