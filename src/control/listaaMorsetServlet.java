package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Morse;
import model.dao.morseDAO;

@WebServlet("/lista")
public class listaaMorsetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public listaaMorsetServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		morseDAO morse = new morseDAO();
		List<Morse> morset = morse.findAll();
		
		request.setAttribute("morset", morset);
		
		String jsp = "/view/listaaMorset.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
