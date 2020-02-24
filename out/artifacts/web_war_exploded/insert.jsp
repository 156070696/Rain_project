<%--
  Created by IntelliJ IDEA.
  User: userNo1
  Date: 2020/2/18
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增雨量检测信息</title>
    <style>
        h3{
            text-align: center;
        }
        #myform{
            width: 500px;
            height: 310px;
            font-size: 1.6rem;
            line-height: 2.2rem;
            margin: 0 auto;
        }

        dl{
            clear: both;
            line-height: 22px;
            margin-top: 20px;
        }
        dt, dd {
            float: left;
            padding-top: 5px;
        }
        dt{
            width: 110px;
            text-align: right;
            font-size: 16px;
            height: 30px;
            line-height: 25px;
            font-weight: bold;
        }
        dd{
            font-size: 12px;
            color: #666666;
        }
        dd>input{
            font-weight: bold;
        }
        p{
            float: none;
            margin-top: 50px;
        }
        p>input{
            font-size: 16px;
            margin: 0 auto;
            font-weight: bold;
        }

    </style>
</head>
<body>
<form action="Rain?opr=insert" method="post" id="myform">
    <h3>新增雨量监测信息</h3>
    <dl>
        <dt>区域名称：</dt>
        <dd><input type="text" class="districtName" name="districtName"/></dd>
    </dl>
    <dl>
        <dt>检测时间：</dt>
        <dd><input type="text" class="monitorTime" name="monitorTime"/>&nbsp;&nbsp;&nbsp;(yyyy-MM-dd格式)</dd>
    </dl>
    <dl>
        <dt>雨量值(mm)：</dt>
        <dd><input type="text" class="rain" name="rain"/></dd>
    </dl>
    <dl>
        <dt>监测站：</dt>
        <dd><input type="text" class="monitoringStation" name="monitoringStation"/></dd>
    </dl>
    <dl>
        <dt>站点地址：</dt>
        <dd><input type="text" class="monitoringAddress" name="monitoringAddress"/></dd>
    </dl>
    <p class="btn">
        <input type="submit" value="保存"/>
        <input type="reset" value="重置"/>
        <input type="button" value="返回"/>
    </p>
</form>
<script src="jquery-3.1.1.js"></script>
<script>
    $(function () {

        $("#myform").submit(function(){
            var $districtName = $(".districtName").val();
            var $monitorTime = $(".monitorTime").val();
            var $rain = $(".rain").val();
            var $monitoringStation = $(".monitoringStation").val();
            var $monitoringAddress = $(".monitoringAddress").val();

            var data = /^(\d{4})-(\d{2})-(\d{2})$/;         //日期的正则表达式！
            var $int =/^\d$/;
            //区域名称
            if($districtName == ""){
                alert("区域名称不能为空！");
                return false;
            }
            //记录时间
            if(!data.test($monitorTime)){
                /*
                 * $("#check_username").click(function(){
                 var str = $("#t_username").val();
                 var ret = /^[a-zA-Z][a-zA-Z0-9_]{5,20}$/;
                 if(ret.test(str)){
                 alert('ok');
                 }else{
                 alert('wrong');
                 }*/
                alert("请填写正确的日期格式！");
                return false;
            }
            //判断雨量值
            if($rain == "" || !$int.test($rain)){
                alert("雨量值不能为空！且必须是整数数字");
                return false;
            }
            //
            if($monitoringStation == ""){
                alert("监测站不能为空！");
                return false;
            }
            if($monitoringAddress == ""){
                alert("站点地址不能为空");
                return false;
            }
            return true;
        })
    })

</script>

</body>
</html>
