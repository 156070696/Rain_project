package cn.bdqn.servlet;

import cn.bdqn.entity.RainManage;
import cn.bdqn.service.RainManageService;
import cn.bdqn.service.RainManageServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/Rain")
public class RainManageServlet extends HttpServlet {
    RainManageService service = new RainManageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //浏览器响应类型
        response.setCharacterEncoding("utf-8");
        //告诉浏览器响应的内容以及字符编码
        response.setHeader("context-type","text.html;charset=utf-8");


        String action = request.getParameter("opr");
        System.out.println(action);
        if(action.equals("showAll")){
            List<RainManage> list = service.showAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if(action.equals("delete")){
            //删除
            String id = request.getParameter("id");
            int i = Integer.parseInt(id);
            Boolean delete = service.Delete(i);
            if(delete){
                response.getWriter().write("<script type='text/javascript'>alert('删除成功！');</script>");
                response.sendRedirect("index.jsp");
            }else{
                response.getWriter().write("<script type='text/javascript'>alert('删除失败！');</script>");
                response.sendRedirect("index.jsp");
            }
        }else if(action.equals("insert")){
            //增加
            String districtName = request.getParameter("districtName");
            String monitorTime = request.getParameter("monitorTime");
            String rain = request.getParameter("rain");
            String monitoringStation = request.getParameter("monitoringStation");
            String monitoringAddress = request.getParameter("monitoringAddress");

            //将接收到的降雨量转换成int类型；
            int intRain = Integer.parseInt(rain);
            //格式化日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);

            //将接收的字符串转化成日期格式！
            Date date = sdf.parse(monitorTime);

            //创建对象并且赋值
            RainManage rm = new RainManage();
            rm.setDistrictName(districtName);
            rm.setMonitorTime(date);
            rm.setRain(intRain);
            rm.setMonitoringStation(monitoringStation);
            rm.setMonitoringAddress(monitoringAddress);

            //将对象作为参数传给增加的方法！
            Boolean insert = service.Insert(rm);
            //判断是否成功！
            if(insert){
                response.getWriter().write("<script type='text/javascript'>alert('添加成功！');</script>");
                //增加成功跳到查询页面
                response.sendRedirect("index.jsp");
            }else{
                response.getWriter().write("<script type='text/javascript'>alert('添加失败！');</script>");
                //增加失败跳到查询页面
                response.sendRedirect("index.jsp");
            }


        }


    }
}
