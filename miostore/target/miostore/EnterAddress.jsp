<%-- 
    Document   : EnterAddress
    Created on : Jun 18, 2020, 11:18:41 PM
    Author     : ADM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/EnterAddress.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="address">
            <div class="address_title">
                <h3>ĐỊA CHỈ NHẬN HÀNG</h3>
            </div>
            <div class="address_form">
                <div class="hoten">
                    <label><b style="size: 14px">HỌ TÊN NGƯỜI NHẬN</b></label>
                    <input type="text" name ="hoten" placeholder="Họ tên người nhận">
                </div>
                <div class="sodienthoai">
                    <label><b style="size: 14px">SỐ ĐIỆN THOẠI</b></label>
                    <input type="text" name ="sodienthoai" placeholder="Số điện thoại liên hệ khi giao hàng">
                </div>
                <div class="thanhpho">
                    <label><b style="size: 14px">TỈNH THÀNH</b></label>
                    <select name="thanhpho_list" placeholder="Chọn tỉnh thành">
                        <option value="hanoi">Hà nội</option>
                        <option value="hochiminh">Hồ Chí Minh</option>
                        <option value="thanhhoa">Thanh Hóa</option>
                    </select>
                </div>
                <div class="quanhuyen">
                    <label><b style="size: 14px">QUẬN HUYỆN</b></label>
                    <select name="quanhuyen_list" placeholder="Chọn quận huyện">
                        <option value="hanoi">Hà nội</option>
                        <option value="hochiminh">Hồ Chí Minh</option>
                        <option value="thanhhoa">Thanh Hóa</option>
                    </select>
                </div>
                <div class="phuongxa">
                    <label><b style="size: 14px">PHƯỜNG/XÃ</b></label>
                    <select name="phuongxa_list" placeholder="Chọn phường/xã">
                        <option value="hanoi">Hà nội</option>
                        <option value="hochiminh">Hồ Chí Minh</option>
                        <option value="thanhhoa">Thanh Hóa</option>
                    </select>
                </div>
                <div class="diachi">
                    <label><b style="size: 14px">ĐỊA CHỈ</b></label>
                    <input type="text" name ="diachi" placeholder="Nhập số nhà, tên đường">
                </div>
                <div class="luu">
                    <input type="checkbox" name ="luu" value="luu">
                    <label><b style="size: 12px">Đặt làm địa chỉ mặc định</b></label>
                </div>
                <div class="button">
                    <input type="submit" name ="huy" value="Hủy">
                    <input type="submit" name ="tieptuc" value="Tiếp tục">
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
