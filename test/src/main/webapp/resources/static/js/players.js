$(document).ready(function(){
    $("h4").hide();
    $("h5").hide();
    $("h6").hide();
    $(".ClassNameOfShouldBeHiddenElements").hide();
    $("h3").click(function(){
        $("h4").css("color", "red");
        $("h4").css( "fontSize", "50px" );
        $("h4").show();
        $("h4").css("text-align", "center");
        $("h5").css("text-align", "center");
        $("h5").show();
        $("h6").css("color", "yellow");
        $("h6").css( "fontSize", "25px" );
        $("h6").css("text-align", "center");
        $("h6").show();
    });
});

