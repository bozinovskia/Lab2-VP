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
        artistRepository.save(new Artist(1L, "Avicii", "", "Legendary EDM producer"));
        artistRepository.save(new Artist(2L, "Calvin", "Harris", "Global EDM superstar"));
        artistRepository.save(new Artist(3L, "Zedd", "", "Grammy-winning EDM artist"));
        artistRepository.save(new Artist(4L, "Martin", "Garrix", "Young EDM prodigy"));
        artistRepository.save(new Artist(5L, "Deadmau5", "", "Innovative electronic artist"));
        artistRepository.save(new Artist(6L, "The Chainsmokers", "", "Chart-topping EDM duo"));

        // Add Albums
        albumRepository.save(new Album(1L, "True", "EDM", "2013", new ArrayList<>()));
        albumRepository.save(new Album(2L, "18 Months", "EDM", "2012", new ArrayList<>()));
        albumRepository.save(new Album(3L, "Clarity", "EDM", "2012", new ArrayList<>()));
        albumRepository.save(new Album(4L, "Animals", "EDM", "2013", new ArrayList<>()));
        albumRepository.save(new Album(5L, "Random Album Title", "EDM", "2008", new ArrayList<>()));

        // Add Songs
        Album trueAlbum = albumRepository.findById(1L).orElse(null);
        Album eighteenMonths = albumRepository.findById(2L).orElse(null);
        Album clarity = albumRepository.findById(3L).orElse(null);
        Album animals = albumRepository.findById(4L).orElse(null);
        Album randomAlbumTitle = albumRepository.findById(5L).orElse(null);

        songRepository.save(new Song(songIdGenerator.getAndIncrement(), "1", "Wake Me Up", "EDM", 2013, trueAlbum, new ArrayList<>(), new ArrayList<>()));
        songRepository.save(new Song(songIdGenerator.getAndIncrement(), "2", "Feel So Close", "EDM", 2012, eighteenMonths, new ArrayList<>(), new ArrayList<>()));
        songRepository.save(new Song(songIdGenerator.getAndIncrement(), "3", "Clarity", "EDM", 2012, clarity, new ArrayList<>(), new ArrayList<>()));
        songRepository.save(new Song(songIdGenerator.getAndIncrement(), "4", "Animals", "EDM", 2013, animals, new ArrayList<>(), new ArrayList<>()));
        songRepository.save(new Song(songIdGenerator.getAndIncrement(), "5", "Strobe", "EDM", 2008, randomAlbumTitle, new ArrayList<>(), new ArrayList<>()));
    }
}
