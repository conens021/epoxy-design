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
                    <h1>Product list</h1>
                   
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                         <li class="breadcrumb-item"><a href="/admin">Admin</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Create Product</li>
                    </ol>
                </div>

            </section><!-- #page-title end -->
	
	
				<!-- Content
		============================================= -->
		<section id="content">

			<div class="content-wrap">

				<div class="container clearfix">
				
					

					<div class="table-responsive">
						<div class="row align-items-center mb-3">
							<div class="col-10 pr-0">
								<input type="text" id="template-contactform-name" name="template-contactform-name"
								 value="" class="form-control required" placeholder="Search product" />
								
							</div>
							<div class="col-2 pl-0">
							
								 <button id="search-btn" class="button button-fill button-rounded"><i class="icon-line-search"></i>Search</button>
							</div>
						</div>
						<table id="datatable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
						<input type="hidden" id="sb-sd" value="${sortBy }#${sortDirection}">
							<thead>
								<tr>
									
									<th class="pointer" onclick="sort('id')">ID <i id="id" class="sorting"></i></th>
									<th class="pointer" onclick="sort('name')">Product <i id="name" class="sorting"></i> </th>
									<th class="pointer" onclick="sort('onStock')">On Stock <i id="onStock" class="sorting"></i></th>
									<th class="pointer" onclick="sort('price')">Price <i id="price" class="sorting"></i></th>
									<th class="pointer" onclick="sort('sale')">On Sale <i id="sale"></i></th>
									<th class="pointer" onclick="sort('saleAmount')">Sale Amount <i id="saleAmount" class="sorting"></i></th>
									<th class="pointer" onclick="sort('prodCategory')">Category <i id="prodCategory" class="sorting"></i></th>
									<th class="pointer" onclick="sort('subcategory')">Subcategory <i id="subcategory" class="sorting"></i></th>
									<th class="pointer" onclick="sort('createdTime')">Created <i id="createdTime" class="sorting"></i></th>
									<th class="pointer" onclick="sort('lastUpdated')">Last Update <i id="lastUpdated" class="sorting"></i></th>
								</tr>
							</thead>
							<tfoot>
								<tr>
								<th>ID</th>
									<th>Product</th>
									<th>On Stock</th>
									<th>Price</th>
									<th>On Sale</th>
									<th>Sale Amount</th>
								
									<th>Category</th>
									<th>Subcategory</th>
									<th>Created</th>
									<th>Last Update</th>
								</tr>
							</tfoot>
							<tbody>
							<c:forEach items="${products.getContent() }" var="product">
									<tr>
										<td>${ product.getId() }</td>
										<td>
											<a href="/product/${product.getId()}-${prod.getName()}"> ${ product.getName() }
											<img style="height:50px"src="/images/${product.getImages().get(0).getImageUrl()}">
										  	</a>  
										</td>
										<td>${product.getOnStock() }</td>
										<td>$${product.getOriginalPrice() }</td>
										<td>${product.onSale() }</td>
										<td>${product.getSaleAmount() }%</td>
										<td>${product.getProdCategory().getName() }</td>
										<td><c:if test="${product.getSubcategory() != null }">
												${product.getSubcategory().getName() }
											</c:if>
										</td>
										<td>${product.getCreatedTime() }</td>
										<td>${product.getLastUpdated() }</td>
								</tr>
							</c:forEach>
							
								</tbody>
								</table>
								
								</div>
								
								<!--Pagination-->
								<c:if test="${products.getTotalPages() > 1}">
									<div class="row justify-content-center mt-3">
										<ul class="pagination pagination-transparent pagination-rounded">
											<c:if test="${!products.isFirst()}">
												<li class="page-item"><a class="page-link"
														href="?page=${products.getNumber()}&sb=${sb}&sd=${sd}" tabindex="-1"
														aria-disabled="true">Previous</a></li>
											</c:if>
					
											<c:forEach begin="0" end="${products.getTotalPages()-1}" var="number">
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
					
											<c:if test="${!products.isLast()}">
												<li class="page-item"><a class="page-link"
														href="?page=${products.getNumber()+2}&sb=${sb}&sd=${sd}">Next</a></li>
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
			
			
			
			$("#search-btn").click(function(){
				 search = $("#template-contactform-name").val();
				
				location.replace("/djeke-djole/list-products?pn="+search);
			});
			
			
			
		});
		
		function sort(by){
			
						
			if(by === sb){
				if(sd == 'ASC'){
					console.log("ASC")
					location.replace("/djeke-djole/list-products?page=1&sd=DESC&sb="+by);
				}
				else{
					console.log("not asc")
					location.replace("/djeke-djole/list-products?page=1&sd=ASC&sb="+by);
				}
			}
			else{
				
				location.replace("/djeke-djole/list-products?page=1&sd=ASC&sb="+by);
			}
			
			
			
	
		}
	</script>
	

	<!-- Footer Scripts
	============================================= -->
	<script src="/scripts/functions.js"></script>
	

</body>
</html>