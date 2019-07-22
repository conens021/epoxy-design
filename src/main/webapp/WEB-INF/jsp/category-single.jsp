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
                    <h1>${category.getName() } Subcategories</h1>
                   
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                         <li class="breadcrumb-item"><a href="/admin">Admin</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Category</li>
                    </ol>
                </div>

            </section><!-- #page-title end -->
            
            
               <!-- Page Title
            ============================================= -->
            <section id="page-title">

                <div class="container clearfix">
                    
                    
                    
                    
                    <c:forEach items="${subcategories }" var="subcategory">
                    
                                        
	                    <div class="row justify-content-center mb-3 align-items-center">
	                    	<div class="col-md-4">
	                    		<a href="#" class="btn btn-primary" style="width:100%">${subcategory.getName() }</a>
	                    	</div>
	                    	<i class="icon-pencil2 mr-2" id="change-category" data-toggle="modal" data-target="#edit-subcategory-modal-${subcategory.getId() }"></i>
                    		<i class="icon-trash1 " data-toggle="modal" data-target="#delete-subcategory-modal-${subcategory.getId() }"></i>
										<div class="modal fade" id="edit-subcategory-modal-${subcategory.getId() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-body">
													<div class="modal-content">
														<div class="modal-header">
															<h4 class="modal-title" id="myModalLabel">Edit Category</h4>
															<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
														</div>
														<div class="modal-body">
															<form method="POST" action="/djeke-djole/edit-subcategory/${ subcategory.getId()}">
																
																<input type="text" value="${subcategory.getName() }" name="subcategoryName">
																<button type="submit" class="btn btn-success">Change</button>
															</form>
													   </div>
													</div>
												</div>
											</div>
										</div>
										<div class="modal fade" id="delete-subcategory-modal-${subcategory.getId() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-body">
													<div class="modal-content">
														<div class="modal-header">
															<h4 class="modal-title" id="myModalLabel">Delete Subcategory</h4>
															<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
														</div>
														<div class="modal-body">
															<p class="mb-4">You are going to permanently delete this subcategory,category that belongs and ALL PRODUCTS releated to it. Are you sure?</p>
															<form action="/djeke-djole/delete-subcategory" method="POST">
																<input type="hidden" name="subcategoryId" value="${subcategory.getId() }">
																<button type=Submit class="btn btn-success">Yes,delete</button>
																<button class="btn btn-danger" data-dismiss="modal" >No,close</button>
															</form>
													   </div>
													</div>
												</div>
											</div>
										</div>
                   	 </div>
                  </c:forEach>
                    
                    <div class="row justify-content-center">
                    	<div class="col-md-4 text-center"><i id="create-new-prod" class="icon-plus-sign" data-toggle="modal" data-target="#create-category-modal"></i></div>
                    	<div class="modal fade" id="create-category-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-body">
													<div class="modal-content">
														<div class="modal-header">
															<h4 class="modal-title" id="myModalLabel">Create Subcategory</h4>
															<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
														</div>
														<div class="modal-body">
															<form method="POST" action="/djeke-djole/save-subcategory">
																
																<input type="hidden" value="${category.getId() }" name="categoryId"/>
																
																<div class="row">
																	<div class="col-12 bottommargin-sm">
																
																		<input type="text" placeholder="name"  name="subcategoryName">
																	</div>
																</div>
																<div class="row">
																	<div class="col-12 bottommargin-sm">
																
																		<input type="text" placeholder="title(Google)"  name="title">
																	</div>
																</div>
																<div class="row">
																	<div class="col-12 bottommargin-sm">
																		<textarea rows="3" cols="50" placeholder="description" name="description"></textarea>
																	</div>
																</div>
																<button type="submit" class="btn btn-success">Save</button>
															</form>
													   </div>
													</div>
												</div>
											</div>
										</div>
                    </div>
                    
                </div>

            </section><!-- #page-title end -->
  
	
				<!-- Content
		============================================= -->
		<section id="content">

			<div class="content-wrap">

				<div class="container clearfix">
				
					
					
										
			   </div>
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
	
	
	

	<!-- Footer Scripts
	============================================= -->
	<script src="/scripts/functions.js"></script>
	

</body>
</html>