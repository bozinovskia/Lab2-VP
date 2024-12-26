package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class DataHolder {
    public final SongRepository songRepository;
    public final ArtistRepository artistRepository;
    public final AlbumRepository albumRepository;
    public static final AtomicLong songIdGenerator = new AtomicLong(1);

    public DataHolder(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @PostConstruct
    public void init() {
        // Add Artists
        artistRepository.save(new Artist(1L, "Avicii", "", "DJ"));
        artistRepository.save(new Artist(2L, "Kygo", "", "DJ"));
        artistRepository.save(new Artist(3L, "Zedd", "", "DJ"));
        artistRepository.save(new Artist(4L, "David", "Guetta", "DJ"));
        artistRepository.save(new Artist(5L, "Marshmellow", "", "DJ"));
        artistRepository.save(new Artist(6L, "Loopy", "", "DJ"));

        // Add Albums
        albumRepository.save(new Album(1L, "Levels", "EDM", "2013", new ArrayList<>()));
        albumRepository.save(new Album(2L, "A Loop", "EDM", "2017", new ArrayList<>()));
        albumRepository.save(new Album(3L, "Titanium", "EDM", "2015", new ArrayList<>()));
        albumRepository.save(new Album(4L, "Bridges", "EDM", "2014", new ArrayList<>()));
        albumRepository.save(new Album(5L, "Sun up", "EDM", "2019", new ArrayList<>()));

        // Add Songs
        Album nevermind = albumRepository.findById(1L).orElse(null);
        Album nightAtTheOpera = albumRepository.findById(2L).orElse(null);
        Album darkSide = albumRepository.findById(3L).orElse(null);
        Album ten = albumRepository.findById(4L).orElse(null);
        Album blackHoles = albumRepository.findById(5L).orElse(null);

        songRepository.save(new Song(songIdGenerator.getAndIncrement(), "1", "Levels", "EDM", 2016, nevermind, new ArrayList<>(), new ArrayList<>()));
        songRepository.save(new Song(songIdGenerator.getAndIncrement(), "2", "No love", "EDM", 2015, nightAtTheOpera, new ArrayList<>(), new ArrayList<>()));
        songRepository.save(new Song(songIdGenerator.getAndIncrement(), "3", "Timeless", "EDM", 2012, darkSide, new ArrayList<>(), new ArrayList<>()));
        songRepository.save(new Song(songIdGenerator.getAndIncrement(), "4", "Keep me alive", "EDM", 2014, ten, new ArrayList<>(), new ArrayList<>()));
        songRepository.save(new Song(songIdGenerator.getAndIncrement(), "5", "Storm", "EDM", 2019, blackHoles, new ArrayList<>(), new ArrayList<>()));
    }
}
