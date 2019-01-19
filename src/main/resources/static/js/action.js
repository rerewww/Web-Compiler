/**
 * Created by son on 2019-01-08.
 */
var action = {
    selectQuestion: function () {
        var box = window.event.currentTarget;
        var title = box.firstElementChild.textContent;
        var content = box.lastElementChild.textContent;

        var url = window.location.protocol + "//" + window.location.hostname + ":" + window.location.port + "/coding.action?title=" + title + "&content=" + content;
        window.location.href = url;
    },

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
                document.getElementById('resultElem').innerText = response.result;
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