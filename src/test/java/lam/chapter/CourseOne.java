package lam.chapter;

import lam.pojo.Album;
import lam.pojo.Artist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseOne {
    public static void main(String[]args){
    }

    public static class Imperative{
        public Set<String> originsOfBands(Album album){
            Set<String> nationalities=new HashSet<>();
            for(Artist artist:album.getMusiciansList()){
                if(artist.getName().startsWith("The")){
                    String nationality=artist.getNationality();
                    nationalities.add(nationality);
                }
            }
            return nationalities;
        }
    }

    /**
     * 乐队来源
     * @param album
     * @return
     */
    public Set<String> originsOfBands(Album album){
        Set<String> origins=album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality())
                .collect(Collectors.toSet());
        return origins;
    }

    /**
     * 乐队误用的起源
     * @param album
     * @return
     */
    public Set<String> originsOfBandsMisuse(Album album){
        List<Artist> musicians=album.getMusicians()
                .collect(Collectors.toList());
        List<Artist> bands=musicians.stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .collect(Collectors.toList());
        Set<String> origins=bands.stream()
                .map(artist -> artist.getNationality())
                .collect(Collectors.toSet());
        return origins;
    }
}
