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
 * Servlet implementation class ServletContadorCookies
 */
@WebServlet("/ServletContadorCookies")
public class ServletContadorCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletContadorCookies() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		Cookie[] cookies = request.getCookies(); // Método para leer todas las cookies en una petición HTTP
		Cookie contador = buscaCookie("contador", cookies);

		if (contador == null) {
			// Creamos la cookie con el contador

			Cookie cookie = new Cookie("contador", "1");
			cookie.setMaxAge(60); //Método que especifica el tiempo en expirar la cookie en segundos
			response.addCookie(cookie); //Método para agregar una cookie a la respuesta

			// Mostramos el mensaje de primera visita

			PrintWriter out = response.getWriter();
			
			out.println("Primera visita");
			

		} else {

			// Obtenemos el valor actual del contador

			int cont = Integer.parseInt(contador.getValue());
			cont++;

			// Modificamos el valor de la cookie
			// incrementando el contador

			Cookie cookie = new Cookie("contador", "" + cont);
			cookie.setMaxAge(60);
			response.addCookie(cookie);

			// Mostramos el numero de visitas

			PrintWriter out = response.getWriter();

			out.println("Visita numero " + cont);

			System.out.println(cont);
		}
	}

	// Busca la cookie 'nombre'
	// en el array de cookies indicado.
	// Devuelve null si no esta

	private Cookie buscaCookie(String nombre, Cookie[] cookies) {
		if (cookies == null) {
			return null;

		} else {
			for (int i = 0; i < cookies.length; i++)
				if (cookies[i].getName().equals(nombre))
					return cookies[i];

		}

		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

	}

}
