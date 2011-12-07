package semola;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.*;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class RDFServlet extends HttpServlet {
	private static final long serialVersionUID = -5485387849338180912L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("Nothing to see here");
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String input, inputType, outputType, content;
		
		Model model = ModelFactory.createDefaultModel();
		
		input = req.getParameter("input");
		if ((input == null) || (input == null) || (input == null)) {
			resp.sendError(500, "You should provide : input, inputType, outputType");
		}
		else {
			// Parse input
			model.read(new ByteArrayInputStream(input.getBytes()), null);
			model.write(resp.getWriter(), null);
		}
		
	}
}