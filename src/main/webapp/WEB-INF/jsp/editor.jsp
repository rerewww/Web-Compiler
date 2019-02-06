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
</head>
<body>
    <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Start Bootstrap
                    </a>
                </li>
                <li>
                    <a href="/">Dashboard</a>
                </li>
                <li>
                    <a href="/codingView.cmd">Practice</a>
                </li>
                <li>
                    <a href="#">Overview</a>
                </li>
                <li>
                    <a href="#">Events</a>
                </li>
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid" style="margin-bottom: 15px">
                <div>
                    <h1 style="display: inline-block">${title}</h1>
                    <select id="compileLangs" onclick="action.select()" style="display: inline-block; float: right; margin-top: 20px;">
                        <option value="java">java</option>
                        <option value="python">python</option>
                        <option value="javascript">javascript</option>
                    </select>
                </div>
                <textarea id="codemirrorArea"></textarea>

                <div style="margin: 10px 0px 10px 0px">
                    <button class="btn btn-danger" onclick="action.compile()">Compile</button>
                    <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
                </div>

                <div style="height: 300px; border: 2px solid silver">
                    <div style="border-bottom: 1px solid silver; font-weight: bold; font-size: 25px; text-indent: 10px">결과 값</div>
                    <div id="resultElem" style="font-size: 20px; text-indent: 5px"></div>
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->
    </div>
    <!-- /#wrapper -->

    <!-- Bootstrap core JavaScript -->
    <script src="/resources/lib/jquery.min.js"></script>
    <script src="/resources/lib/bootstrap.bundle.min.js"></script>
    <script src="/resources/js/action.js"></script>
    <script src="/resources/js/codemirror.js"></script>
    <script src="/resources/js/clike.js"></script>
    <!-- Menu Toggle Script -->

    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });

    var textarea = document.getElementById('codemirrorArea');
    var editor = CodeMirror.fromTextArea(textarea, {
        lineNumbers: true,
        lineWrapping: true,
        theme: "darcula",
        mode: "text/x-java",
        styleActiveLine: true,
        matchBrackets: true,
        val: textarea.value
    });
    editor.setValue('public class Test {\n	public static void main(String[] args) {\n		System.out.println(\"Hello, World!\");\n	}\n}');
    </script>
</body>
</html>
