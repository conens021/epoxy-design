<%@include file="templates/top.jsp" %>
	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">


		<%@include file="templates/header_shop.jsp"%>

		<section id="slider" class="slider-element slider-parallax full-screen dark error404-wrap" style="background: url(/images/404.jpg) center;">
			<div class="slider-parallax-inner" style="background:rgb(0,0,0,40%)">

				<div class="container-fluid vertical-middle center clearfix">

					<div class="error404">404</div>

					<div class="heading-block nobottomborder">
						<h4>Ooopps.! The Page you were looking for, couldn't be found.</h4>
						<span>Try the search below to find matching pages:</span>
					</div>

					<form action="#" method="get" class="divcenter nobottommargin">
						<div class="input-group input-group-lg">
							<input type="text" class="form-control" placeholder="Search for Pages...">
							<div class="input-group-append">
								<button class="btn btn-danger" type="button">Search</button>
							</div>
						</div>
					</form>

				</div>

			</div>
		</section>

		<%@include file="templates/footer.jsp"%>

	</div><!-- #wrapper end -->
	<%@ include file="templates/bottom.jsp" %>