package cn.yijiao.film.dao.factory;

import cn.yijiao.film.dao.dao.FilmDao;
import cn.yijiao.film.dao.impl.FilmImpl;

public class FilmDaoFactory {

	public FilmDao getFilmDao() {
		return new FilmImpl();
	}
}
