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
                    <h1>Orders List</h1>
                   
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                         <li class="breadcrumb-item"><a href="/djeke-djole">Admin</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Order Lists</li>
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
									<th class="pointer" onclick="sort('subtotal')"> Subtotal <i id="subtotal" class="sorting"></i></th>
									<th class="pointer" onclick="sort('tax')"> Tax <i id="tax" class="sorting"></i></th>
									<th class="pointer" onclick="sort('total')">Total <i id="total" class="sorting"></i></th>
									<th class="pointer" onclick="sort('customer')">Customer ID <i id="customer" class="sorting"></i></th>
									<th class="pointer" onclick="sort('orderDate')">Order Time <i id="orderDate" class="sorting"></i></th>	
								</tr>
							</thead>
							<tfoot>
								<tr>
								<th>ID</th>
								<th>Order Subtotal</th>
								<th>Order Tax</th>
								<th>Order Total</th>
								<th>Customer</th>
								<th>Order Time</th>	
								</tr>
							</tfoot>
							<tbody>
							<c:forEach items="${orders.getContent() }" var="orders">
									<tr>
										<td><a href="/djeke-djole/order/${orders.getId()}" class="admin-href">${ orders.getId() } </a>  </td>
									
										<td>$${ orders.getSubtotal() }</td>									
																		
										<td>${ orders.getTax() }%</td>
																
										<td>$${ orders.getTotal() }</td>
																		
										<td><a href="/djeke-djole/customer/${ orders.getCustomer().getId() }" class="admin-href">
											${ orders.getCustomer().getId() }</a>
										</td>
																	
										<td>${ orders.getOrderDate() }</td>
									</tr>
							</c:forEach>
							
								</tbody>
								</table>
								
								</div>
								
								<!--Pagination-->
								<c:if test="${orders.getTotalPages() > 1}">
									<div class="row justify-content-center mt-3">
										<ul class="pagination pagination-transparent pagination-rounded">
											<c:if test="${!orders.isFirst()}">
												<li class="page-item"><a class="page-link"
														href="?page=${orders.getNumber()}&sb=${sb}&sd=${sd}" tabindex="-1"
														aria-disabled="true">Previous</a></li>
											</c:if>
					
											<c:forEach begin="0" end="${orders.getTotalPages()-1}" var="number">
												<c:choose>
													<c:when test="${number == products.getNumber()}">
														<li class="page-item active"><a class="page-link"
																href="?page=${number+1}&sb=${sb}&sd=${sd}">${number + 1}</a></li>
													</c:when>
					
													<c:otherwise>
														<li class="page-item"><a class="page-link"
																href="?page=${number+1}&sb=${sb}&sd=${sd}">${number + 1}</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
					
											<c:if test="${!orders.isLast()}">
												<li class="page-item"><a class="page-link"
														href="?page=${orders.getNumber()+2}&sb=${sb}&sd=${sd}">Next</a></li>
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
					location.replace("/djeke-djole/orders?page=1&sd=DESC&sb="+by);
				}
				else{
					console.log("not asc")
					location.replace("/djeke-djole/orders?page=1&sd=ASC&sb="+by);
				}
			}
			else{
				
				location.replace("/djeke-djole/orders?page=1&sd=ASC&sb="+by);
			}
			
			
			
	
		}
	</script>
	

	<!-- Footer Scripts
	============================================= -->
	<script src="/scripts/functions.js"></script>
	

</body>
</html>