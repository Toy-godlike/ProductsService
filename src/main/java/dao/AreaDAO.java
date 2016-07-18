package dao;

import entity.Area;

import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
public interface AreaDAO {
    public void addArea(Area area);
    public void deleteArea(int a_num);
    public void updateArea(Area area);
    public Area getArea(int a_num);
    public List getAreas();
}
