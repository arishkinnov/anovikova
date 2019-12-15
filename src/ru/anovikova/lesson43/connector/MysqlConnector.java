package ru.anovikova.lesson43.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnector {
  private static final String driverName = "com.mysql.cj.jdbc.Driver";
  private static final String connectionString = "jdbc:mysql://127.0.0.1:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  private static final String login = "root";
  private static final String password = "";

  public static Connection getConnection() {
    try {
      Class.forName(driverName);
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException("Can't get class. No driver found", e);
    }
    try {
      Connection connection = DriverManager.getConnection(connectionString, login, password);
      Statement statement = connection.createStatement();

      //отключение режима ONLY_FULL_GROUP_BY для mysql
      //необходим для группировки запросов по одному полю
      statement.executeQuery(
          "SET sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION'");
      return connection;
    } catch (SQLException e) {
      throw new IllegalStateException("Can't get connection. Incorrect URL", e);
    }

  }

  public static void closeConnection(Connection connection) {
    try {
      connection.close();
    } catch (SQLException e) {
      throw new IllegalStateException("Can't close connection", e);
    }
  }

}
