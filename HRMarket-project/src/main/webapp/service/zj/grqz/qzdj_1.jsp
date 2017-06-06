<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title></title>
<jsp:include flush="true" page="/common/alert.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/styles/css/common.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath() %>/js/commonjs.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery-1.11.1.js"></script>
<script>
	$(function(){
		//$.get("/jobregist/qzdj_1.do",{code:"bip_id"},function(data){$("#bip_id").html(data);})
		//根据身份证号码判断性别和年龄 		
		$("#bipCitizenid").blur(function(){
			var len=$("#bipCitizenid").val().length;	
			if(len==18){
				$.get("/jobregist/qzdj_1.do",{code:"bipSex",bipCitizenid:$(this).val()},function(data){$("#bipSex").html(data);});
				$.get("/jobregist/qzdj_1.do",{code:"bipAge",bipCitizenid:$(this).val()},function(data){$("#bipAge").val(data);});
				$.get("/jobregist/qzdj_1.do",{code:"panduan",s:$(this).val()},function(data){
					/* if(data==1){
						var s=$("#bipCitizenid").val();
						window.open('qzdj_3.do?bipCitizenid='+s+'','_self');
					} */				
				})
			}else{
				$("#bipSex").html("");
				$("#bipAge").val("");
			}			
		})
		$.get("/jobregist/qzdj_1.do",{code:"bipMinzu"},function(data){$("#bipMinzu").html(data);})
		$.get("/jobregist/qzdj_1.do",{code:"bipZzmm"},function(data){$("#bipZzmm").html(data);})
		$.get("/jobregist/qzdj_1.do",{code:"bipHyzk"},function(data){$("#bipHyzk").html(data);})
		$.get("/jobregist/qzdj_1.do",{code:"bipHjxz"},function(data){$("#bipHjxz").html(data);})
		$.get("/jobregist/qzdj_1.do",{code:"bipRylb"},function(data){$("#bipRylb").html(data);})
		$.get("/jobregist/qzdj_1.do",{code:"bipJkzk"},function(data){$("#bipJkzk").html(data);})
		$.get("/jobregist/qzdj_1.do",{code:"bipCjqk"},function(data){$("#bipCjqk").html(data);})
		//省+市+区/街道 				
		$.get("/jobregist/qzdj_1.do",{code:"dwszs"},function(data){$("#dwszs").html(data);})
		$("#dwszs").change(function(){
			$("#dwszq").empty();
			$("#dwszj").empty();			
			$.get("/jobregist/qzdj_1.do",
				{code:"dwszq",
				selectedId:$("#dwszs").val(),
				region:"city"},
				function(data){$("#dwszq").html(data);
			})
			
		})
		$("#dwszq").change(function(){			
			$.get("/jobregist/qzdj_1.do",
				{code:"dwszj",
				selectedId:$("#dwszq").val(),
				region:"village"},
				function(data){$("#dwszj").html(data);
			})
		})
		//文化程度 
		$.get("/jobregist/qzdj_1.do",{code:"bipWhcd"},function(data){$("#bipWhcd").html(data);})
		
		//职业等级		
		$("#bipSJsdj").click(function(){
			var dx,dy;
			var dx=(screen.height/2-105)+"";
   			var dy=(screen.width/2-200)+"";
			var rValue,iTem;
			rValue=window.showModalDialog("../../../common/choosegz_ModalDialog_qyc.jsp",null,"dialogTop="+dx+";dialogLeft="+dy+";dialogHeight=210px;dialogWidth=400px;help=no;fullscreen=1;status=no;center=yes");		
			if(rValue != null){				
				$(this).html(rValue);
			}
				return;			
		})
		if($("#bipSZyjn").val()!=""){
			$.get("/jobregist/qzdj_1.do",{code:"bipSJsdj"},function(data){$("#bipSJsdj").html(data);});		
		}
		//职业技能 		
		$("#bipSZyjn").click(function(){
			var dx,dy;
			var dx=(screen.height/2-105)+"";
   			var dy=(screen.width/2-200)+"";
			var rValue,iTem;
			rValue=window.showModalDialog("../../../common/choosegz_ModalDialog_qyc.jsp",null,"dialogTop="+dx+";dialogLeft="+dy+";dialogHeight=210px;dialogWidth=400px;help=no;fullscreen=1;status=no;center=yes");		
			if(rValue != null){				
				$(this).html(rValue);
			}
				return;			
		})
			$.get("/jobregist/qzdj_1.do",{code:"bipSZyjn"},function(data){$("#bipSZyjn").html(data);});		
		//添加职业技能 
		$("#zyjntj").click(function(){
			if($("#bipSJsdj").val()=="" ||$("#bipSJsdj").val()==""||$("# bipSYears").val()==""){
				alert("该添加项必须填写完毕后，才能继续添加");
				return;
			}else{
				var reg=/^[0-9]{1,2}$/;
				
				//$!reg.test($("# bipSYears").val())
				if(!reg.test($("# bipSYears").val())){
					alert("从事年限有误 ");
					return;
				}else{
					var zyjn_text=$("#bipSJsdj option:selected").text();
					var zyjn_value=$("#bipSJsdj option:selected").val();
					
					var jsdj_text=$("#bipSJsdj option:selected").text();
					var jsdj_value=$("#bipSJsdj option:selected").val();
					
					var csnx_value=$("# bipSYears").val();
					
					var bipSJsdj=$("<td width='13%' align='right'>职业技能 </td ><td width='19%'><input type='hidden' name='bip_s_zyjn' value='"+zyjn_value+"'><input type='text' name='bipSJsdj' size='1' value='"+zyjn_text+"' readobipAgey='readobipAgey' style='WIDTH: 100%'></td >");			
					var bipSJsdj=$("<td width='11%' align='right'>技术等级 </td ><td width='18%'><input type='hidden' name='bip_s_jsdj' value='"+jsdj_value+"'><input type='text' name='bipSJsdj' value='"+jsdj_text+"' size='1' readobipAgey='readobipAgey' style='WIDTH: 100%'></td >");
					var  bipSYears=$("<td width='11%' align='right'>从事年限 </td ><td width='15%'><INPUT type='text' name='bip_s_years' value='"+csnx_value+"' readobipAgey='readobipAgey' style='WIDTH: 100%'></td >");
					var csnx=$("<td width='7%' align='center'><INPUT type='hidden' value='"+csnx_value+" style='WIDTH: 100%'></td >");
					var jnsc=$("<td width='8%' align='center'><input name='jnsc' type='button'  value='删除' class='BUTTON2' onClick='delRows(jywyTable)'></td >");
					var tr=$("<tr class='line2' align='center' ></tr >");
					var tab=$("<table id='jywyTable' width='100%'  align='center' border='0' cellpadding='0' cellspacing='1'  style='word-break:break-all;width:fixed'></table>");
					var div=$("<div></div>");
					tr.append(bipSJsdj);
					tr.append(bipSJsdj);
					tr.append( bipSYears);
					tr.append(csnx);
					tr.append(jnsc);			
					tab.append(tr);
					div.append(tab);			
					$("#panel_1").prepend(div);
					//一行div中的删除 
					jnsc.click(function(){
						$(this).parent().parent().parent().remove();
					})
					//清空选项 
					$("#bipSJsdj").empty();					
					if($("#bipSJsdj").val()!=""){
						$.get("/jobregist/qzdj_1.do",{code:"bipSJsdj"},function(data){$("#bipSJsdj").html(data);});		
					}else{
						$("#bipSJsdj").empty();
					}
					$("# bipSYears").val("");
				}
			}	
		})
		//清空职业技能列表 
		$("#zyjnqc").click(function(){
			if($("#panel_1").html()==""){
				alert("未找到清除对象 ");
				return;
			}else{
				if(confirm("确认清空列表吗 ")){
					$("#panel_1").empty();	
				}
				return;
			}
			
		})
		
		
		//外语 
		$.get("/jobregist/qzdj_1.do",{code:"init_jywy"},function(data){$("#init_jywy").html(data);})
		$("#init_jywy").change(function(){			
			$.get("/jobregist/qzdj_1.do",{code:"init_wyslcd"},function(data){$("#init_wyslcd").html(data);})
			$("#init_wysm").val("");
		})
		
		$("#wytj").click(function(){			
			//alert($(this).parent().parent().next());
			if($("#init_jywy").val()=="" || $("#init_wyslcd").val()=="" || $("#init_wysm").val()==""){
				alert("该添加项必须填写完毕后，才能继续添加");
				return;
			}			
			var ijwy_text=$("#init_jywy option:selected").text();
			var ijwy_value=$("#init_jywy option:selected").val();
			
			var init_wyslcd_text=$("#init_wyslcd option:selected").text();
			var init_wyslcd_value=$("#init_wyslcd option:selected").val();
			
			var init_wysm_value=$("#init_wysm").val();
			
			var init_jywy=$("<td width='13%' align='right'>具有外语 </td ><td width='19%'><input type='hidden' name='bip_fl_jywy' value='"+ijwy_value+"'><input type='text' name='init_jywy' size='1' value='"+ijwy_text+"' readobipAgey='readobipAgey' style='WIDTH: 100%'></td >");			
			var init_wyslcd=$("<td width='11%' align='right'>熟练程度 </td ><td width='18%'><input type='hidden' name='bip_fl_years' value='"+init_wyslcd_value+"'><input type='text' name='init_wyslcd' value='"+init_wyslcd_text+"' size='1' readobipAgey='readobipAgey' style='WIDTH: 100%'></td >");
			var init_wysm=$("<td width='11%' align='right'>外语说明 </td ><td width='15%'><INPUT type='text' name='init_wysm' value='"+init_wysm_value+"' readobipAgey='readobipAgey' style='WIDTH: 100%'></td >");
			var wytj=$("<td align='center'><INPUT type='hidden' value='"+init_wysm_value+" style='WIDTH: 100%'></td >");
			var wysc=$("<td width='8%' align='center'><input name='wysc' type='button'  value='删除' class='BUTTON2' onClick='delRows(jywyTable)'></td >");
			var tr=$("<tr class='line2' align='center' ></tr >");
			var tab=$("<table id='jywyTable' width='100%'  align='center' border='0' cellpadding='0' cellspacing='1'  style='word-break:break-all;width:fixed'></table>");
			var div=$("<div></div>");
			tr.append(init_jywy);
			tr.append(init_wyslcd);
			tr.append(init_wysm);
			tr.append(wytj);
			tr.append(wysc);			
			tab.append(tr);
			div.append(tab);			
			$("#panel_2").prepend(div);
			//一行div中的删除 
			wysc.click(function(){
				$(this).parent().parent().parent().remove();
			})
			$.get("/jobregist/qzdj_1.do",{code:"init_jywy"},function(data){$("#init_jywy").html(data);})						
			$("#init_jywy").change();
			$("#init_wysm").val("");
			
		})
		//外语-清空按钮 
		$("#wyqc").click(function(){
			if($("#panel_2").html()==""){
				alert("未找到清除对象 ");
				return;
			}else{
				if(confirm("确认清空列表吗 ")){
					$("#panel_2").empty();	
				}
				return;
			}
			
		})
				
		//计算机等级+熟练程度
		$.get("/jobregist/qzdj_1.do",{code:"bipPcDj"},function(data){$("#bipPcDj").html(data);})		
		$("#bipPcDj").change(function(){			
			$.get("/jobregist/qzdj_1.do",{code:"bipPcSlcd"},function(data){$("#bipPcSlcd").html(data);})
		})
		
		//择业信息 
		$.get("/jobregist/qzdj_1.do",{code:"dwxx"},function(data){$("#dwxx").html(data);})
		$.get("/jobregist/qzdj_1.do",{code:"dwhy"},function(data){$("#dwhy").html(data);})
		$.get("/jobregist/qzdj_1.do",{code:"dwjjlx"},function(data){$("#dwjjlx").html(data);})
		$.get("/jobregist/qzdj_1.do",{code:"gzdq"},function(data){$("#gzdq").html(data);})
		/* $("#gzdq").click(function(){
			var dx,dy;
			var dx=(screen.height/2-105)+"";
   			var dy=(screen.width/2-200)+"";
			var rValue,iTem;
			rValue=window.showModalDialog("../../../common/choosegzdq_ModalDialog_szd.jsp",null,"dialogTop="+dx+";dialogLeft="+dy+";dialogHeight=210px;dialogWidth=400px;help=no;fullscreen=1;status=no;center=yes");		
			if(rValue != null){				
				$(this).html(rValue);
			}
				return;			
		}) */
		//择业工种 
		$(".gz").click(function(){
			var dx,dy;
			var dx=(screen.height/2-105)+"";
   			var dy=(screen.width/2-200)+"";
			var rValue,iTem;
			rValue=window.showModalDialog("../../../common/choosegz_ModalDialog_qyc.jsp",null,"dialogTop="+dx+";dialogLeft="+dy+";dialogHeight=210px;dialogWidth=400px;help=no;fullscreen=1;status=no;center=yes");		
			if(rValue != null){				
				$(this).html(rValue);
			}
				return;			
		})
		$.get("/jobregist/qzdj_1.do",{code:"gz"},function(data){$("#gz").html(data);})
		$.get("/jobregist/qzdj_1.do",{code:"ygxs"},function(data){$("#ygxs").html(data);})		
		$("#gztj").click(function(){
			if($("#gz").val()=="" ||$("#ygxs").val()==""||$("#zdyx").val()==""||$("#zgyx").val()==""){
				alert("该添加项必须填写完毕后，才能继续添加");
				return;
			}else{
				var reg=/^[0-9]*$/;
				var zdyx1_value=$("#zdyx").val();
				var zgyx2_value=$("#zgyx").val();				
				if(!reg.test(zdyx1_value)||!reg.test(zgyx2_value)||zdyx1_value>zgyx2_value){
					alert("薪水超出范围 ");
					return;
					
				}else{
					var gz_text=$("#gz option:selected").text();
					var gz_value=$("#gz option:selected").val();
					
					var ygxs1_text=$("#ygxs option:selected").text();
					var ygxs1_value=$("#ygxs option:selected").val();
					
									
					var gz=$("<td width='40' align='right'>工种 </td ><td width='110'><input type='hidden' name='GZ' value='"+gz_value+"'><input type='text' size='1' value='"+gz_text+"' readobipAgey='readobipAgey' style='WIDTH: 100%'></td >");			
					var ygxs1=$("<td width='50' align='right'>用工形式 </td ><td width='80'><input type='hidden' name='YGXS' value='"+ygxs1_value+"'><input type='text' value='"+ygxs1_text+"' size='1' readobipAgey='readobipAgey' style='WIDTH: 100%'></td >");
					var zdyx=$("<td width='40' align='right'>月薪  </td ><td width='140'><INPUT type='text' name='ZDYX' value='"+zdyx1_value+"' readobipAgey='readobipAgey' style='WIDTH: 40px'>&nbsp;至&nbsp;<INPUT type='text' name='ZGYX' value='"+zgyx2_value+"' readobipAgey='readobipAgey' style='WIDTH: 40px'></td >");
					var gztj=$("<td width='40' align='right'><INPUT type='hidden'style='WIDTH: 100%'></td >");
					var gzsc=$("<td width='40' align='right'><input name='gzsc' type='button'  value='删除' class='BUTTON2'></td >");
					var tr=$("<tr class='line2' align='center' ></tr >");
					var tab=$("<table width='100%'  align='center' border='0' cellpadding='0' cellspacing='1'  style='word-break:break-all;width:fixed'></table>");
					var div=$("<div></div>");
					tr.append(gz);
					tr.append(ygxs1);
					tr.append(zdyx);
					tr.append(gztj);
					tr.append(gzsc);			
					tab.append(tr);
					div.append(tab);			
					$("#panel_3").prepend(div);
					//一行div中的删除 
					gzsc.click(function(){
						$(this).parent().parent().parent().remove();
					})
					//清空选项 
					$("#gz").empty();					
					if($("#gz").val()!=""){
						$.get("/jobregist/qzdj_1.do",{code:"ygxs"},function(data){$("#ygxs").html(data);});		
					}else{
						$("#ygxs").empty();
					}
					$("#zdyx").val("");
					$("#zgyx").val("");
				}
			}
			//清空列表 
			$("#gzqc").click(function(){
				if($("#panel_3").html()==""){
					alert("未找到清除对象 ");
					return;
				}else{
					if(confirm("确认清空列表吗 ")){
						$("#panel_3").empty();	
					}
					return;
				}
			
			})	
		})
		
		$("#baocun").click(function(){
			var bipCitizenidReg=/^([0-9]{17})([0-9]|X)$/;
			if($("#bipCitizenid").val()==""){
				alert("身份证号不得为空");
				$("#bipCitizenid").focus();
				return;
			}else{
				if(!bipCitizenidReg.test($("#bipCitizenid").val())){
					alert("身份证号格式不对");
					$("#bipCitizenid").focus();
					return;
				}
			}
			if($("#bipSex").val()==""){
				alert("性别为必添项，请选择一个！");
				$("#bipSex").focus();
				return;
			}
			if($("#bipName").val()==""){
				alert("姓名为必添项");
				$("#bipName").focus();
				return;
			}
			if($("#bipMinzu").val()==""){
				alert("民族为必添项，请选择一个！");
				$("#bipMinzu").focus();
				return;
			}
			if($("#bipHjxz").val()==""){
				alert("户籍性质为必添项，请选择一个！");
				$("#bipHjxz").focus();
				return;
			}
			if($("#bipRylb").val()==""){
				alert("人员类别为必添项，请选择一个！");
				$("#bipRylb").focus();
				return;
			}
			if($("#dwszs").val()==""&&$("#dwszq").val()==""){
				alert("户口所在地为必添项，请选择！");
				$("#dwszs").focus();
				return;
			}
			if($("#bipWhcd").val()==""){
				alert("文化程度为必添项，请选择一个！");
				$("#bipWhcd").focus();
				return;
			}
			if($("#bipConTelephone").val()==""||$("#bipConMobile").val()==""){
				alert("固话手机必添项其一，请填写！");
				$("#bipConTelephone").focus();
				return;
			}
			if($("#panel_1").html()==""){
				alert("职业技能为必添项");
				$("#bipSJsdj").focus();
				return;
			}
			/* if($("#gz").html()==""){
				alert("择业工种为必添项");
				$("#gz").focus();
				return;
			} */
	
			
			$("form").submit();
		});
		$("#cz").click(function(){
			if(confirm("确认清空列表吗 ")){
				$("#panel_3").empty();	
			}
					return;		
		})
	})


</script>
</head>
<body>
<form name="form1" action="/jobregist/save.do" method="post">
<table width="98%"  border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td height="20" valign="bottom">
		<img src="<%=request.getContextPath()%>/styles/images/right/now.gif" width="11" height="12"> 
			当前位置：职业介绍 &gt; 个人求职 &gt; 求职登记</td >
	</tr>
	<tr>
		<td valign="bottom" background="<%=request.getContextPath()%>/styles/images/right/dsline.gif" height="8"><img src="<%=request.getContextPath()%>/styles/images/index/spacer.gif"></td >
	</tr>
	<tr>
		<td height="20" valign="bottom">
		<table border="0" cellpadding="0" cellspacing="0" >
            <tr >
              <td ><table border="0" cellspacing="0" cellpadding="0">
                  <tr>
						<td valign="middle" background="<%=request.getContextPath()%>/styles/images/right/tagm_on_bg.gif" class="white" style="padding-left:10px;padding-top:2px">登记信息</td >
						<td><img src="<%=request.getContextPath()%>/styles/images/right/tagr_on_x.gif" width="23" height="18"></td >
                  </tr>
              </table></td>
              <td><table border="0" cellspacing="0" cellpadding="0">
                 <tr>
					 <td background="<%=request.getContextPath()%>/styles/images/right/tagm_off_bg.gif" style="padding-top:2px">
					 查看失业信息
					 </td >
              <td ><img src="<%=request.getContextPath()%>/styles/images/right/tagr_off_all.gif" width="23" height="18"></td >
            </tr >
              </table></td >
              <td ><table border="0" cellspacing="0" cellpadding="0">
                  <tr >
                      <td background="<%=request.getContextPath()%>/styles/images/right/tagm_off_bg.gif"style="padding-top:2px"><a href="#" class="link04">查看培训信息</a></td >
                      <td ><img src="<%=request.getContextPath()%>/styles/images/right/tagr_off_end.gif" width="23" height="18"></td >
                  </tr >
              </table>
            </td > 
          </tr >
      </table>
    </td > 
  </tr >
</table>
<table width="98%" align="center" border="0" cellpadding="0" cellspacing="0"  
	onClick="collapseCon('1');" class="titlehand">
	<tr > 
		<td width="60"> <table width="38" border="0" cellspacing="0" cellpadding="0">
				<tr> 
					<td width="30"><img src="<%=request.getContextPath()%>/styles/css/bb_d.gif"></td >
					<td width="8"><img src="<%=request.getContextPath()%>/styles/images/right/ico_up.gif" id="imgmini1"></td >
				</tr >
		</table></td >
		<td valign="bottom">登记信息&nbsp;&nbsp;&nbsp;提示：[个人初始登记有效期为:15天,使用修改功能可以延长有效期:12次]</td >
	</tr >
</table>
<table width="98%" border="0" cellspacing="0" cellpadding="0" style="display:block" id="c1" align="center" style="word-break:break-all;width:fixed">
  <tr >
    <td>
	    <table width="100%" border="0" cellspacing="1" cellpadding="0"   >
        <tr class="line1">
          <td width="13%" align="right"><span class="redtxt">*</span>身份证号码</td >
          <td width="20%"><INPUT  id="bipCitizenid" name="bipCitizenid" style="WIDTH: 100%"  value="" /></td >
          <td width="13%" align="right" ><span class="redtxt">*</span>性　　别</td >
          <td width="20%"><select name="bipSex" id="bipSex" size="1"  style="WIDTH: 100%" disabled></select></td >
          <td width="13%" align="right">年　　龄</td >
          <td width="20%"><INPUT id="bipAge"  name="bipAge"   style="WIDTH: 100%" value="${Age} " disabled></td >
        </tr>
        <tr class="line2">
          <td align="right"><span class="redtxt">*</span>姓　　名</td >
          <td ><INPUT id="bipName" name="bipName" maxlength="32"  style="WIDTH: 100%" value="${Name}"></td >
          <td align="right"><span class="redtxt">*</span>民　　族</td >
          <td ><select id="bipMinzu" name="bipMinzu" size="1"  style="WIDTH: 100%" ></select></td >
          <td align="right">政治面貌</td >
          <td ><select id="bipZzmm" name="bipZzmm" size="1"  style="WIDTH: 100%" ></select></td >
        </tr > 
        <tr class="line1">
          <td align="right">婚姻状况</td >
          <td ><select id="bipHyzk" name="bipHyzk" size="1"  style="WIDTH: 100%" ></select></td >
          <td align="right"><span class="redtxt">*</span>户籍性质</td >
          <td ><select id="bipHjxz" name="bipHjxz" size="1"  style="WIDTH: 100%" ></select></td >            
          <td align="right"><span class="redtxt">*</span>人员类别</td >
          <td ><select id="bipRylb" name="bipRylb" size="1"  style="WIDTH: 100%" ></select></td >
        </tr >
        <tr class="line2">
          <td align="right" >健康状况</td >
          <td ><select id="bipJkzk" name="bipJkzk" size="1"  style="WIDTH: 100%"></select>
          </td >
		 <td align="right">
				     <table border="0" cellpadding="0" cellspacing="0">
							<tr class="line2" id="id1"  ><td align="right">残疾状况</td ></tr >
				    </table>
		 </td>
		 <td class="line2" colspan="3">
			     <table border="0" cellpadding="0" cellspacing="0" width="100%" > 
             <tr id="id2"  >
               <td ><select id="bipCjqk" name="bipCjqk" size="1"  style="WIDTH: 100%" ></select></td >				
             </tr >
		      </table></td >
        </tr >
        <tr class="line1">
          <td align="right">视　　力</td >
          <td >左<INPUT  name="bipEyesightleft" maxlength="3" style="WIDTH: 34%" value="">
            	右 <INPUT  name="bipEyesightright"   maxlength="3"  style="WIDTH: 34%" value="">
            </td >
          <td align="right">身　　高</td >
          <td ><INPUT  name="bipLong"   maxlength="3" style="WIDTH: 65%" value="">(厘米)</td >
          <td align="right">体　　重</td >
          <td ><INPUT  name="bipWeight"   maxlength="3"  style="WIDTH: 65%" value="">(公斤)</td >
        </tr >
  
        <tr class="line2">
        <td align="right"><span class="redtxt">*</span>户口所在地</td>
        <td ><select id="dwszs" name="dwszs" style="WIDTH: 100%"></select></td>
        <td align="right" >市(区\县)</td>
        <td id="sqx" ><select id="dwszq" name="dwszq" style="WIDTH: 100%" ></select></td>
        <td  align="right" >街(镇\乡)</td>
        <td id="jzx"><select id="dwszj" id="dwszj" name="dwszj" style="WIDTH: 100%" ></select></td>
        </tr >
        
			<tr class="line2">
				<td align="right"><span class="redtxt">*</span>文化程度</td >
				<td><select id="bipWhcd" name="bipWhcd" style="width:100%" ></select></td>
				<td align="right">所学专业</td >
				<td ><input  name="bipSubject" maxlength="32"   style="WIDTH: 100%" value=""></td >
				<td align="right">毕业时间</td >
				<td ><input  name="bipBybipConMobile" maxlength="32"   style="WIDTH: 100%" value="" maxlength="8"></td >
			</tr>
				<tr class="line1">
					<td align="right">毕业学校</td >
					<td colspan="5"><input  name="bipGraduateschool" maxlength="32"   style="WIDTH: 100%" value=""></td >
					
				</tr>
				
				<tr class="line2">
					<td align="right"><span class="redtxt">*</span>固定电话</td >
					<td><INPUT  name="bipConTelephone"    style="WIDTH: 100%" value="" maxlength="32"></td >
					<td width="12%" align="right" ><span class="redtxt">*</span>手　机</td >
					<td width="21%" ><INPUT  name="bipConMobile"   maxlength="11"  style="WIDTH: 100%" value="">
					</td>
					<td align="right">E-mail</td >
					<td width="21%"><INPUT  name="bipConEmail" maxlength="48"  style="WIDTH: 100%" value="">
					</td >
				</tr>
				<tr class="line1">
					<td align="right">邮政编码</td >
					<td ><INPUT  name="bipConPostcode" maxlength="6"   style="WIDTH: 100%" value=""></td >
					<td align="right">联系人</td >
					<td ><INPUT  name="bipConContact" maxlength="32"    style="WIDTH: 100%" value=""></td >
					<td align="right" >联系人电话</td >
					<td ><INPUT  name="bipConContacttel" maxlength="32"   style="WIDTH: 100%" value=""></td >
				</tr>
				<tr class="line2">
				<td width="13%" align="right">居住地址</td >
				 <td colspan="5"><INPUT  name="bipResAddress" maxlength="32"   style="WIDTH: 100%" value=""></td >
				</tr >
				<tr class="line1">
					<td align="right">第二学历</td >
					<td colspan="5"><textarea name="bipEducationallevel2"  style="width:100%" ></textarea></td >
				</tr>
				<tr class="line2"> 
		          <td width="13%" align="right" >工作简历</td >
				  <td class="line1" colspan="5"><textarea name="bipResume" style="width:100%" ></textarea> </td >
		          </tr >
				<tr class="line1">
				<td width="13%" align="right">其他说明</td >
				 <td colspan="5"><textarea id="bipQtsm" name="bipQtsm" style="width:100%"></textarea></td >
				</tr >
			</table>
		</td >
	</tr>
</table>
	
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="titlehand" onClick="collapseCon('4');">
	<tr >
		<td width="60"> 
			<table width="37" border="0" cellpadding="0" cellspacing="0">
				<tr > 
					<td width="30"><img src="<%=request.getContextPath()%>/styles/css/bb_d.gif" height="19"></td >
					<td width="7"><img src="<%=request.getContextPath()%>/styles/images/right/ico_up.gif" id="imgmini4"></td >
				</tr >
			</table>
		</td >
		<td valign="bottom">其它信息</td >
	</tr >
</table>
	 
<TABLE width="98%" border=0  align="center" cellPadding=0 cellSpacing=1  class="tablebody" style="display:block" id="c4">
  <tr class="line2">
      <td width="12%" align="right"><input name="bipTLowersecurity" type="checkbox"  class="radio" value="1"></td >
      <td colspan="18%">          低保人员</td >
      <td width="12%" align="right" ><input name="bipTDestitute" type="checkbox" class="radio" value="1" ></td >
      <td width="18%" >          特困人员</td >
      <td width="12%" align="right" ><input type="checkbox" name="bipTNewgraduate"  class="radio" value="1" >  </td >
      <td width="26%" > 应届高校毕业生 </td >
  </tr >
  <tr class="line1">
      <td width="12%" align="right"><input name="bipTVeteran" type="checkbox"  class="radio" value="1" ></td >
      <td colspan="18%">          复员退伍</td >
      <td width="12%" align="right" ><input type="checkbox" name="bipTOthercities"  class="radio" value="1"></td >
      <td width="18%" >          外埠转入</td >
      <td width="12%" align="right" ><input type="checkbox" name="bipTRhfl"  class="radio" value="1">  </td >
      <td width="26%" > 是否人户分离 </td >
  </tr >
  <tr class="line2">
      <td width="12%" align="right"><input name="bipTPeasant" type="checkbox"  class="radio" value="1" ></td >
      <td colspan="18%">          农转非</td >
      <td width="12%" align="right" ><input type="checkbox" name="bipTCriminal"  class="radio" value="1" ></td >
      <td width="18%" >          两劳释放</td >
      <td width="12%" align="right" ><input type="checkbox" class="radio" name="bipTCzjyyhz" value="1">  </td >
      <td width="26%" > 是否持再就业优惠证</td >
  </tr >
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="titlehand" onClick="collapseCon('5');">
  <tr>
    <td width="60"> 
      <table width="37" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td width="30"><img src="<%=request.getContextPath()%>/styles/css/bb_d.gif" height="19"></td >
          <td width="7"><img src="<%=request.getContextPath()%>/styles/images/right/ico_up.gif" id="imgmini5"></td >
        </tr >
      </table>
    </td >
    <td valign="bottom">具有信息</td >
  </tr >
</table>
	
      <table width="98%" border="0" cellspacing="0"  align="center" cellpadding="0" style="display:block" id="jnTable">
        <tr  align="center" >
          <td valign="top"> 
            <table id="zyjnTable" width="100%" border="0" cellpadding="0" cellspacing="1">
              <tr class="line1"> 
                <td width="13%" align="right">职业技能</td >
				<td id="o2" width="19%"><select id="bipSZyjn" name="bipSZyjn" size="1"  style="WIDTH: 100%"></select></td >
                <td width="11%" align="right">技术等级</td >
                <td width="18%"><select id="bipSJsdj" name="bipSJsdj" size="1"  style="WIDTH: 100%" ></select></td >
                <td width="11%" align="right">从事年限</td >
                <td width="15%"> <INPUT  id=" bipSYears" name=" bipSYears"  style="WIDTH: 100%" maxlength="2"> </td>
                <td width="7%" align="center" > 
                  <input id="zyjntj" name="zyjntj" type="button"  value="添加" class="BUTTON2"></td >
                <td width="8%" align="center"> 
                  <input id="zyjnqc" type="button"  value="清空" class="BUTTON2"></td >
              </tr >
            </table>
            <div id="panel_1" > </div>
            <!-- 外语 div+css+jQuery -->
            <table id="jywyTable" width="100%"  align="center" border="0" cellpadding="0" cellspacing="1"  style="word-break:break-all;width:fixed">
              
              <tr class="line2" align="center" > 
                <td width="13%" align="right">具有外语 </td >
                <td width="19%">
                	<select class="init_jywy" id="init_jywy" size="1"  style="WIDTH: 100%"></select></td >
                <td width="11%" align="right">熟练程度 </td >
                <td width="18%">
                	<select id="init_wyslcd" size="1" style="WIDTH: 100%"></select>
                </td >
                <td width="11%" align="right">外语说明 </td >
                <td width="15%"><INPUT  id="init_wysm" style="WIDTH: 100%"></td >
                <td width="7%" align="center"> 
                	<input id="wytj" name="wytj" type="button"  value="添加" class="BUTTON2"></td >
                <td width="8%" align="center"> 
                  	<input id="wyqc" name="wyqc" type="button"  value="清空" class="BUTTON2"></td >
              </tr >             	
			</table>
			<div id="panel_2" > </div>
			  <table  width="100%" border="0" cellpadding="0" align="center"  cellspacing="1">
              <tr class="line1" align="center" >
                <td width="13%" align="right">计算机等级</td >
                <td width="19%"><select id="bipPcDj" name="bipPcDj" size="1"  style="WIDTH: 100%" ></select></td >
                <td width="11%" align="right">熟练程度</td >
                <td width="18%"><select id="bipPcSlcd" name="bipPcSlcd" size="1" style="WIDTH: 100%" ></select></td >
				<td width="10%"></td><td width="15%"></td><td width="7%"></td><td width="8%"></td>
              </tr >
            </table>
            </td >
        </tr >
      </table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="titlehand" onClick="collapseCon('6');">
  <tr>
    <td width="60"> 
      <table width="37" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td width="30"><img src="<%=request.getContextPath()%>/styles/css/bb_d.gif" height="19"></td >
          <td width="7"><img src="<%=request.getContextPath()%>/styles/images/right/ico_up.gif" id="imgmini6"></td >
        </tr >
      </table>
    </td >
    <td valign="bottom">择业信息</td >
  </tr >
</table>
<table width="98%" border="0" cellspacing="0" align="center"  cellpadding="0" id="c6" style="display:block">
  <tr align="center" >
    <td>
    	<TABLE width="100%" border=0 cellPadding=0 cellSpacing=1 class="tablebody">
        <tr class="line1">
          <td width="13%" align="right">单位性质</td >
          <td width="22%" ><select id="dwxx" name="dwxx" size="1"  style="WIDTH: 100%" ></select></td >
          <td width="10%" align="right">单位行业</td >
          <td width="21%" ><select id="dwhy" name="dwhy" size="1"  style="WIDTH: 100%"></select></td >
          <td width="11%" align="right">经济类型</td >
          <td width="23%" ><select id="dwjjlx" name="dwjjlx" size="1"  style="WIDTH: 100%"></select></td >
        </tr>
        <tr class="line2">
          <td align="right">工作地区</td >
          <td ><select id="gzdq" name="gzdq" size="1"  style="WIDTH: 100%"></select></td>
             <td></td>
             <td></td>
             <td></td>
             <td></td>
        </tr>
      </table>
		  <table width="100%" border="0" cellpadding="0" cellspacing="1">
		    <tr class="line2">
		      <td width="14%" align="right">是否接收短信</td >
		      <td width="17%"><input name="sfjsdx" type="checkbox" value="1"  class="radio" ></td >
		      <td width="14%" align="right">是否参加培训</td >
		      <td width="14%"><input name="sfcjpx" type="checkbox" value="1"  class="radio"></td >
		      <td width="18%" align="right">是否接受职业指导</td >
		      <td width="23%"><input name="sfjszyzd" type="checkbox" value="1"  class="radio"></td >
		    </tr>
		</table>
    </td >
  </tr >
</table>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="titlehand" onClick="collapseCon('7');">
  <tr >
    <td width="60"> 
      <table width="37" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td width="30"><img src="<%=request.getContextPath()%>/styles/css/bb_d.gif" height="19"></td >
          <td width="7"><img src="<%=request.getContextPath()%>/styles/images/right/ico_up.gif" id="imgmini7"></td >
        </tr >
      </table>
    </td >
    <td valign="bottom">择业工种</td >
  </tr >
</table>
<table width="98%"  id="c7"
  border=0 cellPadding=0 cellSpacing=1 align="center"   class="tablebody" style="display:block"  >
  <tr align="center" >
  	<td>
			<table id="qzgzTable" width="100%" border=0 cellPadding=0 cellSpacing=1  class="tablebody" style="display:block"  >
			  <tr class="line1" align="center">
			    <td width="40"><span class="redtxt">*</span>工种</td>
				<td id="o1" width="110"><select class="gz" id="gz" name="gz" size="1"  style="WIDTH: 100%"></select></td >
			    <td width="50">用工形式</td>
				<td width="80"><select class="ygxs1" id="ygxs" name="ygxs" size="1"  style="WIDTH: 100%"></select></td >
			    <td width="50" align="right">月薪</td>
				<td width="140">
					<div id="yx" style="display:">
					<table><tr><td>
					<input id="zdyx" name="zdyx" type="text" style="width:40px" maxlength="6">
                  	至
					<input id="zgyx" name="zgyx" type="text" style="width:40px" maxlength="6" >
					元</td></tr></table>
					</div>
				</td >
					<!--  -->
			    <td width="40"><input  type="button" id="gztj" name="gztj" value="添加" class="BUTTON2" ></td >
			    <td width="40"><input  type="button" id="gzqc" name="gzsc" value="清空" class="BUTTON2"></td >
			  </tr >
			</table>
			
		</td>
	</tr>	
</table>
<table width="98%"  id="c8"
  border=0 cellPadding=0 cellSpacing=1 align="center"   class="tablebody" style="display:block"  >
  <tr align="center" >
  	<td>
			<div id="panel_3"></div>
			
		</td>
	</tr>	
</table>
<!-- <div id="panel_3"></div>	 -->
<TABLE width="98%" border=0 cellPadding="0" cellSpacing=1 align="center"   class="tablebody">
  <tr align="center">
    <td colspan="9">
      &nbsp;&nbsp; 
  </tr >
  <tr align="center">
    <td colspan="9" class="line2">
      <input  type="button" id="baocun" class="BUTTONs3" name="bc"  value="保 存"> 
      &nbsp;&nbsp; 
      <INPUT name="cz" type="reset" class="BUTTONs3" id="cz" value="取 消" onClick="valueReset();">
      <input name="hkszd" type="hidden">
  </tr >
</TABLE>
</form>
</body>
</html>