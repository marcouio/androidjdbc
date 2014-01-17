package com.molinari.jdbcandroid.wrap;

import android.database.SQLException;

public class ExceptionDB extends SQLException {

	private static final long serialVersionUID = 1L;
	private String message = null;
	private String help = null;

	public ExceptionDB(final String message, final String help) {
		this.message = message;
		this.help = help;
	}

	@Override
	public String getMessage() {
		if (message != null && help != null) {
			return message + " - " + help;
		} else if (help != null) {
			return help;
		} else if (message != null) {
			return message;
		} else {
			return "Metodo non supportato: da non chiamare!";
		}
	}
}
