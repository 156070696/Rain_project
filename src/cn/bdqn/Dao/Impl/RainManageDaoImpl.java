package cn.bdqn.Dao.Impl;

import cn.bdqn.Dao.BeasDao;
import cn.bdqn.Dao.RainManageDao;
import cn.bdqn.entity.RainManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RainManageDaoImpl extends BeasDao implements RainManageDao {
    Connection conn = null;
    Statement st = null;
    PreparedStatement ps = null ;//执行对象
    ResultSet rs = null;//结果集

    @Override
    public List<RainManage> showAll() {
        String sql = "select * from rainQuality";
        rs = getExrcuteQuery(sql);
        List<RainManage> list = new ArrayList<>();
        try{
        while(rs.next()){
            RainManage rm = new RainManage();
            rm.setId(rs.getInt(1));
            rm.setDistrictName(rs.getString(2));
            rm.setMonitorTime(rs.getDate(3));
            rm.setRain(rs.getInt(4));
            rm.setMonitoringStation(rs.getString(5));
            rm.setMonitoringAddress(rs.getString(6));
            list.add(rm);
        }
        return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            closeAll(rs,conn,st);
        }

    }

    @Override
    public int Insert(RainManage rm) {
        String sql = "insert into rainQuality (districtName,monitorTime,rain,monitoringStation,monitoringAddress) values (?,?,?,?,?)";
        return getExrcuteUpdate(sql,rm.getDistrictName(),rm.getMonitorTime(),rm.getRain(),rm.getMonitoringStation(),rm.getMonitoringAddress());
    }

    @Override
    public int Delete(int id) {
        String sql = "delete from rainQuality where id=?";
        return getExrcuteUpdate(sql,id);
    }

    @Override
    public int Update(RainManage mr, int id) {
        return 0;
    }

    @Override
    public RainManage getRain(int id) {
        return null;
    }

}
