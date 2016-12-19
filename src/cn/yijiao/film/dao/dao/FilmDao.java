package cn.yijiao.film.dao.dao;

import java.sql.Connection;
import java.util.List;

import cn.yijiao.film.entity.Film;

public interface FilmDao {

	public List<Film> findAll(Connection conn);

	public void insert(Connection conn, Film film);

	public void delete(Connection conn, int filmId);

	public void update(Connection conn, Film film);
	
	public Film getByFilmId(Connection conn,int filmId);
	
	public int getLanguageId(Connection conn,String name);

}
