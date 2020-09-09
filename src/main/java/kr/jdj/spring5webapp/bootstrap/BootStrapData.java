package kr.jdj.spring5webapp.bootstrap;

import kr.jdj.spring5webapp.domain.Author;
import kr.jdj.spring5webapp.domain.Book;
import kr.jdj.spring5webapp.domain.Publisher;
import kr.jdj.spring5webapp.repositories.AuthorRepository;
import kr.jdj.spring5webapp.repositories.BookRepository;
import kr.jdj.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pub = new Publisher("name1", "addr1", "city1", "state2", "35404");
        publisherRepository.save(pub);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("My First Book", "123456");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(pub);
        pub.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub);


        Author rod = new Author("Rod", "Rod2");
        Book eee = new Book("My First Book2", "4567");

        rod.getBooks().add(eee);
        eee.getAuthors().add(rod);
        eee.setPublisher(pub);
        pub.getBooks().add(eee);

        authorRepository.save(rod);
        bookRepository.save(eee);
        publisherRepository.save(pub);




        System.out.println("Start in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Publisher Number of Books : " + pub.getBooks().size());
    }
}
