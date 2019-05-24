$(document).ready(function () {
    $('.b-page').hide();
    getMakesFilterItems();
    $('.b-search').click(function () { search(0); });
    $('.b-page').click(function () { search(-1); });
    $('#filter_makes li a').click(function () {
        getModelsFilterItems();
    });
});

function getMakesFilterItems() {
    $.ajax({
        type: "GET",
        url: "/rest/makes",
        data: {},
        contentType: "application/json",
        success: function (data) {
            if (data !== "false") {
                data.forEach(function(item) {
                    $('#filter_makes').append('<li><a>' + capitalizeFirstLetter(item) + '</a></li>');
                });
                dropyList();
                $("#filter_makes").on("click", "li", function(){
                    getModels();
                });
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function getModels() {
    var data = {};
    data['make.makeName'] = $('#filter_makes').find('li a.selected').text();
    $.ajax({
        type: "GET",
        url: "/rest/models",
        data: data,
        contentType: "application/json",
        success: function (data) {
            if (data !== "false") {
                $('#filter_models').find('li:not(:first)').remove();
                data.forEach(function(item) {
                    $('#filter_models').append('<li><a>' + capitalizeFirstLetter(item) + '</a></li>');
                });
                dropyList();
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function search(page) {
    var size = 6;
    if (page === -1) {
        page = Math.round($('#result').children('div').length / size);
    }
    var data = {};
    addIfNotEmpty(data, 'complectation.model.modelName', $('#filter_models').find('li a.selected').text());
    addIfNotEmpty(data, 'complectation.model.make.makeName', $('#filter_makes').find('li a.selected').text());
    addIfNotEmptyForTitle(data, 'complectation.transmission.transmissionName', $('#filter_transmission').find('li a.selected'));
    addIfNotEmptyForTitle(data, 'complectation.fuelType.fuelTypeName', $('#filter_fueltype').find('li a.selected'));
    addIfNotEmptyForTitle(data, 'mileage', $('#filter_mileage').find('li a.selected'));
    addIfNotEmptyForTitle(data, 'complectation.year', $('#filter_year').find('li a.selected'));
    var min = addOrDefault($('#minprice').find('li a.selected').text(), 0);
    var max = addOrDefault($('#maxprice').find('li a.selected').text(), 1000000000);

    var bodies = $('.bodystyles').find('button.active');
    var bodyStyles = "";
    for (var i = 0; i < bodies.length; i++) {
        bodyStyles += '&complectation.bodystyle.bodystyleName=' + bodies[i].title;
    }

    var colorsButton = $('.colors').find('button.active');
    var colors = "";
    for (var i = 0; i < colorsButton.length; i++) {
        colors += '&color.colorName=' + colorsButton[i].title;
    }

    data['page'] = page;
    data['size'] = size;
    $.ajax({
        type: "GET",
        url: "/rest/ads?price=" + min + "&price=" + max + bodyStyles + colors,
        data: data,
        contentType: "application/json",
        success: function (data) {
            if (data !== "false") {
                showCars(data, page);
                if (data.length < size) {
                    $('.b-page').hide();
                } else {
                    $('.b-page').show();
                }
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function showCars(cars, page) {
    if (page === 0) {
        $('#result').find('div').remove();
    }
    for (var i = 0; i < cars.length; i++) {
        $('#result').append(
        '<div class="col-lg-4 col-md-6 col-xs-12" align="center">' +
            '<div class="r">' +
                '<a class="r__head dist" href="/ads/' + cars[i].carId + '">' +
                    '<p class="title">' + cars[i].fullModel + '</p>' +
                '</a>' +
                '<a class="image" href="/ads/' + cars[i].carId + '">' +
                    '<div class="ui-onvisible">' +
                    '<img class="image__photo" src="' + cars[i].image + '" alt="no image">' +
                    '</div>' +
                '</a>' +
                '<div class="detail">' +
                    '<div class="detail__price" align="left">' + cars[i].price + '$</div>' +
                    '<div class="detail__date">' + cars[i].year + '</div>' +
                    '<div class="detail__finance"></div>' +
                '</div>' +
                '<ul class="spec">' +
                    '<li class="spec__item">' +
                        '<i class="icon">' + cars[i].mileage + '</i>' +
                        '<span>' + $('#mileage').val() +'</span>' +
                    '</li>' +
                    '<li class="spec__item">' +
                        '<img class="icon" src="/img/fuel.svg">' +
                        '<span>' + capitalizeFirstLetter(cars[i].fuelTypeLocal) + '</span>' +
                    '</li>' +
                    '<li class="spec__item">' +
                        '<img class="icon" src="/img/gears.svg">' +
                        '<span>' + cars[i].transmissionLocal + '</span>' +
                    '</li>' +
                    '<li class="spec__item body">' +
                        '<img class="icon" src="/img/bodystyle/' + cars[i].bodystyle + '.svg">' +
                        '<span>' + cars[i].bodystyleLocal + '</span>' +
                    '</li>' +
                '</ul>' +
                '<div class="r__cta">' +
                '<a class="item button" href="/ads/' + cars[i].carId + '">' +
                    '<span>' + $('#full-details').val() + '</span>' +
                '</a>' +
            '</div>' +
        '</div>');
    }
}

function addIfNotEmpty(data, param, value) {
    if (value !== "") {
        data[param] = value;
    }
}

function addIfNotEmptyForTitle(data, param, value) {
    if (value.length > 0 && value[0].title !== "") {
        data[param] = value[0].title;
    }
}

function addOrDefault(value, defaultValue) {
    if (value !== "") {
        return value.substr(1, value.length - 1).replace(",", "");
    } else {
        return defaultValue;
    }
}

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

function dropyList(){
    var dropy={$dropys:null,openClass:"open",selectClass:"selected",init:function(){this.$dropys=$(".dropy"),this.eventHandler()},eventHandler:function(){var s=this;s.$dropys.find(".dropy__title").click(function(){s.$dropys.removeClass(s.openClass),$(this).parents(".dropy").addClass(s.openClass)}),s.$dropys.find(".dropy__content ul li a").click(function(){var e=$(this),t=e.parents(".dropy"),a=t.find("input"),n=$(this).parents(".dropy").find(".dropy__title span");t.find(".dropy__content a").each(function(){$(this).removeClass(s.selectClass)}),n.html(e.html()),a.val(e.attr("data-value")).trigger("change"),e.hasClass("dropy__header")?(n.removeClass(s.selectClass),n.html(n.attr("data-title"))):(n.addClass(s.selectClass),e.addClass(s.selectClass)),t.removeClass(s.openClass)}),$(document).bind("click",function(e){$(e.target).parents().hasClass("dropy")||s.$dropys.removeClass(s.openClass)})}};$(function(){dropy.init()});
}