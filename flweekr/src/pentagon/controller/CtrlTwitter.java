package pentagon.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pentagon.action.Action;
import pentagon.action.ActionMap;
import pentagon.action.SendTweet;
import pentagon.action.TwitterLogin;
import pentagon.action.TwitterLogout;
import pentagon.twitterlab.Model;

/**
 * Servlet implementation class TestTwitter
 */
@WebServlet(urlPatterns = { "*.tw" }, initParams = {
		@WebInitParam(name = "API_key", value = "RlwN23E3OgcGV6wCJzA0A"),
		@WebInitParam(name = "API_secret", value = "uHM1wCrDHK7JoCF7uV4aetM6ujVbUtTTYOyT70MKyK4") })
public class CtrlTwitter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;
	private final String jspPath = "/WEB-INF/";
	private ActionMap actions;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.model = new Model(config);
		actions = new ActionMap();
		// add actions
		actions.addAction(new TwitterLogin(model));
		actions.addAction(new TwitterLogout());
		actions.addAction(new SendTweet(model));
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
			String nextStep = processRequest(request);
			proceedToNext(nextStep, request, response);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private String processRequest(HttpServletRequest request) {
		String actionName = getActionName(request.getServletPath());
		Action action = actions.getAction(actionName);
		if (action == null) {
			System.out.println(actionName);
			return "404";
		} else {
			return action.perform(request);
		}
	}

	private void proceedToNext(String nextStep, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (nextStep.endsWith(".tw")) {
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
