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
     * 操作商品界面
     */
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

    /**
     * 2更改商品界面
     */
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
                switch (info) {
                    case 0:
                        MainPage.MaintenancePage();
                        break;
                    case 1:
                        System.out.println("请输入商品新名称");
                        String gname = ScannerInfoString();
                        Goods goodsName = new Goods(gid, gname);
                        boolean boolName = new GoodsDao().updateGoods(1, goodsName);
                        if (boolName) {
                            System.out.println("\t成功更新商品名称至数据库！");
                        } else {
                            System.out.println("\t更新商品名称失败");
                        }
                        changedInfoNext("updateGoodsPage");
                        break;
                    case 2:
                        System.out.println("\t请输入商品新价格：");
                        double gprice = ScannerInfo();
                        Goods goodsPrice = new Goods(gid, gprice);
                        boolean boolPrice = new GoodsDao().updateGoods(2, goodsPrice);
                        if (boolPrice) {
                            System.out.println("\t成功更新商品价格");
                        } else {
                            System.out.println("\t更新价格失败");
                        }
                        break;
                    case 3:
                        System.out.println("\t请输入商品新数量：");
                        int gNum = ScannerNum();
                        Goods goodsNum = new Goods(gid, gNum);
                        boolean boolNum = new GoodsDao().updateGoods(3, goodsNum);
                        if (boolNum) {
                            System.out.println("\t成功更新商品数量");
                        } else {
                            System.out.println("\t更新商品数量失败");
                        }
                        break;
                    default:
                        System.out.println("\t请输入正确的选择");
                        break;
                }
                System.out.println("\t输入有误，请重新选择，或者按0返回上一级菜单");
                }
            }while (true);
        }

    /**
     * 3删除商品界面
     */
    public static void deleteGoodsPage()
    {
        System.out.println("\t正在执行 删除商品 操作\n");
        System.out.println("请输入想要删除的商品名称");

        //调用查找商品函数，显示将要删除的商品
        int gid = QueryPrint.query("deleteGoodsPage");
    }
}

