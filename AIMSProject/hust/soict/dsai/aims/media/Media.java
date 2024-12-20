package hust.soict.dsai.aims.aims.media;
import java.util.Comparator;
public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;


    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }



    @Override
    public boolean equals(Object obj) {
        Media media = (Media) obj;
        try {
            String title = media.getTitle();
            return this.title.equals(title);
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Media [id=" + '\'' + id + '\'' + ", title=" + '\'' + title  + '\''
                + ", category=" + category+ ", cost=" + cost + "]";
    }


    public void displayDetails() {
        System.out.println("----------------MEDIA's DETAILs----------------");
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Cost: " + cost);
        System.out.println("---------------END-----------------");
    }

    public boolean searchMediaByTitle(String title) {
        String[] words = title.split(" ");
        for (String word : words) {
            if (this.title.contains(word)) {
                return true;
            }
        }
        return false;
    }

    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }
    public abstract void print();



    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

//        @Override
//        public int compareTo(Media media) {
//
//            int titleCompare = this.title.compareTo(media.title);
//            return (titleCompare == 0) ? Float.compare(this.cost, media.cost) : titleCompare;
//        }
}
