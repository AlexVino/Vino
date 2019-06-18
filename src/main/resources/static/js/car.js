$(document).ready(function () {

    loadCarRrPrice();

    $('#btn-order').click(function () {
        postOrder();
    });
    $('#btn-edit').click(function () {
        window.location.href = "/ads/" + window.location.href.match(/([^\/]*)\/*$/)[1] + "/edit";
    });
    $('#btn-delete').click(function () {
        if (confirm($('#confirmdeleting').val())) {
            $.ajax({
                type: "DELETE",
                url: "/rest/ads/" + window.location.href.match(/([^\/]*)\/*$/)[1],
                success: function (data) {
                    if (data !== "false") {
                        window.location.href = "/";
                    }
                },
                error: function (e) {
                    throwMessage(e.responseJSON.message);
                }
            });
        }
    });
});

function loadCarRrPrice() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/rest/ads/" + window.location.href.match(/([^\/]*)\/*$/)[1],
        success: function (respond) {
            showInfo(respond);
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function showInfo(car) {

    if (car.rrPrice !== 0 && car.rrPrice !== "" && car.rrPrice !== null) {
        $('#appendprice').append(
            '<dl class="car-card__price-option">' +
            '<dt><span>' + $('#rrPrice').val() + '</span></dt>' +
            '<dd>$ ' + car.rrPrice + '</dd>' +
            '</dl>' +
            '<dl class="car-card__price-option">' +
            '<dt><span>' + $('#discount').val() + '</span></dt>' +
            '<dd class="bg">$ ' + (car.price - car.rrPrice) + '</dd>' +
            '</dl>'
        );
    }

    //characteristics
    var i = 1

    $('#characteristics1').append(
        '<div class="car-card__al-item-wt-title">' +
        $('#complectation').val() +
        '</div>' +
        '<div class="car-card__al-item-wt-item">' +
        car.complectationName +
        '</div>'
    );
    $('#characteristics2').append(
        '<div class="car-card__al-item-wt-title">' +
        $('#vin').val() +
        '</div>' +
        '<div class="car-card__al-item-wt-item">' +
        car.vin +
        '</div>'
    );
    $('#characteristics1').append(
        '<div class="car-card__al-item-wt-title">' +
        $('#drivetype').val() +
        '</div>' +
        '<div class="car-card__al-item-wt-item">' +
        car.drivetypeLocal +
        '</div>'
    );
    $('#characteristics2').append(
        '<div class="car-card__al-item-wt-title">' +
        $('#headlights').val() +
        '</div>' +
        '<div class="car-card__al-item-wt-item">' +
        car.headlightLocal +
        '</div>'
    );
    if (car.horsepower !== null && car.horsepower !== 0) {
        $('#characteristics' + i).append(
            '<div class="car-card__al-item-wt-title">' +
            $('#horsepower').val() +
            '</div>' +
            '<div class="car-card__al-item-wt-item">' +
            car.horsepower +
            '</div>'
        );
        if (i == 1)
        {
            i = 2;
        }else{
            i = 1;
        }
    }
    if (car.maxspeed !== null && car.maxspeed !== 0) {
        $('#characteristics' + i).append(
            '<div class="car-card__al-item-wt-title">' +
            $('#maxspeed').val() +
            '</div>' +
            '<div class="car-card__al-item-wt-item">' +
            car.maxspeed +
            '</div>'
        );
        if (i == 1)
        {
            i = 2;
        }else{
            i = 1;
        }
    }
    if (car.acceleration !== null && car.acceleration !== 0) {
        $('#characteristics' + i).append(
            '<div class="car-card__al-item-wt-title">' +
            $('#acceleration').val() +
            '</div>' +
            '<div class="car-card__al-item-wt-item">' +
            car.acceleration +
            '</div>'
        );
        if (i == 1)
        {
            i = 2;
        }else{
            i = 1;
        }
    }
    if (car.length !== null && car.length !== 0) {
        $('#characteristics' + i).append(
            '<div class="car-card__al-item-wt-title">' +
            $('#length').val() +
            '</div>' +
            '<div class="car-card__al-item-wt-item">' +
            car.length +
            '</div>'
        );
        if (i == 1)
        {
            i = 2;
        }else{
            i = 1;
        }
    }
    if (car.width !== null && car.width !== 0) {
        $('#characteristics' + i).append(
            '<div class="car-card__al-item-wt-title">' +
            $('#width').val() +
            '</div>' +
            '<div class="car-card__al-item-wt-item">' +
            car.width +
            '</div>'
        );
        if (i == 1)
        {
            i = 2;
        }else{
            i = 1;
        }
    }
    if (car.commonconsumption !== null && car.commonconsumption !== 0) {
        $('#characteristics' + i).append(
            '<div class="car-card__al-item-wt-title">' +
            $('#commonconsumption').val() +
            '</div>' +
            '<div class="car-card__al-item-wt-item">' +
            car.commonconsumption +
            '</div>'
        );
        if (i == 1)
        {
            i = 2;
        }else{
            i = 1;
        }
    }
    if (car.cityconsumption !== null && car.cityconsumption !== 0) {
        $('#characteristics' + i).append(
            '<div class="car-card__al-item-wt-title">' +
            $('#cityconsumption').val() +
            '</div>' +
            '<div class="car-card__al-item-wt-item">' +
            car.cityconsumption +
            '</div>'
        );
        if (i == 1)
        {
            i = 2;
        }else{
            i = 1;
        }
    }
    if (car.routeconsumption !== null && car.routeconsumption !== 0) {
        $('#characteristics' + i).append(
            '<div class="car-card__al-item-wt-title">' +
            $('#routeconsumption').val() +
            '</div>' +
            '<div class="car-card__al-item-wt-item">' +
            car.routeconsumption +
            '</div>'
        );
        if (i == 1)
        {
            i = 2;
        }else{
            i = 1;
        }
    }

    //multimedia
    if (car.bluetooth) {
        $('#multimedia').append(
            '<div class="car-card__al-item-rn">' +
            $('#bluetooth').val() +
            '</div>'
        );
    }
    if (car.usb) {
        $('#multimedia').append(
            '<div class="car-card__al-item-rn">' +
            $('#usb').val() +
            '</div>'
        );
    }
    if (car.aux) {
        $('#multimedia').append(
            '<div class="car-card__al-item-rn">' +
            $('#aux').val() +
            '</div>'
        );
    }
    if (car.navigationsystem) {
        $('#multimedia').append(
            '<div class="car-card__al-item-rn">' +
            $('#navigationsystem').val() +
            '</div>'
        );
    }

    //visibility
    if (car.electricheatingofthewindshield) {
        $('#visibility').append(
            '<div class="car-card__al-item-rn">' +
            $('#electricheatingofthewindshield').val() +
            '</div>'
        );
    }
    if (car.electricheatingofsidemirrors) {
        $('#visibility').append(
            '<div class="car-card__al-item-rn">' +
            $('#electricheatingofsidemirrors').val() +
            '</div>'
        );
    }
    if (car.headlightwashersystem) {
        $('#visibility').append(
            '<div class="car-card__al-item-rn">' +
            $('#headlightwashersystem').val() +
            '</div>'
        );
    }
    if (car.rainsensor) {
        $('#visibility').append(
            '<div class="car-card__al-item-rn">' +
            $('#rainsensor').val() +
            '</div>'
        );
    }
    if (car.foglight) {
        $('#visibility').append(
            '<div class="car-card__al-item-rn">' +
            $('#foglight').val() +
            '</div>'
        );
    }

    //comfort
    if (car.cruisecontrol) {
        $('#comfort').append(
            '<div class="car-card__al-item-rn">' +
            $('#cruisecontrol').val() +
            '</div>'
        );
    }
    if (car.parktronic) {
        $('#comfort').append(
            '<div class="car-card__al-item-rn">' +
            $('#parktronic').val() +
            '</div>'
        );
    }
    if (car.climatecontrol) {
        $('#comfort').append(
            '<div class="car-card__al-item-rn">' +
            $('#climatecontrol').val() +
            '</div>'
        );
    }
    if (car.powerWindows) {
        $('#comfort').append(
            '<div class="car-card__al-item-rn">' +
            $('#powerWindows').val() +
            '</div>'
        );
    }
    if (car.steeringadjustment) {
        $('#comfort').append(
            '<div class="car-card__al-item-rn">' +
            $('#steeringadjustment').val() +
            '</div>'
        );
    }

}

function postOrder() {
    if ($('#username').val() !== "") {
        if ($('#btn-order').hasClass('cancel')) {
            $.ajax({
                type: "DELETE",
                url: "/rest/orders/ads/" + window.location.href.match(/([^\/]*)\/*$/)[1],
                success: function (data) {
                    if (data !== "false") {
                        $('#btn-order').text($('#order').val()).removeClass("cancel");
                    }
                },
                error: function (e) {
                    throwMessage(e.responseJSON.message);
                }
            });
        } else {
            $.ajax({
                type: "POST",
                url: "/rest/orders/" + window.location.href.match(/([^\/]*)\/*$/)[1],
                success: function (data) {
                    if (data !== "false") {
                        $('#btn-order').text($('#cancel').val()).addClass("cancel");
                    }
                },
                error: function (e) {
                    throwMessage(e.responseJSON.message);
                }
            });
        }
    } else {
        window.location.href = "/signUp";
    }
}
