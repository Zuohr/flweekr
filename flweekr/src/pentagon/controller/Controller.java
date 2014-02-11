package pentagon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pentagon.action.Action;
import pentagon.action.ActionMap;
import pentagon.action.GetPic;
import pentagon.action.SetMap;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String jspPath = "/WEB-INF/";
	private ActionMap actions;

	@Override
	public void init() throws ServletException {
		actions = new ActionMap();
		//add actions
		actions.addAction(new GetPic());
		actions.addAction(new SetMap());
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
			throw new RuntimeException(e.getCause());
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
		if (nextStep.endsWith(".do")) {
			response.sendRedirect(nextStep);
		} else if (nextStep.endsWith(".jsp")) {
			request.getRequestDispatcher(jspPath + nextStep).forward(request,
					response);
		} else {
			response.sendError(404);
		}
	}

	private String getActionName(String path) {
		return path.substring(path.lastIndexOf('/') + 1);
	}

}
