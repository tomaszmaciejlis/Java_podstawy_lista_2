import pl.my.library.Author;
import pl.my.library.Library;
import pl.my.library.Reader;

import java.util.*;

public class Task {
    private static final Library library = new Library();
    private static final List<Reader> knownReaders = new ArrayList<>();
    private static final Map<String, Author[]> knownTitles = new HashMap<>();

    public static void main(String[] args) {
        initBooks();
        initReaders();
        manageReaders();
    }

    private static void manageReaders() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Obsługujemy wypożyczenia.");
        do {
            Reader chosenReader = getChosenReader();
            manageReader(chosenReader);
            System.out.println("Czy chcesz obsłużyć kolejnego czytelnika? (true/false)");
        } while (scanner.nextBoolean());
    }

    private static void manageReader(Reader chosenReader) {
        if (chosenReader != null) {
            borrowBooksBy(chosenReader);
        } else {
            System.out.println("Przykro mi nie wybrałeś nikogo.");
        }
    }

    private static void borrowBooksBy(Reader chosenReader) {
        Scanner scanner = new Scanner(System.in);
        if (!knownTitles.isEmpty()) {
            do {
                borrowSingleBook(chosenReader);
                System.out.println("Czy chcesz pożyczyć coś jeszcze? (true/false)");
            } while (scanner.nextBoolean());
        } else {
            System.out.println("Przykro mi, wygląda na to, że nie ma nic do wypożyczenia.");
        }
    }

    private static void borrowSingleBook(Reader chosenReader) {
        Scanner scanner = new Scanner(System.in);
        Map.Entry<String, Author[]> chosenBook = null;
        System.out.println("Którą książkę wybierasz: ");
        for (Map.Entry<String, Author[]> book : knownTitles.entrySet()) {;
            System.out.printf("%s? (true/false)\n", book.getKey());
            if (scanner.nextBoolean()) {
                chosenBook = book;
                break;
            }
        }
        borrowBookIfNotEmpty(chosenReader, chosenBook);
    }

    private static void borrowBookIfNotEmpty(Reader chosenReader, Map.Entry<String, Author[]> chosenBook) {
        if (chosenBook != null) {
            borrowConcreteBook(chosenReader, chosenBook);
        } else {
            System.out.println("Nie dokonano wyboru książki.");
        }
    }

    private static void borrowConcreteBook(Reader chosenReader, Map.Entry<String, Author[]> chosenBook) {
        boolean success = library.lendABook(chosenReader, chosenBook.getKey(), chosenBook.getValue());
        if (success) {
            System.out.printf("Udało się wypożyczyć książkę %s!\n", chosenBook.getKey());
        } else  {
            System.out.printf("Nie udało się wypożyczyć książki %s.\n", chosenBook.getKey());
        }
    }

    private static Reader getChosenReader() {
        System.out.println("Kto wypożycza: ");
        Reader chosenReader = null;
        Scanner scanner = new Scanner(System.in);
        for (Reader reader : knownReaders) {
            System.out.printf("%s %s? (true, false)\n", reader.getName(), reader.getSurname());
            if (scanner.nextBoolean()) {
                chosenReader = reader;
                break;
            }
        }
        return chosenReader;
    }

    private static void initReaders() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Wprowadzamy czytelników.");
            Reader reader = getReader();
            if(reader == null) {
                System.out.println("Nie można już rejestrować czytelnika.");
            } else {
                knownReaders.add(reader);
                System.out.println("Czy chcesz wprowadzić więcej czytelników? (true/false)");
            }
        } while (scanner.nextBoolean());
    }

    private static Reader getReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię czytelnika: ");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko czytelnika: ");
        String surname = scanner.nextLine();
        Reader reader = library.register(name, surname);
        return reader;
    }

    private static void initBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("czy chcesz wprowadzić książkę? (true/false)");
        while (scanner.nextBoolean()) {
            String title = getTitle();
            Author[] authors = getAuthors();
            library.addBook(title, authors, getCount());
            knownTitles.put(title, authors);
            System.out.println("czy chcesz wprowadzić następną książkę? (true/false)");
        }
    }

    private static String getTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        return title;
    }

    private static int getCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile sztuk tej książki jest w bibliotece?");
        int count = scanner.nextInt();
        return count;
    }

    private static Author[] getAuthors() {
        Scanner scanner = new Scanner(System.in);
        List<Author> authors = new ArrayList<>();
        do {
            authors.add(getAuthor());
            System.out.println("Czy jest więcej autorów? (true/false)");
        } while (scanner.nextBoolean());
        return authors.toArray(new Author[authors.size()]);
    }

    private static Author getAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię autora: ");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko autora: ");
        String surname = scanner.nextLine();
        return new Author(name, surname);
    }
}