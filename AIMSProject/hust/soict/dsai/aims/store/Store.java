package hust.soict.dsai.aims.aims.store;
import hust.soict.dsai.aims.aims.media.*;
import java.util.ArrayList;
import java.util.List;
public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();

    public void initializeItems() {
        // Add CompactDiscs
        itemsInStore.add(new CompactDisc(1, "CD1", "Pop Music", 15.99f, "John Doe", 40, "Artist1"));
        itemsInStore.add(new CompactDisc(2, "Jazz Nights", "Jazz", 12.50f, "Jane Smith", 60, "Artist2"));
        itemsInStore.add(new CompactDisc(3, "Rock Revolution", "Rock", 18.75f, "Rock Band", 50, "Artist3"));
        itemsInStore.add(new CompactDisc(4, "Classic Hits", "Classical", 22.00f, "Beethoven", 70, "Artist4"));

        // Add DigitalVideoDiscs
        itemsInStore.add(new DigitalVideoDisc(5, "The Matrix", "Science Fiction", 19.99f, "The Wachowskis", 136));
        itemsInStore.add(new DigitalVideoDisc(6, "Inception", "Thriller", 14.99f, "Christopher Nolan", 148));
        itemsInStore.add(new DigitalVideoDisc(7, "Avengers", "Action", 24.50f, "Joss Whedon", 143));
        itemsInStore.add(new DigitalVideoDisc(8, "Frozen", "Animation", 12.99f, "Chris Buck", 102));

        // Add Books
        itemsInStore.add(new Book(9, "Effective Java", "Programming", 45.99f));
        itemsInStore.add(new Book(10, "Clean Code", "Software Development", 39.99f));
        itemsInStore.add(new Book(11, "Harry Potter", "Fantasy", 29.99f));
        itemsInStore.add(new Book(12, "The Great Gatsby", "Classic", 15.99f));
    }

    // Phương thức thêm 1 media moi vào cửa hàng
    public void addMedia(Media media) {
        itemsInStore.add(media);
    }

    public void removeMedia(Media media) {
        int indexOfMedia = itemsInStore.indexOf(media);
        if (indexOfMedia == -1) {
            System.out.println("Media does not exist!");
            return;
        }
        itemsInStore.remove(indexOfMedia);
        System.out.println("Media removed!");
    }

    // Getter and Setter
    public List<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void setItemsInStore(List<Media> itemsInStore) {
        this.itemsInStore = itemsInStore;
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        for (Media media : this.itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("***************************************************");
    }

    public Media findMediaById(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void displayStore() {
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }

}
