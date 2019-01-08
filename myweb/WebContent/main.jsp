<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function allowDrop(ev){
	ev.preventDefault();
}

function drag(ev){
	ev.dataTransfer.setData("Text", ev.target.id);
}

function drop(ev){
	ev.preventDefault();
	var data = ev.dataTransfer.getData("Text");
	ev.target.appendChild(document.getElementById(data));
}

</script>
</head>
<body>
<!-- 拖放 -->
<!-- <div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)" style="width: 700px; height: 300px; border: 1px solid red;">主显示页面</div> -->
<!-- <img draggable="true" id="drag1" ondragstart="drag(event)" width="800px" alt="古剑奇谭三" src="images/gujian3.jpg"> -->

<!-- 画布 -->
	<canvas id="myCanvas" width="1000" height="500"></canvas>
</body>
<script type="text/javascript">
var c = document.getElementById("myCanvas");
var cxt = c.getContext("2d");
var img = new Image();
img.src = "images/gujian3.jpg";

cxt.drawImage(img, 0, 0);

</script>
</html>