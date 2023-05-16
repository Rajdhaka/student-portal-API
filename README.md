# Student Portal API Application


## Built With
* `Java 17`
* `Maven 4.0.0`
* `MySql Ver 8.0.32`
* `Spring Boot 3.0.5`
* `IntelliJ IDEA 2023.1 (Community Edition)`
## Data Flow

### 1. Models:
* It consists of **Student** ,**Address**, **Course** ,**Laptop** and **Book** entity classes along with their data members and member functions
* Used **_@Table_** and **_@Entity_** annotations inside the entity class.
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like _**@Data,**_ **@_NoArgsConstructor_**, **_@AllArgsConstructor_** getters and setters for those object generate automatically.
* Used **_@OneToOne_**, **_@OneToMany_**, **_@ManyToOne_**, and  **_@ManyToMany_**.

### 2. Controllers:
* It consists of  **StudentController** ,**AddressController**, **CourseController**, **LaptopController** and **BookController** classes in which used the annotations like **@RestController** to annotate the class as Controller.
* Used annotation **_@GetMapping_** , **_@PostMapping_** , **_@PutMapping_** , **_@DeleteMapping_** to map the HTTP web requests to the specific handler methods.

<br>

### API Reference:
<br>

>Student's API References
<br>

* Add Student:
```*.sh-session
  http://localhost:8080/student
```

* Get Student By ID:
```*.sh-session
 http://localhost:8080/student/studentId/{studentId}
```
* Update Student phoneNumber:
```*.sh-session
http://localhost:8080/student/studentId/{studentId}/phoneNumber/{phoneNumber}
```
* Delete Student By ID:
```*.sh-session
http://localhost:8080/student/studentId/{studentId}
```
<br>

>Address's API References:
<br>

* Add Address:
```*.sh-session
  http://localhost:8080/address
```

* Get all Addresses:
```*.sh-session
http://localhost:8080/address/all
```

* Update Address Landmark:
```*.sh-session
 http://localhost:8080/address/addressId/{addressId}/landmark/{landmark}
```
* Delete Address By ID:
```*.sh-session
 http://localhost:8080/address/addressId/{addressId}
```

>Laptop's API References:
<br>

* Add Laptop:
```*.sh-session
  http://localhost:8080/laptop
```

* Get all Laptops:
```*.sh-session
http://localhost:8080/laptop/all
```

* Update Laptop Price:
```*.sh-session
 http://localhost:8080/laptop/laptopId/{laptopId}/laptopPrice/{laptopPrice}
```

* Delete Laptop By LaptopId:
```*.sh-session
  http://localhost:8080/laptop/laptopId/{laptopId}
```


>Course's API References:
<br>

* Add Courses:
```*.sh-session
  http://localhost:8080/course
```

* Get all Courses:
```*.sh-session
  http://localhost:8080/course/all
```

* Update Courses By ID:
```*.sh-session
  http://localhost:8080/course/courseId/{courseId}/courseTitle/{courseTitle}

```

* Delete Courses By ID:
```*.sh-session
  http://localhost:8080/course/courseId/{courseId}
```

>Book's API References:
<br>

* Add Book:
```*.sh-session
 http://localhost:8080/book
```

* Get all Books:
```*.sh-session
  http://localhost:8080/book/all
```

* Update Book By ID:
```*.sh-session
 http://localhost:8080/book/bookId/{bookId}/bookPrice/{bookPrice}
```
* Delete Book By ID:
```*.sh-session
  http://localhost:8080/book/bookId/{bookId}
```

### 3. Services:
* It consists of **StudentService** ,**AddressService**, **LaptopService**, **CourseService** and **BookService**classes in which provide some business functionalities of every handler methods.
* Used _**@Service**_ annotation to indicate that a class belongs to the service layer.
* Used **_@Transactional_** annotation to separate transaction management code from the code for business logic on the update and delete methods.

### 4. Repositories:
* It consists of **StudentDao** ,**AddressDao**, **LaptopDao**, **CourseDao** and **BookDao** interface classes that extends CrudRepository which is interface for generic inbuilt CRUD operations on a repository for a specific type. Usually represent the database access layer in an application.
* Used **Iterable** to manage the data of entity classes by performing CRUD operations.
* Used _**@Repository**_ annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
* Used _**@Modifying**_ annotation wrote named parameters query using @Query annotation to insert, update, or delete an entity.


## Project Summary
* In this project I performed CRUD operation like add,get,delete and update.<br/>
* The aim of this project to perform **_one to one_**, **_one-to-many_**, **_many-to-one_** and **_many-to-many_** relationships mapping between entity classes.
* Used interface JpaRepository for generic CRUD inbuilt operations like save,saveAll,updateById, etc.
* Used our own custom finder methods and wrote operations using custom queries.