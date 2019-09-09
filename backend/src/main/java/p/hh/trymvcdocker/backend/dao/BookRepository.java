package p.hh.trymvcdocker.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.hh.trymvcdocker.backend.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
