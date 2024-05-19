package hu.nye.progkor;
/*
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
*/
/**
 * The Main class serves as the entry point for the Spring Boot application.
 * It contains the main method which starts the application.
 */
/*
@SpringBootApplication
public final class Main {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
/*
    private Main() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * The main method which starts the Spring Boot application.
     *
     * @param args command-line arguments (optional)
     */
/*
    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
