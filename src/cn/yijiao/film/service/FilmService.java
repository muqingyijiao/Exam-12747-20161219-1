package cn.yijiao.film.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.yijiao.customer.entity.Customer;
import cn.yijiao.film.dao.factory.FilmDaoFactory;
import cn.yijiao.film.entity.Film;
import cn.yijiao.utils.JDBCUtil;

public class FilmService {

	public List<Film> getAll() {
		Connection conn = new JDBCUtil().getConnection();
		List<Film> list = new FilmDaoFactory().getFilmDao().findAll(conn);
		return list;
	}

	public void add(Film film) {
		Connection conn = new JDBCUtil().getConnection();
		new FilmDaoFactory().getFilmDao().insert(conn, film);
	}

	public int getLanguageId(String name) {

		Connection conn = new JDBCUtil().getConnection();
		return new FilmDaoFactory().getFilmDao().getLanguageId(conn, name);

	}

	public Film getByFilmId(int filmId) {
		Connection conn = new JDBCUtil().getConnection();
		return new FilmDaoFactory().getFilmDao().getByFilmId(conn, filmId);
	}

	public void update(Film film) {
		Connection conn = new JDBCUtil().getConnection();
		new FilmDaoFactory().getFilmDao().update(conn, film);
	}

	public void delete(int filmId) throws SQLException {
		Connection conn = new JDBCUtil().getConnection();
		new FilmDaoFactory().getFilmDao().delete(conn, filmId);
	}

	public List<String> getLanguage() {
		Connection conn = new JDBCUtil().getConnection();

		return new FilmDaoFactory().getFilmDao().getLanguage(conn);

	}
	// public void deleteCascade(int filmId){
	// Connection conn = new JDBCUtil().getConnection();
	//
	// new FilmDaoFactory().getFilmDao().delete(conn, filmId);
	//
	// }
}
