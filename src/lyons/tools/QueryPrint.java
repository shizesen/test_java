package lyons.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lyons.dao.GoodsDao;
import lyons.db.*;
import lyons.entity.Goods;
import lyons.entity.SalesMan;

/**
 * ��ѯ����ӡ��������
 * Created by shizesen on 2018/2/5.
 */
public final class QueryPrint {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * ģ����ѯ�����в�ѯ��Ϣ����С����
     * @param oper ������
     * @return ��ѯ������Ϣ��gid���������ֵ����-1��������ѯ�쳣
     */
    public static int query(String oper)
    {
        int gid= -1;
        String shopping = ScannerChoice.ScannerInfoString();//���̻�ȡ��Ʒ����
        ArrayList<Goods> goodsList = new QueryPrint().queryGoodsKey(-1,shopping);//���ݼ��̻�ȡ����Ʒ�����{�� ��ȷ��ѯ�������_���Ñ���Ҫ����������
        if (goodsList == null || goodsList.size() <= 0)
        {
            System.out.println("\t���޴���Ʒ");

            //����ѡ����һ������
            ScannerChoice.changedInfoNext(oper);
        }else {//�鵽�д���Ʒ

        }

    }

}
