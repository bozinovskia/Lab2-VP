package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByTrackId(String trackId);

    List<Song> findAllByAlbum_Id(Long albumId);

    @Query("SELECT DISTINCT s.genre FROM Song s")
    List<String> getGenres();

    List<Song> findAllByGenre(String genre);
}