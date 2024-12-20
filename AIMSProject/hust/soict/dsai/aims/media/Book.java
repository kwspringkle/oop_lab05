package hust.soict.dsai.aims.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

        public void addAuthor(String authorName) {
            if (authors.contains(authorName)) {
                System.out.println("Author already exists!");
            } else {
                authors.add(authorName);
                System.out.println("Author added!");
            }
        }

        public void removeAuthor(String authorName) {
            if (authors.contains(authorName)) {
                authors.remove(authorName);
                System.out.println("Author removed!");
            } else {
                System.out.println("Author does not exist!");
            }
        }


    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public void print() {
        System.out.print(getId() + ". Book - " + getTitle() + " - " + getCategory() + " : ");
        for (String author : authors) {
            System.out.println("Author: " + author);
        }
        System.out.println(getCost() + "$");
    }
}
