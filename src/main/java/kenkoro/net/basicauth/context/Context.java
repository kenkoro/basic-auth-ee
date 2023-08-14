package kenkoro.net.basicauth.context;

public interface Context {
    String LOGIN_DISPATCHER = "login.jsp";
    String INDEX_DISPATHCER = "index.jsp";
    String REGISTER_DISPATCHER = "registration.jsp";

    String DB_URL = "jdbc:mysql://localhost:3306/basic_auth_ee?useSSL=false";
    String DB_USER = "root";
    String DB_PWD = "669631478910097";

    String LOAD_MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    String REGISTER_SUCCESS = "success";
    String REGISTER_FAIL = "failed";
}
