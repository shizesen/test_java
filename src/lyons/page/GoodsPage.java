package lyons.page;

import java.util.ArrayList;

import lyons.dao.GoodsDao;
import lyons.entity.Goods;
import lyons.tools.QueryPrint;
import lyons.tools.ScannerChoice;

/**
 * Created by shizesen on 2018/2/5.
 */
public final class GoodsPage extends ScannerChoice{

    public static void addGoodsPage()
    {
        System.out.println("\t执行添加商品操作：\n");

        System.out.println("\t添加商品名称：");
        String goodsName = ScannerInfoString();

        System.out.println("\t添加商品价格：");
        double goodsPrice = ScannerInfo();

        System.out.println("\t添加商品数量：");
        int goodsNumber = ScannerNum();

        Goods goods = new Goods(goodsName,goodsPrice,goodsNumber);
        boolean bool = new GoodsDao().addGoods(goods);

        if (bool)
        {
            System.out.println("\t商品添加成功");
        }else
        {
            System.out.println("\t商品添加失败");
        }
        changedInfoNext("addGoodsPage");

    }

    public static void updateGoodsPage()
    {
        System.out.println("\t执行更改商品操作：\n");

        System.out.println("\t输入更改商品名称：");
        int gid = QueryPrint.query("updateGoodsPage");//return the goods gid

        System.out.println("\t选择您要更改的内容：\n");
        System.out.println("\t1。更改商品名称：\n");
        System.out.println("\t2。更改商品价格：\n");
        System.out.println("\t3。更改商品数量：\n");
        System.out.println("\t请输入已更改商品数量：\n");

        do {
            String choice = ScannerInfoString();
            String regex = "[0-3]";
            if (choice.matches(regex))
            {
                int info = Integer.parseInt(choice);
                switch (info)
                {
                    case 0:
                        MainPage.MaintenancePage();
                        break;
                    case 1:
                        System.out.println();
                }
            }
        }
    }
}
