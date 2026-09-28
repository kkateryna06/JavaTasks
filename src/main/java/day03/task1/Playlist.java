package day03.task1;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final List<String> tracks;

    Playlist() {
        this.tracks = new ArrayList<>();
    }

    public void addTrack(String track) {
        if (track == null || track.isBlank()) {
            throw new IllegalArgumentException("Track can't be null or blank");
        } else {
            tracks.add(track);
        }
    }

    public boolean removeTrack(String track) {
        if (track == null || track.isBlank()) {
            throw new IllegalArgumentException("Track can't be null or blank");
        } else {
            return tracks.remove(track);
        }
    }

    public String getTrack(int index) {
        if (index < 0 || index > tracks.size()-1) {
            throw new IndexOutOfBoundsException("Index is out of range");
        } else {
            return tracks.get(index);
        }
    }

    public int getTrackCount() {
        return tracks.size();
    }

    public List<String> findTracks(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Text can't be null or blank");
        }
        List<String> result = new ArrayList<>();
        for (String item : tracks) {
            if (item.toLowerCase().contains(text.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    public List<String> getAllTracks() {
        return new ArrayList<>(tracks);
    }
}