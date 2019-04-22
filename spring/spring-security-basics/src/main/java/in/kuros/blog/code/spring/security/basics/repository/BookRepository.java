package in.kuros.blog.code.spring.security.basics.repository;

import in.kuros.blog.code.spring.security.basics.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
