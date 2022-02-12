import org.junit.Assert;
import org.junit.Test;
import pl.my.library.Author;
import pl.my.library.Library;
import pl.my.library.Reader;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    @Test
    public void canNotRegisterLessThen50() {
        Library library = new Library();
        for (int i = 0; i < 49; i++) {
            library.register("TestUser" + i, "Test" + i);
        }

        Assert.assertNotNull("Można dodać dokładnie 50 czytelników.", library.register("Nieudany", "User"));
    }


    @Test
    public void canNotRegisterMoreThen50() {
        Library library = new Library();
        for (int i = 0; i < 50; i++) {
            library.register("TestUser" + i, "Test" + i);
        }

        Assert.assertNull("Nie można dodać więcej niż 50 czytelników.", library.register("Nieudany", "User"));
    }

    @Test
    public void canNotAddMoreThen20Books() {
        Library library = new Library();
        for (int i = 0; i < 20; i++) {
            library.addBook("TestBook" + i, new Author[]{new Author("TestA", "TE" + i)}, i + 1);
        }

        Assert.assertFalse("Nie można dodać więcej niż 20 typów książek.",
                library.addBook("TestBook", new Author[]{new Author("TestA", "Bookowy")}, 12));
    }

    @Test
    public void canAddLessThen20Books() {
        Library library = new Library();
        for (int i = 0; i < 19; i++) {
            library.addBook("TestBook" + i, new Author[]{new Author("TestA", "TE" + i)}, i + 1);
        }

        Assert.assertTrue("Maksymalnie można dodać dokładnie 20 typów książek.",
                library.addBook("TestBook", new Author[]{new Author("TestA", "Bookowy")}, 12));
    }

    @Test
    public void canNotBorrowABookWhichIsNotInTheLibrary() {
        Library library = new Library();
        for (int i = 0; i < 20; i++) {
            library.addBook("TestBook" + i, new Author[]{new Author("TestA", "TE" + i)}, i + 1);
        }

        Reader reader = library.register("Tomasz", "Czytelnik");

        Assert.assertFalse("Nie można wypożyczyć książki, której nie ma w bibliotece.",
                library.lendABook(reader, "TestBook", new Author[]{new Author("TestA", "Bookowy")}));
    }

    @Test
    public void canNotBorrowABookWhichIsNotAvailable() {
        Library library = new Library();
        for (int i = 0; i < 20; i++) {
            library.addBook("TestBook" + i, new Author[]{new Author("TestA", "TE" + i)}, i + 1);
        }

        Reader reader = library.register("Tomasz", "Czytelnik");
        Reader reader2 = library.register("Roman", "Niecny");

        library.lendABook(reader2, "TestBook0", new Author[]{new Author("TestA", "TE0")});
        Assert.assertFalse("Nie można wypożyczyć książki, której wszystkie egzemplarze są wypożyczone.",
                library.lendABook(reader, "TestBook0", new Author[]{new Author("TestA", "TE0")}));
    }

    @Test
    public void canBorrowABookWhichIsAvailable() {
        Library library = new Library();
        for (int i = 0; i < 20; i++) {
            library.addBook("TestBook" + i, new Author[]{new Author("TestA", "TE" + i)}, i + 1);
        }

        Reader reader = library.register("Tomasz", "Czytelnik");

        Assert.assertTrue("Można wypożyczyć książki, której są jeszcze jakieś niewypożyczone sztuki. " +
                        "Ilość zajętych indeksów currentReaders jest mniejsza od count - ilości egzemplarzy.",
                library.lendABook(reader, "TestBook0", new Author[]{new Author("TestA", "TE0")}));
    }

    @Test
    public void canBorrowABookWhichIsAvailable2() {
        Library library = new Library();
        for (int i = 0; i < 20; i++) {
            library.addBook("TestBook" + i, new Author[]{new Author("TestA", "TE" + i)}, i + 1);
        }

        List<Reader> readers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Reader reader = library.register("Nieznośny" + i, "Nicpoń" + i);
            if (reader != null) readers.add(reader);
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < i + 1; j++) {
                library.lendABook(readers.get(i + j), "TestBook" + i, new Author[]{new Author("TestA", "TE" + i)});
            }
        }

        Assert.assertTrue("Można wypożyczyć książki, której są jeszcze jakieś niewypożyczone sztuki. " +
                        "Ilość zajętych indeksów currentReaders jest mniejsza od count - ilości egzemplarzy.",
                library.lendABook(readers.get(0), "TestBook19", new Author[]{new Author("TestA", "TE19")}));
    }

    @Test
    public void canBorrowABookIfTitleMatches() {
        Library library = new Library();
        for (int i = 0; i < 20; i++) {
            library.addBook("TestBook" + i, new Author[]{new Author("TestA", "TE" + i)}, i + 1);
        }

        List<Reader> readers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Reader reader = library.register("Nieznośny" + i, "Nicpoń" + i);
            if (reader != null) readers.add(reader);
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < i + 1; j++) {
                library.lendABook(readers.get(i + j), "TestBook" + i, new Author[]{new Author("TestA", "TE" + i)});
            }
        }

        Assert.assertTrue("Można wypożyczyć książki jeśli znaleziono ją po tytule." +
                        " Dopuszczalne jest podanie tytułu bez uwzględnienia wielkości znaków. ",
                library.lendABook(readers.get(0), "testbook19", new Author[]{new Author("TestA", "TE19")}));
    }

    @Test
    public void canBorrowABookIfAuthorsMatches() {
        Library library = new Library();
        for (int i = 0; i < 20; i++) {
            library.addBook("TestBook" + i, new Author[]{new Author("TestA", "TE" + i), new Author("TestB","Terefere")}, i + 1);
        }

        List<Reader> readers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Reader reader = library.register("Nieznośny" + i, "Nicpoń" + i);
            if (reader != null) readers.add(reader);
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < i + 1; j++) {
                library.lendABook(readers.get(i + j), "TestBook" + i, new Author[]{new Author("TestA", "TE" + i), new Author("TestB","Terefere")});
            }
        }

        Assert.assertTrue("Kolejność autorów nie ma znaczenia. Zawartość tablicy autorów może mieć inną kolejność." +
                        " Ważne natomiast jest by po prostu każdy autor miał swój odpowiednik z jednej i drugiej strony.",
                library.lendABook(readers.get(0), "TestBook19", new Author[]{new Author("TestB","Terefere"), new Author("TestA", "TE19")}));
    }

    @Test
    public void canNotBorrowABookIfAuthorsDiffers() {
        Library library = new Library();
        for (int i = 0; i < 20; i++) {
            library.addBook("TestBook" + i, new Author[]{new Author("TestA", "TE" + i), new Author("TestB","Terefere")}, i + 1);
        }

        List<Reader> readers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Reader reader = library.register("Nieznośny" + i, "Nicpoń" + i);
            if (reader != null) readers.add(reader);
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < i + 1; j++) {
                library.lendABook(readers.get(i + j), "TestBook" + i, new Author[]{new Author("TestA", "TE" + i), new Author("TestB","Terefere")});
            }
        }

        Assert.assertFalse("Wszyscy autorzy muszą się zgadzać.",
                library.lendABook(readers.get(0), "TestBook19", new Author[]{new Author("TestB","Tararara"), new Author("TestA", "TE19")}));
    }

    @Test
    public void canNotBorrowABookIfAuthorsCountDiffers() {
        Library library = new Library();
        for (int i = 0; i < 20; i++) {
            library.addBook("TestBook" + i, new Author[]{new Author("TestA", "TE" + i), new Author("TestB","Terefere")}, i + 1);
        }

        List<Reader> readers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Reader reader = library.register("Nieznośny" + i, "Nicpoń" + i);
            if (reader != null) readers.add(reader);
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < i + 1; j++) {
                library.lendABook(readers.get(i + j), "TestBook" + i, new Author[]{new Author("TestA", "TE" + i), new Author("TestB","Terefere")});
            }
        }

        Assert.assertFalse("Ilość autorów musi się zgadzać przy wypożyczeniu..",
                library.lendABook(readers.get(0), "TestBook19", new Author[]{new Author("TestA", "TE19")}));
    }
}