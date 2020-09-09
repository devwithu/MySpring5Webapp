package kr.jdj.spring5webapp.repositories;

import kr.jdj.spring5webapp.domain.Book;
import kr.jdj.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
