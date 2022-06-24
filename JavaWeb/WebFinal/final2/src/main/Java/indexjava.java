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

public class indexjava extends HttpServlet {

    private static String driverClass = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/csudatabase?serverTimezone=GMT&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "zzmysql";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
			// 注册 JDBC 驱动器
            Class.forName(driverClass);
            // 打开一个连接
            Connection conn = DriverManager.getConnection(url,username,password);
            // 执行 SQL 查询
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM tab_userinfo";
            // 结果集储存结果
            ResultSet rs = stmt.executeQuery(sql);
            // 创建json对象
            JSONObject jsonObj = new JSONObject();
            // 创建json数组
            JSONArray arraytemp = new JSONArray();
            // 遍历结果集
            while(rs.next()){

                String id  = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String isPaid = rs.getString("isPaid");

                // 创建临时json对象
                JSONObject jsontemp = new JSONObject();
                jsontemp.put("id", id);
                jsontemp.put("name", name);
                jsontemp.put("address", address);
                jsontemp.put("isPaid", isPaid);

                // 添加到json数组
                arraytemp.add(jsontemp);
            }
            // 将所有插入json对象
            jsonObj.put("info",arraytemp);

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();

            // 发送json字符串
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(jsonObj.toString());
            response.getWriter().close();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
	}
}
