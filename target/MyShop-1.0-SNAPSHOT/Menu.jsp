<%--
  Created by IntelliJ IDEA.
  User: Dương Võ Hoàng
  Date: 6/1/2021
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .carousel-inner img {width: 100%;
            height: 500px;
            object-fit: cover;
        }
        </style>
    </head>
</head>
<body>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="products">MY WATCH</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:if test="${sessionScope.accountS.isAdmin == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Manager Account</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.accountS.isSell == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="managers">Manager Product</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.accountS != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Hello ${sessionScope.accountS.user}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.accountS == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                </c:if>

            </ul>

            <form action="search" method="get" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${keyword}" name="productName" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" style="background-image: linear-gradient(#3becff, #9e9e9e 50%, #00bcd4)" href="/cart.jsp">
                    <i class="fa fa-cart-plus"></i> Cart
                    <span class="badge badge-light">0</span>
                </a>
            </form>
        </div>
    </div>
</nav>
<div id="demo" class="carousel slide" data-ride="carousel">
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/img/slide2.jpg" alt="Los Angeles" width="1100" height="500">
            <div class="carousel-caption">
<%--                <h3  style="color: antiquewhite">Thương hiệu đồng hồ uy tín</h3>--%>
                <p></p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/img/slide5.jpg" alt="Chicago" width="1100" height="500">
            <div class="carousel-caption">
                <h3></h3>
                <p></p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/img/slide4.jpg" alt="New York" width="1100" height="500">
            <div class="carousel-caption">
                <h3></h3>
                <p></p>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
</div>
<!--end of menu-->
</body>
</html>
