package pentagon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.genericdao.RollbackException;

public interface Action {
	public String perform(HttpServletRequest request,
			HttpServletResponse response) throws RollbackException;

	public String getName();
}
