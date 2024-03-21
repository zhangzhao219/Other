import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

public class setPaid extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 获取参数
            request.getSession();
            String id = request.getParameter("id");
            // 查看数据库中对应id的状态并返回ok或fail
            String rtn = setPaidStatus(id);

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(rtn);
            response.getWriter().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    private String setPaidStatus(String id){
        // 存储返回的结果
        JSONObject jsonObj = new JSONObject();
        // 数据库连接
        String driverClass = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/csudatabase?serverTimezone=GMT&characterEncoding=UTF-8";
        String username = "root";
        String password = "zzmysql";
        try{
            // 注册 JDBC 驱动器
            Class.forName(driverClass);
            // 打开一个连接
            Connection conn = DriverManager.getConnection(url,username,password);
            // 执行 SQL 更新
            Statement stmt = conn.createStatement();
            String sql = "UPDATE tab_userinfo SET isPaid = '是' WHERE id = '" + id + "';";
            // 获取返回码
            int rs = stmt.executeUpdate(sql);
            if(rs > 0){
                jsonObj.put("result","ok");
            }
            else{
                jsonObj.put("result","fail");
            }
        } catch (Exception e) {
			e.printStackTrace();
        }
        
        return jsonObj.toString();
    }
}


