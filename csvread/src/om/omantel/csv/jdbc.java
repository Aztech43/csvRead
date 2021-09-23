package om.omantel.csv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class jdbc
{
    private static String dbURL = "jdbc:derby://localhost:1527/myDB;create=true;user=me;password=mine";
    private static String tableName = "Data";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void main(String[] args)
    {
        createConnection();
        
    }
    
    private static void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
    private static void insertData(String FirstName, String LastName, String ArabicName, String DOB, String Gender, String Nationanilty, String Degree, String GPA, int Salary)
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("insert into " + tableName + " values (" +
                    FirstName + ",'" + LastName + "','" + ArabicName + "','" +  DOB + "','" + Gender + "','" + Nationanilty + "','"+ Degree + "','" + GPA + "','" + Salary +"')");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    private static void selectData()
    {
        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                String FirstName = results.getString(1);
                String LastName = results.getString(2);
                String ArabicName = results.getString(3);
                String DOB = results.getString(4);
                String Gender = results.getString(5);
                String Nationality = results.getString(6);
                String Degree = results.getString(7);
                String GPA = results.getString(8);
                int Salary = results.getInt(9);

                System.out.println(FirstName + "\t\t" + LastName + "\t\t" + ArabicName + "\t\t" + DOB + "\t\t" + Gender + "\t\t" + Nationality + "\t\t" +Degree + "\t\t" + GPA + "\t\t" + Salary) ;
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    private static void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    }
}
