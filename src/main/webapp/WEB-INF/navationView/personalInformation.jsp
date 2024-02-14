<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #personalInformationWrap {
        display: none;
    }

    #personalTitle {
        font-size: 50px;
        margin-bottom: 10px;
    }


</style>
<div id="personalInformationWrap">
    <div id="personalTitle">개인정보</div>
    <div id="personalTable">
        <table>
            <tr>
                <td>이름</td>
                <td>${user.name}</td>
            </tr>
            <tr>
                <td>생년월일</td>
                <td>${user.bathday}</td>
            </tr>
            <tr>
                <td>직책</td>
                <td>${user.role}</td>
            </tr>
            <tr>
                <td>입사날짜</td>
                <td>${user.register}</td>
            </tr>
        </table>
    </div>
</div>
