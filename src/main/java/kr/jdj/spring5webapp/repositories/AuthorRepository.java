package kr.jdj.spring5webapp.repositories;

import kr.jdj.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
