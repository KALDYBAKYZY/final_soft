# Book Store REST API
Description
This project is a RESTful API for managing a bookstore system.
It is built using Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL.
The application supports CRUD operations for books and related entities such as authors, categories, formats, publishers, orders, and payments.
The project follows a layered architecture:

Controller layer
Service layer
Repository layer
DTO + Mapper layer
Unit tests are written using JUnit 5 and Mockito.
Technologies Used
Java 21
Spring Boot
Spring Data JPA
Hibernate
PostgreSQL
MapStruct
Lombok
Mockito
JUnit 5
Gradle
Project Structure
src/main/java/com/example/demo
│
├── controller        # REST controllers
├── service           # Business logic interfaces
│   └── impl           # Service implementations
├── repository        # JPA repositories
├── entity            # JPA entities
├── dto
│   ├── request        # Request DTOs
│   └── response       # Response DTOs
├── mapper            # MapStruct mappers
└── config            # Configuration classes
Main Entities
Book
Author
Category
Publisher
Format
Language
Series
Tag
Order
OrderItem
Payment
Example: BookRequestDto
public class BookRequestDto {
    private String title;
    private String description;
    private Double price;
    private Long authorId;
    private Long categoryId;
    private Long publisherId;
    private Long languageId;
    private Long formatId;
    private Long seriesId;
    private List<Long> tagIds;
}
Example API Endpoints
Create Book
POST /api/books
Request body:
{
  "title": "Harry Potter",
  "description": "Fantasy book",
  "price": 25.5,
  "authorId": 1,
  "categoryId": 2,
  "publisherId": 1,
  "languageId": 1,
  "formatId": 1,
  "seriesId": 1,
  "tagIds": [1, 2, 3]
}
Get Book by ID
GET /api/books/{id}
Update Book
PUT /api/books/{id}
Delete Book
DELETE /api/books/{id}
Service Layer Example
@Override
public BookResponseDto create(BookRequestDto dto) {
    Book book = bookMapper.toEntity(dto);

    book.setAuthor(authorRepository.findById(dto.getAuthorId()).orElse(null));
    book.setCategory(categoryRepository.findById(dto.getCategoryId()).orElse(null));
    book.setPublisher(publisherRepository.findById(dto.getPublisherId()).orElse(null));
    book.setLanguage(languageRepository.findById(dto.getLanguageId()).orElse(null));
    book.setFormat(formatRepository.findById(dto.getFormatId()).orElse(null));
    book.setSeries(seriesRepository.findById(dto.getSeriesId()).orElse(null));
    book.setTags(tagRepository.findAllById(dto.getTagIds()));

    return bookMapper.toDto(bookRepository.save(book));
}
Testing
Unit tests are written using:
JUnit 5
Mockito
Example test:
@Test
void testGetById() {
    Book book = new Book();
    book.setId(1L);
    book.setTitle("Test Book");

    when(repository.findById(1L)).thenReturn(Optional.of(book));

    BookResponseDto result = service.getById(1L);

    assertEquals("Test Book", result.getTitle());
}
Common Issues
1. NullPointerException in tests
Cause:
Mapper or repository is not mocked.
Solution:
Use @Mock and @InjectMocks
Or pass mapper via constructor
2. 401 Unauthorized error
Cause:
Spring Security dependency added
No custom security configuration
Solution:
Disable security or configure SecurityFilterChain
3. ID is not saved in relations
Cause:
Entity relations not set manually
DTO only contains IDs
Solution:
Load entities via repository and set them manually
How to Run
Clone repository
Configure database in application.yml
Run:
./gradlew bootRun
Open:
http://localhost:8080
