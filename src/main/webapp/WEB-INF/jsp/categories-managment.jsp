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
                    <h1>Categoires</h1>
                   
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                         <li class="breadcrumb-item"><a href="/admin">Admin</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Create Product</li>
                    </ol>
                </div>

            </section><!-- #page-title end -->
            
            
               <!-- Page Title
            ============================================= -->
            <section id="page-title">

                <div class="container clearfix">
                    
                    
                    
                    
                    <c:forEach items="${categories }" var="category">
                    
                                        
	                    <div class="row justify-content-center mb-3 align-items-center">
	                    	<div class="col-md-4">
	                    		<a href="/djeke-djole/category/${category.getId() }" class="btn btn-primary" style="width:100%">${category.getName() }</a>
	                    	</div>
	                    	<i class="icon-pencil2 mr-2" id="change-category" data-toggle="modal" data-target="#edit-category-modal-${category.getId() }"></i>
                    	
										<div class="modal fade" id="edit-category-modal-${category.getId() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-body">
													<div class="modal-content">
														<div class="modal-header">
															<h4 class="modal-title" id="myModalLabel">Edit Category</h4>
															<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
														</div>
														<div class="modal-body">
															<form method="POST" action="/djeke-djole/edit-category/${ category.getId()}">
																
																<input type="text" value="${category.getName() }" name="categoryName">
																<button type="submit" class="btn btn-success">Change</button>
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
															<h4 class="modal-title" id="myModalLabel">Create Category</h4>
															<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
														</div>
														<div class="modal-body">
															<form method="POST" action="/djeke-djole/save-category">
																
																
																<div class="row">
																	<div class="col-12 bottommargin-sm">
																
																		<input type="text" placeholder="name"  name="categoryName">
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