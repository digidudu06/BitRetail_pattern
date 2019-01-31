package factory;

import enums.Vendor;

public class DatabaseFactory {
	public static Database creataDatabase(Vendor v) {
		Database db = null;
		switch (v) {
		case ORACLE:
			db = new Oracle();
			break;

		default:
			break;
		}
		return db;
	}
}
