package example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;


import example.domain.LoginLog;

@Repository
public interface LoginLogDao extends JpaRepository<LoginLog, Integer> {

}