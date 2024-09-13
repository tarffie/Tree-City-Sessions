package dev.tarffie.TreeCitySessions.utils;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectDotEnv {

  @Bean
  public Dotenv dotenv() {
    return Dotenv.configure().load();
  }
}
