package kr.ac.hanggies.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hanggies.model.Patient;
import kr.ac.hanggies.model.State;

@Repository
public class PatientDao {
	private JdbcTemplate jdbcTemplate;

	// DataSource를 JdbcTemplate에 Dependency Injection
	@Autowired
	public void setDataSource(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public List<State> getRooms() {

		String sqlStatement = "select distinct room, needChange from patient"; // record -> object

		return jdbcTemplate.query(sqlStatement, new RowMapper<State>() {

			@Override
			public State mapRow(ResultSet rs, int rowNum) throws SQLException {
				State roomState = new State();
				roomState.setRoomNumber(rs.getString("room"));
				roomState.setNeedChange(rs.getInt("needChange"));

				return roomState;
			}
		});
	}


	public List<Patient> getRoomPatients(String room) {

		String sqlStatement = "select p.sid, p.name, p.room, p.needChange, h.time\r\n" + 
				"from history h, patient p\r\n" + 
				"where h.sid = p.sid and p.room = ? and h.time = (select max(h2.time)\r\n" + 
				"from history h2\r\n" + 
				"where h2.sid = h.sid)\r\n" + 
				"order by room asc"; // record -> object

		return jdbcTemplate.query(sqlStatement, new Object[] { room }, new RowMapper<Patient>() {

			@Override
			public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
				Patient patient = new Patient();
				patient.setSid(rs.getString("sid"));
				patient.setName(rs.getString("name"));
				patient.setRoom(rs.getString("room"));
				patient.setNeedChange(rs.getInt("needChange"));

				return patient;
			}
		});
	}

	public List<Patient> getAllPatients() {

		String sqlStatement = "select p.sid, p.name, p.room, p.needChange, h.time\r\n" + 
				"from history h, patient p\r\n" + 
				"where h.sid = p.sid and h.time = (select max(h2.time)\r\n" + 
				"from history h2\r\n" + 
				"where h2.sid = h.sid)\r\n" +
				"order by room asc"; // record -> object

		return jdbcTemplate.query(sqlStatement, new RowMapper<Patient>() {

			@Override
			public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
				Patient patient = new Patient();
				patient.setSid(rs.getString("sid"));
				patient.setName(rs.getString("name"));
				patient.setRoom(rs.getString("room"));
				patient.setNeedChange(rs.getInt("needChange"));
				patient.setTime(rs.getString("time"));

				return patient;
			}
		});
	}

	public boolean updatePatient(Patient patient) {
		String sid = patient.getSid();
		String name = patient.getName();
		String room = patient.getRoom();

		String sqlStatement = "update patient set name=?, room=? where sid=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { name, room, sid }) == 1);
	}

	public boolean deletePatient(String sid) {
		String sqlStatement = "delete from patient where sid = ?";
		return (jdbcTemplate.update(sqlStatement, new Object[] { sid }) == 1);
	}

	public Patient getPatientById(String sid) {
		String sqlStatement = "select * from patient where sid = ?"; // record -> object

		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { sid }, new RowMapper<Patient>() {

			@Override
			public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {

				Patient patient = new Patient();

				patient.setSid(rs.getString("sid"));
				patient.setName(rs.getString("name"));
				patient.setRoom(rs.getString("room"));

				System.out.println(patient);
				return patient;
			}

		});
	}

	public boolean addPatient(Patient patient) {
		
		String sid = patient.getSid();
		String name = patient.getName();
		String room = patient.getRoom();
		int needChange = 0;

		String sqlStatement = "insert into patient (sid, name, room, needChange) values (?, ?, ?, ?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { sid, name, room, needChange }) == 1);
	}

}