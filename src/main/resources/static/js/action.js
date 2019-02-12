/**
 * Created by son on 2019-01-08.
 */
var action = {
    selectQuestion: function () {
        var box = window.event.currentTarget;
        var title = box.firstElementChild.textContent;
        var content = box.lastElementChild.textContent;

        var url = window.location.protocol + "//" + window.location.hostname + ":" + window.location.port + "/coding.cmd?title=" + title + "&content=" + content + "&number=" + box.number;
        window.location.href = url;
    },

    compile: function () {
        var note = document.getElementById('codemirrorArea');
        $.ajax({
            url: '/compile.cmd',
            type:'POST',
            async: true,
            data: {
                text: editor.getValue(),
                lang: document.getElementById('compileLangs').value,
                number: window.info.number
            },
            dataType: 'json',
            success: function(response) {
                if (!response && !response.success) {
                    return;
                }

                var length = response.result.length;
                var text = '';
                for (var i = 0; i < length; i++) {
                    if (i > 0) {
                        text += '\n';
                    }
                    text += i + '번 테스트 케이스 ';
                    text += !!response.result[i] ? "성공" : "실패";
                }
                document.getElementById('resultElem').innerText = text;
            },
            error: function(response) {
            }
        });
    },

    select: function () {
        var elem = document.getElementById('compileLangs');
        if ('java' === elem.value) {
            editor.setValue('static class Solution {\n	public int solution(int width, int height) {\n        int area = 0;\n        return area;\n	}\n}');
        } else if('python' === elem.value) {
            editor.setValue('print(\'Hello, World!\')');
        } else if('javascript' === elem.value) {
            editor.setValue('function solution() {\n     return;\n}');
        }
    }
};