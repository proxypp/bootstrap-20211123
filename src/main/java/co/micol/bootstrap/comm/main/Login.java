package co.micol.bootstrap.comm.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bootstrap.comm.Command;

public class Login implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		return "main/login";
	}

}
