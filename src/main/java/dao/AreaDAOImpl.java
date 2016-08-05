package dao;

import entity.Area;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
@Repository
public class AreaDAOImpl implements AreaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    public void addArea(Area area) {
        getCurrentSession().save(area);
    }

    public void deleteArea(int a_num) {
        Area area = getArea(a_num);
        if (area != null) {
            getCurrentSession().delete(area);
        }
    }

    public void updateArea(Area area) {
        Area areaToUpdate = getArea(area.getA_num());
        areaToUpdate.setA_name(area.getA_name());
        areaToUpdate.setLocation(area.getLocation());
        getCurrentSession().update(areaToUpdate);
    }

    public Area getArea(int a_num) {
        Area area = (Area) getCurrentSession().get(Area.class,a_num);
        return area;
    }

    public List getAreas() {
        return getCurrentSession().createQuery("from Area order by a_num asc").list();
    }
}
