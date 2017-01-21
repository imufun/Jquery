(function () {
    $(".nav li ").click(function () {
        $(this).addClass('selected').siblings().removeClass("selected");
        var $target = 'target';

        $("#navtopbar").slideDown();
    });
})();