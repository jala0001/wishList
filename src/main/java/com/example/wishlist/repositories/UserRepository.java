package com.example.wishlist.repositories;

import com.example.wishlist.models.User;
import com.example.wishlist.models.WishList;
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

    public List<User> getUsers() {
        String query = "select * from User;";
        RowMapper rowMapper = new BeanPropertyRowMapper(User.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public User getUser(int id) {
        String query = "Select * from user where user_id = ?;";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }
    public List<WishList> getWishLists(int id) {
        String query = "select * from wishlist where user_id = ?;";
        RowMapper rowMapper = new BeanPropertyRowMapper(WishList.class);
        return jdbcTemplate.query(query, rowMapper, id);
    }

    public void addUser(String username, String userEmail, String password) {
        String query = "insert into user(username, user_email, password)" +
                "values(?, ?, ?);";
        jdbcTemplate.update(query, username, userEmail, password);
    }


    public void addWishList(String header, int id) {
        String query = "insert into wishlist(user_id, wish_list_header)" +
                "values(?, ?);";
        jdbcTemplate.update(query, id, header);
    }

    public void deleteUser(int wishlistId) {
        String query = "delete from wishlist where wish_list_id = ?;";
        jdbcTemplate.update(query, wishlistId);
    }
}
