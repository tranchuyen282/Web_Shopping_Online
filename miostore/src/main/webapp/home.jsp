<%-- 
    Document   : home
    Created on : Jun 17, 2020, 10:44:56 AM
    Author     : Tran Chuyen
--%>
<%@page import="model.item.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="currency.ShowMoney" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>MIOSTORE</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%     
            // data test
            ArrayList<Item> listItem = (ArrayList<Item>) request.getAttribute("listItem");
            String msg = request.getParameter("suc");

        %>
        <%if("cod".equals(msg)){ %>
             <script type="text/javascript">
                 alert("Thêm thành công đơn hàng");
             </script>
        <%} %>
        <br/><br/><br/><br/><br/>
        <div id="banner">
            <img src="img/banner.png" width="100%" height="350px">
        </div>
        <div id="list">
            <div class="list_detail">
                <table style="width: 100%">
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>

                        <%      
                        //start for
                            for (int i = 0; i<listItem.size();){
                        %>
                            <tr>
                                <% for(int x = 0; x < 5; x++){
                                    if(i < listItem.size()){
                                       
                                        Item item =  listItem.get(i);
                                        String urlImage = listItem.get(i).getDetail().getImage();   //url anh
                                        int idItem = item.getId();           // id item
                                        String nameItem = item.getNameItem();  // ten anh
                                        int priceItem = item.getPrice();

                                    %>
                                        <td>
                                            <a href="item?id=<%=idItem%>">
                                            <img src="img/<%=urlImage%>" width="250px" height="250px">
                                            </a>
                                            <h3 style="color: red"><%=nameItem%></h3>
                                            <p><i>Đơn giá: <%=ShowMoney.fomartMoney(priceItem)%></i></p>
                                        </td>
                                        
                                    <% } %>
                                <% 
                                    i++;  } 
                                    
                                
                                %>
                                
                            
                            </tr>


                    <% }  // end for %>

                </table>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
