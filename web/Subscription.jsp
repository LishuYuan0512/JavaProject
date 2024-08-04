<%-- 
    Document   : Subscription
    Created on : 2024年8月2日, 14:39:12
    Author     : ZU
--%>

<%@page import="org.apache.commons.dbutils.handlers.MapListHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.commons.dbutils.QueryRunner"%>
<%@page import="utils.DbUtil"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Subscription - XXX Website</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <span>xxx website</span>
        <div>
            <a href="login.html" class="text-white">Log out</a>
        </div>
    </div>
    <div class="main">
        <div class="container">
            <h2 class="text-center">Subscription</h2>
            <%
                int userID = Integer.parseInt(request.getParameter("userID")); // 获取userID
            %>
            <form action="<%= request.getContextPath() %>/customer/safe/SubscribeController?userID=<%= userID %>" method="post">
                <div class="form-group">
                    <label for="foodPreference">Food Preference</label>
                    <select class="form-control" id="foodPreference" name="foodPrefer">
                        <option value="">Select</option>
                        <%
                            QueryRunner queryRunner = new QueryRunner();
                            Connection con = null;
                            try {
                                con = DbUtil.getConnection();
                                String sql = "SELECT itemID, itemName FROM FoodItem2";
                                List<Map<String, Object>> results = queryRunner.query(con, sql, new MapListHandler());

                                for (Map<String, Object> row : results) {
                                    int itemID = (Integer) row.get("itemID");
                                    String itemName = (String) row.get("itemName");
                                    out.println("<option value='" + itemID + "'>" + itemName + "</option>");
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } finally {
                                DbUtil.closeAll(con, null, null);
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="location">Location</label>
                    <select class="form-control" id="location" name="locationID">
                        <option value="">Select</option>
                        <%
                            Connection con2 = null;
                            try {
                                con2 = DbUtil.getConnection();
                                String sql = "SELECT locationID, locationName FROM location";
                                List<Map<String, Object>> results2 = queryRunner.query(con2, sql, new MapListHandler());

                                for (Map<String, Object> row : results2) {
                                    int locationID = (Integer) row.get("locationID");
                                    String locationName = (String) row.get("locationName");
                                    out.println("<option value='" + locationID + "'>" + locationName + "</option>");
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } finally {
                                DbUtil.closeAll(con2, null, null);
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="contactMethod">How would you like to receive subscription</label>
                    <select class="form-control" id="contactMethod" name="communicationMethod">
                        <option value="Email">Email</option>
                        <option value="Phone">Phone</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email">
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" id="phone" name="phone">
                </div>
                <button type="submit" class="btn btn-custom btn-block">Subscribe</button>
            </form>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>


