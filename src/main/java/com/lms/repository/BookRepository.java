package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("SELECT COALESCE(SUM(b.availableCopies), 0) FROM Book b")
	public Long getTotalAvailableBooks();
	
	@Query("SELECT COALESCE(SUM(b.totalCopies - b.availableCopies), 0) FROM Book b")
	public Long getTotalIssuedBooks();
	
	@Query("SELECT COALESCE(SUM(b.totalCopies), 0) FROM Book b")
	public Long getTotalBooks();
 

}
