package dam2.dii.p21.service;

import dam2.dii.p21.config.ConfigService;
import dam2.dii.p21.dao.UserDAO;
import dam2.dii.p21.dao.UserDAOJDBC;
import dam2.dii.p21.dao.UserDAOinMem;

public class PersistenceService {
  public static UserDAO getUserDAO() {
    String mode = ConfigService.getInstance().getParametro("app.persistence");
    if (mode.equals("jdbc")) {
      return UserDAOJDBC.getInstance();
    } else {
      return UserDAOinMem.getInstance();
    }
  }
}
