$(document).ready(function () {
    getUserName();
    getMakesFilterItems();
    $('.b-search').click(function () { search(0); });
    $('.b-page').click(function () { search(-1); });
    $('#filter_makes li a').click(function () {
        getModelsFilterItems();
    });
});

function getUserName() {
    $.ajax({
        type: "GET",
        url: "/rest/users/username",
        cache: false,
        timeout: 600000,
        dataType: "text",
        success: function (data) {
            if (data !== "false") {
                $('.b-sign').text(data).attr('href', "/logout");
            }
        }
    });
}

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
        }
    });
}

function search(page) {
    var size = 6;
    if (page === -1) {
        page = Math.round($('#result').children('div').length / size);
    }
    var data = {};
    addIfNotEmpty(data, 'model.modelName', $('#filter_models').find('li a.selected').text());
    addIfNotEmpty(data, 'model.make.makeName', $('#filter_makes').find('li a.selected').text());
    addIfNotEmpty(data, 'transmission.transmissionName', $('#filter_transmission').find('li a.selected').text());
    data['page'] = page;
    data['size'] = size;
    $.ajax({
        type: "GET",
        url: "/rest/cars",
        data: data,
        contentType: "application/json",
        success: function (data) {
            if (data !== "false") {
                //console.log(JSON.stringify(data));
                showCars(data, page);
            }
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
                '<a class="r__head dist" href="/cars/' + cars[i].carId + '">' +
                    '<p class="title">' + cars[i].fullModel + '</p>' +
                '</a>' +
                '<a class="image" href="/cars/' + cars[i].carId + '">' +
                    '<div class="ui-onvisible">' +
                    '<img class="image__photo" src="/img/car-default.jpg" alt="no image">' +
                    '</div>' +
                '</a>' +
                '<div class="detail">' +
                    '<div class="detail__price" align="left">' + cars[i].price + '$</div>' +
                    '<div class="detail__date">' + cars[i].year + '</div>' +
                    '<div class="detail__finance"></div>' +
                '</div>' +
                '<ul class="spec">' +
                    '<li class="spec__item">' +
                        '<i class="icon">' + cars[i].mileage + 'k</i>' +
                        '<span>Miles</span>' +
                    '</li>' +
                    '<li class="spec__item">' +
                        '<img class="icon" src="/img/fuel.svg">' +
                        '<span>' + capitalizeFirstLetter(cars[i].fuelType) + '</span>' +
                    '</li>' +
                    '<li class="spec__item">' +
                        '<img class="icon" src="/img/gears.svg">' +
                        '<span>' + cars[i].transmission + '</span>' +
                    '</li>' +
                    '<li class="spec__item body">' +
                        '<img class="icon" src="/img/bodystyle/' + cars[i].bodystyle + '.svg">' +
                        '<span>' + cars[i].bodystyle + '</span>' +
                    '</li>' +
                '</ul>' +
                '<div class="r__cta">' +
                '<a class="item button" href="/cars/' + cars[i].carId + '">' +
                    '<span>Full Details</span>' +
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
function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

function dropyList(){
    var dropy={$dropys:null,openClass:"open",selectClass:"selected",init:function(){this.$dropys=$(".dropy"),this.eventHandler()},eventHandler:function(){var s=this;s.$dropys.find(".dropy__title").click(function(){s.$dropys.removeClass(s.openClass),$(this).parents(".dropy").addClass(s.openClass)}),s.$dropys.find(".dropy__content ul li a").click(function(){var e=$(this),t=e.parents(".dropy"),a=t.find("input"),n=$(this).parents(".dropy").find(".dropy__title span");t.find(".dropy__content a").each(function(){$(this).removeClass(s.selectClass)}),n.html(e.html()),a.val(e.attr("data-value")).trigger("change"),e.hasClass("dropy__header")?(n.removeClass(s.selectClass),n.html(n.attr("data-title"))):(n.addClass(s.selectClass),e.addClass(s.selectClass)),t.removeClass(s.openClass)}),$(document).bind("click",function(e){$(e.target).parents().hasClass("dropy")||s.$dropys.removeClass(s.openClass)})}};$(function(){dropy.init()}),$(function(){$("button").on("click",function(){$(this).hasClass("active")?$(this).removeClass("active"):$(this).addClass("active")})});
}