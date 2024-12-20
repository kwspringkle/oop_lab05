package hust.soict.dsai.aims.aims.media;
public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost, director, length);
    }
//    private String director;
//    private int length;
    // Constructor 1: Create a DVD object by id and title
    public DigitalVideoDisc(int id, String title) {
        super(id, title);
    }

//     Constructor 2: Create a DVD object by id, title, category and cost
    public DigitalVideoDisc(int id, String title, String category, float cost) {
        this(id, title);
        this.setCategory(category);
        this.setCost(cost);
    }

//Constructor 3: Create a DVD object by id, title, category, directorand cost
    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        this(id, title, category, cost);
        this.setDirector(director);

    }

//Constructor 4: Create a DVD object by all attributes: title, category, director, length, and cost
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        this(id, title, category, director, cost);
        this.setLength(length);
    }

    @Override
    public void print() {
        System.out.println(getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory()
                + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + "$");
    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}