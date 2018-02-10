package lyons.page;

import java.util.ArrayList;

import lyons.dao.*;
import lyons.entity.*;
import lyons.tools.*;

/**
 * �̳��������ϵͳ������
 * Created by shizesen on 2018/2/5.
 */
public final class MainPage extends ScannerChoice{
    /**
     * ��ں���
     */
    public static void main(String[] args)
    {
        MainPage.mainPage();
    }

    /**
     * ������
     */
    public static void mainPage()
    {
        System.out.println("*****************\n");
        System.out.println("\t 1.��Ʒά��\n");
        System.out.println("\t 2.ǰ̨�վ�\n");
        System.out.println("\t 3.��Ʒ����\n");
        System.out.println("*****************");

        System.out.println("\n������ѡ���0�˳�");
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
                        System.out.println("�����˳�ϵͳ");
                        System.exit(1);//�˳�ϵͳ������ֵ�����
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
            System.err.println("!��������");
            System.out.println("����ѡ���0�˳�");
        }while (true);

    }

    /**
     * 1.��Ʒά������
     */
    public static void MaintenancePage() {
        System.out.println("*****************\n");
        System.out.println("\t 1.�����Ʒ\n");
        System.out.println("\t 2.������Ʒ\n");
        System.out.println("\t 3.ɾ����Ʒ\n");
        System.out.println("\t 4.��ѯ��Ʒ\n");
        System.out.println("\t 5.��ʾ������Ʒ\n");
        System.out.println("*****************");

        System.out.println("\n������ѡ����߰�0������һ���˵���");
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
            System.err.println("!��������");
            System.out.println("����ѡ���0�˳�");
        } while (true);
    }

    /**
     * 2.ǰ̨������½����
     */
    public static void checkstandLogPage() {
        System.out.println("******��ӭʹ���̳��������ϵͳ***********\n");
        System.out.println("\t 1.��½ϵͳ\n");
        System.out.println("\t 2.�˳�\n");
        System.out.println("--------------------------------------");

        System.out.println("\n������ѡ����߰�0������һ���˵���");
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
                        int loginTimes = 3; //3�ε�½����
                        while (loginTimes != 0) {
                            loginTimes--;
                            System.out.println("----�û���----");
                            String sName = ScannerInfoString();
                            System.out.println("----����----");
                            String sPassWord = ScannerInfoString();
                            ArrayList<SalesMan> salesManInfo = new SalesManDao().checkstandLog(sName);

                            if (salesManInfo == null || salesManInfo.size() == 0)//û�д��û�
                            {
                                System.err.println("\t!!�û���������󣡣�\n");
                                System.out.println("\nʣ���½������" + loginTimes);
                            } else {
                                SalesMan salesMan = salesManInfo.get(0);//�˵أ�ֻ������һ����ֵ��ֻ����һ�μ���
                                if (sPassWord.equals(salesMan.getSPassword()))//��֤���룬��½�ɹ�
                                {
                                    System.out.println("\t ----�˻���½�ɹ�----");
                                    shoppingSettlementPage(salesMan.getSId());//����ΪӪҵ�����sId
                                } else {
                                    System.err.println("\t!!�������!!\n");
                                    System.out.println("\nʣ���½������" + loginTimes);
                                }
                            }
                        }
                        //logintime = 0
                        System.out.println("-------------");
                        System.err.println("\t!!���ѱ�ǿ���˳�ϵͳ!!");
                        System.exit(1);
                        break;
                    case 2:
                        System.out.println("-------------");
                        System.err.println("\t!!���Ѿ��˳�ϵͳ!!");
                        System.exit(-1);
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!!��������!!");
            System.out.println("���������0������һ���˵�");
        } while (true);
    }
    /**
     * 3��Ʒ�������
     */
    public static void commodityManagementPage() {
        System.out.println("*****************\n");
        System.out.println("\t 1.�ۻ�Ա����\n");
        System.out.println("\t 2.�г����������б�\n");
        System.out.println("*****************");

        System.out.println("\n������ѡ����߰�0������һ���˵���");
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
            System.err.println("!��������!");
            System.out.println("���������0������һ���˵�");
        } while (true);
    }

    /**
     * ����������
     */
    public static void shoppingSettlementPage(int salesManSid)
    {
        System.out.println("\n\t*****�������*****\n");
        do {
            System.out.println("��S��ʼ������㣬��0�����˻���½����");
            String choNext = ScannerInfoString();
            if ("0".equals(choNext))
            {
                checkstandLogPage();
            }
            else if ("S".equals(choNext))
            {
                System.out.println("\n--��������Ʒ�ؼ���--");
                int gid = QueryPrint.querySettlement();//����Ʒ��������ֻ��һ��ʱ������Ʒgid�ţ���Ʒ���ۿ�ʱ����-1����1ʱ����-2�����޴���Ʒʱ����-3
                switch (gid)
                {
                    case -3:
                        //�޴���Ʒ������ѭ��
                        break;
                    case -1:
                        System.out.println("\t--��Ǹ������Ʒ���ۿ�--");
                        break;
                    default:
                        System.out.println("--����Ʒ���ѡ����Ʒ--");

                        //����gid�����þ�ȷ��ѯ��Ʒ
                        int shoppingGid = ScannerNum();

                        ArrayList<Goods> goodsList = new QueryPrint().queryGoodsKey(shoppingGid,null);
                        if (goodsList == null || goodsList.size() == 0)
                        {
                            System.out.println("\t!!���޴���Ʒ!!\n");
                        }else
                        {
                            Goods goods = goodsList.get(0);
                            int gNum = goods.getGnum();
                            double gPrice = goods.getGprice();

                            System.out.println("\t�����빺������\n");
                            do {
                                int choicegoodsNum = ScannerNum();
                                if (choicegoodsNum > gNum)
                                {
                                    System.out.println("\t�ֿ���������");
                                    System.out.println("--��������������--");

                                }else
                                {
                                    double allPrice = Arith.mul(choicegoodsNum,gPrice);//����BigDecimal���˷�����
                                    System.out.println("\t\t\t ���ﳵ����\n");
                                    System.out.println("\t\t��Ʒ����\t��Ʒ����\t��������\t�ܼ�\n");
                                    System.out.println("\t\t"+goods.getGname()+"\t"+goods.getGprice()+"\t"+choicegoodsNum+"\t"+allPrice+"$\n");

                                    do {
                                        System.out.println("ȷ�Ϲ���Y/N");
                                        String choShopping = ScannerInfoString();
                                        if ("Y".equals(choShopping))
                                        {
                                            System.out.println("�ܼۣ�"+allPrice+"$");
                                            System.out.println("\nʵ�ʽɷѽ��");

                                            do {
                                                double amount = ScannerInfo();
                                                double balance = Arith.sub(amount,allPrice);//�û���Ǯ�빺����Ʒ�ܼ۵Ĳ��
                                                if (balance < 0)
                                                {
                                                    System.out.println("\t!!���ɽ���!!");
                                                    System.out.println("\n������������ɽ�$��");
                                                }
                                                else//�����ǹ������������ݿ�-----1������goods��������2������sales������
                                                {
                                                    //��sales����в���
                                                    Gsales gSales = new Gsales(goods.getGid(), salesManSid, choicegoodsNum);
                                                    boolean insert = new GsalesDao().shoppingSettlement(gSales);
                                                    //��goods����в���
                                                    int goodsNewNum = gNum - choicegoodsNum;//ѡ��goods���и���Ʒ����
                                                    Goods newGoods = new Goods(goods.getGid(), goodsNewNum);
                                                    boolean update = new GoodsDao().updateGoods(3, newGoods);

                                                    if (update && insert) {
                                                        System.out.println("���㣺" + balance);
                                                        System.out.println("лл���٣���ӭ�´λݹ�");
                                                    } else {
                                                        System.out.println("!֧��ʧ��!");//���ݿ��������
                                                    }
                                                    shoppingSettlementPage(salesManSid);//��ת������������
                                                }
                                            }while (true);
                                        }else if ("N".equals(choShopping))
                                        {
                                            shoppingSettlementPage(salesManSid);
                                        }
                                        System.out.println("\t!!��ȷ�Ϲ�������!!");
                                    }while (true);
                                }
                            }while (true);
                        }
                        break;
                }
            }else {
                System.out.println("������Ϸ��ַ�\n");
            }
        }while (true);
    }

    /**
     * �ۻ�Ա�������
     */
    public static void salesManManagementPage()
    {

        System.out.println("***************************\n");
        System.out.println("\t 1.����ۻ�Ա\n");
        System.out.println("\t 2.�����ۻ�Ա\n");
        System.out.println("\t 3.ɾ���ۻ�Ա\n");
        System.out.println("\t 4.��ѯ�ۻ�Ա\n");
        System.out.println("\t 5.��ʾ�����ۻ�Ա\n");
        System.out.println("***************************");

        System.out.println("\n������ѡ��,���߰� 0 ������һ���˵�.");
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
            System.err.println("\t!��������!");
            System.out.println("��������� 0 ������һ���˵�.");
        }while(true);
    }


}
