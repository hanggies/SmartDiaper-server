package kr.ac.hanggies.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hanggies.model.History;
import kr.ac.hanggies.model.Patient;

@Repository
public class HistoryDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean addHistory(String sid, String sig) {

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
	
	public List<History> getHistoryById(String sid) {
		String sqlStatement = "select h.id, h.sid, p.name, p.room, h.time, h.signal\r\n" + 
				"from history h, patient p\r\n" + 
				"where h.sid = p.sid and h.sid\r\n" +
				"ORDER BY h.id ASC"; // record -> object
			
		return jdbcTemplate.query(sqlStatement, new Object[] { sid }, new RowMapper<History>() {

			@Override
			public History mapRow(ResultSet rs, int rowNum) throws SQLException {
				History history = new History();
				history.setId(rs.getString("id"));
				history.setSid(rs.getString("sid"));
				history.setName(rs.getString("name"));
				history.setRoom(rs.getString("room"));
				history.setTime(rs.getString("time"));
				history.setSignal(rs.getString("signal"));

				return history;
			}

		});
	}
	
	public List<History> getAllHistory() {

		String sqlStatement = "select h.id, h.sid, p.name, p.room, h.time, h.signal\r\n" + 
				"from history h, patient p\r\n" + 
				"where h.sid = p.sid\r\n" +
				"ORDER BY h.id ASC"; // record -> object

		return jdbcTemplate.query(sqlStatement, new RowMapper<History>() {

			@Override
			public History mapRow(ResultSet rs, int rowNum) throws SQLException {
				History history = new History();
				history.setId(rs.getString("id"));
				history.setSid(rs.getString("sid"));
				history.setName(rs.getString("name"));
				history.setRoom(rs.getString("room"));
				history.setTime(rs.getString("time"));
				history.setSignal(rs.getString("signal"));

				return history;
			}
		});
	}

}
