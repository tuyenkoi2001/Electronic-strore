/**$('.add-to-cart-btn').click(function(){
        var productID = "${product.id}";
        var qty = $('#so-luong').val();
        $.ajax({
            type: "POST",
            url: "/addtocart",
            data: {productID:productID,qty:qty},
            success: function(){
                alert("Đã thêm sản phẩm"+productID);
            }
          });
    });**/

$('.add-to-cart-btn').click(function(){
    var productID = $(this).attr('id');
    var qty = 1;
    $.ajax({
        type: "get",
        url: "/addtocart",
        data: {productID:productID,qty:qty},
        success: function(){
            showSuccessToast();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            showErrorToast();
        }
      });
});
function clickme(data){
    var productID = data;
    var qty = 1;
    $.ajax({
        type: "get",
        url: "/addtocart",
        data: {productID:productID,qty:qty},
        success: function(){
            alert("Đã thêm sản phẩm"+ productID);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("lỗi rồi bro: "+productID);
        }
      });
}

$('.btn-light').click(function(){
    var productID = $(this).attr('id');
    $.ajax({
        type: "POST",
        url: "/removeProductFromCart",
        data: {productID:productID},
        success: function(){
            $('#productnumber'+productID).remove();
            sumPrice();
        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
      });
    });
                    
/*$('.qty').change(function (){
    var id = $(this).parent().parent().attr('id');
    var sl = $('#'+id).find('.qty').val();
    sl = parseInt(sl,10);
    var each = $('#'+id).find('.text-muted').html();
    each = parseInt(each,10);
    total = (each*sl);
    $('#'+id).find('.price').html(total);
});*/

$('.qty').change(function (){
    var id = $(this).parent().parent().attr('id');
    var sl = $('#'+id).find('.qty').val();
    sl = parseInt(sl,10);
    var each = $('#'+id).find('.text-muted').html();
    each = parseInt(each,10);
    total = (each*sl);
    $('#'+id).find('.price').html(total);
    sumPrice();
});
 function sumPrice(){
     var sum = 0;
    $('.price').each(function(){
        sum += parseInt($(this).text());
    });
    $('#total').html(sum);
};

// hàm bên dưới tính tổng tiền các sản phẩm trong cart
var previous;
$(".qty").on('focus', function () {
    // Store the current value on focus and on change
    previous = this.value;
}).change(function() {
    // Do something with the previous value after the change
    // Make sure the previous value is updated
    var id = $(this).parent().parent().attr('id');
    var sl = $('#'+id).find('.qty').val();
    sl = parseInt(sl,10);
    sl = sl-previous;
    id = id.match(/\d+/);
    $.ajax({
        type: "post",
        url: "/addtocart?productID="+id+"&qty="+sl,
        success: function(){
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("lỗi rồi bro: "+id);
        }
      });
    previous = this.value;
});

/*
$(".apply-filter").click(function(){
    var category_checkbox;
    var brand_checkbox;
    var price_max;
    var price_min;
    $('.category-filter-checkbox:checkbox:checked').each(function (){
        category_checkbox = $(this).val();
    });
    $('.brand-filter-checkbox:checkbox:checked').each(function (){
        brand_checkbox = $(this).val();
    });
    price_max = $('#price-max').val();
    price_min = $('#price-min').val();
    $.ajax({
        type: "post",
        url: "/filter",
        data: {productID:productID,qty:qty},
        success: function(){
            alert("Đã thêm sản phẩm");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("lỗi rồi bro: "+productID);
        }
      });
});
*/