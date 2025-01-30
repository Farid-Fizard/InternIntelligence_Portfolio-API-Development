# Portfolio API

A RESTful API for managing user portfolios, including projects, skills, education, and experiences. Built with **Spring Boot**, **Spring Security**, **JWT Authentication**, and **MySQL**.

## Features
- **Authentication**: User login and registration with JWT-based security.
- **User Management**: Retrieve, update, and delete user profiles.
- **Portfolio Management**:
  - **Projects**: Create, read, update, and delete projects.
  - **Skills**: Manage user skills.
  - **Education**: Track educational background.
  - **Experiences**: Store professional experiences.
- **Security**: Endpoints are protected with JWT authentication.
- **Lombok**: Used to reduce boilerplate code.

## Technologies Used
- Java 17
- Spring Boot 3
- Spring Security (JWT Authentication)
- Hibernate & JPA
- MySQL
- Lombok

## Installation & Setup
### Prerequisites
- Java 17+
- MySQL database setup
- Maven installed

### Configuration
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/portfolio-api.git
   cd portfolio-api
   ```
2. Configure **application.properties**:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/portfolio_db
   spring.datasource.username=root
   spring.datasource.password=******
   spring.jpa.hibernate.ddl-auto=create-drop

   jwt.secret=df5992ae9b4354ecac2b2f2397382b9adeb1475d9619e0f25c56096b55651e55f7946758b3f6fbb784518fcc6d1a633fa40c80e714075ec4ab5c7cb0e9305cfd21ededcc9d50e628b03e05cdda783f503473795e750712b9622091b2ebab813f01e79014f64324ee5d94ca602f74807ea7e25b8c359dcbb5c1d73cd93850ce41cef70ffb7acff3fa78169ead15a5b695dff9a7523a6c94a8259fa4e35b135fadf45e8b15eac0536f7450d33d942726af1109bf56f9a17ecb98d6bacf643405bba9a83f65209ba4dd444092a8cf51aebf7d561c7c213ef4be7acd515da2cc1f237a6684bc9ff248a5de6ac07f22312b64a0fbe98dc9d4a024de36076db6ba7188

   ```
3. Build and run the application:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints

### Authentication
- **POST /api/auth/register** – Register a new user and recieve a JWT token
- **POST /api/auth/login** – Authenticate and receive a JWT token

### Users
- **GET /api/users/{id}** – Retrieve user details
- **PUT /api/users/{id}** – Update user details
- **DELETE /api/users/{id}** – Delete user account

### Projects
- **POST /api/projects** – Create a new project
- **GET /api/projects** – Get all projects
- **GET /api/projects/{id}** – Get project by ID
- **PUT /api/projects/{id}** – Update project details
- **DELETE /api/projects/{id}** – Delete project

### Skills
- **POST /api/skills** – Add a new skill
- **GET /api/skills** – Retrieve all skills
- **GET /api/skills/{id}** – Get skill by ID
- **PUT /api/skills/{id}** – Update skill
- **DELETE /api/skills/{id}** – Remove skill

### Education
- **POST /api/educations** – Add education record
- **GET /api/educations** – Get all education records
- **GET /api/educations/{id}** – Get education by ID
- **PUT /api/educations/{id}** – Update education record
- **DELETE /api/educations/{id}** – Delete education record

### Experiences
- **POST /api/experiences** – Add experience
- **GET /api/experiences** – Retrieve all experiences
- **GET /api/experiences/{id}** – Get experience by ID
- **PUT /api/experiences/{id}** – Update experience
- **DELETE /api/experiences/{id}** – Delete experience

## Authentication & Security
- JWT authentication is required for accessing user and portfolio management endpoints.
- Include `Authorization: Bearer <token>` in headers for authenticated requests.

## Contributing
Feel free to fork this project and submit pull requests. Contributions are welcome!

## License
MIT License

