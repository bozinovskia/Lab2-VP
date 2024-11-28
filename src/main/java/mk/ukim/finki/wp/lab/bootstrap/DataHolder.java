package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class DataHolder {
    public static List<Song> songs = null;
    public static List<Artist> artists = null;
    public static List<Album> albums = null;
    public static final AtomicLong songIdGenerator = new AtomicLong(1);

    @PostConstruct
    public void init() {

        artists = new ArrayList<>(5);
        artists.add(new Artist(1L, "Avicii", "", "Popular DJ"));
        artists.add(new Artist(2L, "David", "Guetta", "Popular DJ"));
        artists.add(new Artist(3L, "Zedd", "", "Popular DJ"));
        artists.add(new Artist(4L, "Ellie", "Goulding", "Popular Singer"));
        artists.add(new Artist(5L, "Fisher", "", "Popular DJ"));
        artists.add(new Artist(5L, "Dom", "Dolla", "Popular DJ"));

        albums = new ArrayList<>(5);
        albums.add(new Album(1L, "Album 1", "Electronic", "2011", new ArrayList<>()));
        albums.add(new Album(2L, "Album 2", "Electronic", "2012", new ArrayList<>()));
        albums.add(new Album(3L, "Album 3", "Eletronic", "2017", new ArrayList<>()));
        albums.add(new Album(4L, "Album 4", "Pop", "2010", new ArrayList<>()));
        albums.add(new Album(5L, "Album 5", "Electronic", "2022", new ArrayList<>()));

        songs = new ArrayList<>(5);
        songs.add(new Song(songIdGenerator.getAndIncrement(), "1", "Levels", "Electronic", 2012, albums.get(0), new ArrayList<Artist>(), new ArrayList<>()));
        songs.add(new Song(songIdGenerator.getAndIncrement(), "2", "Beautiful now", "Electronic", 2018, albums.get(1), new ArrayList<>(), new ArrayList<>()));
        songs.add(new Song(songIdGenerator.getAndIncrement(), "3", "Lights", "Pop", 2011,albums.get(2), new ArrayList<>(), new ArrayList<>()));
        songs.add(new Song(songIdGenerator.getAndIncrement(), "4", "World hold on", "Electronic", 2015, albums.get(3),new ArrayList<>(), new ArrayList<>()));
        songs.add(new Song(songIdGenerator.getAndIncrement(), "5", "San Frandisco", "Electronic", 2019,albums.get(4), new ArrayList<>(), new ArrayList<>()));

    }
}
