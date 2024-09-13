package dev.tarffie.TreeCitySessions.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
  private static final Logger log = LoggerFactory.getLogger(UserRepository.class);
  private final JdbcClient jdbcClient;

  public UserRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  public List<User> findAll() {
    return jdbcClient.sql("SELECT * FROM USER")
        .query(User.class)
        .list();
  }

  public Optional<User> findById(Integer id) {
    return jdbcClient.sql("SELECT id, username, registered_on FROM User WHERE id = :id")
        .param("id", id)
        .query(User.class)
        .optional();
  }

  public Optional<User> findByUsername(String username) {
    return jdbcClient.sql("SELECT * FROM User WHERE username = :username")
        .param("username", username)
        .query(User.class)
        .optional();
  }

  public void create(User user) {
    var updated = jdbcClient.sql("INSERT INTO User(id,username,password,registered_on) values(?,?,?,?)")
        .params(List.of(
            user.id(),
            user.username(),
            user.password(),
            user.registeredOn()
        ))
        .update();

    Assert.state(updated == 1, "Failed to create User" + user.username());
  }

  public void delete(Integer id) {
    var updated = jdbcClient.sql("DELETE FROM User WHERE id = :id")
        .param("id", id)
        .update();

    Assert.state(updated == 1, "Failed to delete user " + id);
  }

  public void saveAll(List<User> users) {
    users.forEach(this::create);
  }
}
