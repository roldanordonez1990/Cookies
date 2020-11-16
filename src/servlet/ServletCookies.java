package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCookies
 */
@WebServlet(name = "/ServletCookies", urlPatterns = { "/ServletCookies" })
public class ServletCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCookies() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		Cookie[] total = request.getCookies();

		PrintWriter out = response.getWriter();

		String botonCrear = request.getParameter("crear");
		String botonModificar = request.getParameter("modificar");
		String botonEliminar = request.getParameter("eliminar");

		String nombre = request.getParameter("nombre");
		String valor = request.getParameter("valor");

		if (botonCrear != null) {

			Cookie cookie = new Cookie(nombre, valor);

			// out.println(cookie.getName() + cookie.getValue());

			response.addCookie(cookie);

			System.out.println(cookie.getName() + "-" + cookie.getValue());

			response.sendRedirect("index.jsp");
		}

		if (botonModificar != null) {

			for (Cookie co : total) {

				if (co.getName().equals(nombre)) {

					co.setValue(valor);

					response.addCookie(co);
					response.sendRedirect("index.jsp");
					System.out.println("modificada");
				}

			}

		}

		if (botonEliminar != null) {

			Cookie c = null;

			for (Cookie co : total) {

				if (co.getName().equals(nombre)) {
					c = co;
					c.setMaxAge(0);
					c.setValue("");
					response.addCookie(c);
					response.sendRedirect("index.jsp");
				}

			}

		}
	}

}
