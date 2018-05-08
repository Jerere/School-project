package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Morse;

public class morseDAO extends DataAccesObject {

	private Morse readMorse(ResultSet rs) {

		try {
			int id = rs.getInt("id");
			String nimimerkki = rs.getString("nimimerkki");
			String teksti = rs.getString("teksti");
			String morsekoodi = rs.getString("morsekoodi");

			return new Morse(id, nimimerkki, teksti, morsekoodi);

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public ArrayList<Morse> findAll() {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Morse morse = null;
		ArrayList<Morse> morset = new ArrayList<Morse>();

		try {
			// LUODAAN YHTEYS
			conn = getConnection();
			// LUODAAN KOMENTO: HAETAAN KAIKKI RIVIT PIZZA-TAULUSTA
			String sqlSelect = "SELECT id, nimimerkki, teksti, morsekoodi FROM morsekanta ;";
			// VALMISTELLAAN KOMENTO
			stmt = conn.prepareStatement(sqlSelect);
			// LÄHETETÄÄN KOMENTO
			rs = stmt.executeQuery();

			while (rs.next()) {
				morse = readMorse(rs);
				morset.add(morse); // LISÄTÄÄN MORSE LISTAAN
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

		finally {
			close(rs, stmt, conn); // SULJETAAN
		}

		return morset;

	}
	
	public void addMorse(Morse morse) throws SQLException {

		Connection connection = null;
		PreparedStatement stmtInsert = null;

		try {
			connection = getConnection();
			String sqlInsert = "INSERT INTO morsekanta (id, nimimerkki, teksti, morsekoodi) VALUES (?,?,?,?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, morse.getId());
			stmtInsert.setString(2, morse.getNimimerkki());
			stmtInsert.setString(3, morse.getTeksti());
			stmtInsert.setString(4, morse.getMorsekoodi());
			stmtInsert.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection);
		}
	}
	
	public void removeMorse(int morseid) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtDelete = null;

		try {
			// LUODAAN YHTEYS
			connection = getConnection();
			//POISTETAAN VIESTI TIETOKANNASTA
			String sqlInsert = "DELETE FROM morsekanta WHERE id = ?";
			stmtDelete = connection.prepareStatement(sqlInsert);
			stmtDelete.setInt(1, morseid);
			stmtDelete.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtDelete, connection); // SULJETAAN STATEMENT JA YHTEYS
		}
	}

}
