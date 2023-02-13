package com.slokam.SpringbootJDBC;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustController {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@PostMapping("savecust")
	public void saveCust(@RequestBody Cust cust)
	{
		System.out.println(cust);
		
		jdbctemplate.update("insert into cust values(?,?,?,?)",
				cust.getId(),cust.getName(),cust.getEmail(),cust.getPhone());
	}

}
