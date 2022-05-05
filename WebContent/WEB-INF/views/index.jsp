<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<c:set var="uri" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ICS</title>
<%@ include file="/include/head.jsp"%>
</head>

<body>
	<div class="wrapper">
		<%@ include file="/include/navbar.jsp"%>
		<div class="container-fluid">
			<div class="row">
				<!-- Left Sidebar start-->
				<%@ include file="/include/sidebar.jsp"%>
				<!-- Left Sidebar End-->
				<div class="content-wrapper ">
					<div class="row">
						<div class="col-sm-8">
							<h3>Place List</h3>
						</div>

						<div class="col-sm-4 row">
							<select class="form-select form-select-lg mr-3 col-sm-7"
								id="listType" onchange="searchTypeList()">

							</select> <input type="text" id="nameList" class="form-control col-sm-4"
								onkeyup="searchNameList()">

						</div>
					</div>
					<div id="res" class="row col-sm-12"></div>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="/include/footer_scripts.jsp"%>
	<script
		src="${pageContext.request.contextPath}/contents/script/data.js"></script>

	<script type="text/javascript">  

	$(document).ready(async function() {
		showList();	      
	}); 

	
	  function showList() {   
		 var list = []; 
		 console.log(dataRest)  
		 let listType=`` 
		 let tag=``
		for (var i = 0; i < dataRest.length; i++) {
			
			//บันทึกlist ลง array
			list.push(dataRest[i].categories[0])      	
				
				//สร้าง Placelist  
				tag+=`				   
				<div class="card mt-2 col-sm-4" style="width: 18rem;">
					<div class="row">
					<div class="col-sm-2">     
						<img class="card-img-top mt-3"
							style="height: 50px; object-fit: contain;"  
							src="\${dataRest[i].profile_image_url}">
					</div>     
					<div class="col-sm-10 mt-3">  
						<p>\${dataRest[i].name} (\${dataRest[i].categories[0]})</p>    
						<div class="row">
							<div class="col-sm-7 sm-2 text-left" style="font-size: 12px;">\${dataRest[i].operation_time[0].time_open} AM - \${dataRest[i].operation_time[0].time_close} PM</div>
							<div class="col-sm-5  sm-2 text-right"  
								style="font-size: 12px;"><i class="fas fa-star" style="font-size:48px;color:red"></i>\${dataRest[i].rating}</div> 
						</div>  
					</div>            
				</div>         
				<div class="card-body row">           
				         
				  <div class="column " style=" float: left;width: 33.33%;padding: 5px;">  
				    <img class="img-rounded" src="\${dataRest[i].images[0]}"  width="170" height="110">  
				  </div>  
				  <div class="column" style=" float: left;width: 33.33%;padding: 5px;">        
				    <img class="img-rounded" src="\${dataRest[i].images[1]}"   width="170" height="110">  
				  </div>
				  <div class="column" style=" float: left;width: 33.33%;padding: 5px;">  
				    <img class="img-rounded" src="\${dataRest[i].images[2]}"   width="170" height="110">  
				  </div>
				    
				</div>  
			</div>       
			`   
		}      
		 
		 //รวม List ที่ซ้ำกัน
		 const count = {} 
			const result = []
			list.forEach(item => {
			    if (count[item]) {
			       count[item] +=1
			       return
			    }
			    count[item] = 1
			})
			for (let prop in count){
			    if (count[prop] >=2){
			        result.push(prop)
			    }
			} 
			
			//สร้าง list
		 	for (var i = 0; i < result.length; i++) {
		 		listType+=`<option  value="\${result[i]}">\${result[i]}</option>`	
			}  

		  $('#res').html(tag);
		  $("#listType").html(listType);
 		   
      }    
	  function searchNameList() {  
			 const nameList = $('#nameList').val() 
			 let tag=``
				//searchName    
			  for (var i=0; i<dataRest.length; i++) {
		        if (dataRest[i].name.match(nameList)){
		        	tag+=`				   
						<div class="card mt-2 col-sm-4" style="width: 18rem;">
							<div class="row">
							<div class="col-sm-2">     
								<img class="card-img-top mt-3"
									style="height: 50px; object-fit: contain;"  
									src="\${dataRest[i].profile_image_url}">
							</div>     
							<div class="col-sm-10 mt-3">  
								<p>\${dataRest[i].name} (\${dataRest[i].categories[0]})</p>    
								<div class="row">
									<div class="col-sm-7 sm-2 text-left" style="font-size: 12px;">\${dataRest[i].operation_time[0].time_open} AM - \${dataRest[i].operation_time[0].time_close} PM</div>
									<div class="col-sm-5  sm-2 text-right"  
										style="font-size: 12px;">\${dataRest[i].rating}</div> 
								</div>
							</div>      
						</div>      
						<div class="card-body row">         
						    
						  <div class="column" style=" float: left;width: 33.33%;padding: 5px;">  
						    <img class="rounded " src="\${dataRest[i].images[0]}"  width="170" height="110">  
						  </div>  
						  <div class="column" style=" float: left;width: 33.33%;padding: 5px;">      
						    <img  src="\${dataRest[i].images[1]}"   width="170" height="110">  
						  </div>
						  <div class="column" style=" float: left;width: 33.33%;padding: 5px;">
						    <img class="rounded " src="\${dataRest[i].images[2]}"   width="170" height="110">  
						  </div>
						    
						</div>  
					</div>       
					`   
		        }
		    }    
  
		 $('#res').html(tag);     
	  }  
	     
	  function searchTypeList() {    
		 const nameList = $('#listType').val()  
		  let tag=``
			 //searchType  
			 for (var i=0; i<dataRest.length; i++) {
		        if (dataRest[i].categories[0].match(nameList)){
		        	tag+=`				   
						<div class="card mt-2 col-sm-4" style="width: 18rem;">
							<div class="row">
							<div class="col-sm-2">     
								<img class="card-img-top mt-3"
									style="height: 50px; object-fit: contain;"  
									src="\${dataRest[i].profile_image_url}">
							</div>     
							<div class="col-sm-10 mt-3">  
								<p>\${dataRest[i].name} (\${dataRest[i].categories[0]})</p>    
								<div class="row">
									<div class="col-sm-7 sm-2 text-left" style="font-size: 12px;">\${dataRest[i].operation_time[0].time_open} AM - \${dataRest[i].operation_time[0].time_close} PM</div>
									<div class="col-sm-5  sm-2 text-right"  
										style="font-size: 12px;">\${dataRest[i].rating}</div> 
								</div>
							</div>      
						</div>      
						<div class="card-body row">         
						    
						  <div class="column" style=" float: left;width: 33.33%;padding: 5px;">  
						    <img class="rounded " src="\${dataRest[i].images[0]}"  width="170" height="110">  
						  </div>  
						  <div class="column" style=" float: left;width: 33.33%;padding: 5px;">      
						    <img  src="\${dataRest[i].images[1]}"   width="170" height="110">  
						  </div>
						  <div class="column" style=" float: left;width: 33.33%;padding: 5px;">
						    <img class="rounded " src="\${dataRest[i].images[2]}"   width="170" height="110">  
						  </div>
						    
						</div>  
					</div>       
					`   
		        }
		    }    
  
		 $('#res').html(tag);     

		
		}
</script>
</body>


</html>
