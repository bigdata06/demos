package org.said.utils;

/**
 * Created by BigdataArchitect on 2018-01-23.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Sample program to test MySQL database connection
 */


    public class AppDB {

    private static final String EMPLOYEE_TABLE = "create table MyEmployees3 ( "
            + "   id INT PRIMARY KEY, firstName VARCHAR(20), lastName VARCHAR(20), "
            + "   title VARCHAR(20), salary INT )";
    private static Statement stmt=null;
    private static Connection connection=null;

    public static void mainN( String[] args )
        {
            String url =
                    "jdbc:mysql://192.168.99.100:3306/petclinic";
            String username = "root";
            String password = "petclinic";

            System.out.println("Connecting database...");

            try {
                connection =
                        DriverManager.getConnection(url, username,
                                password);
                System.out.println("Database connected!");
                stmt = connection.createStatement();
                stmt.executeUpdate(EMPLOYEE_TABLE);
                stmt.executeUpdate("insert into MyEmployees3(id, firstName) values(100, 'A')");
                stmt.executeUpdate("insert into MyEmployees3(id, firstName) values(200, 'B')");
                System.out.println("CreateEmployeeTableMySQL: main(): table created.");

            }
            catch (SQLException e) {
                throw new IllegalStateException("Cannot connect the database!", e);
            }
            finally {
                try {

                    Thread.sleep(2000);
                    System.out.println("terminating connection from database...");
                    stmt.close();
                    connection.close();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

