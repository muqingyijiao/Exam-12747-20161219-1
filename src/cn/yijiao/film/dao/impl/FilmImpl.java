package cn.yijiao.film.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yijiao.customer.entity.Customer;
import cn.yijiao.film.dao.dao.FilmDao;
import cn.yijiao.film.dao.factory.FilmDaoFactory;
import cn.yijiao.film.entity.Film;
import cn.yijiao.utils.JDBCUtil;

public class FilmImpl implements FilmDao {

	@Override
	public List<Film> findAll(Connection conn) {
		String sql = "select f.*,name from film f,language l where f.language_id=l.language_id ";
		PreparedStatement ps;
		List<Film> list = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<>();

			while (rs.next()) {
				Film film = new Film();
				film.setFilm_id(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setRelease_year(rs.getDate("release_year"));
				film.setLanguage_id(rs.getInt("language_id"));
				film.setOriginal_language_id(rs.getInt("original_language_id"));
				film.setRental_duration(rs.getInt("rental_duration"));
				film.setRental_rate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacement_cost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecial_features(rs.getString("special_features"));
				film.setLast_update(rs.getDate("last_update"));
				film.setLanguage(rs.getString("name"));
				list.add(film);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void insert(Connection conn, Film film) {
		String sql = "insert into film (title,description,language_id) values (?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setInt(3, film.getLanguage_id());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public void delete(Connection conn, int filmId) throws SQLException {
		// delete from film_text t,film_category c,film_actor a,film f where
		// t.film_id=
		// f.film_id and c.film_id
		// = f.film_id and a.film_id = f.film_id and  f.film_id=?
		
		String sql = "delete from film where film_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ps.execute();
			conn.close();

	}

	@Override
	public void update(Connection conn, Film film) {
		String sql = "update film set title=?,description=?,language_id=? where film_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setInt(3, film.getLanguage_id());
			ps.setInt(4, film.getFilm_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public Film getByFilmId(Connection conn, int filmId) {

		String sql = "select film_id,title,description,name from film f,language l where f.language_id=l.language_id and film_id=? ";
		Film film = new Film();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				film.setFilm_id(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setLanguage(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return film;
	}

	@Override
	public int getLanguageId(Connection conn, String name) {

		String sql = "select language_id from language where name=?";
		int id = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("language_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}

	@Override
	public List<String> getLanguage(Connection conn) {

		String sql = "select name from language";
		List<String> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				list.add(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void deleteCascade(Connection conn, int filmId) {
		// TODO Auto-generated method stub
		
	}

	// 测试代码
	// public static void main(String[] args) {
	// Connection conn = new JDBCUtil().getConnection();
	// System.out.println(new FilmDaoFactory().getFilmDao().findAll(conn));
	// }

}
