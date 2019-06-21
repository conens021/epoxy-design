<!-- Top Cart
        ============================================= -->
<div id="top-cart">
    <a href="#" id="top-cart-trigger"><i class="icon-line-bag"></i><span id="cart-size">${cartItems.size()}</span></a>
    <div class="top-cart-content">
        <div class="top-cart-title">
            <h4>Shopping Cart</h4>
        </div>
        <div class="top-cart-items">
            <c:forEach items="${cartItems}" var="prod">

                <!--Cart item-->
                <div class="top-cart-item clearfix">
                    <div class="top-cart-item-image">

                        <a href="/product/${prod.getId()}-${prod.getName()}"><img src="/images/${prod.getImages().get(0).getImageUrl()}"
                                alt="${prod.getName()}" /></a>
                    </div>
                    <div class="top-cart-item-desc">
                        <a href="/product/${prod.getId()}-${prod.getName()}" class="t400">${prod.getName()}</a>
                        <span class="top-cart-item-price">$${prod.getPrice()}</span>
                        <span class="top-cart-item-quantity t600">x ${prod.getQuantity()}</span>
                    </div>
                </div>


            </c:forEach>
        </div>

        <!--Cart total-->
        <div class="top-cart-action clearfix">
            <span id="cart-total" class="fleft top-checkout-price t600 text-light">$${cartTotal}</span>
            <a href="/cart"><button class="button button-dark button-small nomargin fright">View
                Cart</button></a>
        </div>
    </div>
</div><!-- #top-cart end -->