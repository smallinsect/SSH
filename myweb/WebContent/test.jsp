<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript" src="jquery/swfobject.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	var data = {
// 			userid: "DD8B0F0F73EC5B29",
// 			format: "json"
		videoid: "9264FF49C5B9FB109C33DC5901307461"
	};
	$("#btn").click(function(){
  
// 		$.ajax({
// 			async: true,
// 			type: "get",
// 			url: "getUserInfo",
// 			data: data,
// 			success: function(data){
// 				debugger;
// 				console.log(data);
// 			},
// 			error: function(data){
// 				alert("11"+data);
// 			}
// 		});
		$.ajax({
			async: true,
			type: "get",
			url: "getVideoInfo",
			data: data,
			success: function(data){
				console.log(data);
			},
			error: function(data){
				
			}
		});

	});
	var swfobj = new SWFObject("1040970-472.swf", "mymovie", "440", "330", "8");
	swfobj.addVariable("title", "test");
	swfobj.addVariable("number", 123);
	swfobj.addParam("allowFullscreen", "true");
	swfobj.addParam("allowScripyAccess", "always");
	swfobj.addParam("wmode", "transparent");
	swfobj.write("divid");

// 	swfobject.embedSWF("test.swf", "myContent", "300", "140", "9.0.0", "expressInstall.swf");
});
</script>
</head>
<body>
       <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="780" height="420">
         <param name="movie" value="http://p.bokecc.com/flash/api/uploader.swf" />
         <!--[if !IE]>-->
         <object type="application/x-shockwave-flash" data="http://p.bokecc.com/flash/api/uploader.swf" width="780" height="420">
         <!--<![endif]-->
           <p>Alternative content</p>
         <!--[if !IE]>-->
         </object>
         <!--<![endif]-->
       </object>

<input type="text" name="hehe" id="hehe" value="111">

<input type="button" id="btn" value="btn"><br>
<div id="divid" style="width: 300px; height: 400px; border: 1px solid red;"></div>
</body>
<div id="myContent">
			<h1>Alternative content</h1>
			<p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash player" /></a></p>
		</div>
</html>
