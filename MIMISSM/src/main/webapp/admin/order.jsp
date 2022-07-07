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
    <p>订单管理>订单列表</p>
  </div>
  <div id="condition" style="text-align: center">
    <form id="myform">
      价格：<input name="lprice" id="lprice">-<input name="hprice" id="hprice">
      <input type="button" value="查询" onclick="condition()">
    </form>
  </div>
  <br>
  <div id="table">
    <c:choose>
      <c:when test="${info.list.size()!=0}">
        <!--订单信息-->
        <div id="middle">
          <table class="table table-bordered table-striped">
            <tr>
              <th>订单号</th>
              <th>商品名</th>
              <th>商品数量</th>
              <th>总金额</th>
              <th>操作</th>
            </tr>
            <c:forEach items="${info.list}" var="p">
              <tr>
                <td>${p.oid}</td>
                <td>${p.pName}</td>
                <td>${p.pnumber}</td>
                <td>${p.ptotal}</td>
                <td>
                  <button type="button" class="btn btn-info "
                          onclick="toOrderTail(${p.odid})">查看详情
                  </button>
                </td>
              </tr>
            </c:forEach>
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
                  <c:forEach begin="1" end="${info.pages}" var="i">
                    <c:if test="${info.pageNum==i}">
                      <li>
                          <%--                                                <a href="${pageContext.request.contextPath}/prod/split.action?page=${i}" style="background-color: grey">${i}</a>--%>
                        <a href="javascript:ajaxsplit(${i})"
                           style="background-color: grey">${i}</a>
                      </li>
                    </c:if>
                    <c:if test="${info.pageNum!=i}">
                      <li>
                          <%--<a href="${pageContext.request.contextPath}/prod/split.action?page=${i}">${i}</a>--%>
                        <a href="javascript:ajaxsplit(${i})">${i}</a>
                      </li>
                    </c:if>
                  </c:forEach>
                  <li>
                      <%--  <a href="${pageContext.request.contextPath}/prod/split.action?page=1" aria-label="Next">--%>
                    <a href="javascript:ajaxsplit(${info.nextPage})" aria-label="Next">
                      <span aria-hidden="true">»</span></a>
                  </li>
                  <li style=" margin-left:150px;color: #0e90d2;height: 35px; line-height: 35px;">总共&nbsp;&nbsp;&nbsp;<font
                          style="color:orange;">${info.pages}</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <c:if test="${info.pageNum!=0}">
                      当前&nbsp;&nbsp;&nbsp;<font
                      style="color:orange;">${info.pageNum}</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
      </c:when>
      <c:otherwise>
        <div>
          <h2 style="width:1200px; text-align: center;color: orangered;margin-top: 100px">暂时没有符合条件的商品！</h2>
        </div>
      </c:otherwise>
    </c:choose>
  </div>
</div>
</body>

<script type="text/javascript">

  function toOrderTail(odid) {
    alert("${pageContext.request.contextPath}/order/toOrderTail.action?odid="+odid);
    window.location="${pageContext.request.contextPath}/order/toOrderTail.action?odid="+odid;
  }
</script>
</html>
