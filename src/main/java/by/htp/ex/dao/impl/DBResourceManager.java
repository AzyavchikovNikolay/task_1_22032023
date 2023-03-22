package by.htp.ex.dao.impl;

import java.util.ResourceBundle;

public class DBResourceManager {

	private static final String DATABASE = "database.db";

	private final static DBResourceManager instance = new DBResourceManager();

	private ResourceBundle bundle = ResourceBundle.getBundle(DATABASE);

	public static DBResourceManager getInstance() {
		return instance;
	}

	public String getValue(String key) {
		return bundle.getString(key);
	}
}
