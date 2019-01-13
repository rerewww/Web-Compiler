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
                    <a href="/codingView.action">Practice</a>
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
                    <h1>Example</h1>
                    <select id="compileLangs">
                        <option value="java">java</option>
                        <option value="python">python</option>
                    </select>
                </div>
                <textarea id="codemirrorArea">public class Test {
  public static void main(String []args) {
    System.out.println("Hello, World!");
  }
}
                    </textarea>
                </div>
                <button onclick="action.compile()">Compile</button>
                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
        <div id="resultElem"></div>
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
    </script>
</body>
</html>
