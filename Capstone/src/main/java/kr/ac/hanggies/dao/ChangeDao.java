package kr.ac.hanggies.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChangeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public boolean updateChangeState(String sid) {
	
		String sqlStatement = "update patient set needChange=? " + "where sid=?" ;
	
		return (jdbcTemplate.update(sqlStatement,
					new Object[] { false, sid }) == 1 );
	}

}
