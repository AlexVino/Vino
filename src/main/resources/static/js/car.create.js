$(document).ready(function () {
    $('#btn-order').click(function () {
        postOrder();
    });
    $("#btn-img").click(function() {
        $("#input-img").trigger('click');
    });
    $('.button-image').click(function (event) {
        event.stopPropagation(); // Остановка происходящего
        event.preventDefault();  // Полная остановка происходящего

        // Создадим данные формы и добавим в них данные файлов из files

        var data = new FormData();
        $.each(files, function (key, value) {
            data.append(key, value);
        });

        // Отправляем запрос

        $.ajax({
            url: './submit.php?uploadfiles',
            type: 'POST',
            data: data,
            cache: false,
            dataType: 'json',
            processData: false, // Не обрабатываем файлы (Don't process the files)
            contentType: false, // Так jQuery скажет серверу что это строковой запрос
            success: function (respond, textStatus, jqXHR) {

                // Если все ОК

                if (typeof respond.error === 'undefined') {
                    // Файлы успешно загружены, делаем что нибудь здесь

                    // выведем пути к загруженным файлам в блок '.ajax-respond'

                    var files_path = respond.files;
                    var html = '';
                    $.each(files_path, function (key, val) {
                        html += val + '<br>';
                    })
                    $('.ajax-respond').html(html);
                }
                else {
                    console.log('ОШИБКИ ОТВЕТА сервера: ' + respond.error);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('ОШИБКИ AJAX запроса: ' + textStatus);
            }
        });

    });
});

function postOrder() {
    if ($('#username').val() !== "") {
        if ($('#btn-order').hasClass('cancel')) {
            $.ajax({
                type: "DELETE",
                url: "/rest/orders/" + window.location.href.match(/([^\/]*)\/*$/)[1],
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


$(document).ready(function () {
    getUserName();
    getMakesFilterItems();
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
                $('#btn-sign').text(data).attr('href', "/logout");
            }
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
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

function search(page) {
    var size = 6;
    if (page === -1) {
        page = Math.round($('#result').children('div').length / size);
    }
    var data = {};
    addIfNotEmpty(data, 'model.modelName', $('#filter_models').find('li a.selected').text());
    addIfNotEmpty(data, 'model.make.makeName', $('#filter_makes').find('li a.selected').text());
    addIfNotEmptyForTitle(data, 'transmission.transmissionName', $('#filter_transmission').find('li a.selected'));
    addIfNotEmptyForTitle(data, 'fuelType.fuelTypeName', $('#filter_fueltype').find('li a.selected'));
    addIfNotEmptyForTitle(data, 'mileage', $('#filter_mileage').find('li a.selected'));
    addIfNotEmptyForTitle(data, 'year', $('#filter_year').find('li a.selected'));
    var min = addOrDefault($('#minprice').find('li a.selected').text(), 0);
    var max = addOrDefault($('#maxprice').find('li a.selected').text(), 1000000000);

    var bodies = $('.bodystyles').find('button.active');
    var bodyStyles = "";
    for (var i = 0; i < bodies.length; i++) {
        bodyStyles += '&bodystyle.bodystyleName=' + bodies[i].title;
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
        url: "/rest/cars?price=" + min + "&price=" + max + bodyStyles + colors,
        data: data,
        contentType: "application/json",
        success: function (data) {
            if (data !== "false") {
                showCars(data, page);
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