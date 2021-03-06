<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"
   integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
   crossorigin="anonymous"> </script>
   
<script>
$().ready(function() {
	<!-- email의값이 바뀌면 실행(맨 처음에는 공백)-->
   $("#email").change(function() {

	   <!--result의 값을 초기회해-->
      $("#result").val(""); // 초기화
      
      var emailValue = $("#email").val();
      //alert('변경된 emailValue = ' + emailValue);
      
      $.ajax({
          <!--컨트롤러 호출, checkIdDup?email=*-->
         url : '/member/rest/checkIdDup',
         data : {
            email : emailValue
         },
         dataType : 'text', /*html, text, json, xml, script*/
         method : 'get',
         success : function(data) {
             <!--서버쪽과 통일이 되야해, 서버가 주는ㄱ 0이냐 0이 아니냐-->
            if (data  == "0" ) { 
               $("#result").val("사용 가능합니다.");
            } else { 
               $("#result").val("중복 입니다. 다시 입력해주세요");
               $("#email").focus();
            }
            
            //$("#result").val("중복되지 않았습니다.");
            // success 오는조건 ? 200 ok ... 값을 틀렸지만 200번으로 주면 무조건 여기 ?
         } ,  
         error : function() { 
            $("#result").val("url을 호출하지 못했습니다. 혹은 url 호출중 에러입니다.");
         }
      });
   });
});
</script>
   
</head>
<body>

ID를입력하세요 <input type="text" name="email" id="email"> <br>
<input type="text" id="result" value="" size="50">

<p> 데이터 현황 </p>
<div>
   <table id="memberList" border = "1">
    </table>
</div>

<script>

$().ready(function() {
      $.ajax({
         url : '/member/rest/listJson',
         dataType : 'json', /*html, text, json, xml, script*/
         method : 'get',
         success : function(data) {
            $.each( data, function( key, value ) {
                 var tdValue = "";
                  $.each(value, function(k1, v1) {
                      //alert(k1 + ' ' + v1);
                      // TD 에 합치기
                      tdValue += v1 + ",";
                  });
                  // TR
                  $('#memberList').append("<tr><td>" + tdValue + "</td></tr>");
               })

         }
      });
});
</script>
</body>
</html>