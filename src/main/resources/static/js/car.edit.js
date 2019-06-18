$(document).ready(function () {
    $("#btn-img").click(function() {
        $("#input-img").trigger('click');
    });
    $('#add').click(function () {
        var data = {};
        addIfNotEmpty(data,         'adId',         $('#adid').val());
        addIfNotEmpty(data,      'complectationId', $('#complectationId').val());

        addIfNotEmpty(data,         'carId',        $('#carid').val());
        addIfNotEmpty(data,         'model',        $('#filter_models').find('li a.selected').text());
        addIfNotEmpty(data,         'make',         $('#filter_makes').find('li a.selected').text());
        addIfNotEmptyForTitle(data, 'bodystyle',    $('#filter_bodystyle').find('li a.selected'));
        addIfNotEmptyForTitle(data, 'transmission', $('#filter_transmission').find('li a.selected'));
        addIfNotEmptyForTitle(data, 'fuelType',     $('#filter_fueltype').find('li a.selected'));
        addIfNotEmptyForTitle(data, 'color',        $('#filter_color').find('li a.selected'));
        addIfNotEmpty(data,         'price',        $('#price').val());
        addIfNotEmpty(data,         'mileage',      $('#mileage').val());
        addIfNotEmpty(data,         'enginevolume', $('#enginevolume').val());
        addIfNotEmpty(data,         'description' , $('#description').val());
        addIfNotEmpty(data,         'year',         $('#year').val());

        addIfNotEmpty(data,         'vin',          $('#vin').val());
        addIfNotEmpty(data,    'complectationName', $('#complectation').val());
        addIfNotEmptyForTitle(data, 'headlight',    $('#filter_headlights').find('li a.selected'));
        addIfNotEmptyForTitle(data, 'drivetype',    $('#filter_drivetype').find('li a.selected'));
        addIfNotEmpty(data,         'rrPrice',      $('#rrPrice').val());
        addIfNotEmpty(data,         'horsepower',   $('#horsepower').val());
        addIfNotEmpty(data,         'maxspeed',     $('#maxspeed').val());
        addIfNotEmpty(data,    'commonconsumption', $('#commonconsumption').val());
        addIfNotEmpty(data,      'cityconsumption', $('#cityconsumption').val());
        addIfNotEmpty(data,     'routeconsumption', $('#routeconsumption').val());
        addIfNotEmpty(data,         'acceleration', $('#acceleration').val());
        addIfNotEmpty(data,         'length',       $('#length').val());
        addIfNotEmpty(data,         'width',        $('#width').val());

        addIfNotEmpty(data,         'electricheatingofthewindshield', document.getElementById("myonoffswitchElectricheatingofthewindshield").checked);
        addIfNotEmpty(data,         'electricheatingofsidemirrors',   document.getElementById("myonoffswitchElectricheatingofsidemirrors").checked);
        addIfNotEmpty(data,         'headlightwashersystem',          document.getElementById("myonoffswitchHeadlightwashersystem").checked);
        addIfNotEmpty(data,         'rainsensor',                     document.getElementById("myonoffswitchRainsensor").checked);
        addIfNotEmpty(data,         'foglight',                       document.getElementById("myonoffswitchFoglight").checked);
        addIfNotEmpty(data,         'bluetooth',                      document.getElementById("myonoffswitchBluetooth").checked);
        addIfNotEmpty(data,         'usb',                            document.getElementById("myonoffswitchUSB").checked);
        addIfNotEmpty(data,         'aux',                            document.getElementById("myonoffswitchAUX").checked);
        addIfNotEmpty(data,         'navigationsystem',               document.getElementById("myonoffswitchNavigationsystem").checked);
        addIfNotEmpty(data,         'cruisecontrol',                  document.getElementById("myonoffswitchCruisecontrol").checked);
        addIfNotEmpty(data,         'parktronic',                     document.getElementById("myonoffswitchParktronic").checked);
        addIfNotEmpty(data,         'climatecontrol',                 document.getElementById("myonoffswitchClimatecontrol").checked);
        addIfNotEmpty(data,         'powerWindows',                   document.getElementById("myonoffswitchPowerWindows").checked);
        addIfNotEmpty(data,         'steeringadjustment',             document.getElementById("myonoffswitchsteeringadjustment").checked);

        data['image'] = $('#myimage').attr('src');

        // Отправляем запрос

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/rest/ads/" + $('#adid'),
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (respond) {
                window.location.href = "/ads/" + respond.adId;
            },
            error: function (e) {
                throwMessage(e.responseJSON.message);
            }
        });

    });
});

$(document).ready(function () {
    getMakesFilterItems();
    loadCar();
});

function loadCar() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/rest/ads/" + $('#adid').val(),
        success: function (respond) {
            showCar(respond);
        },
        error: function (e) {
            throwMessage(e.responseJSON.message);
        }
    });
}

function showCar(car) {
    $($('#filter_makes').find('li a:contains("' + car.make + '")')[0]).addClass('selected');
    $($('.span_makes').text($('#filter_makes').find('li a.selected').text()));
    getModels();
    $($('#filter_models').find('li a:contains("' + car.model + '")')[0]).addClass('selected');
    $($('.span_models').text($('#filter_models').find('li a.selected').text()));
    $($('#filter_bodystyle').find('li a[title="' + car.bodystyle + '"]')[0]).addClass('selected');
    $($('.span_bodystyle').text($($('#filter_bodystyle').find('li a.selected')[0]).text()));
    $($('#filter_transmission').find('li a[title="' + car.transmission + '"]')[0]).addClass('selected');
    $($('.span_transmission').text($($('#filter_transmission').find('li a.selected')[0]).text()));
    $($('#filter_fueltype').find('li a[title="' + car.fuelType + '"]')[0]).addClass('selected');
    $($('.span_fuel').text($($('#filter_fueltype').find('li a.selected')[0]).text()));
    $($('#filter_color').find('li a[title="' + car.color + '"]')[0]).addClass('selected');
    $($('.span_color').text($($('#filter_color').find('li a.selected')[0]).text()));

    $($('#filter_drivetype').find('li a[title="' + car.drivetype + '"]')[0]).addClass('selected');
    $($('.span_drivetype').text($($('#filter_drivetype').find('li a.selected')[0]).text()));
    $($('#filter_headlights').find('li a[title="' + car.headlight.toLowerCase() + '"]')[0]).addClass('selected');
    $($('.span_headlights').text($($('#filter_headlights').find('li a.selected')[0]).text()));

    $('#price').val(car.price);
    $('#mileage').val(car.mileage);
    $('#enginevolume').val(car.enginevolume);
    $('#description').val(car.description);
    $('#year').val(car.year);

    $('#vin').val(car.vin);
    $('#complectation').val(car.complectationName);
    $('#rrPrice').val(car.rrPrice);
    $('#horsepower').val(car.horsepower);
    $('#maxspeed').val(car.maxspeed);
    $('#commonconsumption').val(car.commonconsumption);
    $('#cityconsumption').val(car.cityconsumption);
    $('#routeconsumption').val(car.routeconsumption);
    $('#acceleration').val(car.acceleration);
    $('#length').val(car.length);
    $('#width').val(car.width);

    //multimedia
    if (car.bluetooth) {
        document.getElementById("myonoffswitchBluetooth").checked = true;
    }
    if (car.usb) {
        document.getElementById("myonoffswitchUSB").checked = true;
    }
    if (car.aux) {
        document.getElementById("myonoffswitchAUX").checked = true;
    }
    if (car.navigationsystem) {
        document.getElementById("myonoffswitchNavigationsystem").checked = true;
    }

    //visibility
    if (car.electricheatingofthewindshield) {
        document.getElementById("myonoffswitchElectricheatingofthewindshield").checked = true;
    }
    if (car.electricheatingofsidemirrors) {
        document.getElementById("myonoffswitchElectricheatingofsidemirrors").checked = true;
    }
    if (car.headlightwashersystem) {
        document.getElementById("myonoffswitchHeadlightwashersystem").checked = true;
    }
    if (car.rainsensor) {
        document.getElementById("myonoffswitchRainsensor").checked = true;
    }
    if (car.foglight) {
        document.getElementById("myonoffswitchFoglight").checked = true;
    }

    //comfort
    if (car.cruisecontrol) {
        document.getElementById("myonoffswitchCruisecontrol").checked = true;
    }
    if (car.parktronic) {
        document.getElementById("myonoffswitchParktronic").checked = true;
    }
    if (car.climatecontrol) {
        document.getElementById("myonoffswitchClimatecontrol").checked = true;
    }
    if (car.powerWindows) {
        document.getElementById("myonoffswitchPowerWindows").checked = true;
    }
    if (car.steeringadjustment) {
        document.getElementById("myonoffswitchsteeringadjustment").checked = true;
    }
}

function onFileSelected(event) {
    var selectedFile = event.target.files[0];
    var reader = new FileReader();

    var imgtag = document.getElementById("myimage");
    imgtag.title = selectedFile.name;

    reader.onload = function(event) {
        imgtag.src = event.target.result;
    };

    reader.readAsDataURL(selectedFile);
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
        async: false,
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