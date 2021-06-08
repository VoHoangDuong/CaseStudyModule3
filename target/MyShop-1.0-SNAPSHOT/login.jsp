<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dương Võ Hoàng
  Date: 6/6/2021
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login Page</title>
    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- Font-->
    <link rel="stylesheet" type="text/css" href="css/sourcesanspro-font.css">
    <!-- Main Style Css -->
    <link rel="stylesheet" href="css/login.css"/>
</head>
<body class="form-v8">
<div class="page-content" style="background-image: -webkit-linear-gradient(
136deg
, rgb(253 254 255) 0%, rgb(230 241 236) 100%);">
    <div class="form-v8-content">
        <div class="form-left">
            <img src="https://bossluxury.vn/uploads/2-10/50/armin-strom-skeleton-pure-water.jpg" alt="form">
        </div>
        <div class="form-right" style="background-image: linear-gradient(311deg, #dacfcf, transparent)">
            <div class="tab">
                <div class="tab-inner">
                    <button class="tablinks" onclick="openCity(event, 'sign-in')" id="defaultOpen">Sign In</button>
                </div>
                <div class="tab-inner">
                    <button class="tablinks" onclick="openCity(event, 'sign-up')" id="defaultOpen1" >Sign Up</button>
                </div>
            </div>

        <%-- Start Form login--%>

            <form class="form-detail" action="login" method="post">
                <div class="tabcontent" id="sign-in">
                    <div class="form-row">
                        <label class="form-row-inner">
                            <input type="text" name="user_name" id="full_name_1" class="input-text" required>
                            <span class="label">Username</span>
                            <span class="border"></span>
                        </label>
                    </div>
                    <div class="form-row">
                        <label class="form-row-inner">
                            <input type="password" name="pass" id="password_1" class="input-text" required>
                            <span class="label">Password</span>
                            <span class="border"></span>
                        </label>
                    </div>
                    <div class="form-row-last">
                        <input type="submit" name="register" class="register" value="Sign In">
                    </div>
                    <c:if test='${requestScope["text"] != null}'>
                        <p>Wrong password !!</p>
                    </c:if>
                </div>
            </form>
            <%--  End Form login--%>

            <%--  Start Form Sign up--%>
            <form class="form-detail" action="signup" method="post">
                <div class="tabcontent" id="sign-up">
                    <div class="form-row">
                        <label class="form-row-inner">
                            <input type="text" name="full_name" id="full_name" class="input-text" required>
                            <span class="label">Username</span>
                            <span class="border"></span>
                        </label>
                    </div>
                    <div class="form-row">
                        <label class="form-row-inner">
                            <input type="password" name="password" id="password" class="input-text" required>
                            <span class="label">Password</span>
                            <span class="border"></span>
                        </label>
                    </div>
                    <div class="form-row">
                        <label class="form-row-inner">
                            <input type="password" name="comfirm_password" id="comfirm_password" class="input-text" required>
                            <span class="label">Comfirm Password</span>
                            <span class="border"></span>
                        </label>
                    </div>
                    <div class="form-row-last">
                        <input type="submit" name="register" class="register" value="Register">
                    </div>
                    <c:if test='${requestScope["alert"] != null}'>
                        <p>Account is exist!!</p>
                    </c:if>
                </div>
            </form>
            <%--  End Form Sign up--%>
        </div>
    </div>
</div>
<script type="text/javascript">
    function openCity(evt, cityName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " active";
    }

    // Get the element with id="defaultOpen" and click on it
    document.getElementById("defaultOpen").click();
</script>
</body>
</html>