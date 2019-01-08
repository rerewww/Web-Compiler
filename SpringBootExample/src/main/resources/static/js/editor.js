/**
 * Created by son on 2019-01-08.
 */
var editor = {
    compile : function () {
        var note = document.getElementById('note');
        $.ajax({
            url: '/compile.action',
            type:'POST',
            async: true,
            data: {
                text: note.textContent
            },
            dataType: 'json',
            success: function(response) {

            },
            error: function(response) {
            }
        });
    }
};