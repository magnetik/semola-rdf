package org.magnetik.semola;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.*;

/**
 * Jena Libs should be placed in war/WEB-INF/lib/ directory
 */
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class SparQLServlet extends HttpServlet {
	private static final long serialVersionUID = -3566925951320590765L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("Nothing to see here");
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String input, inputType, outputType, queryString, result;
		
		Model model = ModelFactory.createDefaultModel();
		
		input = req.getParameter("input");
		queryString = req.getParameter("query");
		outputType = req.getParameter("outputType");
		inputType = req.getParameter("inputType");
		
		if ((input == null) || (outputType == null) || (inputType == null) || (queryString == null)) {
			resp.sendError(500, "You should provide : input, query, inputType, outputType");
		}
		//TODO : check outputType
		else {
			// Reading input
			model.read(new ByteArrayInputStream(input.getBytes()), null, inputType);
			
			// Executing query
			Query query = QueryFactory.create(queryString);
			QueryExecution qe = QueryExecutionFactory.create(query, model);
			ResultSet results = qe.execSelect();
			
			// TODO: other output style
			result = ResultSetFormatter.asText(results);
			
			// Writing output
			resp.getWriter().println(result);
		}
		
	}
}