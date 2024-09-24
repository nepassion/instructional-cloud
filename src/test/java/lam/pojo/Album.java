package lam.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;

/**
 * 专辑
 */
public class Album implements Performance{
    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;

    /**
     * 专辑构造方法
     * @param name
     * @param tracks
     * @param musicians
     */
    public Album(String name,List<Track> tracks,List<Artist> musicians){
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);
        this.name=name;
        this.tracks=new ArrayList<>(tracks);
        this.musicians=new ArrayList<>(musicians);
    }


    @Override
    public String getName() {
        return name;
    }

    public Stream<Track> getTracks(){
        return tracks.stream();
    }

    public List<Track> getTrackList(){
        return unmodifiableList(tracks);
    }

    @Override
    public Stream<Artist> getMusicians() {
        return musicians.stream();
    }

    public List<Artist> getMusiciansList(){
        return unmodifiableList(musicians);
    }

    /**
     * @return
     */
    public Album copy(){
        List<Track> tracks=getTracks().map(Track::copyNew).collect(Collectors.toList());
        List<Artist> musicians=getMusicians().map(Artist::copy).collect(Collectors.toList());
        return new Album(name,tracks,musicians);
    }


    public Artist getMainMusician(){
        return musicians.get(0);
    }
}
