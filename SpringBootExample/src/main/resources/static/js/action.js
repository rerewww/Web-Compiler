/**
 * Created by son on 2019-01-08.
 */
var action = {
    compile : function () {
        var note = document.getElementById('codemirrorArea');
        $.ajax({
            url: '/compile.action',
            type:'POST',
            async: true,
            data: {
                text: editor.getValue(),
                lang: 'java'
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