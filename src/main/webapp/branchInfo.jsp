<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Warehouse</title>
<link rel="stylesheet" type="text/css" href="style.css">
<style type="text/css">
<%@
include file="style.css" %>
</style>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body class="sb-nav-fixed" style="background-color: #eff3f6 !important;">
<%@include file="shared/header.jsp" %>
<div id="loading" style="display:none;"><img id="loading-image" src="fetch-mod.gif" alt="Loading..."/></div>
<div id="layoutSidenav" style="margin-top: 84px;">
    <div id="layoutSidenav_content">
        <div id="loading" style=display:none> <img id="loading-image" src="fetch-mod.gif" alt="Loading..."/></div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div id="layoutSidenav_nav"> <a href="gotoDashboard">Customer Info</a> <a href="gotoTransactionInfo" >Transaction Info</a><a href="gotoBranchInfo"  class="active">Branch Info</a></div>
                </div>
          
                <div class="col-md-12">
                <div class="sectionColumn moderationTable">
                    <div role="tabpanel" class="tab-pane active" id="tag">
                  
                       
                           <div role="tabpanel" class="tab-pane active" id="tag">

                                            <div class="row">
		${message}
                                                <div class="col-md-12" id="aftershowtran">
	  <form class="searchForm" action="findBranchInfo">
                <h3>Enter Branch ID</h3>
                <div class="searchBar">
                    <input class="form-control" name="branchId" type="text"
										placeholder="Enter Month">
					
                </div>
                <button type="submit" class="btn btn-primary " id="sub2"
									style="float: right">Search</button>
									 <h3 style="color:red; text-align:center;"> ${err}</h3>
            </form>
            ${size}
                                                    <div id="forScroll">
                                                  
						
                                                  <table class="table_prop">
											
											 
											<tr>
											<th> Branch ID</th>
											<th>Customer ID</th>
											<th>Account Number</th>
											<th>Customer Name</th>
																			
											</tr>
											
											
											<c:forEach var="branchinfo" items="${branchinfo}">
											<tr>
											<td> ${branchinfo.branchId}</td>
											<td> ${branchinfo.customerId} </td>
											<td> ${branchinfo.accountNumber}</td>
											<td> ${branchinfo.customerName}</td>
																
											</tr>
											</c:forEach>
											
										</table>

                                                    </div>

                            </div>

                            <!------Tabs content Closed------>
                            

                      
                        
              
                </div>
                
                </div>
            </div>
        </div>
    
    </div>
</div>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<script>
    $("#sub_twitter").click(function(){
    $("#loading").show();
    });  
    $("#sub_twitter_search").click(function(){
      $("#loading").show();
      });  
    $("#sub_facebook_timeline").click(function(){
      $("#loading").show();
      });
    $("#sub_facebook_posts").click(function(){
      $("#loading").show();
      }); 
  </script> 
<script>
    $("#sub2").click(function(){
    $("#loading").show();
    });
     $("#layoutSidenav_nav li a").hover(function(){
    $(".subMenu").css('display', 'block');
    });
    
  </script>
</body>
</html>