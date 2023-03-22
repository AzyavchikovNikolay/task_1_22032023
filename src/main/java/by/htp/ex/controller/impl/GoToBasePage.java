package by.htp.ex.controller.impl;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GoToBasePage implements Command {

	private static final String LATEST_NEWS = "latestNews";
	private static final String LOCAL = "local";
	private static final String WELCOME = "welcome";
	private static final String GUEST = "guest";

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<News> latestNews;
		try {
			latestNews = newsService.latestList(5);
			request.getSession().setAttribute(LATEST_NEWS, latestNews);
			Locale defaultLocale = Locale.getDefault();
			String locale = defaultLocale.getLanguage();
			if (request.getSession().getAttribute(LOCAL) == null) {
				request.getSession().setAttribute(LOCAL, locale);
			}
			request.getSession().setAttribute(WELCOME, GUEST);
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {
			request.getRequestDispatcher("/WEB-INF/pages/tiles/error.jsp").forward(request, response);
		}
	}
}
