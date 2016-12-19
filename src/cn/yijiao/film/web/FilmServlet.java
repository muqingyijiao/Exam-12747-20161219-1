package cn.yijiao.film.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yijiao.film.entity.Film;
import cn.yijiao.film.service.FilmService;

public class FilmServlet extends HttpServlet {

	private FilmService filmService = new FilmService();

	/**
	 * 
	 */
	private static final long serialVersionUID = -5660094138197954492L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String submitFlag = req.getParameter("submitFlag");
		if (submitFlag.equals("toList")) {
			List<Film> list = filmService.getAll();
			req.setAttribute("list", list);
			req.getRequestDispatcher("/film/filmList.jsp").forward(req, resp);
			// System.out.println(list);
		} else if (submitFlag.equals("add")) {

			Film film = new Film();
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String language = req.getParameter("language");
			film.setDescription(description);
			film.setTitle(title);
			film.setLanguage_id(filmService.getLanguageId(language));
			filmService.add(film);
			req.getRequestDispatcher("/film?submitFlag=toList").forward(req, resp);
		} else if (submitFlag.equals("toUpdate")) {
			
			String filmId = req.getParameter("film_id");
			Film film = filmService.getByFilmId(Integer.parseInt(filmId));
			req.setAttribute("film", film);
			req.getRequestDispatcher("/film/update.jsp").forward(req, resp);
			
		} else if (submitFlag.equals("update")) {
			
			String filmId = req.getParameter("filmId");
			//System.out.println(filmId);
			Film film = filmService.getByFilmId(Integer.parseInt(filmId));
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String language = req.getParameter("language");
			//System.out.println(language);
			//System.out.println(filmService.getLanguageId(language)+"hh");
			film.setDescription(description);
			film.setTitle(title);
			film.setLanguage_id(filmService.getLanguageId(language));
			filmService.update(film);
			req.getRequestDispatcher("/film?submitFlag=toList").forward(req, resp);
		}
		
		else if(submitFlag.equals("toDelete")){
			//System.out.println("ddd");
			String filmId = req.getParameter("film_id");
			//System.out.println(filmId);
			filmService.delete(Integer.parseInt(filmId));
			req.getRequestDispatcher("/film?submitFlag=toList").forward(req, resp);
			
		}
	}
}
