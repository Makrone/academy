package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import domain.User;

public class UserService {

	public UserService() {
		super();
	}

	private static Map<String, User> users = new HashMap<>();

	public void create(User user) {

		users.put(user.getUsername(), user);
	}

	public List<User> getAllUsers() {
		return new ArrayList<>(users.values());
	}

	public User getByUsername(String username) {
		return users.get(username);
	}

	public boolean checkPassword(String username, String password) throws Exception {
		User user = users.get(username);
		if (user != null) {
			if (!Objects.equals(user.getPassword(), password)) {
				throw new Exception("Password is not correct");
			}
		} else {
			throw new Exception("User not found");
		}
		return true;
	}
}
