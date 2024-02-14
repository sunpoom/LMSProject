<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        #headCon {
            display: flex;
            height: 100px;
            border: 1px solid;
            align-items: center;
        }

        .headLeft {
            margin-right: 60px;
        }

        #MainLogo {
            font-size: 50px;
            margin: 20px;
            cursor: pointer;
        }

        #clientName {
            margin-left: 0; /* 왼쪽으로 살짝 이동 */
            font-size: 30px; /* 폰트 크기 조절 */
        }

        .headLeft span {
            margin: 50px;
        }

        #mainWrap {
            border: 1px solid;
            height: 500px;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #loginWrap {
            display: flex;
            justify-content: center;
        }

        #loginTable tr td {
            text-align: center;
            width: 180px;
            height: 70px;
            font-size: 30px;
        }

        #loginTable input {
            width: 100%;
            height: 60%;
            padding: 10px;
            box-sizing: border-box;
        }

        #loginTable input[type="submit"] {
            background-color: #030d6b;
            width: 80%;
            color: white;
            cursor: pointer;
            border: none;
            height: 70px;
            font-size: 20px;
        }

        #informationWrap {
            display: flex;
            justify-content: center;
        }

        .information {
            border: 1px solid;
            padding: 20px;
            margin: 10px;
            text-align: center;
        }
        .information_title {
            padding-bottom: 10px;
            margin-bottom: 10px;
            border-bottom: 1px solid;
        }

    </style>
</head>
<body>
<div id="headCon">
    <div class="headLeft">
    <span id="MainLogo">
        신세계교육
    </span>
        <span id="clientName">
        로그인
    </span>
    </div>
</div>

<div id="mainWrap">
    <div id="main">
        <div id="loginWrap">
            <form action="api/login" method="post" >
                <table id="loginTable" >
                    <tr>
                        <td rowspan="2">
                            <img src="http://placehold.it/130X170"/>
                        </td>
                        <td>아이디</td>
                        <td><input type="text" name="id"></td>
                        <td rowspan="2"><input type="submit" value="로그인"></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="password" name="password"></td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="informationWrap">
            <div class="information">
                <div class="information_title" >직원/조교</div>
                <div>이메일아이디/비밀번호
                    (@없이 아이디만 입력하기)
                </div>
            </div>
            <div class="information">
                <div class="information_title" >학부생</div>
                <div>학번/비밀번호
                </div>
            </div>
            <div class="information">
                <div class="information_title" >교수</div>
                <div>클래스넷아이디/비밀번호
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../resources/js/jquery-3.6.0.min.js"></script>
<script>
    $(document).on("click","#MainLogo",function () {
        window.location.href="/"
    })
</script>
</body>
</html>