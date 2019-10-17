<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/js/jquery-3.4.1.js" ></script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<canvas id="" style="display: none;"></canvas>
<input type="button" id="btnSubmit" value="다운로드" />

<script type="text/javascript">
var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");

function showPer(per){
	ctx.clearRect(0, 0, 400, 400);
}

</script>

</body>
</html>