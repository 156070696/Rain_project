package cn.bdqn.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter@Setter
public class RainManage implements Serializable {
    private int id;
    private String districtName;            //区域名称
    private Date monitorTime;               //测量时间
    private int rain;                       //雨量
    private String monitoringStation;       //监测站
    private String monitoringAddress;       //站点地址

}
