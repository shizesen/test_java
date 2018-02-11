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
 * 查询并打印函数工具
 * Created by shizesen on 2018/2/5.
 */
public final class QueryPrint {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * 模糊查询并陈列查询信息函数小工具
     * @param oper 调用者
     * @return 查询到的信息的gid，如果返回值等于-1，则代表查询异常
     */
    public static int query(String oper)
    {
        int gid= -1;
        String shopping = ScannerChoice.ScannerInfoString();//键盘获取商品名称
        ArrayList<Goods> goodsList = new QueryPrint().queryGoodsKey(-1,shopping);//根据键盘获取的商品名字調用 精确查询函数，確定用戶所要操作的数据
        if (goodsList == null || goodsList.size() <= 0)
        {
            System.out.println("\t查无此商品");

            //调用选择下一步函数
            ScannerChoice.changedInfoNext(oper);
        }else {//查到有此商品

        }

    }

}
