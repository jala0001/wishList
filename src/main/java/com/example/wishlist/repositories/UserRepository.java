package com.example.wishlist.repositories;

import com.example.wishlist.models.SharedWishList;
import com.example.wishlist.models.User;
import com.example.wishlist.models.Wish;
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

    public List<SharedWishList> getSharedWishlists(int id) {
        String query = "select * from shared_with_user where user_id = ?;";
        RowMapper rowMapper = new BeanPropertyRowMapper(SharedWishList.class);
        return jdbcTemplate.query(query, rowMapper, id);
    }

    public User getUser(int id) {
        String query = "Select * from user where user_id = ?;";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }
    public WishList getWishList(int wishlistId) {
        String query = "select * from wishlist where wish_list_id = ?;";
        RowMapper<WishList> rowMapper = new BeanPropertyRowMapper<>(WishList.class);
        return jdbcTemplate.queryForObject(query, rowMapper, wishlistId); // netop tilføjet
    }
    public List<WishList> getWishLists(int id) {
        String query = "select * from wishlist where user_id = ?;";
        RowMapper rowMapper = new BeanPropertyRowMapper(WishList.class);
        return jdbcTemplate.query(query, rowMapper, id);
    }

   public void editWishList(String header, int wishlistId){
       String query = "UPDATE wishlist SET wish_list_header = ?  WHERE wish_list_id = ?";
       jdbcTemplate.update(query, header, wishlistId);
   }

    public List<Wish> getWishes(int wishlistId) {
        String query = "select * from wish where wishlist_id = ?;";
        RowMapper rowMapper = new BeanPropertyRowMapper(Wish.class);
        return jdbcTemplate.query(query, rowMapper, wishlistId); // netop tilføjet
    }

    public void addUser(String username, String userEmail, String password) {
        String query = "insert into user(username, user_email, password, shared_wish_lists)" +
                "values(?, ?, ?, ?);";
        jdbcTemplate.update(query, username, userEmail, password, 0);
    }

    public void addWishList(String header, int id) {
        String query = "insert into wishlist(user_id, wish_list_header)" +
                "values(?, ?);";
        jdbcTemplate.update(query, id, header);
    }

    public void addWish(String header, String link, double price, String note, int wishlistId) {
        String query = "insert into wish(wishlist_id, wish_header, wish_link, wish_price, wish_note, is_reserved)" +
                "values(?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(query, wishlistId, header, link, price, note, 0);
    }

    public void shareWithUser(int wishlistId, int userId) {
        String query = "insert into shared_with_user(user_id, shared_wishlists)" +
                "values(?, ?);";
        jdbcTemplate.update(query, userId, wishlistId);
    }

    public void deleteUser(int wishlistId) {
        String query = "delete from wishlist where wish_list_id = ?;";
        jdbcTemplate.update(query, wishlistId);
    }

    public void deleteWish(int wishId) {
        String query = "delete from wish where wish_id = ?;";
        jdbcTemplate.update(query, wishId);
    }

    public void reserveWish(int wishId) {
        String query = "update wish set is_reserved = ? where wish_id = ?;";
        jdbcTemplate.update(query, 1, wishId);
    }


}