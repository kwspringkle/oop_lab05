package hust.soict.dsai.aims;
import hust.soict.dsai.aims.aims.cart.Cart;
import hust.soict.dsai.aims.aims.exception.PlayException;
import hust.soict.dsai.aims.aims.store.*;
import hust.soict.dsai.aims.aims.media.*;

import java.util.Scanner;
import java.util.Iterator;
public class Aims {
    public static void main(String[] args) throws PlayException {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        int choice;
        store.initializeItems();
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStore(store, cart, scanner);
                    break;
                case 2:
                    updateStore(store, scanner);
                    break;
                case 3:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3");
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        System.out.print("Enter your choice: ");
    }

    public static void viewStore(Store store, Cart cart, Scanner scanner) throws PlayException {
        store.displayStore();
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    seeMediaDetails(store, cart, scanner);
                    break;
                case 2:
                    addMediaToCart(store, cart, scanner);
                    break;
                case 3:
                    playMedia(store, scanner);
                    break;
                case 4:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3-4");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        System.out.print("Enter your choice: ");
    }

    public static void seeMediaDetails(Store store, Cart cart, Scanner scanner) throws PlayException {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            media.displayDetails();
            int choice;
            do {
                mediaDetailsMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        System.out.println("Media added to cart.");
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a number: 0-1-2");
                }
            } while (choice != 0);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.print("Enter your choice: ");
    }

    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia(Store store, Scanner scanner) throws PlayException {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or not found.");
        }
    }

    public static void updateStore(Store store, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // Add media to store logic
                addMediaToStore(store, scanner);
                break;
            case 2:
                // Remove media from store logic
                removeMediaFromStore(store, scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please choose a number: 0-1-2");
        }
    }

    public static void addMediaToStore(Store store, Scanner scanner) {
        System.out.print("Enter the type of media (CD/DVD/Book): ");
        String type = scanner.nextLine();

        if (type.equalsIgnoreCase("DVD")) {
            System.out.println("Enter the ID:");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the title:");
            String title = scanner.nextLine();
            System.out.println("Enter the category:");
            String category = scanner.nextLine();
            System.out.println("Enter the cost:");
            float cost = scanner.nextFloat();
            scanner.nextLine();
            System.out.println("Enter the director:");
            String director = scanner.nextLine();
            System.out.println("Enter the length:");
            int length = scanner.nextInt();

            DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, director, length);
            store.addMedia(dvd);
            System.out.println("DVD added to store.");
        } else if (type.equalsIgnoreCase("CD")) {
            System.out.println("Enter the ID:");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the title:");
            String title = scanner.nextLine();
            System.out.println("Enter the category:");
            String category = scanner.nextLine();
            System.out.println("Enter the cost:");
            float cost = scanner.nextFloat();
            scanner.nextLine();
            System.out.println("Enter the director:");
            String director = scanner.nextLine();
            System.out.println("Enter the length:");
            int length = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the artist:");
            String artist = scanner.nextLine();

            CompactDisc cd = new CompactDisc(id, title, category, cost, director, length, artist);
            store.addMedia(cd);
            System.out.println("CD added to store.");
        } else if (type.equalsIgnoreCase("Book")) {
            System.out.println("Enter the ID:");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the title:");
            String title = scanner.nextLine();
            System.out.println("Enter the category:");
            String category = scanner.nextLine();
            System.out.println("Enter the cost:");
            float cost = scanner.nextFloat();

            Book book = new Book(id, title, category, cost);
            store.addMedia(book);
            System.out.println("Book added to store.");
        } else {
            System.out.println("Invalid media type.");
        }
    }

    public static void removeMediaFromStore(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void seeCurrentCart(Cart cart, Scanner scanner) throws PlayException {
        cart.printCart();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Filter medias in cart logic
                    filterMediasInCart(cart, scanner);
                    break;
                case 2:
                    // Sort medias in cart logic
                    sortMediasInCart(cart, scanner);
                    break;
                case 3:
                    // Remove media from cart logic
                    removeFromCart(cart, scanner);
                    break;
                case 4:
                    // Play a media logic
                    playMedia(cart, scanner);
                    break;
                case 5:
                    // Place order logic
                    placeOrder(cart);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3-4-5");
            }
        } while (choice != 0);
    }

    // Sort medias in cart logic
    public static void sortMediasInCart(Cart cart, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                cart.sortByTitleCost();
                break;
            case 2:
                cart.sortByCostTitle();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please choose a number: 0-1-2");
        }
        cart.printCart();
    }

    // Filter medias in cart logic
    public static void filterMediasInCart(Cart cart, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by title");
        System.out.println("2. Filter by ID");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // Filter by title logic
                System.out.print("Enter the title to filter: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            case 2:
                // Filter by ID logic
                System.out.print("Enter the ID to filter: ");
                int id = scanner.nextInt();
                cart.searchById(id);

                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please choose a number: 0-1-2");
        }
    }

    // Remove from a cart logic
    public static void removeFromCart(Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    // Play a media logic
    public static void playMedia(Cart cart, Scanner scanner) throws PlayException {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or not found.");
        }
    }

    // Place order logic
    public static void placeOrder(Cart cart) {
        Iterator<Media> iterator = cart.itemsOrdered.iterator();
        while (iterator.hasNext()) {
            Media media = iterator.next();
            iterator.remove();
        }
        System.out.println("Order placed.");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        System.out.print("Enter your choice: ");
    }
}

