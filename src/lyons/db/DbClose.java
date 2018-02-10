package lyons.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * �رղ������ݿ�ʱ��������Դ��
 * Created by shizesen on 2018/2/5.
 */
public final class DbClose {
    /**
     * �ر� ��ӹ��� ��Դ
     * @param pstmt,rs,conn
     */
    public static void addClose(PreparedStatement pstmt,Connection conn)
    {
        /*
         *���try-catch ��ȫ
         */
        try
        {
            if (pstmt != null) {
                pstmt.close();
            }
        }catch (SQLException e1)
        {
            e1.printStackTrace();
        }
        try {
            if (conn !=null)
            {
                conn.close();
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * �ر���Դ
     * @param pstmt,rs,conn
     */
    public  static void queryClose(PreparedStatement pstmt , ResultSet rs,Connection conn)
    {
        try {
            if (pstmt != null)
            {
                pstmt.close();
            }
        }catch (SQLException e1)
        {
            e1.printStackTrace();
        }
        try {
            if (rs != null)
            {
                rs.close();
            }
        }catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }
}
