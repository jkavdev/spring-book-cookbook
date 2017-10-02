package br.com.jkavdev.cookbook.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jkavdev.cookbook.boot.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	public Book findBookByIsbn(String isbn);

}
