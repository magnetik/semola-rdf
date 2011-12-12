package org.magnetik.semola;
 
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.*;

/**
 * Jena Libs should be placed in war/WEB-INF/lib/ directory
 */
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFReader;

import net.rootdev.javardfa.jena.*;

public class ConverterServlet extends HttpServlet {
	private static final long serialVersionUID = -5485387849338180912L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
         resp.sendError(405);
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String input, inputType, outputType;
		
		try {
			Class.forName("net.rootdev.javardfa.jena.RDFaReader");
		} catch (ClassNotFoundException e) {
			System.out.println("WAHHHHHHHHHH");
		}
		
		Model model = ModelFactory.createDefaultModel();
		
		input = req.getParameter("input");
		outputType = req.getParameter("outputType");
		inputType = req.getParameter("inputType");
		
		RDFReader reader = model.getReader(inputType);
		
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