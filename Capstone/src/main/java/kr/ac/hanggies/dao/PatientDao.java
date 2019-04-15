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

	/*
	 * public List<Patient> getPatients() {
	 * 
	 * String sqlStatement = "select * from patient"; // record -> object
	 * 
	 * return jdbcTemplate.query(sqlStatement, new RowMapper<Patient>() {
	 * 
	 * @Override public Patient mapRow(ResultSet rs, int rowNum) throws SQLException
	 * {
	 * 
	 * Patient patient = new Patient();
	 * 
	 * patient.setId(rs.getInt("id")); patient.setName(rs.getString("name"));
	 * patient.setCategory(rs.getString("category"));
	 * patient.setPrice(rs.getInt("price"));
	 * patient.setManufacturer(rs.getString("manufacturer"));
	 * patient.setUnitInStock(rs.getInt("unitInStock"));
	 * patient.setDescription(rs.getString("description"));
	 * 
	 * return patient; }
	 * 
	 * }); }
	 */

	public List<Patient> getRoomPatients(String room) {

		String sqlStatement = "select * from patient where room = ?"; // record -> object

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

		String sqlStatement = "select * from patient"; // record -> object

		return jdbcTemplate.query(sqlStatement, new RowMapper<Patient>() {

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

	/*
	 * public boolean addPatient(Patient patient) {
	 * 
	 * String name = patient.getName(); String category = patient.getCategory(); int
	 * price = patient.getPrice(); String manufacturer = patient.getManufacturer();
	 * int unitInStock = patient.getUnitInStock(); String description =
	 * patient.getDescription();
	 * 
	 * String sqlStatement = "insert into estore.patient (name, category, price" +
	 * ", manufacturer, unitInStock, description) values (?, ?, ?, ?, ?, ?)";
	 * 
	 * return (jdbcTemplate.update(sqlStatement, new Object[] { name, category,
	 * price, manufacturer, unitInStock, description }) == 1); }
	 * 
	 * public boolean deletePatient(int id) {
	 * 
	 * String sqlStatement = "delete from patient where id = ?";
	 * 
	 * return (jdbcTemplate.update(sqlStatement, new Object[] { id }) == 1); }
	 * 
	 * public Patient getPatientById(int id) { String sqlStatement =
	 * "select * from patient where id = ?"; // record -> object
	 * 
	 * return jdbcTemplate.queryForObject(sqlStatement, new Object[] { id }, new
	 * RowMapper<Patient>() {
	 * 
	 * @Override public Patient mapRow(ResultSet rs, int rowNum) throws SQLException
	 * {
	 * 
	 * Patient patient = new Patient();
	 * 
	 * patient.setId(rs.getInt("id")); patient.setName(rs.getString("name"));
	 * patient.setCategory(rs.getString("category"));
	 * patient.setPrice(rs.getInt("price"));
	 * patient.setManufacturer(rs.getString("manufacturer"));
	 * patient.setUnitInStock(rs.getInt("unitInStock"));
	 * patient.setDescription(rs.getString("description"));
	 * 
	 * return patient; }
	 * 
	 * }); }
	 * 
	 * public boolean updatePatient(Patient patient) { int id = patient.getId();
	 * String name = patient.getName(); String category = patient.getCategory(); int
	 * price = patient.getPrice(); String manufacturer = patient.getManufacturer();
	 * int unitInStock = patient.getUnitInStock(); String description =
	 * patient.getDescription();
	 * 
	 * String sqlStatement = "update patient set name=?, category=?, price=?" +
	 * ", manufacturer=?, unitInStock=?, description=? where id=?";
	 * 
	 * return (jdbcTemplate.update(sqlStatement, new Object[] { name, category,
	 * price, manufacturer, unitInStock, description, id}) == 1);
	 * 
	 * }
	 */

}