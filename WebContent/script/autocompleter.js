$(document).ready(function() {
	 $("#managerinfo").hide();
	$("#managerName").autocomplete({
			source : function(request, response) {
				$.ajax({
					url : "SearchController",
					type : "POST",
					data : {
						term : request.term
					},
					dataType : "json",
					success : function(data) {
							response(data);
					}
				}); //Ajax End
			},
			minLength:3,
			search: function (event, ui) {
				reset();
				$("#managerNameInfo").empty();
				 $("#managerinfo").hide();
				$('#employeeEmail').val("");
				 
			},
			select: function (event, ui) {
					event.preventDefault();
					$(this).val(ui.item.ename);
					
					$('#employeeEmail').val(ui.item.email);
					$('#empID').val(ui.item.empId);
					$('#managerNameInfo').empty().prepend('<b>EMP NO:</b> '+ui.item.empId+', <b>Designation:</b> '+ui.item.designation);
					
		}
	}); // Autocomplete End
	
	$("#peer1").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "SearchController",
				type : "POST",
				data : {
					term : request.term
				},
				dataType : "json",
				success : function(data) {
						response(data);
				}
			}); //Ajax End
		},
		minLength:3,
		search: function (event, ui) {
				$('#peer1Email').val("");
			 	$("#peer1Info").empty();
			 				 	
		},
		select: function (event, ui) {
				event.preventDefault();
				$(this).val(ui.item.ename);
				$('#peer1Email').val(ui.item.email);
				$('#peer1Info').empty().prepend('<b>EMP NO:</b> '+ui.item.empId+', <b>Designation:</b> '+ui.item.designation);
				
			
	}
}); // Autocomplete End
	
	$("#peer2").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "SearchController",
				type : "POST",
				data : {
					term : request.term
				},
				dataType : "json",
				success : function(data) {
						response(data);
				}
			}); //Ajax End
		},
		minLength:3,
		search: function (event, ui) {
			 	$("#peer2Info").empty();
			 	$('#peer2Email').val("");
			 	
		},
		select: function (event, ui) {
				event.preventDefault();
				$(this).val(ui.item.ename);
				$('#peer2Email').val(ui.item.email);
				$('#peer2Info').empty().prepend('<b>EMP NO:</b> '+ui.item.empId+', <b>Designation:</b> '+ui.item.designation);
				
			
	}
}); 
	
	$("#crossfunction").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "SearchController",
				type : "POST",
				data : {
					term : request.term
				},
				dataType : "json",
				success : function(data) {
						response(data);
				}
			}); //Ajax End
		},
		minLength:3,
		search: function (event, ui) {
			 	$("#crossfunctionInfo").empty();
			 	$('#crossfunctionEmail').val("");
		},
		select: function (event, ui) {
				event.preventDefault();
				$(this).val(ui.item.ename);
				$('#crossfunctionEmail').val(ui.item.email);
				$('#crossfunctionInfo').empty().prepend('<b>EMP NO:</b> '+ui.item.empId+', <b>Designation:</b> '+ui.item.designation);
				
			
	}
}); 
	$("#hr").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "SearchController",
				type : "POST",
				data : {
					term : request.term
				},
				dataType : "json",
				success : function(data) {
						response(data);
				}
			}); //Ajax End
		},
		minLength:3,
		search: function (event, ui) {
			 	$("#hrInfo").empty();
			 	$('#hrEmail').val("");
			 	
		},
		select: function (event, ui) {
				event.preventDefault();
				$(this).val(ui.item.ename);
				$('#hrEmail').val(ui.item.email);
				$('#hrInfo').empty().prepend('<b>EMP NO:</b> '+ui.item.empId+', <b>Designation:</b> '+ui.item.designation);
				
			
	}
}); 
	$("#it").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "SearchController",
				type : "POST",
				data : {
					term : request.term
				},
				dataType : "json",
				success : function(data) {
						response(data);
				}
			}); //Ajax End
		},
		minLength:3,
		search: function (event, ui) {
			 	$("#itInfo").empty();
			 	$('#itEmail').val("");
			 	
		},
		select: function (event, ui) {
				event.preventDefault();
				$(this).val(ui.item.ename);
				$('#itEmail').val(ui.item.email);
				$('#itInfo').empty().prepend('<b>EMP NO:</b> '+ui.item.empId+', <b>Designation:</b> '+ui.item.designation);
			
	}
}); 
	$("#admin").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "SearchController",
				type : "POST",
				data : {
					term : request.term
				},
				dataType : "json",
				success : function(data) {
						response(data);
				}
			}); //Ajax End
		},
		minLength:3,
		search: function (event, ui) {
			 	$("#adminInfo").empty();
			 	$('#adminEmail').val("");
			 	
		},
		select: function (event, ui) {
				event.preventDefault();
				$(this).val(ui.item.ename);
				$('#adminEmail').val(ui.item.email);
				$('#adminInfo').empty().prepend('<b>EMP NO:</b> '+ui.item.empId+', <b>Designation:</b> '+ui.item.designation);
			
	}
}); 
	$("#qmo").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "SearchController",
				type : "POST",
				data : {
					term : request.term
				},
				dataType : "json",
				success : function(data) {
						response(data);
				}
			}); //Ajax End
		},
		minLength:3,
		search: function (event, ui) {
			 	$("#qmoInfo").empty();
			 	$('#qmoEmail').val("");
		},
		select: function (event, ui) {
				event.preventDefault();
				$(this).val(ui.item.ename);
				$('#qmoEmail').val(ui.item.email);
				$('#qmoInfo').empty().prepend('<b>EMP NO:</b> '+ui.item.empId+', <b>Designation:</b> '+ui.item.designation);
			
	}
}); 
	
	$("#finance").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "SearchController",
				type : "POST",
				data : {
					term : request.term
				},
				dataType : "json",
				success : function(data) {
						response(data);
				}
			}); //Ajax End
		},
		minLength:3,
		search: function (event, ui) {
			 	$("#financeInfo").empty();
			 	$('#financeEmail').val("");
			 	
		},
		select: function (event, ui) {
				event.preventDefault();
				$(this).val(ui.item.ename);
				$('#financeEmail').val(ui.item.email);
				$('#financeInfo').empty().prepend('<b>EMP NO:</b> '+ui.item.empId+', <b>Designation:</b> '+ui.item.designation);
			
	}
});
	
	$("#recruitment").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "SearchController",
				type : "POST",
				data : {
					term : request.term
				},
				dataType : "json",
				success : function(data) {
						response(data);
				}
			}); //Ajax End
		},
		minLength:3,
		search: function (event, ui) {
			 	$("#recruitmentInfo").empty();
			 	$('#recruitmentEmail').val("");
			 	
		},
		select: function (event, ui) {
				event.preventDefault();
				$(this).val(ui.item.ename);
				$('#recruitmentEmail').val(ui.item.email);
				$('#recruitmentInfo').empty().prepend('<b>EMP NO:</b> '+ui.item.empId+', <b>Designation:</b> '+ui.item.designation);
			
	}
});
	$("#rmg").autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "SearchController",
				type : "POST",
				data : {
					term : request.term
				},
				dataType : "json",
				success : function(data) {
						response(data);
				}
			}); //Ajax End
		},
		minLength:3,
		search: function (event, ui) {
			 	$("#rmgInfo").empty();
			 	$('#rmgEmail').val("");
			 	
		},
		select: function (event, ui) {
				event.preventDefault();
				$(this).val(ui.item.ename);
				$('#rmgEmail').val(ui.item.email);
				$('#rmgInfo').empty().prepend('<b>EMP NO:</b> '+ui.item.empId+', <b>Designation:</b> '+ui.item.designation);
			
	}
});
	
	$.ui.autocomplete.prototype._renderItem = function(ul, item) {
	return $("<li></li>").data("item.autocomplete", item).append(
			"<a>" + item.ename + "</a>").appendTo(ul);
	};
	
	
	$("#seach").click(function(){
		reset();
		 var empid = $('#employeeEmail').val();
		 if(empid==""){
			 $('#searchError').empty().prepend("Please provide valid employee name..");
			 return false;
		 }
		 var name = $('#empID').val();
		$.ajax({
			url : "./adminApplication.do?action=getManagerInfo",
			type : "POST",
			  data: "name=" + name,
			  dataType : "json",
			success : function(data) {
				setdata(data);
			},
            error: function(e){
                alert('Error: ' + e);
            }
	});
	});
	
	$("#close").click(function(){
		 $("#managerinfo").hide();
	});
	
	function contains(a, obj) {
	    var i = a.length;
	    while (i--) {
	       if (a[i] === obj) {
	           return true;
	       }
	    }
	    return false;
	}
	
	
	
	function setdata(data){
		$("#managerinfo").show();
		$('#peer1').val(data.peer1Name);
		$('#peer2').val(data.peer2Name);
		$('#crossfunction').val(data.crossFunctionalName);
		$('#it').val(data.itName);
		$('#hr').val(data.hrbpName);
		$('#admin').val(data.adminName);
		$('#qmo').val(data.qmoName);
		$('#finance').val(data.financeName);
		$('#recruitment').val(data.requitmentName);
		$('#rmg').val(data.rmgName);
		
		$('#peer1Email').val(data.peer1Email);
		$('#peer2Email').val(data.peer2Email);
		$('#crossfunctionEmail').val(data.crossFunctionalEmail);
		$('#itEmail').val(data.itEmail);
		$('#hrEmail').val(data.hrbpEmail);
		$('#adminEmail').val(data.adminEmail);
		$('#qmoEmail').val(data.qmoEmail);
		$('#financeEmail').val(data.financeEmail);
		$('#recruitmentEmail').val(data.requitmentEmail);
		$('#rmgEmail').val(data.rmgEmail);
	}
	function preparedata(){
	
		
	var	data="empID="+$('#empID').val()+"&";
		
		if($('#peer1Email').val()!=""){
		data=data+"peer1Email="+$('#peer1Email').val()+"&";
		}
		
		if($('#peer2Email').val()!=""){
		data=data+"peer2Email="+$('#peer2Email').val()+"&";
		}
		
		if($('#crossfunctionEmail').val()!=""){
		data=data+"crossfunctionEmail="+$('#crossfunctionEmail').val()+"&";
		}
		if($('#itEmail').val()!=""){
		data=data+"itEmail="+$('#itEmail').val()+"&";
		}
		
		if($('#hrEmail').val()!=""){
		data=data+"hrEmail="+$('#hrEmail').val()+"&";
		}
		if($('#adminEmail').val()!=""){
			data=data+"adminEmail="+$('#adminEmail').val()+"&";
		}
		if($('#qmoEmail').val()!=""){
			data=data+"qmoEmail="+$('#qmoEmail').val()+"&";
		}
		if($('#financeEmail').val()!=""){
			data=data+"financeEmail="+$('#financeEmail').val()+"&";
		}
		if($('#recruitmentEmail').val()!=""){
			data=data+"recruitmentEmail="+$('#recruitmentEmail').val()+"&";
		}
		if($('#rmgEmail').val()!=""){
			data=data+"rmgEmail="+$('#rmgEmail').val()+"&";
		}
		return data;
	}
	
	
	function validate(){
		var error="";
		var email =[];
		email.push($('#employeeEmail').val());
		if($('#peer1Email').val()!="" && !contains(email,$('#peer1Email').val())){
		email.push($('#peer1Email').val());
		}else{
			if($('#peer1Email').val()!="")
			error=error+"Peer1 role already assined to some one. \n";
		}
		if($('#peer2Email').val()!="" &&  !contains(email,$('#peer2Email').val())){
			email.push($('#peer2Email').val());
			}else{
				if($('#peer2Email').val()!="")
				error=error+"Peer2 role already assined to some one. \n";
		}
		if($('#crossfunctionEmail').val()!="" && !contains(email,$('#crossfunctionEmail').val())){
			email.push($('#crossfunctionEmail').val());
			}else{
				if($('#crossfunctionEmail').val()!="")
				error=error+"Crossfunction role already assined to some one. \n";
		}
		if($('#itEmail').val()!="" && !contains(email,$('#itEmail').val())){
			email.push($('#itEmail').val());
			}else{
				if($('#itEmail').val()!="")
				error=error+"IT role already assined to some one. \n";
		}
		if($('#hrEmail').val() !="" && !contains(email,$('#hrEmail').val())){
			email.push($('#hrEmail').val());
			}else{
				if($('#hrEmail').val()!="")
				error=error+"HR role already assined to some  role. \n";
		}
		if($('#adminEmail').val() !="" && !contains(email,$('#adminEmail').val())){
			email.push($('#adminEmail').val());
			}else{
				if($('#adminEmail').val()!="")
				error=error+"Admin role person already assined to some role. \n";
		}
		if($('#qmoEmail').val()!="" && !contains(email,$('#qmoEmail').val())){
			email.push($('#qmoiEmail').val());
			}else{
				if($('#qmoEmail').val()!="")
				error=error+"QMO role already assined to some one. \n";
		}
		if($('#financeEmail').val() !="" && !contains(email,$('#financeEmail').val())){
			email.push($('#financeEmail').val());
			}else{
				if($('#financeEmail').val()!="")
				error=error+"Finance role already assined to some one. \n";
		}
		if($('#recruitmentEmail').val() !="" && !contains(email,$('#recruitmentEmail').val())){
			email.push($('#recruitmentEmail').val());
			}else{
				if($('#recruitmentEmail').val()!="")
				error=error+"Recruitment role already assined to some one. \n";
		}
		if($('#rmgEmail').val()!="" && !contains(email,$('#rmgEmail').val())){
			email.push($('#rmgEmail').val());
			}else{
				if($('#rmgEmail').val()!="")
				error=error+"RMG role already assined to some one. \n";
		}
		
		if($('#peer1').val()!="" && $('#peer1Email').val()==""){
			error=error+"Peer1 is invalid. \n";
		}
		if($('#peer2').val()!="" && $('#peer2Email').val()==""){
			error=error+"peer2 is invalid. \n";
		}
		if($('#crossfunction').val()!="" && $('#crossfunctionEmail').val()==""){
			error=error+"Cross Funtional is invalid. \n";
		}
		if($('#it').val()!="" && $('#itEmail').val()==""){
			error=error+"IT is invalid. \n";
		}
		if($('#hr').val()!="" && $('#hrEmail').val()==""){
			error=error+"HR is invalid. \n";
		}
		if($('#admin').val()!="" && $('#adminEmail').val()==""){
			error=error+"ADMIN is invalid. \n";
		}
		if($('#qmo').val()!="" && $('#qmoiEmail').val()==""){
			error=error+"QMO is invalid. \n";
		}
		if($('#finance').val()!="" && $('#financeEmail').val()==""){
			error=error+"Finance is invalid. \n";
		}
		if($('#recruitment').val()!="" && $('#recruitmentEmail').val()==""){
			error=error+"Recruitment is invalid. \n";
		}
		if($('#rmg').val()!="" && $('#rmgEmail').val()==""){
			error=error+"RMG is invalid. \n";
		}
		
		return error;
	}
	
	$("#updateID").click(function(){
		$('#message').empty();
		 $('#error').empty();
		var error=validate();
		if(error!=""){
			 $('#error').empty().prepend(error);
			return false;
		}
		var formdata=preparedata();
		  $.ajax({
			url : "./adminApplication.do?action=updateManagerInfo",
			type : "POST",
			  data: formdata,
			  dataType : "json",
			success : function(data) {
				$('#message').empty().prepend(data);
				},
           error: function(e){
        	   $('#message').empty().prepend(e);
           }
	});
	});
	
	
	$("#submit").click(function() 
			{
				/*$('#error').empty();
				$('#message').empty();
				var size=$("#size").val();
				var	formdata="surveyId="+$('#surveyId').val()+"&";
				var count=0;
				var duplicateCheck =[];
				for(var i=0;i<size;i++){
					var checkboxID = "#review"+i;
					var textAreaID = "#comments"+i;
					var returnValue = $(checkboxID).prop('checked');
					var commentsVal = $(textAreaID).val();
					 if(((returnValue!=true) && commentsVal.trim()!="")||(returnValue==true && commentsVal.trim()=="")){
						$('#error').empty().prepend("Please select the check box and provide comments to respective the textbox");
						return false;
					}
					 
					if(commentsVal!="" && returnValue==true){
						
						var comptencyID = "#comptency"+i;
						var ratingID = "#rating"+i;
						var subCompetency = "#subCompetency"+i;
						var questionNo = "#questionNo"+i;
						
						var comptency=$(comptencyID).val()+$(subCompetency).val();
						//contains method(array, object)
						if(!contains(duplicateCheck,comptency)){
						duplicateCheck.push(comptency);
						var rating=$(ratingID).val().replace('%', '');
						
						formdata+="rating"+count+"="+escape(rating)+"&";
						formdata+="comments"+count+"="+escape(commentsVal)+"&";
						formdata+="comptency"+count+"="+escape($(comptencyID).val())+"&";
						formdata+="subCompetency"+count+"="+escape($(subCompetency).val())+"&";
						formdata+="questionNo"+count+"="+escape($(questionNo).val())+"&";
						
						count++;
						}else{
							$('#error').empty().prepend("You have already selected Comptency:"+$(comptencyID).val()+" and sub comptency:"+$(subCompetency).val());
							return false;
						}
					
					}
					
				}
				if(count==3){
					}else{
					$('#error').empty().prepend("Please select the 3 check box and provide comments to the respective textbox");
					return false;
				}*/
		
		
		$('#error').empty();
		$('#message').empty();
		var size=$("#size").val();
		var	formdata="surveyId="+$('#surveyId').val()+"&";
		var count=0;
		
		var selectedCheckBoxs = [];
		
		$('input:checked').each(function() {
			selectedCheckBoxs.push($(this).attr('id'));
		});
		
		if(selectedCheckBoxs.length < 3){
			$('#error').empty().prepend("Please select the 3 check box and provide comments to the respective textbox");
			return false;
		}
		
		for(var i=0;i<size;i++){
			var checkboxID = "#review"+i;
			var textAreaID = "#comments"+i;
			var ImprovementSelect = "#ImprovementSelect"+i;
			var competencyChecked = $(checkboxID).prop('checked');
			if(competencyChecked){
				if($(ImprovementSelect).val() =='1' && $(textAreaID).val() =='' ){
					$('#error').empty().prepend("Please selected the check box and provide comments to respective the textbox or select improvement option");
					return false;
				}else{
					var comptencyID = "#comptency"+i;
					var ratingID = "#rating"+i;
					var subCompetency = "#subCompetency"+i;
					var questionNo = "#questionNo"+i;				
					
					var rating=$(ratingID).val().replace('%', '');
					
					formdata+="rating"+count+"="+escape(rating)+"&";
					formdata+="comments"+count+"="+escape($(textAreaID).val())+"&";
					formdata+="comptency"+count+"="+escape($(comptencyID).val())+"&";
					formdata+="subCompetency"+count+"="+escape($(subCompetency).val())+"&";
					formdata+="questionNo"+count+"="+escape($(questionNo).val())+"&";
					formdata+="ImprovementSelectID"+count+"="+escape($(ImprovementSelect).val())+"&";
					
					count++;
					
			}
			}
		}
			        
				  $.ajax({
						url : "./adminApplication.do?action=reviewSubmit",
						type : "POST",
						  data: formdata,
						  dataType : "json",
						success : function(data) {
							$('#message').empty().prepend(data);
							$("input").prop('disabled', true);
							},
			         error: function(e){
			        	 $('#message').empty().prepend(e);
			         	}
				});
		});
	
	function reset(){
		
		$('#message').empty();
		$('#error').empty();
		$("#peer2Info").empty();
		$("#peer1Info").empty();
		$('#hrInfo').empty();
		$("#itInfo").empty();
		$("#adminInfo").empty();
		$("#qmoInfo").empty();
		$("#financeInfo").empty();
		$("#recruitmentInfo").empty();
		$("#rmgInfo").empty();
		$('#searchError').empty();
	}
	
});


	