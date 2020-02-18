package cn.bdqn.service;

import cn.bdqn.entity.RainManage;

import java.util.List;

public interface RainManageService {
    public List<RainManage> showAll();          //查询全部

    public Boolean Insert(RainManage rm);           //新增数据

    public Boolean Delete(int id);                  //删除记录


}
