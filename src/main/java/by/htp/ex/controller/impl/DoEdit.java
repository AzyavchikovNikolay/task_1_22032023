package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.htp.ex.bean.News;

public class DoEdit implements Command {

	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	private static final String JSP_NEWS_TITLE_PARAM = "titleEdit";
	private static final String JSP_BRIEF_PARAM = "briefEdit";
	private static final String JSP_CONTENT_PARAM = "contentEdit";
	private static final String JSP_STATUS_PARAM = "statusNewsEdit";
	private static final String SESSION_WARNING = "session_warning";
	private static final String WARNING = "warning";
	private static final String ID_PREVIOUS_NEWS = "idPre";
	private static final String EDIT = "edit";
	private static final String ID_USER = "idUser";
	private static final String EDIT_RESULT = "edit_result";
	private static final String SUCCESS = "success";
	private static final String ID_NEWS = "id";


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String titleEditNews = request.getParameter(JSP_NEWS_TITLE_PARAM);
		String briefEditNews = request.getParameter(JSP_BRIEF_PARAM);
		String contentEditNews = request.getParameter(JSP_CONTENT_PARAM);
		String statusEditNews = request.getParameter(JSP_STATUS_PARAM);
		int idUser = 0;

		try {
			CommandSecurity checkCommand = new CommandSecurity();
			checkCommand.checkCommandSecurity(request, response);

			if (request.getSession() == null) {
				request.getSession(true).setAttribute(SESSION_WARNING, WARNING);
				response.sendRedirect("controller?command=go_to_base_page");
			}
			int idEditNews = Integer.valueOf((String) request.getSession(true).getAttribute(ID_PREVIOUS_NEWS));
			//int idEditNews = Integer.valueOf((String) request.getParameter(ID_NEWS));
			News newsEdit = new News(idEditNews, titleEditNews, briefEditNews, contentEditNews, "0", statusEditNews);
			String check = "";
			if (check.equals(titleEditNews) || check.equals(briefEditNews) || check.equals(contentEditNews)
					|| check.equals(statusEditNews)) {
				request.getSession().setAttribute(EDIT, WARNING);
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			} else {
				idUser = (int) (request.getSession().getAttribute(ID_USER));
				newsService.update(newsEdit, idUser);
				request.getSession().setAttribute(EDIT_RESULT, SUCCESS);
				request.getSession(true).setAttribute(ID_PREVIOUS_NEWS, Integer.toString(idEditNews));
				response.sendRedirect("controller?command=go_to_view_news");
			}
		} catch (ServiceException e) {
			request.getRequestDispatcher("/WEB-INF/pages/tiles/error.jsp").forward(request, response);
		}
	}
}