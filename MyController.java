package com.infotech.app.controller;

import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infotech.app.injection.DbInjection;
import com.infotech.app.injection.MsgInjection;
import com.infotech.app.model.Book;

@RestController
public class MyController {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(final DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Autowired
	private DbInjection dbInj;

	public DbInjection getDbInj() {
		return this.dbInj;
	}

	@Autowired
	private MsgInjection msgInj;

	public MsgInjection getMsgInj() {
		return this.msgInj;
	}

	@GetMapping("/")
	public String hello() throws Exception {
		String production = getDbInj().getMessage() + " [ URL: " + getDbInj().getDatasource() + ", Username: "
				+ getDbInj().getUsername() + ", Password: " + getDbInj().getPassword() + ", Database: "
				+ dataSource.getConnection().getCatalog() + "]";
		System.out.println(production);
		return production;
	}

	@GetMapping("/all/book")
	public List<Book> findAll() {

		List<Book> books = jdbcTemplate.query("select * from book", new BeanPropertyRowMapper(Book.class));
		for (Book book : books) {
			System.out.println(book.getTitle());
			System.out.println(book.getAuthors());
			System.out.println(book.getStock());
			System.out.println(book.getPrice());
		}

		return books;
	}

	@GetMapping("/inject/message")
	public String getJsonText() {
		String message = getMsgInj().getAlert() + "," + "" + getMsgInj().getError() + "," + "" + getMsgInj().getText()
				+ "," + "" + getMsgInj().getWarning();
		return message;
	}
}
