<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>  
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../layui/css/layui.css"  media="all">
<script src="../layui/layui.js" charset="utf-8"></script>
<script>
layui.use('table', function(){
  var table = layui.table;  
});
</script>
</head>
<body>
<div style="margin:20px 20px">
  <table class="layui-table">
    <tr style="background-color:#eeeeee">
      <th >投票序号</th>
      <th >投票名</th>
      <th >投票选项1</th>
      <th >投票选项2</th>
      <th >投票选项3</th>
      <th >操作</th>
    </tr>

   <s:iterator value="#request.voteResultList" var="voteResult">
     <tr>
       <td><s:property value="#voteResult.vote.voteID"/>  </td>
       <td><s:property value="#voteResult.vote.voteName"/>  </td>
       <s:subset source="#voteResult.voteOptions" id="subvoteOptions" start="0" count="3"></s:subset>
       <s:iterator value="#attr.subvoteOptions" var="voteOption">
          <td><s:property value="#voteOption.voteOptionName"/></td>
       </s:iterator>     
      <!--  <td> <a class="" href="deleteVote.action?voteID=#voteResult.vote.voteID">删除</a></td> -->
      <td>
      <s:url action="deleteVote.action" var="urlTag" namespace="/admin">
       <s:param name="voteID">
          <s:property value="#voteResult.vote.voteID"/>
       </s:param>
      </s:url> 
      <s:a href="%{urlTag}">删除</s:a>
      </td>
     </tr>
   </s:iterator>
   </table>
</div> 


<div style="margin: 20px 20px">
	共<s:property value="#request.page.totalCount"/>条纪录，
    当前第<s:property value="#request.page.currentPage"/>/<s:property value="#request.page.totalPage"/>页
    每页<s:property value="#request.page.everyPage"/>条纪录
<a href="showVote.action?currentPage=1">首页</a>
 <s:if test="#request.page.hasPrePage"> 
 <s:url action="showVote.action" var="urlTag" namespace="/admin">
       <s:param name="currentPage">
          <s:property value="#request.page.currentPage-1"/>
       </s:param>
      </s:url> 
      <s:a href="%{urlTag}">上一页</s:a>         
          
</s:if>
<s:else>
</s:else>

<s:if test="#request.page.hasNextPage">
   <s:url action="showVote.action" var="urlTag" namespace="/admin">
       <s:param name="currentPage">
          <s:property value="#request.page.currentPage+1"/>
       </s:param>
      </s:url> 
      <s:a href="%{urlTag}">下一页</s:a>                	
     
</s:if>                
<s:else>
</s:else>
<s:url action="showVote.action" var="urlTag" namespace="/admin">
       <s:param name="currentPage">
          <s:property value="#request.page.totalPage"/>
       </s:param>
      </s:url> 
      <s:a href="%{urlTag}">尾页</s:a>
</div>
</body>
</html>