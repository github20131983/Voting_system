<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加投票</title>
 <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
 
 <script src="../layui/layui.js" charset="utf-8"></script>
 <script>
 layui.use(['form'], function(){
	  var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate; 
	});	  	 	 
 </script>
 <script type="text/javascript" language="javascript">
	var i = 4;
	function addVoteOption(){
		window.document.getElementById("voteOptionList").innerHTML=
			window.document.getElementById("voteOptionList").innerHTML + 
			"<label class=\"layui-form-label\" style=\"width:120px\">选项"+(i++)+"名称</label>"
			+"<input type=\"text\" name=\"voteOption\" lay-verify=\"title\" autocomplete=\"off\" placeholder=\"输入\" class=\"layui-input\" style=\"width:180px;margin: 15px 0\">"; 
	}
 </script>
</head>
<body>

<form class="layui-form" action="addVote.action">

  <div class="layui-form-item" >
    <label class="layui-form-label" style="width:120px">选择投票频道</label>
    <div style="width:180px;margin: 15px 150px">
      <select name="channel" >
        <option value=""></option>
        <option value="1">NBA</option>
        <option value="2" selected="">CBA</option>
        <option value="3">足球世界杯</option>
        <option value="4">中超</option>
        <option value="5">英超</option>
        <option value="6">F1</option>
      </select>
    </div>
          
    <div>   
        <label class="layui-form-label" style="width:120px">请输入投票名称</label> 	
      	<input type="text" name="voteName" lay-verify="title" autocomplete="off" placeholder="输入" class="layui-input" style="width:180px;margin: 15px 150px">   
    </div>
 
    <div id="voteOptionList"> 
        <label class="layui-form-label" style="width:120px">选项1名称</label>               
      	<input type="text" name="voteOption" lay-verify="title" autocomplete="off" placeholder="输入" class="layui-input" style="width:180px;margin: 15px 0">
      	<label class="layui-form-label" style="width:120px">选项2名称</label>
      	<input type="text" name="voteOption" lay-verify="title" autocomplete="off" placeholder="输入" class="layui-input" style="width:180px;margin: 15px 0">
      	<label class="layui-form-label" style="width:120px">选项3名称</label>   
      	<input type="text" name="voteOption" lay-verify="title" autocomplete="off" placeholder="输入" class="layui-input" style="width:180px;margin: 15px 0">   
    </div>
    
    <div>
    	<button onclick="addVoteOption()" type="button" class="layui-btn" style="margin:10px 10px 10px 50px;" >新增投票选项</button>
    	<button class="layui-btn" style="margin:10px 10px;" type="submit">发布</button>
    	<button class="layui-btn" style="margin:10px 10px;" type="reset">重置</button>
    </div>
</div>
</form>
</body>
</html>