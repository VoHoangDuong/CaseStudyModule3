<%--
  Created by IntelliJ IDEA.
  User: Dương Võ Hoàng
  Date: 6/1/2021
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-sm-3">
    <div class="card bg-light mb-3" style="margin-top: 5px;">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${categoryList}" var="o">
                <li class="list-group-item text-white ${tag == o.cid ? "active" : ""}"><a href="category?cid=${o.cid}">${o.cname}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <div class="card-body">
            <img class="img-fluid" src="${lastP.img}" />
            <h5 class="card-title">${lastP.name}</h5>
            <p class="card-text">${lastP.title}</p>
            <p class="bloc_left_price">${lastP.price} $</p>
        </div>
    </div>
</div>