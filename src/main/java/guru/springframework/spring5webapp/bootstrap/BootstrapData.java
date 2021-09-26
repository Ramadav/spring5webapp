package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRespository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRespository bookRespository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository,
                         BookRespository bookRespository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRespository = bookRespository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("The only One Publisher", "Publishstreet 1", "Publishtown", "PublishState", "Publishtown");

        Author daniel = new Author("Daniel", "Idontknow");
        Book theDunno = new Book("The Dunno Book", "12324556", "The Publisher");
        daniel.getBooks().add(theDunno);
        theDunno.getAuthors().add(daniel);

        authorRepository.save(daniel);
        bookRespository.save(theDunno);

        Author craig = new Author("craig", "Idontknow");
        Book theDunnoTwo = new Book("The Dunno Book P2", "1232444556", "The Publisher");
        craig.getBooks().add(theDunno);
        theDunnoTwo.getAuthors().add(daniel);

        authorRepository.save(craig);
        bookRespository.save(theDunnoTwo);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRespository.count());
        System.out.println("Publisher info: " + publisher);
    }
}
