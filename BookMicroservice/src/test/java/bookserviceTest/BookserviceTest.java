package bookserviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.sunil.BookMicroservice.BookMicroserviceApplication;
import com.sunil.BookMicroservice.Entity.Book;
import com.sunil.BookMicroservice.Repository.BookRepository;

@SpringBootTest
@ContextConfiguration(classes = BookMicroserviceApplication.class)
@TestMethodOrder(OrderAnnotation.class)
public class BookserviceTest {
@Autowired
BookRepository bookRepository;

@Test
@Order(0)
public void testcreate() {

	Book b = new Book();
	b.setAccessnumber("1234");
	b.setAuthor("sunil");
	b.setBook_Id(2);
	b.setImg("gfddgchgccv");
	b.setCategory("Novel");
	b.setSubject("Life");
	b.setKeyword("life is to short");
	b.setTitle("The LIFE");
	bookRepository.save(b);
	assertNotNull(bookRepository.findByAuthor(" "));
}
//@Test
//@Order(1)
//public void deleteBook() {
//	bookRepository.deleteById(34);
//	assertThat(bookRepository.existsById(34)).isFalse();
//}
@Test
@Order(2)
public void testreadAll()
{
	List<Book> list=bookRepository.findAll();
	assertThat(list).size().isGreaterThan(0);
}
}
