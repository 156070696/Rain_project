package cn.bdqn.Dao;

import cn.bdqn.entity.RainManage;

import java.util.List;

public interface RainManageDao {
    public List<RainManage> showAll();          //查询全部

    public int Insert(RainManage rm);           //新增数据

    public int Delete(int id);                  //删除记录

    public int Update(RainManage mr ,int id );  //修改记录

    public RainManage getRain(int id);          //获取某一条记录
}
