package lyons.tools;

import java.util.Scanner;

import lyons.page.GoodsPage;
import lyons.page.MainPage;
import lyons.page.SalesManPage;

/**
 * Created by shizesen on 2018/2/5.
 */
public class ScannerChoice {
    public static double ScannerInfo()
    {
        double num = 0.00;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("");
            String info = sc.next();

            String regex = "(([1-9][0-9]*)\\.([0-9{2}))|[0]\\.([0-9]{2})";

            if (info.matches(regex))
            {
                num = Double.parseDouble(info);
            }else
            {
                System.err.println("");
                continue;
            }
            break;
        }while (true);
        return num;
    }
    public static int ScannerNum()
    {
        int num = 0;
        String regex = "([1-9])|([1-9][0-9]+)";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("");
            String nums = sc.next();

            if (nums.matches(regex))
            {
                num = Integer.parseInt(nums);
            }else
            {
               System.err.println();
               continue;
            }
            break;
        }while (true);
        return num;
    }
    public static String ScannerInfoString()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("");
        return scanner.next();
    }
    public static void changedInfoNext(String oper)
    {
        do {
            System.out.println("Y/N?");
            String choice = ScannerChoice.ScannerInfoString();
            if ("Y".equals(choice)) {
                if ("updateGoodsPage".equals(oper)) {
                    GoodsPage.updateGoodsPage();
                } else if ("deleteGoodsPage".equals(oper)) {
                    GoodsPage.deleteGoodsPage();
                } else if ("addGoodsPage".equals(oper)) {
                    GoodsPage.addGoodsPage();
                }
            }
            else if ("N".equals(choice))
            {
                MainPage.MaintenancePage();
            }

            System.out.println("");
        }while (true);
    }
    public static void choiceSalesManNext(String oper)
    {
        do {
            System.out.println("Y/N?");
            String choice = ScannerChoice.ScannerInfoString();

            if ("Y".equals(choice)) {
                if ("updateSalesMan".equals(oper)) {
                    SalesManPage.updateSaleManPage();
                } else if ("deleteSalesMan".equals(oper)) {
                    SalesManPage.deleteSalesManPage();
                } else if ("addSalesMan".equals(oper)) {
                    SalesManPage.addSalesManPage();
                } else if ("querySalesMan".equals(oper)) {
                    SalesManPage.querySalesManPage();
                }
            }else if ("N".equals(choice))
            {
                MainPage.salesManManagementPage();
            }
            System.err.println("");
        }while (true);
    }


}
