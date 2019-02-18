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
</head>

<body>
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

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <h1>Welcome!</h1>
                <p>Solve your algorithmic problems and improve your skills.</p>
                <p>Press the 'Show Menu' Button to start!</p>
                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Show Menu</a>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
    <!-- Bootstrap core JavaScript -->
    <script src="/resources/lib/jquery.min.js"></script>
    <script src="/resources/lib/bootstrap.bundle.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>
</body>
</html>
