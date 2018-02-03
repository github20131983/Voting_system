<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui/css/layui.css">
<script src="layui/layui.js"></script>
<script>
layui.use('form', function(){
});
</script>
</head>
<body>

<div>
<ul class="layui-nav" style="padding:0 15%">
  <li class="layui-nav-item" style="margin:0 3%"><a href="showVoteByChannel.action?channelID=1">NBA</a></li>
  <li class="layui-nav-item" style="margin:0 3%"><a href="showVoteByChannel.action?channelID=2">CBA</a></li>
  <li class="layui-nav-item" style="margin:0 3%"><a href="showVoteByChannel.action?channelID=3">足球世界杯</a></li>
  <li class="layui-nav-item" style="margin:0 3%"><a href="showVoteByChannel.action?channelID=4">中超</a></li>
  <li class="layui-nav-item" style="margin:0 3%"><a href="showVoteByChannel.action?channelID=5">英超</a></li>
  <li class="layui-nav-item" style="margin:0 3%"><a href="showVoteByChannel.action?channelID=6">F1</a></li>
</ul>
</div>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>最新投票</legend>
</fieldset>

 <div style="margin:0 20px;padding:0 15%">
   <s:actionerror/>
	   <s:iterator value="#request.voteResultList" var="voteResult">
	  	 <s:property value="#voteResult.vote.voteName"/>
	        <form class="layui-form layui-form-pane1" action="doVote.action" method="post">
<%-- 	          <s:iterator value="#voteResult.voteOptions" var="voteOption"> --%>
<%-- 	          		<input type="radio" name="voteOptionID" value="voteOption.voteOptionID"><s:property value="#voteOption.voteOptionName"/><br> --%>
<%-- 	          </s:iterator> --%>
	        <input type="radio" name="voteOptionID" value="0">其它
	        <input type="text" name="otherOption" lay-verify="title" autocomplete="off" placeholder="输入" class="layui-input" style="width:200px;margin:10px 0">
 	        <input type="hidden" name="voteID" value="voteResult.vote.voteID"> 
 	        <s:property value="#voteResult.vote.voteID"/>
<!-- 	        <input type="hidden" name="channelID" value="#voteResult.vote.channelID"> -->
<!--             <input type="hidden" name="voteID" value="53"> -->
<!-- 	        <input type="hidden" name="channelID" value="2"> -->
	        <s:url action="voteResult" var="urlTag" namespace="/admin">
                <s:param name="voteID">
                <s:property value="#request.voteResult.vote.voteID"/>
                 </s:param>
                 </s:url> 
             <s:a href="%{urlTag}">查看投票结果</s:a> 
	         <br/>
	         <button class="layui-btn" style="margin:10px 0px;" type="submit">投票</button>
    	     <button class="layui-btn" style="margin:10px 10px;" type="reset">重置</button>
	         </form>
	  </s:iterator>
	  
	   <s:if test="#request.voteResultList.size == 0">
	                     	没有任何投票内容!
	    </s:if>
	    
           <div align="center" style="font-size: 12px">
			<s:if test="#request.page.hasPrePage">
			     <s:url action="showVoteByChannel.action" var="urlTag">
		       <s:param name="channelID">
		          <s:property value="#request.channelID"/>
		       </s:param>
		       <s:param name="currentPage">
		          <s:property value="#request.page.currentPage=1"/>
		       </s:param>
		      </s:url> 
		      <s:a href="%{urlTag}">首页</s:a>
				
				<s:url action="showVoteByChannel.action" var="urlTag">
		       <s:param name="channelID">
		          <s:property value="#request.channelID"/>
		       </s:param>
		       <s:param name="currentPage">
		          <s:property value="#request.page.currentPage -1"/>
		       </s:param>
		      </s:url> 
		      <s:a href="%{urlTag}">上一页</s:a>
			</s:if>

			<s:else>
				首页 | 上一页
			</s:else>
			
			<s:if test="#request.page.hasNextPage">
			<s:url action="showVoteByChannel.action" var="urlTag">
		       <s:param name="channelID">
		          <s:property value="#request.channelID"/>
		       </s:param>
		       <s:param name="currentPage">
		          <s:property value="#request.page.currentPage + 1"/>
		       </s:param>
		      </s:url> 
		      <s:a href="%{urlTag}">下一页</s:a>
				
				<s:url action="showVoteByChannel.action" var="urlTag">
		       <s:param name="channelID">
		          <s:property value="#request.channelID"/>
		       </s:param>
		       <s:param name="currentPage">
		          <s:property value="#request.page.totalPage"/>
		       </s:param>
		      </s:url> 
		      <s:a href="%{urlTag}">尾页</s:a>
			</s:if>
			<s:else>
				下一页 | 尾页
			</s:else>
		</div>	
 </div>
</body>
</html>