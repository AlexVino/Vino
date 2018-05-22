$(document).ready(function () {
    $("#btn-img").click(function() {
        $("#input-img").trigger('click');
    });
    $('#add').click(function (event) {
        event.stopPropagation(); // Остановка происходящего
        event.preventDefault();  // Полная остановка происходящего

        var data = {};
        addIfNotEmpty(data, 'model', $('#filter_models').find('li a.selected').text());
        addIfNotEmpty(data, 'make', $('#filter_makes').find('li a.selected').text());
        addIfNotEmptyForTitle(data, 'bodyslyle', $('#filter_bodystyle').find('li a.selected'));
        addIfNotEmptyForTitle(data, 'transmission', $('#filter_transmission').find('li a.selected'));
        addIfNotEmptyForTitle(data, 'fuelType', $('#filter_fueltype').find('li a.selected'));
        addIfNotEmptyForTitle(data, 'color', $('#filter_color').find('li a.selected'));
        addIfNotEmpty(data, 'price', $('#price').val());
        addIfNotEmpty(data, 'mileage', $('#mileage').val());
        addIfNotEmpty(data, 'engine', $('#engine').val());
        addIfNotEmpty(data, 'description', $('#description').val());
        data['image'] = $('#input-img').files;

        // Отправляем запрос

        $.ajax({
            url: '/rest/cars',
            type: 'POST',
            data: JSON.stringify(data),
            cache: false,
            dataType: 'json',
            processData: false, // Не обрабатываем файлы (Don't process the files)
            contentType: false, // Так jQuery скажет серверу что это строковой запрос
            success: function (respond) {
                window.location.href = "/cars/" + respond.id;
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });

    });
});

$(document).ready(function () {
    getMakesFilterItems();
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
                    $('#filter_makes').append('<li><a>' + item + '</a></li>');
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
                    $('#filter_models').append('<li><a>' + item + '</a></li>');
                });
                dropyList();
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function dropyList(){
    var dropy={$dropys:null,openClass:"open",selectClass:"selected",init:function(){this.$dropys=$(".dropy"),this.eventHandler()},eventHandler:function(){var s=this;s.$dropys.find(".dropy__title").click(function(){s.$dropys.removeClass(s.openClass),$(this).parents(".dropy").addClass(s.openClass)}),s.$dropys.find(".dropy__content ul li a").click(function(){var e=$(this),t=e.parents(".dropy"),a=t.find("input"),n=$(this).parents(".dropy").find(".dropy__title span");t.find(".dropy__content a").each(function(){$(this).removeClass(s.selectClass)}),n.html(e.html()),a.val(e.attr("data-value")).trigger("change"),e.hasClass("dropy__header")?(n.removeClass(s.selectClass),n.html(n.attr("data-title"))):(n.addClass(s.selectClass),e.addClass(s.selectClass)),t.removeClass(s.openClass)}),$(document).bind("click",function(e){$(e.target).parents().hasClass("dropy")||s.$dropys.removeClass(s.openClass)})}};$(function(){dropy.init()});
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