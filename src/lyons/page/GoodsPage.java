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
        System.out.println("\tִ�������Ʒ������\n");

        System.out.println("\t�����Ʒ���ƣ�");
        String goodsName = ScannerInfoString();

        System.out.println("\t�����Ʒ�۸�");
        double goodsPrice = ScannerInfo();

        System.out.println("\t�����Ʒ������");
        int goodsNumber = ScannerNum();

        Goods goods = new Goods(goodsName,goodsPrice,goodsNumber);
        boolean bool = new GoodsDao().addGoods(goods);

        if (bool)
        {
            System.out.println("\t��Ʒ��ӳɹ�");
        }else
        {
            System.out.println("\t��Ʒ���ʧ��");
        }
        changedInfoNext("addGoodsPage");

    }

    public static void updateGoodsPage()
    {
        System.out.println("\tִ�и�����Ʒ������\n");

        System.out.println("\t���������Ʒ���ƣ�");
        int gid = QueryPrint.query("updateGoodsPage");//return the goods gid

        System.out.println("\tѡ����Ҫ���ĵ����ݣ�\n");
        System.out.println("\t1��������Ʒ���ƣ�\n");
        System.out.println("\t2��������Ʒ�۸�\n");
        System.out.println("\t3��������Ʒ������\n");
        System.out.println("\t�������Ѹ�����Ʒ������\n");

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
