<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0059)file:///R:/Workspace/Front-End/FlashVocabulary/recital.html -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/basics.css">
<script type="text/javascript">
</script>
</head>

<body class="uni_background">
<jsp:include  page="include/header.jsp"/>
	<form action="ChooseWordLibAction" method="post">
    <div class="center_div">
    <div class="lib_div">
        <h1 style="font-size:40px;color:#707070">LIB CHANGE</h1>
        ${longSTR}
        
    </div>
    </div>
    </form>
    <div class="popup_div" id="wait_div">
    <div class="page">
    <div class="error">
      <h1 class="header">
          FlashVocabulary
      </h1>
      <div class="content" style="padding-bottom:0px;">
       <p>
         <strong>Wait for a minute...</strong>
       </p>
       <p>
          We are switching the word lib for you...
       </p>
       <p style="text-align:center;">
          <i class="icon-spinner icon-spin icon-2x pull-center"></i>
       </p>
     </div>
    </div>
</div>
</div>
    <jsp:include  page="include/footer.jsp"/>
</body></html>