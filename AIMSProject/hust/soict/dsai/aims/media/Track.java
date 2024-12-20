package hust.soict.dsai.aims.aims.media;

public class Track implements Playable {
        private String title;
        private int length;

        public Track(String title, int length) {
            this.title = title;
            this.length = length;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength() + " seconds");
    }
    @Override
    public boolean equals(Object obj) {
        Track track = (Track) obj;
        if (this.getTitle().equals(track.getTitle()) && this.getLength() == track.getLength()) {
            return true;
        } else {
            return false;
        }
    }
}
