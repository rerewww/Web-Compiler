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


    <style class="cp-pen-styles">body{
        margin: 0;
        padding: 0;
        font-family: sans-serif;
    }

    h1, h2, h3, h4, h5, h6, p{
        color: #fff;
        font-weight: 200;
    }

    a{
        text-decoration: none;
    }

    /* GRID */

    .grid { max-width: 940px; width: 100%; margin: 0 auto; }

    .four {
        width: 32.26%;
    }

    /* COLUMNS */

    .col {
        display: block;
        float:left;
        margin: 1% 0 1% 1.6%;
    }

    .col:first-of-type { margin-left: 0; }

    /* CLEARFIX */

    .cf:before,
    .cf:after {
        content: " ";
        display: table;
    }

    .cf:after { clear: both; }
    .cf { *zoom: 1; }

    /* GENERAL STYLES FOR BOX AND OVERLAY */

    .box {
        display: block;
        width: 100%;
        height: 200px;
        overflow: hidden;
        background-color: #bbb;
        text-align: center;
        position: relative;
        cursor: pointer;
    }

    .overlay{
        width: 100%;
        height:100%;
        position: absolute;
        left: 0;
        top: 0;
        right: 0;
        bottom: 0;
    }

    /* SLIDE IN */

    .slide-in .overlay{
        background-color: #6addaa;
        color: #fff;
        transform: translateX(-100%);
        -webkit-transition: transform 0.5s ease-out;
        -o-transition: transform 0.5s ease-out;
        transition: transform 0.5s ease-out;
    }

    .slide-in .box:hover .overlay{
        transform: translateX(0);
    }

    /* SLIDE UP */

    .slide-up .overlay{
        background-color: #3dcbe8;
        line-height: 200px;
        color: #fff;
        transform: translateY(100%);
        -webkit-transition: transform 0.5s ease-out;
        -o-transition: transform 0.5s ease-out;
        transition: transform 0.5s ease-out;
    }

    .slide-up .box:hover .overlay{
        transform: translateY(0);
    }

    /* SLIDE DOWN DELAY */

    .slide-down-delay .overlay{
        background-color: #ee6f8c;
        line-height: 200px;
        color: #fff;
        transform: translateY(-100%);
        -webkit-transition: transform 0.5s ease-out;
        -o-transition: transform 0.5s ease-out;
        transition: transform 0.5s ease-out;
    }

    .slide-down-delay .box:hover .overlay{
        transform: translateY(0);
    }

    .slide-down-delay .overlay i{
        transform: translateY(-80%);
        opacity: 0;
        -webkit-transition: transform 0.5s linear, opacity 0.5s linear 0.5s;
        -o-transition: transform 0.5s linear, opacity 0.5s linear 0.5s;
        transition: transform 0.5s linear, opacity 0.5s linear 0.5s;
    }

    .slide-down-delay .box:hover .overlay i{
        transform: translateY(0);
        opacity: 1;
    }

    /* ROTATE */

    .rotate .overlay{
        background-color: #6d94bb;
        line-height: 200px;
        color: #fff;
        transform-origin: 0 0;
        transform: rotate(90deg);
        -webkit-transition: transform 0.5s ease-in-out;
        -o-transition: transform 0.5s ease-in-out;
        transition: transform 0.5s ease-in-out;
    }

    .rotate .box:hover .overlay{
        transform: rotate(0deg);
    }

    /* SCALE */

    .scale .overlay{
        background-color: #efcb5e;
        line-height: 200px;
        color: #fff;
        transform: translateX(210%) scale(3);
        -webkit-transition: transform 0.6s ease-in-out;
        -o-transition: transform 0.6s ease-in-out;
        transition: transform 0.6s ease-in-out;
    }

    .scale .box:hover .overlay{
        transform: translateX(0) scale(1);
    }

    /* FLIP */

    .flip .overlay{
        background-color: #009688;
        line-height: 200px;
        color: #fff;
        opacity: 0;
        transform: rotateY(180deg);
        -webkit-transition: transform 0.6s ease-in-out 0.3s, opacity 0.3s ease-in-out;
        -o-transition: transform 0.6s ease-in-out 0.3s, opacity 0.3s ease-in-out;
        transition: transform 0.6s ease-in-out 0.3s, opacity 0.3s ease-in-out;
    }

    .flip .box:hover .overlay{
        opacity: 1;
        transform: rotateY(0deg);
    }

    /* SKEW */

    .skew .overlay{
        background-color: #f44336;
        line-height: 200px;
        color: #fff;
        opacity: 0;
        transform: skewX(-10deg);
        -webkit-transition: transform 0.3s ease-in-out, opacity 0.3s ease-in-out;
        -o-transition: transform 0.3s ease-in-out, opacity 0.3s ease-in-out;
        transition: transform 0.3s ease-in-out, opacity 0.3s ease-in-out;
    }

    .skew .box:hover .overlay{
        transform: skewX(0deg);
        opacity: 1;
    }

    /* CORNER */

    .corner-bottom .overlay{
        background-color: #9c27b0;
        line-height: 200px;
        color: #fff;
        transform: translate(100%, 100%);
        -webkit-transition: transform 0.4s ease-in-out;
        -o-transition: transform 0.4s ease-in-out;
        transition: transform 0.4s ease-in-out;
    }

    .corner-bottom .box:hover .overlay{
        transform: translate(0, 0);
    }

    /* CORNER */

    .corner-top .overlay{
        background-color: #ff5722;
        line-height: 200px;
        color: #fff;
        transform: translate(-100%, -100%);
        -webkit-transition: transform 0.4s ease-in-out;
        -o-transition: transform 0.4s ease-in-out;
        transition: transform 0.4s ease-in-out;
    }

    .corner-top .box:hover .overlay{
        transform: translate(0, 0);
    }</style>

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
            <div id="questions" class="grid">
                <div style="margin: 10px 0px 10px 0px">
                    <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Show Menu</a>
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
    <script src="/resources/js/renderer.js"></script>
    <!-- Menu Toggle Script -->

    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
        renderer.createQuestion(${questions});
    </script>
</body>
</html>
