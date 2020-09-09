package kr.jdj.spring5webapp.repositories;

import kr.jdj.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
