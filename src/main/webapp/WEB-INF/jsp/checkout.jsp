<%@include file="templates/top.jsp" %>

<!-- Document Wrapper
	============================================= -->
<div id="wrapper" class="clearfix">

	<!--Header-->
	<%@include file="templates/header_shop.jsp" %>


	<!-- Page Title
		============================================= -->
	<section id="page-title">

		<div class="container clearfix">
			<h1>Checkout</h1>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/">Home</a></li>
				<li class="breadcrumb-item"><a href="/products">Shop</a></li>
				<li class="breadcrumb-item active" aria-current="page">Checkout</li>
			</ol>
		</div>

	</section><!-- #page-title end -->

	<!-- Content
		============================================= -->
	<section id="content">

		<div class="content-wrap">

			<div class="container clearfix">



				<div class="row clearfix justify-content-center">
					<div class="col-lg-6">
						<h3>Personal Info</h3>

						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Unde, vel odio non dicta
							provident sint ex autem mollitia dolorem illum repellat ipsum aliquid illo similique
							sapiente fugiat minus ratione.</p>
							
						 <form:form id="order-form" method="POST"
          						action="/place-order" modelAttribute="customer"  class="nobottommargin">
					

							<div class="col_half">
								<form:label path="firstName">*Name:</form:label>
								<form:input type="text" required="required" id="billing-form-name" path="firstName"
									class="sm-form-control" />
								<span id="error-f-name" class="error">First name is required</span>
							</div>

							<div class="col_half col_last">
								<form:label path="lastName">*Last Name:</form:label>
								<form:input type="text" required="required" id="billing-form-lname" path="lastName"
									class="sm-form-control" />
									<span id="error-l-name" class="error">Last name is required</span>
							</div>

							<div class="clear"></div>

							<div class="col_full">
								<form:label path="company">Company Name:</form:label>
								<form:input type="text" id="billing-form-companyname" path="company"
									 class="sm-form-control" />
							</div>



							<div class="col_half">
								<form:label path="email">*Email Address:</form:label>
								<form:input type="email" required="required" id="billing-form-email" path="email" value=""
									class="sm-form-control" />
									<span id="error-email" class="error">Email address not valid</span>
							</div>

							<div class="col_half col_last">
								<form:label path="phoneNumber">*Phone:</form:label>
								<form:input type="tel" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required="required" id="billing-form-phone" 
									path="phoneNumber" 
									class="sm-form-control" />
									<span id="error-phone" class="error">Phone number not valid</span>
								
							</div>
					
							<div class="col_full">
								<form:label path="note">Notes </form:label>
								<form:textarea class="sm-form-control" id="shipping-form-message"
									path="note" rows="10" cols="30"></form:textarea>
								
							</div>
					

						</form:form>
									<div>
										<input id="checkbox-10" class="checkbox-style" name="checkbox-10" type="checkbox" >
										<label for="checkbox-10" class="checkbox-style-3-label">
										I guarantee the law for the accuracy of the above data</label>
										<span id="check-error"  class="error">You must guarantee for your information</span>
									</div>
					</div>

					<div class="w-100 bottommargin"></div>
					<div class="col-lg-12">
						<h4>Your Orders</h4>

						<div class="table-responsive">
							<table class="table cart">
								<thead>
									<tr>
										<th class="cart-product-thumbnail">&nbsp;</th>
										<th class="cart-product-name">Product</th>
										<th class="cart-product-quantity">Quantity</th>
										<th class="cart-product-subtotal">Total</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cartItems}" var="prod">


										<tr class="cart_item">
											<td class="cart-product-thumbnail">
												<a href="/product/${prod.getId()}-${prod.getName()}"><img width="64" height="64"
														src="images/${prod.getImages().get(0).getImageUrl()}"
														alt="${prod.getName()}"></a>
											</td>

											<td class="cart-product-name">
												<a href="/product/${prod.getId()}-${prod.getName()}">${prod.getName()}</a>
											</td>

											<td class="cart-product-quantity">
												<div class="quantity clearfix">
													${prod.getQuantity()}
												</div>
											</td>

											<td class="cart-product-subtotal">
												<span class="amount">$${prod.totalPrice()}</span>
											</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>
						</div>
					</div>
					<div class="col-lg-12">
						<h4>Cart Totals</h4>

						<div class="table-responsive">
							<table class="table cart">
								<tbody>
									<tr class="cart_subtotal">
										<td class="cart-product-name">
											<strong>Cart Subtotal</strong>
										</td>

										<td class="cart-product-name">
											<span id="cart-subtotal" class="amount">$${cartSubtotal}</span>
										</td>
									</tr>
									<tr class="cart_tax">
										<td class="cart-product-name">
											<strong>TAX 5%</strong>
										</td>

										<td class="cart-product-name">
											<span id="cart-tax" class="amount">+$${tax}</span>
										</td>
									</tr>
									<tr class="cart_total">
										<td class="cart-product-name">
											<strong>Total</strong>
										</td>

										<td class="cart-product-name">
											<span id="cartTotal" class="amount color lead"><strong>$${cartTotal}</strong></span>
										</td>
									</tr>
								</tbody>

							</table>
						</div>
						<button id="place-order"  class="button button-3d fright">Place Order</button>
						<img src="/images/preloader.gif" class="fright" id="form-loader">
					</div>
				</div>


			</div>

		</div>

	</section><!-- #content end -->

	<!--Footer -->
	<%@include file="templates/footer.jsp" %>

	<!--Cookies-->
	<%@include file="templates/cookies.jsp"%>

</div><!-- #wrapper end -->
<%@ include file="templates/bottom.jsp" %>