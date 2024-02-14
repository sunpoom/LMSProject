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

        .headRight {
            margin-left: auto;
        }

        #navAndMain {
            position: relative;
            border: 1px solid;
            height: 1000px;
        }

        #navWrap {
            position: absolute;
            height: 100%;
            width: 200px;
            left: 0;
            border: 1px solid;
            background-color: gray;
            padding: 0;
        }

        #navWrap > ul {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        #navWrap > ul > li {
            cursor: pointer;
            margin: 0;
            text-align: left;
            color: white;
        }

        #navWrap > ul > li > div {
            font-size: 18px;
            padding: 5px 3px;
        }


        .headRight span {
            margin: 10px; /* Adjusted margin for better spacing */
            font-size: 18px; /* Adjusted font size */
        }

        .headRight button {
            font-size: 18px; /* Adjusted font size */
            padding: 5px 10px; /* Added padding for better button appearance */
        }

        .navItem {
            display: block;
            list-style: none;
            padding: 0;
            background-color: white;
        }

        .navItem li {
            margin-left: 10px;
            padding: 3px 0;
            color: black;
        }

        #mainWrap {
            position: absolute;
            /*   border: 1px solid;*/
            width: calc(100% - 200px);
            left: 200px;
            height: 100%;
        }

        #main {
            border: 1px solid;
            width: 95%;
            height: 95%;
            margin: 20px;
        }

        #noticeTile {
            font-size: 50px;
            margin-bottom: 10px;
        }

        #noticeTable {
            border: 1px solid;
            height: 100px;
        }


    </style>
    <script src="../../resources/js/jquery-3.6.0.min.js"></script>
    <script src="../../resources/js/memberRegister.js"></script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<div id="headCon">
    <div class="headLeft">
    <span id="MainLogo">
        신세계교육
    </span>
        <span id="clientName">
        ${user.role} 클래스넷
    </span>
    </div>

    <div class="headRight">
        <span>${user.name}</span>
        <span><a href="api/logout"><button>로그아웃</button></a></span>
    </div>
</div>

<div id="navAndMain">
    <div id="navWrap">
        <ul>
            <li>
                <div class="navBtn">my page</div>
                <ul class="navItem">
                    <li class="item">기본정보</li>
                    <li class="item">개인정보 변경</li>
                </ul>
            </li>
            <li>
                <div class="navBtn">학생정보</div>
                <ul class="navItem">
                    <li class="item">학생추가</li>
                    <li class="item">학생조회</li>
                </ul>
            </li>
            <li>
                <div class="navBtn">교수정보</div>
                <ul class="navItem">
                    <li class="item">교수추가</li>
                    <li class="item">교수조회</li>
                </ul>
            </li>
            <li>
                <div class="navBtn">알림정보</div>
                <ul class="navItem">
                    <li class="item">공지사항</li>
                </ul>
            </li>
            <li>
                <div class="navBtn">이용사항</div>
                <ul class="navItem">
                    <li class="item">공지사항</li>
                    <li class="item">Q&A</li>
                    <li class="item">메뉴얼</li>
                </ul>
            </li>
        </ul>
    </div>
    <div id="mainWrap">
        <div id="main">
            <div id="index">
                <div id="noticeTile">공지사항</div>
                <div id="noticeTable">
                    <table border="1">
                        <tr>
                            <td>게시판</td>
                        </tr>
                        <tr>
                            <td>번호</td>
                            <td>제목</td>
                            <td>일시</td>
                        </tr>
                    </table>
                </div>
            </div>
            <jsp:include page="../navationView/personalInformation.jsp"/>
            <jsp:include page="../navationView/personalmodify.jsp"/>
        </div>
    </div>
</div>

<script>
    $(document).on("click", "#MainLogo", function () {
        $("#main").children().css("display", "none")
        $("#index").css("display", "block")
        window.location.href = "/admin"
    })
    $(document).on("click", ".navBtn", function () {
        if ($(this).next().css("display") === 'block') {
            $(this).next().css("display", "none")
        } else {
            $(this).next().css("display", "block")
        }
    })
    $(document).on("click", ".item", function () {
        $("#main").children().css("display", "none")
        console.log()
        if ($(this).text() === '기본정보') {
            $("#personalInformationWrap").css("display", "block")
        } else if ($(this).text() === '개인정보 변경') {
            $("#personalModifyWrap").css("display", "block");
        }
    })


</script>
</body>
</html>