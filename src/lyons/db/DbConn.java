package lyons.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Struct;

/**
 * ����oracle���ݿ�
 * Created by shizesen on 2018/2/5.
 */


public final class DbConn {
    public static  Connection getconn()
    {
        Connection conn = null;

        String user = "scott";
        String passwd = "tiger";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";//orclΪoracle���ݿ�ʵ������

        //�Ѽ���������
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,user,passwd);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
