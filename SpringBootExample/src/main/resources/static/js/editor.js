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
                if (!response && !response.success) {
                    return;
                }
                document.getElementById('resultElem').innerText = '결과 값 : ' + response.result;
            },
            error: function(response) {
            }
        });
    }
};