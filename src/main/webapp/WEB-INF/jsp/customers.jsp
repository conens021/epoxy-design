 <%@include file="templates/admin/admin-top.jsp" %>

        <!-- Document Wrapper
        ============================================= -->
        <div id="wrapper" class="clearfix">


            <!--Header-->
            <%@include file="templates/admin/admin-header.jsp" %>

            <!-- Page Title
            ============================================= -->
            <section id="page-title">

                <div class="container clearfix">
                    <h1>Customers</h1>
                   
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                         <li class="breadcrumb-item"><a href="/djeke-djole">Admin</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Customers Lists</li>
                    </ol>
                </div>

            </section><!-- #page-title end -->
	
	
				<!-- Content
		============================================= -->
		<section id="content">

			<div class="content-wrap">

				<div class="container clearfix">
				
					

					<div class="table-responsive">
				
						<table id="datatable1" class="table table-striped table-bordered " cellspacing="0" width="100%">
						<input type="hidden" id="sb-sd" value="${sortBy }#${sortDirection}">
							<thead>
								<tr>
									<th class="pointer" onclick="sort('id')">ID <i id="id" class="sorting"></i></th>
									<th class="pointer" onclick="sort('firstName')"> Name <i id="firstName" class="sorting"></i></th>
									<th class="pointer" onclick="sort('email')"> Email Address <i id="email" class="sorting"></i></th>
									<th class="pointer" onclick="sort('phoneNumber')">Contact Number <i id="phoneNumber" class="sorting"></i></th>
									
									<th class="pointer" onclick="sort('company')">Company Name <i id="company" class="sorting"></i></th>	
								</tr>
							</thead>
							<tfoot>
								<tr>
								<th>ID</th>
								<th>Name </th>
								<th>Email Address</th>
								<th>Contact Number</th>
								
								<th>Company Name </th>	
								</tr>
							</tfoot>
							<tbody>
							<c:forEach items="${customers.getContent() }" var="customer">
									<tr>
										<td><a href="/djeke-djole/customer/${customer.getId()}" class="admin-href">${ customer.getId() } </a>  </td>
					
										<td>${ customer.getFirstName() } ${ customer.getLastName() }  </td>
										<td><a href="mailto:${customer.getEmail() }" class="admin-href">${ customer.getEmail()} </a> </td>
										<td><a href="tel:${customer.getPhoneNumber() }" class="admin-href">${ customer.getPhoneNumber()} </a> </td>
									
										<td>${ customer.getCompany()}  </td>
								
									</tr>
							</c:forEach>
							
								</tbody>
								</table>
								
								</div>
								
								<!--Pagination-->
								<c:if test="${customers.getTotalPages() > 1}">
									<div class="row justify-content-center mt-3">
										<ul class="pagination pagination-transparent pagination-rounded">
											<c:if test="${!customers.isFirst()}">
												<li class="page-item"><a class="page-link"
														href="?page=${customers.getNumber()}&sb=${sb}&sd=${sd}" tabindex="-1"
														aria-disabled="true">Previous</a></li>
											</c:if>
					
											<c:forEach begin="0" end="${customers.getTotalPages()-1}" var="number">
												<c:choose>
													<c:when test="${number == customers.getNumber()}">
														<li class="page-item active"><a class="page-link"
																href="?page=${number+1}&sb=${sb}&sd=${sd}">${number + 1}</a></li>
													</c:when>
					
													<c:otherwise>
														<li class="page-item"><a class="page-link"
																href="?page=${number+1}&sb=${sb}&sd=${sd}">${number + 1}</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
					
											<c:if test="${!customers.isLast()}">
												<li class="page-item"><a class="page-link"
														href="?page=${customers.getNumber()+2}&sb=${sb}&sd=${sd}">Next</a></li>
											</c:if>
										</ul>
										
									</div>
								</c:if>
								<!--End pagination-->
								
						
						
								
								</div>
								</section>
		

            <!--Footer-->
            <%@include file="templates/footer.jsp" %>

     

		</div>
		<!-- End wrapper -->
		

	<!-- Go To Top
	============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- External JavaScripts
	============================================= -->
	<script src="/scripts/jquery.js"></script>
	<script src="/scripts/plugins.js"></script>
	
	<script>
	
		var sd;
		var sb;
		
	
		$(document).ready(function(){
			
			var sb_sd = $("#sb-sd").val();
		
			sb = sb_sd.split("#")[0];
			
			sd = sb_sd.split("#")[1];
	
			
			if(sd === "ASC"){
				$("#"+sb).addClass("icon-long-arrow-down");
			}else{
				$("#"+sb).addClass("icon-long-arrow-up");
			}
			
			
	
			
			
		});
		
		function sort(by){
			
						
			if(by === sb){
				if(sd == 'ASC'){
					console.log("ASC")
					location.replace("/djeke-djole/customers?page=1&sd=DESC&sb="+by);
				}
				else{
					console.log("not asc")
					location.replace("/djeke-djole/customers?page=1&sd=ASC&sb="+by);
				}
			}
			else{
				
				location.replace("/djeke-djole/customers?page=1&sd=ASC&sb="+by);
			}
			
			
			
	
		}
	</script>
	

	<!-- Footer Scripts
	============================================= -->
	<script src="/scripts/functions.js"></script>
	

</body>
</html>