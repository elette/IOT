import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

// This class starts the Web server which hosts the servlets for displaying streams data using Dojo Charts

public class StartServer {
  public static void main(String[] args) throws Exception{	
    int port = (args.length > 0) ? Integer.parseInt(args[0]) : 8081;	

    Server server = new Server(port);
    ServletContextHandler root = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);

    root.addServlet(new ServletHolder(new ChartServlet()), "/*");
    root.addServlet(new ServletHolder(new DataServlet()), "/data/*");
				
    try {
      server.start();
      server.join();
    } 
    catch (Exception e) {
      server.stop();
    }	
  }
}
