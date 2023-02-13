package com.slokam.SpringbootJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustController1 {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("getbyid/{id}")
    public Cust getcustById(@PathVariable(name="id") Integer id) {
		System.out.println("ID::"+id);
		Cust c=null;
		c= jdbcTemplate.queryForObject("select * from Cust where id=?" ,new  
				BeanPropertyRowMapper<Cust>(Cust.class),id);
		return c;
	}

}
