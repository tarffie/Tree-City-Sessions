package dev.tarffie.TreeCitySessions.utils;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class DatabaseService {
  private final Dotenv dotenv;

  public DatabaseService(Dotenv dotenv) {
    this.dotenv = dotenv;
  }

  @PostConstruct
  public void configureDatabaseProperties() {
    System.setProperty("spring.datasource.url", Objects.requireNonNull(dotenv.get("POSTGRESDB_URL")));
    System.setProperty("spring.datasource.username", Objects.requireNonNull(dotenv.get("POSTGRESDB_USER")));
    System.setProperty("spring.datasource.password", Objects.requireNonNull(dotenv.get("POSTGRESDB_ROOT_PASSWORD")));
  }
}
