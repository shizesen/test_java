package lyons.page;

import java.util.ArrayList;

import lyons.dao.*;
import lyons.entity.*;
import lyons.tools.*;

/**
 * 商超购物管理系统主界面
 * Created by shizesen on 2018/2/5.
 */
public final class MainPage extends ScannerChoice{
    /**
     * 入口函数
     */
    public static void main(String[] args)
    {
        MainPage.mainPage();
    }

    /**
     * 主界面
     */
    public static void mainPage()
    {
        System.out.println("*****************\n");
        System.out.println("\t 1.商品维护\n");
        System.out.println("\t 2.前台收据\n");
        System.out.println("\t 3.商品管理\n");
        System.out.println("*****************");

        System.out.println("\n请输入选项，或按0退出");
        do {
            String choice = ScannerInfoString();
            String regex = "[0-3]";
            if (choice.matches(regex))
            {
                int info = Integer.parseInt(choice);
                switch (info)
                {
                    case 0:
                        System.out.println("------------");
                        System.out.println("您已退出系统");
                        System.exit(1);//退出系统，返回值随便设
                        break;
                    case 1:
                        MaintenancePage();
                        break;
                    case 2:
                        checkstandLogPage();
                        break;
                    case 3:
                        commodityManagementPage();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!输入有误！");
            System.out.println("重新选择或按0退出");
        }while (true);

    }

    /**
     * 1.商品维护界面
     */
    public static void MaintenancePage() {
        System.out.println("*****************\n");
        System.out.println("\t 1.添加商品\n");
        System.out.println("\t 2.更改商品\n");
        System.out.println("\t 3.删除商品\n");
        System.out.println("\t 4.查询商品\n");
        System.out.println("\t 5.显示所有商品\n");
        System.out.println("*****************");

        System.out.println("\n请输入选项，或者按0返回上一级菜单。");
        do {
            String choice = ScannerInfoString();
            String regex = "[0-5]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mainPage();
                        break;
                    case 1:
                        GoodsPage.addGoodsPage();
                        break;
                    case 2:
                        GoodsPage.updateGoodsPage();
                    case 3:
                        GoodsPage.deleteGoodsPage();
                        break;
                    case 4:
                        GoodsPage.queryGoodsPage();
                        break;
                    case 5:
                        GoodsPage.displayGoodsPage();
                        break;
                    default:
                        break;

                }
            }
            System.err.println("!输入有误！");
            System.out.println("重新选择或按0退出");
        } while (true);
    }

    /**
     * 2.前台收银登陆界面
     */
    public static void checkstandLogPage() {
        System.out.println("******欢迎使用商超购物管理系统***********\n");
        System.out.println("\t 1.登陆系统\n");
        System.out.println("\t 2.退出\n");
        System.out.println("--------------------------------------");

        System.out.println("\n请输入选项，或者按0返回上一级菜单。");
        do {
            String choice = ScannerInfoString();
            String regex = "[0-2]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mainPage();
                        break;
                    case 1:
                        int loginTimes = 3; //3次登陆机会
                        while (loginTimes != 0) {
                            loginTimes--;
                            System.out.println("----用户名----");
                            String sName = ScannerInfoString();
                            System.out.println("----密码----");
                            String sPassWord = ScannerInfoString();
                            ArrayList<SalesMan> salesManInfo = new SalesManDao().checkstandLog(sName);

                            if (salesManInfo == null || salesManInfo.size() == 0)//没有此用户
                            {
                                System.err.println("\t!!用户名输入错误！！\n");
                                System.out.println("\n剩余登陆次数：" + loginTimes);
                            } else {
                                SalesMan salesMan = salesManInfo.get(0);//此地，只返回了一组数值，只遍历一次即可
                                if (sPassWord.equals(salesMan.getSPassword()))//验证密码，登陆成功
                                {
                                    System.out.println("\t ----账户登陆成功----");
                                    shoppingSettlementPage(salesMan.getSId());//参数为营业厅编号sId
                                } else {
                                    System.err.println("\t!!密码错误!!\n");
                                    System.out.println("\n剩余登陆次数：" + loginTimes);
                                }
                            }
                        }
                        //logintime = 0
                        System.out.println("-------------");
                        System.err.println("\t!!您已被强制退出系统!!");
                        System.exit(1);
                        break;
                    case 2:
                        System.out.println("-------------");
                        System.err.println("\t!!您已经退出系统!!");
                        System.exit(-1);
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!!输入有误!!");
            System.out.println("重新输入或按0返回上一级菜单");
        } while (true);
    }
    /**
     * 3商品管理界面
     */
    public static void commodityManagementPage() {
        System.out.println("*****************\n");
        System.out.println("\t 1.售货员管理\n");
        System.out.println("\t 2.列出当日卖出列表\n");
        System.out.println("*****************");

        System.out.println("\n请输入选项，或者按0返回上一级菜单。");
        do {
            String choice = ScannerInfoString();
            String regex = "[0-2]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mainPage();
                        break;
                    case 1:
                        salesManManagementPage();
                        break;
                    case 2:
                        GsalesPage.dailySalesGoodsPage();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!输入有误!");
            System.out.println("重新输入或按0返回上一级菜单");
        } while (true);
    }

    /**
     * 购物结算界面
     */
    public static void shoppingSettlementPage(int salesManSid)
    {
        System.out.println("\n\t*****购物结算*****\n");
        do {
            System.out.println("按S开始购物结算，按0返回账户登陆界面");
            String choNext = ScannerInfoString();
            if ("0".equals(choNext))
            {
                checkstandLogPage();
            }
            else if ("S".equals(choNext))
            {
                System.out.println("\n--请输入商品关键字--");
                int gid = QueryPrint.querySettlement();//当商品件数有且只有一件时返回商品gid号，商品已售空时返回-1，》1时返回-2，查无次商品时返回-3
                switch (gid)
                {
                    case -3:
                        //无此商品，重新循环
                        break;
                    case -1:
                        System.out.println("\t--抱歉，该商品已售空--");
                        break;
                    default:
                        System.out.println("--按商品编号选择商品--");

                        //传参gid，调用精确查询商品
                        int shoppingGid = ScannerNum();

                        ArrayList<Goods> goodsList = new QueryPrint().queryGoodsKey(shoppingGid,null);
                        if (goodsList == null || goodsList.size() == 0)
                        {
                            System.out.println("\t!!查无此商品!!\n");
                        }else
                        {
                            Goods goods = goodsList.get(0);
                            int gNum = goods.getGnum();
                            double gPrice = goods.getGprice();

                            System.out.println("\t请输入购买数量\n");
                            do {
                                int choicegoodsNum = ScannerNum();
                                if (choicegoodsNum > gNum)
                                {
                                    System.out.println("\t仓库数量不足");
                                    System.out.println("--请重新输入数量--");

                                }else
                                {
                                    double allPrice = Arith.mul(choicegoodsNum,gPrice);//利用BigDecimal作乘法运算
                                    System.out.println("\t\t\t 购物车结算\n");
                                    System.out.println("\t\t商品名称\t商品单价\t购买数量\t总价\n");
                                    System.out.println("\t\t"+goods.getGname()+"\t"+goods.getGprice()+"\t"+choicegoodsNum+"\t"+allPrice+"$\n");

                                    do {
                                        System.out.println("确认购买：Y/N");
                                        String choShopping = ScannerInfoString();
                                        if ("Y".equals(choShopping))
                                        {
                                            System.out.println("总价："+allPrice+"$");
                                            System.out.println("\n实际缴费金额");

                                            do {
                                                double amount = ScannerInfo();
                                                double balance = Arith.sub(amount,allPrice);//用户交钱与购买商品总价的差额
                                                if (balance < 0)
                                                {
                                                    System.out.println("\t!!缴纳金额不足!!");
                                                    System.out.println("\n请重新输入缴纳金额（$）");
                                                }
                                                else//这里是购物结算操作数据库-----1，更改goods表数量。2，增加sales表数量
                                                {
                                                    //对sales表进行操作
                                                    Gsales gSales = new Gsales(goods.getGid(), salesManSid, choicegoodsNum);
                                                    boolean insert = new GsalesDao().shoppingSettlement(gSales);
                                                    //对goods表进行操作
                                                    int goodsNewNum = gNum - choicegoodsNum;//选择goods表中该商品数量
                                                    Goods newGoods = new Goods(goods.getGid(), goodsNewNum);
                                                    boolean update = new GoodsDao().updateGoods(3, newGoods);

                                                    if (update && insert) {
                                                        System.out.println("找零：" + balance);
                                                        System.out.println("谢谢光临，欢迎下次惠顾");
                                                    } else {
                                                        System.out.println("!支付失败!");//数据库操作问题
                                                    }
                                                    shoppingSettlementPage(salesManSid);//跳转到购物结算界面
                                                }
                                            }while (true);
                                        }else if ("N".equals(choShopping))
                                        {
                                            shoppingSettlementPage(salesManSid);
                                        }
                                        System.out.println("\t!!请确认购物意向!!");
                                    }while (true);
                                }
                            }while (true);
                        }
                        break;
                }
            }else {
                System.out.println("请输入合法字符\n");
            }
        }while (true);
    }

    /**
     * 售货员管理界面
     */
    public static void salesManManagementPage()
    {

        System.out.println("***************************\n");
        System.out.println("\t 1.添加售货员\n");
        System.out.println("\t 2.更改售货员\n");
        System.out.println("\t 3.删除售货员\n");
        System.out.println("\t 4.查询售货员\n");
        System.out.println("\t 5.显示所有售货员\n");
        System.out.println("***************************");

        System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");
        do
        {
            String choice = ScannerInfoString();
            String regex  = "[0-5]";
            if (choice.matches(regex))
            {
                int info = Integer.parseInt(choice);
                switch (info)
                {
                    case 0:
                        commodityManagementPage();
                        break;
                    case 1:
                        SalesManPage.addSalesManPage();
                        break;
                    case 2:
                        SalesManPage.updateSalesManPage();
                        break;
                    case 3:
                        SalesManPage.deleteSalesManPage();
                        break;
                    case 4:
                        SalesManPage.querySalesManPage();
                        break;
                    case 5:
                        SalesManPage.displaySalesManPage();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("\t!输入有误!");
            System.out.println("重新输入或按 0 返回上一级菜单.");
        }while(true);
    }


}
