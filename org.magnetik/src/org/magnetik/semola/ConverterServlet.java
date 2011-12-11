package org.magnetik.semola;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.*;

/**
 * Jena Libs should be placed in war/WEB-INF/lib/ directory
 */
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ConverterServlet extends HttpServlet {
	private static final long serialVersionUID = -5485387849338180912L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("Nothing to see here");
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String input, inputType, outputType;
		
		Model model = ModelFactory.createDefaultModel();
		
		input = req.getParameter("input");
		outputType = req.getParameter("outputType");
		inputType = req.getParameter("inputType");
		
		if ((input == null) || (outputType == null) || (inputType == null)) {
			resp.sendError(500, "You should provide : input, inputType, outputType");
		}
		//TODO : check outputType
		else {
			System.out.println("Converting input from " + inputType + " to " + outputType);
			// Reading input
			model.read(new ByteArrayInputStream(input.getBytes()), null, inputType);
			
			// Writing output
			model.write(resp.getWriter(), outputType);
		}
		
	}
}