package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	public Book findBookByTitle(String title);
}
