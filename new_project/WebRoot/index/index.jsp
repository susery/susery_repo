<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Amaze UI Admin index Examples</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  
  <%@ include file="/common/meta.jsp" %>
</head>
<body>


<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>Amaze UI</strong> <small>后台管理模板</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
 <%--    
      <ul id="menu_ul"  class="am-list admin-sidebar-list">
      </ul>
      
      <script >
       var menuList = [
                       {menuId:"0001",menuName:"用户管理",menuCode:"user0001",menuUrl:"#",menuLevel:"1",parentMenuId:"0001",childMenuList:[{menuId:"0004",menuName:"子管理1",menuCode:"user0001",menuUrl:"#",menuLevel:"1",parentMenuId:"0001"},{menuId:"0005",menuName:"子管理2",menuCode:"user0001",menuUrl:"#",menuLevel:"1",parentMenuId:"0001"}]},
                       {menuId:"0002",menuName:"角色管理",menuCode:"role0002",menuUrl:"#",menuLevel:"1",parentMenuId:"0002",childMenuList:[]},
                       {menuId:"0003",menuName:"菜单管理",menuCode:"menu0003",menuUrl:"#",menuLevel:"1",parentMenuId:"0003",childMenuList:[]}
                       ];
      	
       var tag = '<li id="{{= menuId}}"><a href="{{= menuUrl}}"><span></span>{{= menuName}}</a></li>';
       
       var child_tag = '<li class="admin-parent">'+
           '<a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>'+
           '<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">'+
           '<li><a href=""><span></span></a></li>'+
           +'</ul>'+
         '</li>';
         
       var tag = '{{if (childMenuList==null ||childMenuList =="")&& parentMenuId!=1}}'
       
       
       +'{{/if}}';
         
       $.template( "menu_tag", tag );
		
       //$.tmpl(传入定义好的显示模板，传入json格式的数据)
       $.tmpl( "menu_tag", menuList ).appendTo( "#menu_ul" );
      </script>
--%>
	
	<ul id="menu_ul"  class="am-list admin-sidebar-list">
		
		<script id="menu-tmpl" type="text/x-jquery-tmpl">
		{{each(i,menu)menuList}}
			{{if (menu.childMenuList==null ||menu.childMenuList =="")&& menu.parentMenuId==menu.menuId}}}
				<li id="{{= menu.menuId}}"><a href="{{= menu.menuUrl}}"><span></span>{{= menu.menuName}}</a></li>
			{{/if}}

			{{if (menu.childMenuList!=null ||menu.childMenuList !="")&& menu.parentMenuId!=menu.menuId}}}
				<li class="admin-parent">
          			<a class="am-cf" data-am-collapse="">
		  			<span class="am-icon-file"></span> 页面模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          			<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            			<li><a href="admin-404.html"><span class="am-icon-bug"></span> 404</a></li>
          			</ul>
        		</li>
			{{/if}}
		{{/each}}
		</script>	
      </ul>
	

	
      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> 公告</p>
          <p>时光静好，与君语；细水流年，与君同。—— Amaze UI</p>
        </div>
      </div>

      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-tag"></span> wiki</p>
          <p>Welcome to the Amaze UI wiki!</p>
        </div>
      </div>
      
    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  	<iframe src="${basePath}index/rf.html" style="display: none;"></iframe>
  <!-- content end -->

</div>



	<script >
	/*
　　	var menuList = [
                    {menuId:"0001",menuName:"用户管理",menuCode:"user0001",menuUrl:"#",menuLevel:"1",parentMenuId:"0001",childMenuList:[{menuId:"0004",menuName:"子管理1",menuCode:"user0001",menuUrl:"#",menuLevel:"1",parentMenuId:"0001"},{menuId:"0005",menuName:"子管理2",menuCode:"user0001",menuUrl:"#",menuLevel:"1",parentMenuId:"0001"}]},
                    {menuId:"0002",menuName:"角色管理",menuCode:"role0002",menuUrl:"#",menuLevel:"1",parentMenuId:"0002",childMenuList:[]},
                    {menuId:"0003",menuName:"菜单管理",menuCode:"menu0003",menuUrl:"#",menuLevel:"1",parentMenuId:"0003",childMenuList:[]}
	];
	*/
　　	var menu_new = {"menus":[
  	                       {"menuId":"0001","menuName":"用户管理","menuCode":"user0001","menuUrl":"#","menuLevel":"1","parentMenuId":"0001","childMenuList":[{menuId:"0004",menuName:"子管理1",menuCode:"user0001",menuUrl:"#",menuLevel:"1",parentMenuId:"0001"},{menuId:"0005",menuName:"子管理2",menuCode:"user0001",menuUrl:"#",menuLevel:"1",parentMenuId:"0001"}]},
  	                     {"menuId":"0002","menuName:"角色管理","menuCode":"role0002","menuUrl":"#","menuLevel":"1","parentMenuId":"0002","childMenuList":[]},
  	                     {"menuId":"0003","menuName":"菜单管理","menuCode":"menu0003","menuUrl":"#","menuLevel":"1","parentMenuId":"0003","childMenuList":[]}
  	 	]};
　　	var s = menu_new.parseJSON();
　　	alert(s);
　　	/*
　　	$(function(){
　　		$("#menu-tmpl").tmpl(menuList).appendTo("#menu_ul");
　　	});
　　*/
	</script>



</body>
</html>

