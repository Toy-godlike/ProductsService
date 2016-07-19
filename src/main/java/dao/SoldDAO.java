package dao;

import entity.Sold;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public interface SoldDAO {
    public void addSold(Sold sold);
    public void deleteSold(int s_num);
    public void updateSold(Sold sold);
    public Sold getSold(int s_num);
    public Sold getSoldByRfid(String rfid);
    public List getSolds();
}
