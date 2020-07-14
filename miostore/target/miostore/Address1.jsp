<%@ page import="model.cart.Cart" %>
<%@ page import="model.item.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="model.customer.Customer" %>
<%@ page import="model.customer.Address" %><%--
    Document   : Address
    Created on : Jun 19, 2020, 1:34:35 PM
    Author     : ADM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MIOStore</title>
        <link rel="stylesheet" type="text/css" href="css/Address.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            Customer customer = null;
            ArrayList<Address> listAddresses = null;
            if(session.getAttribute("customer") != null){
                customer = (Customer)session.getAttribute("customer");
                listAddresses = customer.getAddress();
            }
        %>
        <div class="address">
            <div class="address_title">
                <h3>ĐỊA CHỈ NHẬN HÀNG</h3>
            </div>
            <div class="address_detail">
                <div class="address_detail_title">
                    <b>Chọn địa chỉ nhận hàng</b>
                </div>
                <form action = "deliverymethod" id = 'addresschoose' method="get">
                <div class="address_detail_info">
                    <% if(listAddresses != null){ %>
                        <%  for(int i = 0; i < listAddresses.size();i++){ %>
                            <%if(listAddresses.get(i).getIsDefault() == 1){%>
                                <ul>
                                    <input type="radio" name="selectAddress" value="<%=i%>" checked="checked">
                                    <p><%=listAddresses.get(i).getNameReceiver() +" " + listAddresses.get(i).getPhoneReceiver()%></p>
                                    <p><%=listAddresses.get(i).getAdd()%></p></br>
                                </ul>
                            <%}else{%>
                                <ul>
                                    <input type="radio" name="selectAddress" value="<%=i%>" >
                                    <p><%=listAddresses.get(i).getNameReceiver() +" " + listAddresses.get(i).getPhoneReceiver()%></p>
                                    <p><%=listAddresses.get(i).getAdd()%></p></br>
                                </ul>
                            <%}%>
                        <% }%>
                    <%} else{ %>
                        <div class="address_button">
                            <form action = "newaddress" id = "newAddress" method="get">
                                <input type="submit" value="Thêm địa chỉ nhận hàng">
                            </form>
                        </div>
                    <%}%>
                </div>
                <div class="address_button">
                    <input type="submit" value="Giao đến địa chỉ này" >
                </div>
                </form>
                <div class="address_button">
                    <form action = "newaddress" id = "newAddress" method="get">
                        <input type="submit" value="Thêm địa chỉ nhận hàng">
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>


