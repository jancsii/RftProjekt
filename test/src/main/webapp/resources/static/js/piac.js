$(document).ready(function () {
    $('#kapus_poszt').change(function () {
        var selectedOption = $('#kapus_poszt option:selected');
        $('#kapuss').html('Igazolas = ' + selectedOption.text());
        $('#kapuss').css("color", "red");
        $('#kapuss').css( "fontSize", "10px" );
    });
    $('#vedo_poszt').change(function () {
        var selectedOption = $('#vedo_poszt option:selected');
        $('#vedoo').html('Igazolas = ' + selectedOption.text());
        $('#vedoo').css("color", "red");
        $('#vedoo').css( "fontSize", "10px" );
    });
    $('#kozepes_poszt').change(function () {
        var selectedOption = $('#kozepes_poszt option:selected');
        $('#kozepp').html('Igazolas = ' + selectedOption.text());
        $('#kozepp').css("color", "red");
        $('#kozepp').css( "fontSize", "10px" );
    });
    $('#tamado_poszt').change(function () {
        var selectedOption = $('#tamado_poszt option:selected');
        $('#tamadoo').html('Igazolas = ' + selectedOption.text());
        $('#tamadoo').css("color", "red");
        $('#tamadoo').css( "fontSize", "10px" );
    });
    $('input[type="checkbox"]').on('change', function() {
        $('input[name="' + this.name + '"]').not(this).prop('checked', false);
    });
});