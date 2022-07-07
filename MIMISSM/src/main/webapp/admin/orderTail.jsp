<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <script type="text/javascript">
        if ("${msg}" != "") {
            alert("${msg}");
        }
    </script>

    <c:remove var="msg"></c:remove>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bright.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addBook.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <title></title>
</head>
<body>
<div id="brall">
    <div id="nav">
        <p>订单管理>订单列表>订单详情</p>
    </div>
    <div id="condition" style="text-align: center">
        <form id="myform">
        </select>&nbsp;&nbsp;&nbsp;
            价格：<input name="lprice" id="lprice">-<input name="hprice" id="hprice">
            <input type="button" value="查询" onclick="condition()">
        </form>
    </div>
    <br>
    <div id="table">
            <!--显示分页后的商品-->
            <div id="middle">
                <table class="table table-bordered table-striped">
                    <tr>
                        <th>用户名</th>
                        <th>手机号</th>
                        <th>总金额</th>
                        <th>备注</th>
                        <th>状态</th>
                        <th>时间</th>
                    </tr>
                        <tr>
                            <td>${tail.cnee}</td>
                            <td>${tail.phone}</td>
                            <td>${tail.totalprice}</td>
                            <td>${tail.remarks}</td>
                            <td>${tail.status}</td>
                            <td>${tail.odate}</td>
                        </tr>
                </table>
                <!--分页栏-->
                <div id="bottom">
                    <div>
                        <nav aria-label="..." style="text-align:center;">
                            <ul class="pagination">
                                <li>
                                        <%--                                        <a href="${pageContext.request.contextPath}/prod/split.action?page=${info.prePage}" aria-label="Previous">--%>
                                    <a href="javascript:ajaxsplit(${info.prePage})" aria-label="Previous">

                                        <span aria-hidden="true">«</span></a>
                                </li>
                                <li>
                                    <%--  <a href="${pageContext.request.contextPath}/prod/split.action?page=1" aria-label="Next">--%>
                                    <a href="javascript:ajaxsplit(${info.nextPage})" aria-label="Next">
                                        <span aria-hidden="true">1</span></a>
                                </li>
                                <li>
                                        <%--  <a href="${pageContext.request.contextPath}/prod/split.action?page=1" aria-label="Next">--%>
                                    <a href="javascript:ajaxsplit(${info.nextPage})" aria-label="Next">
                                        <span aria-hidden="true">»</span></a>
                                </li>
                                <li style=" margin-left:150px;color: #0e90d2;height: 35px; line-height: 35px;">总共&nbsp;&nbsp;&nbsp;<font
                                        style="color:orange;">1</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <c:if test="${info.pageNum!=0}">
                                        当前&nbsp;&nbsp;&nbsp;<font
                                        style="color:orange;">1</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </c:if>
                                    <c:if test="${info.pageNum==0}">
                                        当前&nbsp;&nbsp;&nbsp;<font
                                        style="color:orange;">1</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </c:if>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
    </div>
</div>
</body>
</html>
