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
    /**
     * ������Ʒ����
     */
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

    /**
     * 2������Ʒ����
     */
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
                switch (info) {
                    case 0:
                        MainPage.MaintenancePage();
                        break;
                    case 1:
                        System.out.println("��������Ʒ������");
                        String gname = ScannerInfoString();
                        Goods goodsName = new Goods(gid, gname);
                        boolean boolName = new GoodsDao().updateGoods(1, goodsName);
                        if (boolName) {
                            System.out.println("\t�ɹ�������Ʒ���������ݿ⣡");
                        } else {
                            System.out.println("\t������Ʒ����ʧ��");
                        }
                        changedInfoNext("updateGoodsPage");
                        break;
                    case 2:
                        System.out.println("\t��������Ʒ�¼۸�");
                        double gprice = ScannerInfo();
                        Goods goodsPrice = new Goods(gid, gprice);
                        boolean boolPrice = new GoodsDao().updateGoods(2, goodsPrice);
                        if (boolPrice) {
                            System.out.println("\t�ɹ�������Ʒ�۸�");
                        } else {
                            System.out.println("\t���¼۸�ʧ��");
                        }
                        break;
                    case 3:
                        System.out.println("\t��������Ʒ��������");
                        int gNum = ScannerNum();
                        Goods goodsNum = new Goods(gid, gNum);
                        boolean boolNum = new GoodsDao().updateGoods(3, goodsNum);
                        if (boolNum) {
                            System.out.println("\t�ɹ�������Ʒ����");
                        } else {
                            System.out.println("\t������Ʒ����ʧ��");
                        }
                        break;
                    default:
                        System.out.println("\t��������ȷ��ѡ��");
                        break;
                }
                System.out.println("\t��������������ѡ�񣬻��߰�0������һ���˵�");
                }
            }while (true);
        }

    /**
     * 3ɾ����Ʒ����
     */
    public static void deleteGoodsPage()
    {
        System.out.println("\t����ִ�� ɾ����Ʒ ����\n");
        System.out.println("��������Ҫɾ������Ʒ����");

        //���ò�����Ʒ��������ʾ��Ҫɾ������Ʒ
        int gid = QueryPrint.query("deleteGoodsPage");
    }
}

