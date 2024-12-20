package hust.soict.dsai.aims.aims.media;
import hust.soict.dsai.aims.aims.exception.PlayException;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements Playable{
    private String artist;

    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, float cost, String director
            , int length, String artist) {
        super(id, title, category, cost, director, length);
        this.artist = artist;
    }
    public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> arrayList) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = arrayList;
        // TODO Auto-generated constructor stub
    }
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void addTrack(Track track) {
        int indexOfTrack = tracks.indexOf(track);
        if (indexOfTrack == -1) {
            System.out.println("Track already exists!");
            return;
        }
        tracks.add(track);
        System.out.println("Track added!");
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void removeTrack(Track track) {
        int indexOfTrack = tracks.indexOf(track);
        if (indexOfTrack == -1) {
            System.out.println("Track does not exist!");
            return;
        }
        tracks.remove(indexOfTrack);
        System.out.println("Track removed!");
    }
    public void play() throws PlayException {
        if(this.getLength() < 0) {
            throw new PlayException("ERROR: DVD-length is non-positive!");
        } else {
            System.out.println("\ntitle: " + getTitle() + '\n' + "artist: " + getArtist() + "\n\n" + "TRacks:");
            for (Track song : tracks) {
                song.play();
            }
        }
    }
//    @Override
//    public int getLength() {
//        int totalLength = 0;
//        for (Track track : tracks) {
//            totalLength += track.getLength();
//        }
//        setLength(totalLength);
//        return totalLength;
//    }

    // Phuong thuc de display thong tin cua CompactDisc
//    public void play() {
//        System.out.println("Playing CD: " + this.getTitle());
//        System.out.println("CD artist: " + artist);
//        System.out.println("CD length: " + this.getLength());
//        for (Track track : tracks) {
//            track.play();
//        }
//    }

    @Override
    public void print() {
        System.out.println(getId() + ". CD - "
                + getTitle() + " - " + getCategory() + " - "
                + getDirector() + " - " + artist + " - "
                + getCost() + "$");
    }
}
