import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// This servlet serves the source page containing Dojo charts with streams data and it serves the dependent Dojo files

@SuppressWarnings("serial")
public class ChartServlet extends HttpServlet {
  public ChartServlet() {}

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Determine which file to serve
    String fileName = request.getPathInfo().substring(1);
    if (fileName.length() == 0) {
        fileName = "index.html";
    }

    response.setStatus(HttpServletResponse.SC_OK);

    // Read the page source from the file system
    PrintWriter writer = response.getWriter();
    File fileToServe = new File(fileName);
    Scanner read = new Scanner(fileToServe);
        
    // Write the page content to the response
    while(read.hasNext()){
      writer.println(read.nextLine());
    }

    writer.close();
    read.close();
  }
}
