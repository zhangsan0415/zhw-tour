(function ($) {
	//弹出框公共方法
	window.Ewin = function () {
		 var html = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">' +
		  '<div class="modal-dialog modal-sm">' +
		   '<div class="modal-content">' +
		   '<div class="modal-header">' +
		   '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>' +
		   '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
		   '</div>' +
		   '<div class="modal-body">' +
		   '<p>[Message]</p>' +
		   '</div>' +
		   '<div class="modal-footer">' +
		 '<button type="button" class="btn btn-default cancel" data-dismiss="modal">[BtnCancel]</button>' +
		 '<button type="button" class="btn btn-primary ok" data-dismiss="modal">[BtnOk]</button>' +
		 '</div>' +
		   '</div>' +
		  '</div>' +
		  '</div>';
	 
	 
		 var dialogdHtml = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">' +
		  '<div class="modal-dialog">' +
		   '<div class="modal-content">' +
		   '<div class="modal-header">' +
		   '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>' +
		   '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
		   '</div>' +
		   '<div class="modal-body">' +
		   '</div>' +
		   '</div>' +
		  '</div>' +
		  '</div>';
		 var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
		 var generateId = function () {
			 var date = new Date();
			 return 'mdl' + date.valueOf();
		 };
		 
		 var init = function (options) {
			 options = $.extend({}, {
				 title: "操作提示",
				 message: "提示内容",
				 btnok: "确定",
				 btncl: "取消",
				 width: 200,
				 auto: false
			 }, options || {});
			 var modalId = generateId();
			 var content = html.replace(reg, function (node, key) {
				 return {
					  Id: modalId,
					  Title: options.title,
					  Message: options.message,
					  BtnOk: options.btnok,
					  BtnCancel: options.btncl
				 }[key];
			 });
			 $('body').append(content);
			 $('#' + modalId).modal({
				 width: options.width,
				 backdrop: 'static'
			 });
			 $('#' + modalId).on('hide.bs.modal', function (e) {
				 $('body').find('#' + modalId).remove();
			 });
			 return modalId;
		 };
	 
		 return {
			 alert: function (options) {
				 if (typeof options == 'string') {
					  options = {
							  message: options
					  };
				 }
				 var id = init(options);
				 var modal = $('#' + id);
				 modal.find('.ok').removeClass('btn-success').addClass('btn-primary');
				 modal.find('.cancel').hide();
			 
				 return {
					  id: id,
					  on: function (callback) {
						  if (callback && callback instanceof Function) {
							  modal.find('.ok').click(function () { callback(true); });
						  }
					  },
					  hide: function (callback) {
						  if (callback && callback instanceof Function) {
							  modal.on('hide.bs.modal', function (e) {
								  callback(e);
							  });
						  }
					  }
				 };
			 },
			 confirm: function (options) {
				 var id = init(options);
				 var modal = $('#' + id);
				 modal.find('.ok').removeClass('btn-primary').addClass('btn-success');
				 modal.find('.cancel').show();
				 return {
					  id: id,
					  on: function (callback) {
						  if (callback && callback instanceof Function) {
							  modal.find('.ok').click(function () { callback(true); });
							  modal.find('.cancel').click(function () { callback(false); });
						  }
					  },
					  hide: function (callback) {
						  if (callback && callback instanceof Function) {
							  modal.on('hide.bs.modal', function (e) {
								  callback(e);
							  });
						  }
					  }
				 };
			 },
			 dialog: function (options) {
				 options = $.extend({}, {
					  title: 'title',
					  url: '',
					  width: 800,
					  height: 550,
					  onReady: function () { },
					  onShown: function (e) { }
				 }, options || {});
				 var modalId = generateId();
				 
				 var content = dialogdHtml.replace(reg, function (node, key) {
					  return {
						  Id: modalId,
						  Title: options.title
					  }[key];
				 });
				 $('body').append(content);
				 var target = $('#' + modalId);
				 target.find('.modal-body').load(options.url);
				 if (options.onReady())
					 options.onReady.call(target);
				 target.modal();
				 target.on('shown.bs.modal', function (e) {
					  if (options.onReady(e))
					  options.onReady.call(target, e);
				 });
				 target.on('hide.bs.modal', function (e) {
					 $('body').find(target).remove();
				 });
			 }
		};
	 }();
	 
	 //封装Ajax bootstrapPaginator分页
	 window.ZHW_Page = function(){
		 var getTBody = function(arr,dataIndex){
			 var tBody = "<tbody>";
			 if(arr){
				 for(var i = 0; i<arr.length; i++){
					 var str = "<tr>";
					 var element = arr[i];
					 for(var j=0;j<dataIndex.length;j++){
						 var property = dataIndex[j];
						 if(!jQuery.isArray(property)){//不是操作直接赋值 
							 var tdValue = element[property];
							 if(tdValue){
								 str = str + "<td style='text-align:center;'>" + tdValue +"</td>";
							 }else{
								 str = str +"<td style='text-align:center;'></td>";
							 }
						 }else{//是操作做特殊处理
							 str = str + "<td style='text-align:center;'>";
							 for(var k = 0;k<property.length;k++){
								 var btnText = property[k].text;
								 var btnFunc = property[k].func;
								 var paramIndex = property[k].index;
								 str = str + "<button class='btn btn-info' onclick='"+btnFunc(arr[i][dataIndex[paramIndex]])+"'>"
								 	+btnText+"</button>";
							 }
							 str = str + "</td>";
						 }
					 }
					 str = str + "</tr>";
					 tBody = tBody + str;
				 }
			 }
			 tBody = tBody + "</tbody>";
			 return tBody;
		 };
		 
		 return {
			 paging:function(options){
				 var tableId = options.tableId;
				 var clientPageId = options.clientPageId;
				 var tableHead = options.tableHead;
				 var dataIndex = options.dataIndex;
				 var params = options.params;
				 
				 var tHead = "<thead><tr>";
				 $.each(tableHead,function(index,element){
					 tHead=tHead+"<td style='text-align:center;'>"+element+"</td>";
				 });
				 tHead = tHead + "</tr></thead>";
				 
				 var table = $("#"+tableId);
				 var pageClient = $("#" + clientPageId);
				 
				 params.currentPage = 1;
				 $.ajax({
					 type:'POST',
					 dataType:'json',
					 url:options.url,
					 async:false,
					 data:params,
					 error:function(){
						 Ewin.alert("系统繁忙，请稍候重试！");
					 },
					 success:function(data){
//						 var dataObj = JSON.parse(data);
						 var dataObj = data;
						 if(dataObj.status != 0){
							 Ewin.alert("系统繁忙，请稍候重试！");
							 return;
						 }
						 
						 var tBody = getTBody(dataObj.obj,dataIndex);
						 table.html(tHead+tBody);
						 
						 var totalPages = data.totalPages; //获取总页数
						 var currentPage = data.currentPage; //得到currentPage
						 var pageSize = data.pageSize; //每页显示多少条
						 
						 var pageOptions = {
								 currentPage:currentPage,
								 totalPages: totalPages,
								 size:"normal",
							     bootstrapMajorVersion: 3,
							     alignment:"right",
							     numberOfPages:pageSize,
							     itemTexts: function (type, page, current) {
								         switch (type) {
									         case "first": return "首页";
									         case "prev": return "上一页";
											 case "next": return "下一页";
									         case "last": return "末页";
									         case "page": return page;
								         }
							     },
							     onPageClicked: function (event, originalEvent, type, page){//给每个页眉绑定一个事件，其实就是ajax请求，其中page变量为当前点击的页上的数字。
							    	 params.currentPage = page;
							    	 $.ajax({
											 type:'POST',
											 dataType:'json',
											 url:options.url,
											 async:false,
											 data:params,
											 error:function(){
												 Ewin.alert("系统繁忙，请稍候重试！");
											 },
								             success:function (data) {
//									            	 var dataObj = JSON.parse(data);
													 var dataObj = data;

													 if(dataObj.status != 0){
														 Ewin.alert("系统繁忙，请稍候重试！");
														 return;
													 }
													 
													 var tBody = "<tbody>";
													 var arr = dataObj.obj;
													 if(arr){
														 for(var i = 0; i<arr.length; i++){
															 var str = "<tr>";
															 var element = arr[i];
															 for(var j=0;j<dataIndex.length;j++){
																 var property = dataIndex[j];
																 var tdValue = element[property];
																 if(tdValue){
																	 str = str + "<td style='text-align:center;'>" + tdValue +"</td>";
																 }else{
																	 str = str +"<td style='text-align:center;'></td>";
																 }
															 }
															 str = str + "</tr>";
															 tBody = tBody + str;
														 }
													 }
													 tBody = tBody + "</tbody>";
													 table.html(tHead+tBody);
								             }
								        });
							     }
						 };
						 
						 pageClient.bootstrapPaginator(pageOptions);
					 }
					 
				 });
                        
                         
			 }
		 };
	 }();
	 
})(jQuery);


/*
 * 调用方式就是： Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) { if (!e) {
 * return; } });
 * 
 * Ewin.alert("操作成功！");
 * 
 * var options = {tableId:'',clientPageId:'',url:'',tableHead:[],dataIndex:[],params:{}};
 * 分页调用方式： ZHW_Page.paging(options)
 */
