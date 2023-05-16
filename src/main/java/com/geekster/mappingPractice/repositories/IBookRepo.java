package com.geekster.mappingPractice.repositories;

import com.geekster.mappingPractice.models.Address;
import com.geekster.mappingPractice.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book,Long> {

    Book findBookByBookId(Long bookId);

    @Modifying
    @Query(value = "update book set book_price =:bookPrice where book_id =:bookId",nativeQuery = true)
    void updateBookPrize(Long bookId, Double bookPrice);

}
