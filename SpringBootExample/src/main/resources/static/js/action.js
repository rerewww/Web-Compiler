/**
 * Created by son on 2019-01-08.
 */
var action = {
    compile: function () {
        var note = document.getElementById('codemirrorArea');
        $.ajax({
            url: '/compile.action',
            type:'POST',
            async: true,
            data: {
                text: editor.getValue(),
                lang: document.getElementById('compileLangs').value
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
    },

    select: function () {
        var elem = document.getElementById('compileLangs');
        if ('java' === elem.value) {
            editor.setValue('public class Test {\n	public static void main(String[] args) {\n		System.out.println(\"Hello, World!\");\n	}\n}');
        } else if('python' === elem.value) {
            editor.setValue('print(\'Hello, World!\')');
        }
    }
};