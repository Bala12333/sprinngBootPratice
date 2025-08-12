package com.example.Book.modal;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<BookDetails> {
    @Override
    public BookDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BookDetails(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("imageUrl"));
    }
}
