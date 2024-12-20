package hust.soict.dsai.aims.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        if (media1.getCost() > media2.getCost()) {
            return -1;
        } else if (media1.getCost() < media2.getCost()) {
            return 1;
        } else {
            if (media1.getTitle() != null && media2.getTitle() != null) {
                return -media1.getTitle().compareTo(media2.getTitle());
            }
            if (media1.getTitle() == null && media2.getTitle() != null) {
                return 1;
            }
            if (media1.getTitle() != null && media2.getTitle() == null) {
                return -1;
            }
            return 0;

        }
    }

}