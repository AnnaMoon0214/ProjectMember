<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX 테스트</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"
   integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
   crossorigin="anonymous">
   
</script>
<script>
$().ready(function() {
   $("#email").change(function() {
	   $("#result").val("");//초기화
	   
	   var emailValue=$("#email").val();
	   alert("변경된 emailValue="+emailValue);
	   
      $.ajax({
         url : '/member/rest/addJson2',
         data : {
           email: emailValue
         },
         dataType : 'text', /*html, text, json, xml, script*/
         method : 'get',
         success : function(data) {
        	alert("ID가 변경되었습니다.");
        	$("#result").val("중복되지 않았습니다.")
        	

         },
         error : function() {
             alert("ID가 변경되었습니다")
            $("#result").val("중복되었습니다.")
             }
      });
   });
});
</script>

</head>
<body>
ID: <input type="text" name="email" id="email" >
<input type="text" id="result" value="">
<!--  <button id="btn1">AJAX Request Test -- 여길 누르세요</button> -->
<!--     <div> -->
<!--       <table id="memberList" border = "1"> -->
<!--       </table> -->
<!--     </div> -->
</body>
</html>