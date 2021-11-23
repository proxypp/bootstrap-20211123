package co.micol.bootstrap.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bootstrap.comm.Command;

public class MainCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		return "main/main";
	}

}
