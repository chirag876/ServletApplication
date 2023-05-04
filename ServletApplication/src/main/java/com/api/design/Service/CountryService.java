package com.api.design.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.design.Entity.Country;
import com.api.design.Repository.CountryRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.http.HttpServlet;

@Service
public class CountryService extends HttpServlet {

	public static Connection getConnection() {
		Connection con = null;
		try {

			String dbDriver = "com.mysql.jdbc.Driver";
			String dbURL = "jdbc:mysql:// localhost:3306/";
			// Database name to access
			String dbName = "Country";
			String dbUsername = "root";
			String dbPassword = "chirag";

			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	private final CountryRepository countryRepository;

	@Autowired
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	public static int saveCountry(Country country) {

		int status = 0;
		try {
			Connection con = CountryService.getConnection();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO country_tbl (id, name, population) values(?, ?, ?);");
			ps.setInt(1, country.getId());
			ps.setString(2, country.getName());
			ps.setInt(3, country.getPopulation());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;

	}
}
