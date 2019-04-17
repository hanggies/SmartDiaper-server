package kr.ac.hanggies.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean addProduct(String sid, String sig) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월dd일 HH시mm분ss초");

		Date date = new Date();

		String time = format.format(date);

		if (sig.equals("sensing"))
			sig = "감지";
		else if (sig.equals("change"))
			sig = "교체";

		String sqlStatement = "INSERT INTO `smartdiaper`.`history` (`sid`, `time`, `signal`) " + "VALUES (?, ?, ?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { sid, time, sig }) == 1);
	}

}
