function throwMessage(str) {
    $('.error_message p').html(str);
    $(".error_message").fadeIn(500).delay(5000).fadeOut(500);
}