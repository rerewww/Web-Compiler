/**
 * Created by son on 2019-03-06.
 */
var options = {
    vimMode: function () {
        var elem = document.getElementById('vim');
        var keyMap = editor.getOption('keyMap');
        var option = '';

        if (keyMap === 'default') {
            option = 'vim';
            elem.className = elem.className + ' active';
        } else {
            option = 'default';
            elem.className = elem.className.substring(0, elem.className.indexOf(' active'));
        }
        editor.setOption('keyMap', option);
    }
};