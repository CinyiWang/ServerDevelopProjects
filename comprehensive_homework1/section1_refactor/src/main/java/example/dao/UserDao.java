package example.dao;

import example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByNameAndPassword(String username, String password);

    @Cacheable("userCache")
    User findByName(String name);

    @CachePut(value = "userCache", key = "#result.id")
    User save(User user);


}
