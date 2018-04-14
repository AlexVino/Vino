$(document).ready(function () {
    getUserName();
    $('.b-search').click(function () { search(); });
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

function search() {
    $.ajax({
        type: "GET",
        url: "/rest/cars",
        data: {
            "bodystyle.bodystyleName" : "4x4"},
        contentType: "application/json",
        success: function (data) {
            if (data !== "false") {
                console.log(JSON.stringify(data));
                showCars(data);
            }
        }
    });
}

function showCars(cars) {
    var options = {
        valueNames: [
            'model',
            'price',
            "year",
            "mileage"],
           // { attr: 'href', name: 'link' }],
        // Since there are no elements in the list, this will be used as template.
        item:
        '<div class="row">\n' +
        '        <div class="col-4">\n' +
        '            <div class="r">\n' +
        '\n' +
        '                <a class="r__head dist" href="/car-47732219/?i=1&amp;m=sr">\n' +
        '                    <p class="model"></p>\n' +
        '                </a>\n' +
        '\n' +
        '                <a href="/car-47732219" class="image">\n' +
        '                    <div class="ui-onvisible">\n' +
        '                        <img class="image__photo" src="https://images-ae.azureedge.net/AETA55325/AETV94372543_1e.jpg" alt="2001 (51) - Vauxhall Astra 1.6i Envoy Hatchback 5d">\n' +
        '                    </div>\n' +
        '                </a>\n' +
        '\n' +
        '                <div class="detail">\n' +
        '                    <div class="price detail__price"></div>\n' +
        '                    <div class="year detail__date"></div>\n' +
        '                    <div class="detail__finance"></div>\n' +
        '                </div>\n' +
        '\n' +
        '                <ul class="spec">\n' +
        '\n' +
        '                    <li class="spec__item">\n' +
        '                        <img class="icon" src="https://motors-1.azureedge.net/v3/live/20180315-1138/v4/images/icons/engine.svg">\n' +
        '                        <span class="mileage"></span>\n' +
        '                    </li>\n' +
        '\n' +
        '                    <li class="spec__item">\n' +
        '                        <i class="icon">33.5k</i>\n' +
        '                        <span>Miles</span>\n' +
        '                    </li>\n' +
        '\n' +
        '                    <li class="spec__item">\n' +
        '                        <img class="icon" src="https://motors-1.azureedge.net/v3/live/20180315-1138/v4/images/icons/fuel.svg">\n' +
        '                        <span>Petrol</span>\n' +
        '                    </li>\n' +
        '\n' +
        '                    <li class="spec__item">\n' +
        '                        <img class="icon" src="https://motors-1.azureedge.net/v3/live/20180315-1138/v4/images/icons/gears.svg">\n' +
        '                        <span>Auto</span>\n' +
        '                    </li>\n' +
        '\n' +
        '                    <li class="spec__item body">\n' +
        '                        <img class="icon" src="https://motors-1.azureedge.net/v3/live/20180315-1138/v4/images/icons/body/hatchback.svg">Hatchback\n' +
        '                    </li>\n' +
        '\n' +
        '                </ul>\n' +
        '\n' +
        '                <div class="r__cta">\n' +
        '                    <a href="/car-47732219/?i=1&amp;m=sr" class="item button">\n' +
        '                        <span>Full Details</span>\n' +
        '                    </a>\n' +
        '                </div>\n' +
        '            </div>\n' +
        '\n'
    };

    // for (var i = 0; i < cars.length; i++) {
    //     cars[i].link = "/cars/" + cars[i].id;
    // }

    var userList = new List('content', options, cars);
}