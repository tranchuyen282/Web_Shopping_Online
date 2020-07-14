<%@ page import="model.customer.Customer" %>
<%@ page import="ghn.entity.MethodGHN" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="currency.ShowMoney" %><%--
    Document   : Delivery
    Created on : Jun 30, 2020, 8:55:15 PM
    Author     : ADM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MIOStore</title>
        <link rel="stylesheet" type="text/css" href="css/Delivery.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            Customer customer = null;
            customer = (Customer)session.getAttribute("customer");
            ArrayList<MethodGHN> listMethodGHN = (ArrayList<MethodGHN>) request.getAttribute("methodGHN");

        %>
        <div class="delivery">
            <div class="delivery_title">
                <h3>PHƯƠNG THỨC VẬN CHUYỂN</h3>
            </div>
            <div class="delivery_detail">
                <div class="delivery_detail_title">
                    <b>Chọn hình thức giao hàng</b>
                </div>
                <form action = "checkout" id = 'deliverymethod' method="get">
                <div class="delivery_detail_info">
                <% if(listMethodGHN != null){%>
                    <% for(int i = 0; i < listMethodGHN.size();i++){ %>
                        <% if(i==0){ %>
                            <ul>
                                <input type="radio" id ="ghn" name="deliverymethod" value="<%=i%>" checked ="checked">
                                <p><%="Giao hành nhanh, phương thức: "+listMethodGHN.get(i).getShort_name()%></p>
                                <p>  <%="Phí: "+ currency.ShowMoney.fomartMoney(listMethodGHN.get(i).getTotalFee())%></p>
                                <p>  <%="Thời gian giao hàng dự kiến: " +listMethodGHN.get(i).getLeadtime()%></p>
                            </ul>
                        <%}else{%>
                            <ul>
                                <input type="radio" id ="ghn" name="deliverymethod" value="<%=i%>">
                                <p><%="Giao hàng nhanh, phương thức: "+listMethodGHN.get(i).getShort_name()%></p>
                                <p>  <%="Phí: "+ currency.ShowMoney.fomartMoney(listMethodGHN.get(i).getTotalFee())%></p>
                                <p>  <%="Thời gian giao hàng dự kiến: " +listMethodGHN.get(i).getLeadtime() %></p>
                            </ul>
                        <%}%>
                    <%}%>
                <%}%>
                </div>
                <div class="delivery_button">
                    <input type="submit" value="Tiếp tục">
                </div>
                </form>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
