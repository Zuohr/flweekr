package pentagon.action;

import java.util.HashMap;

public class ActionMap {
	private HashMap<String, Action> map;

	public ActionMap() {
		map = new HashMap<String, Action>();
	}

	public boolean addAction(Action action) {
		Action curr = map.get(action.getName());
		if (curr == null) {
			map.put(action.getName(), action);
			return true;
		} else {
			return false;
		}
	}

	public Action getAction(String name) {
		return map.get(name);
	}
}
