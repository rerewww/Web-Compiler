/**
 * Created by son on 2019-01-19.
 */
var renderer = {
    createQuestion: function (questions, isGuest) {
        var elemQuestions = document.getElementById('questions');

        var i = 0;
        while(i < questions.length) {
            var row = document.createElement('div');
            while (row.childElementCount !== 5) { // row
                var question = questions[i];

                if (!question) {
                    break;
                }

                var col = document.createElement('div');
                var box = document.createElement('form');
                var overlay = document.createElement('div');
                var fa = document.createElement('div');

                row.className = 'row cf';

                col.className = 'slide-in four col';
                col.id = 'card_col';

                box.className = 'box';
                overlay.className = 'overlay';
                fa.className = 'fa fa-commenting-o fa-3x';
                fa.setAttribute('aria-hidden', 'true');

                var span = document.createElement('span');
                span.className = 'original';

                var header = document.createElement('h3');
                var title = question.title;
                var number = question.number;
                var content = question.content;
                var editor = question.editor;
                header.innerText = title;
                overlay.innerText = content;

                header.style = "margin-top: 78px";

                span.appendChild(header);
                box.appendChild(span);
                overlay.appendChild(fa);
                box.appendChild(overlay);
                col.appendChild(box);
                row.appendChild(col);

                box.action = window.location.origin + "/coding.cmd";
                box.number = number;
                box.editor = editor;
                box.onclick = function() {
                    action.selectQuestion();
                };
                i++;
            }
            elemQuestions.appendChild(row);
        }
    }
};