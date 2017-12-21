package config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet(urlPatterns = "/StartUp", loadOnStartup = 1, asyncSupported = true)
public class StartUp extends HttpServlet{
	
    /**
	 * This Servlet was developed to load the ApplicationContext on Start up
	 * and register a shutdown hook to close it on shutdown.
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
        try {
             Constants.context = new ClassPathXmlApplicationContext("spring.xml");
             Constants.context.registerShutdownHook();
	        	
        } catch (Exception e){
            System.out.println("Error: Could not load resource: spring.xml");
        }
        
//        System.out.println("WELCOME TO XCHANGE");
//    	APIMethods api = new APIMethods();
//    	System.out.println(api.getAllUsers());
    }
}