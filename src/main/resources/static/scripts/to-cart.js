
function addToCart(id, quantity) {

    $.ajax({
        url: '/add-to-cart',
        method: 'POST',
        data: { 'id': id, 'quantity': quantity },
        success: function (data) {
      
            displayItems(data);

        },
        error: function (err) {
            console.log(err);
        }
    })




    return false;
}


function removeFromCart(productId) {

    $.ajax({
        url: '/remove-from-cart',
        method: 'POST',
        data: { 'id': productId },
        success: function (data) {

            $(`#prod-${productId}`).fadeOut();

            $("#cart-subtotal").text(`$${data.cartSubtotal}`);
            $("#cart-tax").text(`$${data.tax}`);
            $("#cartTotal").text(`$${data.cartTotal}`);

          
            //update navbar cart details
            displayItems(data);

        },
        error: function (err) {


            console.log(err);
        }
    })



    return false;
}





function updateCart(){

    var products = [];

    $(".cart_item").each(function(index,data){
        var cartUpdateRequest = {};
        var id = $(data).find("input[name='prod_id']").val();
        var quantity = $(data).find("input[name='quantity']").val();

        cartUpdateRequest.id = id;
        cartUpdateRequest.quantity = quantity;

        products[index] = cartUpdateRequest;

    });


    var json = JSON.stringify(products);
  

    $.ajax({
        url: '/update-cart',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        method: 'POST',
        data: json,
        success: function (data) {
        	$("#cart-subtotal").text("");
            $("#cart-tax").text("");
            $("#cartTotal").text("");
            $("#cart-subtotal").text(`$${data.cartSubtotal}`);
            $("#cart-tax").text(`$${data.tax}`);
            $("#cartTotal").text(`$${data.cartTotal}`);

            updateItemsPrice(data.products);

            displayItems(data)
        },
        error: function (err) {


            console.log(err);
        }
    })


    return false;
}

//after user update cart display new product subotoal prices
function  updateItemsPrice(data){
    $(data).each(function(index,product){
        var price = product.price;
        var quant = product.quantity;
        var totalPrice = price * quant;
       // console.log(totalPrice);
       $(`#prod-${product.id}`).find("#prod-subtotal").text(`$${totalPrice}`);
      
    })
}

//diplay cart items in navbar topchart
function displayItems(data){
    $("#cart-size").text(data.quantity);
    $(".top-cart-items").empty();
    $.each(data.products, function (index, product) {
        var name = product.name;
        var price = product.price;
        var quantity = product.quantity;
        var image = product.images[0].imageUrl;
        $(".top-cart-items").append(`<div class="top-cart-item clearfix">
        <div class="top-cart-item-image">
            <a href="#"><img src="/images/${image}" alt="${name}"></a>
            </div><div class="top-cart-item-desc">
            <a href="#" class="t400">${name}</a>
            <span class="top-cart-item-price">$${price}</span>
            <span class="top-cart-item-quantity t600">x ${quantity}</span>
        </div>
    </div>`);


    });
    $("#cart-total").text(`$${data.cartSubtotal}`);
}


$("#to-cart-btn").click(function(event){
    event.preventDefault();
    var id = $("input[name='prod_id']").val();
    var quantity = $("input[name='quantity']").val();


   
    addToCart(id,quantity);
})