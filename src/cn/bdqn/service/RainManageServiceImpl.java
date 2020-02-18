package cn.bdqn.service;

import cn.bdqn.Dao.Impl.RainManageDaoImpl;
import cn.bdqn.Dao.RainManageDao;
import cn.bdqn.entity.RainManage;

import java.util.List;

public class RainManageServiceImpl implements RainManageService {
    RainManageDao dao = new RainManageDaoImpl();
    @Override
    public List<RainManage> showAll() {
        List<RainManage> list = dao.showAll();
        return list;
    }

    @Override
    public Boolean Insert(RainManage rm) {
        return dao.Insert(rm) >0 ? true:false;
    }

    @Override
    public Boolean Delete(int id) {
        return dao.Delete(id) >0 ? true:false;
    }


}
