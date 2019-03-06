<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Simple Sidebar - Start Bootstrap Template</title>
    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/resources/css/simple-sidebar.css" rel="stylesheet">
    <link href="/resources/css/codemirror.css" rel="stylesheet">
    <link href="/resources/css/darcula.css" rel="stylesheet">
    <link href="/resources/css/editor.css" rel="stylesheet">
</head>
<body style="background-color:#37485D">
<div id="wrapper">
    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="/">
                    Menu
                </a>
            </li>
            <li>
                <a href="/">Home</a>
            </li>
            <li>
                <a href="/codingView.cmd">Practice</a>
            </li>
            <li>
                <a href="#">UserInfo</a>
            </li>
            <li>
                <a href="/logout" style="margin-top: 20px; font-weight: bold;">Logout</a>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Header -->
    <div class="row">
        <div id="editor_header" class="col-md-12">
            <h3 style="display: inline-block; color: white; margin: 15px 0px 0px 15px;">${title}</h3>
            <select id="compileLangs" onclick="action.select()" class="btn btn-dark" style="display: inline-block; float: right; margin-top: 20px;">
                <option value="java">java</option>
                <option value="python">python</option>
                <option value="javascript">javascript</option>
            </select>
            <button id='vim' class="btn btn-dark" style="float: right; margin-top: 20px; margin-right: 5px;" onclick="options.vimMode()">vim</button>
            <a href="#menu-toggle" class="btn btn-dark" id="menu-toggle" style="float: right; margin-top: 20px; margin-right: 5px">Show Menu</a>
        </div>
    </div>
    <div style="border-bottom: 1px solid black; margin-top: 10px"></div>
    <!-- /Header -->

    <div class="row">
        <!-- quiz content -->
        <div class="col-md-6" style="border-right: 1px solid black;">
            <h6 id="quiz0" style="margin-top: 10px;">문제 설명</h6>
            <p id="quiz_content">${content}</p>
            <div style="margin-top: 20px;"></div>
            <h6 id="quiz0">제한 사항</h6>
            <div style="margin-left: 5px; text-align: center; background: #202B3D; color: #B2C0CC; border-radius: 10px;">
                <p style="padding-top: 5px;">
                    클래스명과 메서드 명을 변경하지 마세요.
                </p>
                <p style="padding-bottom: 5px;">
                    메서드의 파라미터 명을 변경하지 마세요.
                </p>
            </div>
        </div>
        <!-- /quiz content -->

        <div class="col-md-6" style="margin-top: 10px">
            <textarea id="codemirrorArea"></textarea>

            <div style="margin: 10px 0px 10px 0px">
                <button class="btn btn-danger" style="width: 130px" onclick="action.compile()">Run</button>
            </div>

            <div style="height: 300px; border: 2px solid silver">
                <div style="border-bottom: 1px solid silver; font-weight: bold; font-size: 15px; text-indent: 10px; color: white">실행 결과</div>
                <img id="compileLoading" src="/resources/images/loading.gif" style="width: 50px; margin-left: 5px; margin-top: 5px; display: none;"/>
                <div id="resultElem" style="font-size: 20px; text-indent: 5px"></div>
            </div>
        </div>
    </div>
</div>

<script src="/resources/lib/jquery.min.js"></script>
<script src="/resources/lib/bootstrap.bundle.min.js"></script>
<script src="/resources/lib/codemirror.js"></script>
<script src="/resources/lib/active-line.js"></script>
<script src="/resources/lib/vim.js"></script>

<script src="/resources/js/action.js"></script>
<script src="/resources/js/clike.js"></script>
<script src="/resources/js/options.js"></script>

<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });

    if (!window.info) {
        window.info = {};
    }
    window.info.number = ${number};
    var textarea = document.getElementById('codemirrorArea');
    var editor = CodeMirror.fromTextArea(textarea, {
        lineNumbers: true,
        lineWrapping: true,
        theme: "darcula",
        mode: "text/x-java",
        styleActiveLine: true,
        matchBrackets: true,
        val: textarea.value,
        keyMap: "default"
    });
    editor.setValue(decodeURIComponent('${editor}'));
    editor.setSize(null, 500);
</script>
</body>
</html>
