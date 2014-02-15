package pentagon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pentagon.action.Action;
import pentagon.action.ActionMap;
import pentagon.action.Search;
import pentagon.action.GetDetail;
import pentagon.action.SendStatus;
import pentagon.action.SetCookie;
import pentagon.action.SetMap;
import pentagon.action.TwitterLogin;
import pentagon.action.TwitterLogout;
import pentagon.action.TwitterSearch;
import pentagon.action.TwitterSearchByCoordination;
import pentagon.model.Model;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "*.do" }, initParams = {
		@WebInitParam(name = "twitter_key", value = "RlwN23E3OgcGV6wCJzA0A"),
		@WebInitParam(name = "twitter_secret", value = "uHM1wCrDHK7JoCF7uV4aetM6ujVbUtTTYOyT70MKyK4"),
		@WebInitParam(name = "jdbcName", value = "com.mysql.jdbc.Driver"),
		@WebInitParam(name = "jdbcURL", value = "jdbc:mysql:///trip") })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String jspPath = "/WEB-INF/";
	private ActionMap actions;
	private Model model;

	@Override
	public void init() throws ServletException {
		this.model = new Model(getServletConfig());
		actions = new ActionMap();
		// add actions
		actions.addAction(new Search(model));
		actions.addAction(new GetDetail(model));
		actions.addAction(new SetMap());
		actions.addAction(new TwitterLogin(model));
		actions.addAction(new TwitterLogout());
		actions.addAction(new SendStatus(model));
		actions.addAction(new TwitterSearch(model));
		actions.addAction(new TwitterSearchByCoordination(model));
		actions.addAction(new SetCookie());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String nextStep = processRequest(request, response);
			proceedToNext(nextStep, request, response);
		} catch (Exception e) {
			throw new RuntimeException(e.getCause());
		}
	}

	private String processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		String actionName = getActionName(request.getServletPath());
		Action action = actions.getAction(actionName);
		if (action == null) {
			System.out.println(actionName);
			return "404";
		} else {
			return action.perform(request, response);
		}
	}

	private void proceedToNext(String nextStep, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (nextStep.endsWith(".do")) {
			response.sendRedirect(nextStep);
		} else if (nextStep.endsWith(".jsp")) {
			request.getRequestDispatcher(jspPath + nextStep).forward(request,
					response);
		} else if ("404".equals(nextStep)) {
			response.sendError(404);
		} else {
			response.sendRedirect(nextStep);
		}
	}

	private String getActionName(String path) {
		return path.substring(path.lastIndexOf('/') + 1);
	}

}
