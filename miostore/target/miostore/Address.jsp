<%-- 
    Document   : Address
    Created on : Jun 19, 2020, 1:34:35 PM
    Author     : ADM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/Address.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="address">
            <div class="address_title">
                <h3>ĐỊA CHỈ NHẬN HÀNG</h3>
            </div>
            <div class="address_detail">
                <div class="address_detail_title">
                    <b>Chọn địa chỉ nhận hàng</b>
                </div>
                <div class="address_detail_info">
                    <ul>
                        <input type="radio" name="macdinh">
                        <p>Nguyễn Thị Phương|0989671646</p>
                        <p>Gần đại học Hà Nội, xe bus, Phường Mộ Lao, Quận Hà Đông, Hà Nội</p>
                    </ul>
                </div>
                <div class="address_button">
                    <input type="submit" name ="themmoi" value="Thêm địa chỉ nhận hàng">
                    <input type="submit" name ="tieptuc" value="Tiếp tục">
                </div>
            </div>
        </div>
    </body>
</html>
