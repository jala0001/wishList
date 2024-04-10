package com.example.wishlist.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<com.example.wishlist.models.User> getUsers() {
        String query = "select * from User;";
        RowMapper rowMapper = new BeanPropertyRowMapper(com.example.wishlist.models.User.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public com.example.wishlist.models.User getUser(int id) {
        String query = "Select * from user where user_id = ?;";
        RowMapper<com.example.wishlist.models.User> rowMapper = new BeanPropertyRowMapper<>(com.example.wishlist.models.User.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    public void addUser(String username, String userEmail, String password) {
        String query = "insert into user(username, user_email, password)" +
                "values(?, ?, ?);";
        jdbcTemplate.update(query, username, userEmail, password);
    }
}
