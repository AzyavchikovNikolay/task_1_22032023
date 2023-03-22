package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToEditNews implements Command {

	private static final String ID = "id";
	private static final String SESSION_WARNING = "session_warning";
	private static final String WARNING = "warning";
	private static final String PREVIOUS_ID_NEWS = "idPre";
	private static final String NEWS_VIEW = "newsView";
	private static final String PRESENTATION = "presentation";
	private static final String EDIT = "edit";

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		News newsView;
		String id;
		id = request.getParameter(ID);
		try {
			if (request.getSession() == null) {
				request.getSession(true).setAttribute(SESSION_WARNING, WARNING);
				response.sendRedirect("controller?command=go_to_base_page");
			}
			request.getSession().setAttribute(PREVIOUS_ID_NEWS, id);
			newsView = newsService.findById(Integer.parseInt(id));
			request.getSession().setAttribute(NEWS_VIEW, newsView);
			request.getSession().setAttribute(PRESENTATION, EDIT);
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {
			request.getRequestDispatcher("/WEB-INF/pages/tiles/error.jsp").forward(request, response);
		}
	}
}
