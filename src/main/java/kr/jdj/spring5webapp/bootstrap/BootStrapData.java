package kr.jdj.spring5webapp.bootstrap;

import kr.jdj.spring5webapp.domain.Author;
import kr.jdj.spring5webapp.domain.Book;
import kr.jdj.spring5webapp.repositories.AuthorRepository;
import kr.jdj.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("My First Book", "123456");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Rod2");
        Book eee = new Book("My First Book2", "4567");

        rod.getBooks().add(eee);
        eee.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(eee);

        System.out.println("Start in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
