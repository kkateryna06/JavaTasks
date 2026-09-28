package day03.task1;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        // add track
        playlist.addTrack("Track1");
        playlist.addTrack("Track2");
        playlist.addTrack("Track2");
        playlist.addTrack("Track3");
        playlist.addTrack("Track2");
        try {
            playlist.addTrack(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            playlist.addTrack("  ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(playlist.getAllTracks());

        // delete track
        System.out.println(playlist.removeTrack("Track2"));
        System.out.println(playlist.getAllTracks());

        System.out.println(playlist.removeTrack("Track5"));
        System.out.println(playlist.getAllTracks());

        // find track
        System.out.println(playlist.findTracks("2"));
        System.out.println(playlist.findTracks("TRACK"));

        // get track
        System.out.println(playlist.getTrack(0));
        try {
            playlist.getTrack(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // get all tracks
        List<String> tracks = new ArrayList<>(playlist.getAllTracks());
        tracks.clear();
        System.out.println(tracks);
        System.out.println(playlist.getAllTracks());
    }
}
