package lyons.entity;

import java.lang.ref.SoftReference;

/**
 * Goods 商品实体类
 * Created by shizesen on 2018/2/5.
 */
public final class Goods {
    //数据库Goods表
    private int gid;
    private String gname;
    private double gprice;
    private int gnum;

    /**
     * 添加商品信息
     * @param gname,gprice,gnum
     */
    public  Goods(String gname,double gprice,int gnum)
    {
        this.gname = gname;
        this.gprice = gprice;
        this.gnum = gnum;
    }
    /**
     * 展示所有商品
     * @param gid,gname,gprice,gnum
     */
    public Goods(int gid, String gname,double gprice,int gnum)
    {
        this.gid = gid;
        this.gnum = gnum;
        this.gname = gname;
        this.gprice = gprice;
    }
    /**
     * 根据编号更改商品信息
     * @param gid,gnum
     */
    public Goods(int gid,int gnum)
    {
        this.gid = gid;
        this.gnum = gnum;
    }
    /**
     * 根据编号更改商品信息
     * @param gid,gprice
     */
    public Goods(int gid,double gprice)
    {
        this.gid = gid;
        this.gprice = gprice;
    }
    /**
     * 根据编号更改商品信息
     * @param  gid,gname
     */
    public Goods(int gid,String gname)
    {
        this.gid = gid;
        this.gname = gname;
    }

    //共有-get，set-方法
    public  int getGid()
    {
        return gid;
    }
    public void setGid(int gid)
    {
        this.gid = gid;
    }
    public String getGname()
    {
        return gname;
    }
    public void setGname(String gname)
    {
        this.gname = gname;
    }
    public double getGprice()
    {
        return this.gprice;
    }
    public void setGprice(double gprice)
    {
        this.gprice = gprice;
    }
    public int getGnum()
    {
        return gnum;
    }
    public void setGnum(int gnum)
    {
        this.gnum = gnum;
    }
}
