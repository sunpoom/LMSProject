<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #personalModifyWrap {
        display: none;
    }

    #personalModify {
        font-size: 50px;
        margin-bottom: 10px;
    }

    #personalModifyTable {
        display: none;
    }

</style>


<div id="personalModifyWrap">
    <div id="personalModify">개인정보변경</div>
    <div id="passwordInput">
        <input type="password" id="pw">
        <input type="button" id="passwordBtn" value="비밀번호 입력">
    </div>
    <div id="personalModifyTable">
        <form action="api/admin/modify" method="post">
            <table>
                <tr>
                    <td>이름</td>
                    <td>${user.name}</td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" id="password" name="password"></td>
                </tr>
                <tr>
                    <td>비밀번호확인</td>
                    <td><input type="password" id="checkPassword"></td>
                </tr>
                <tr>
                    <td>연락처</td>
                    <td><input type="text" name="phoneNumber" value="${user.phoneNumber}"></td>
                </tr>
                <tr>
                    <td>생년월일</td>
                    <td>${user.bathday}</td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" id="sample4_postcode" placeholder="우편번호" name="postcode" readonly>
                        <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br/>
                        <input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="roadAddress">
                        <input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="jibunAddress">
                        <span id="guide" style="color: #999; display: none"></span>
                        <input type="text" id="sample4_detailAddress" placeholder="상세주소" name="detailAddress">
                        <input type="text" id="sample4_extraAddress" placeholder="참고항목" name="extraAddress">
                    </td>
                </tr>
                <tr>
                    <td rowspan="2" >
                        <input type="hidden" value="${user.id}" name="id">
                        <input type="submit" value="변경하기">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>



<script>
    $(document).on("click", "#passwordBtn", function () {
        let pw = $("#pw").val();
        $.ajax({
            url: "api/admin",
            method: "post",
            data: {
                id: "${user.id}",
                password: pw
            },
            dataType: "text",
            success: function (data) {
                if (data === '1') {
                    $("#passwordInput").css("display", "none")
                    $("#personalModifyTable").css("display", "block")
                } else {
                    alert("비밀번호가 아닙니다")
                }
            },
            error: function (xhr, status, error) {
                console.error(error)
            }
        })
    })
</script>
