package dam2.dii.p21.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.log4j.Logger;

@WebListener
public class ConfigServletContextListener implements ServletContextListener {

  public ConfigServletContextListener() {}


  public void contextDestroyed(ServletContextEvent event) {
    Logger.getLogger("generic").info("ServletContext down");
  }

  public void contextInitialized(ServletContextEvent event) {
    String realPath = event.getServletContext().getRealPath("");
    String classPath = realPath + "\\WEB-INF\\classes\\dam2\\dii\\p21\\";
    ConfigService.getInstance().initConfig(classPath);
    Logger.getLogger("generic").info("ServletContext up");
  }

}
