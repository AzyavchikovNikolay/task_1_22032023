package by.htp.ex.controller.impl;

import java.io.IOException;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoDeleteSelectedNews implements Command {

	private static final String ID_NEWS = "idNews";
	private static final String SESSION_WARNING = "session_warning";
	private static final String WARNING = "warning";
	private static final String DELETE_SELECTED_NEWS = "delete_selected_news";
	private static final String LATEST_NEWS = "latestNews";
	private static final String NEWS = "news";
	private static final String SUCCESS = "success";

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] idNewses = request.getParameterValues(ID_NEWS);		
		List<News> latestNews;
		List<News> allNews;

		try {
			CommandSecurity checkCommand = new CommandSecurity();
			checkCommand.checkCommandSecurity(request, response);

			if (request.getSession() == null) {
				request.getSession(true).setAttribute(SESSION_WARNING, WARNING);
				response.sendRedirect("controller?command=go_to_base_page");
			}

			if (idNewses == null) {
				request.getSession().setAttribute(DELETE_SELECTED_NEWS, WARNING);
				response.sendRedirect("controller?command=go_to_news_list");
			} else {
				newsService.deleteNewses(idNewses);
				latestNews = newsService.latestList(5);
				request.getSession().setAttribute(LATEST_NEWS, latestNews);
				allNews = newsService.list();
				request.getSession().setAttribute(NEWS, allNews);
				request.getSession().setAttribute(DELETE_SELECTED_NEWS, SUCCESS);
				response.sendRedirect("controller?command=go_to_news_list");
			}
		} catch (ServiceException e) {
			request.getRequestDispatcher("/WEB-INF/pages/tiles/error.jsp").forward(request, response);
		}
	}
}
