<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>校园易购</title>
    <style>

        /* =============================================================
           GENERAL STYLES
         ============================================================ */
        body {
            font-family: 'Open Sans', sans-serif;
            letter-spacing:1px;
            color:#fff;

        }
        p{
            padding:20px;
        }

        section
        {
            padding:50px 20px 25px 20px;
        }
        h2
        {

            font-size:60px;

        }

        p {

            line-height:30px;
            margin-bottom:35px;
        }
        hr {
            border-top: 1px solid rgb(27, 106, 131);
            margin: 0px 100px 0px 100px
        }
        /* =============================================================
           NAVBAR STYLES
         ============================================================ */
        .navbar-inverse {
            background-color: rgb(27, 106, 131);
            border-color: transparent;
        }

        .navbar-inverse .navbar-nav > .active > a, .navbar-inverse .navbar-nav > .active > a:hover, .navbar-inverse .navbar-nav > .active > a:focus {
            background-color: transparent;
            border-bottom: 4px solid rgba(0, 231, 222, 0.72);


        }
        .navbar-inverse .navbar-nav > li > a {
            color: #FFF;
            font-size: 13px;
            font-weight: 800;
            padding: 10px;
            letter-spacing: 2px;
            margin:10px 5px 10px 5px;
        }

        .navbar-inverse .navbar-brand {
            color: #FFF;
        }
        .copyrights{
            text-indent:-9999px;
            height:0;
            line-height:0;
            font-size:0;
            overflow:hidden;
        }
        /* =============================================================
           HOME STYLES
         ============================================================ */
        #home {
            text-align:center;
            padding-bottom:50px;
        }
        #home i {
            margin:5px;
        }
        #home h1 {
            text-transform:uppercase;
            padding-top:120px;
            font-size:60px;
            font-weight:900;
            color:#fff;
            line-height:80px;
            padding-bottom:5px;
        }
        /*SLIDER STYLES*/
        #carousel-slider {
            color:#fff;
            min-height:420px;
            padding:30px 20px 5px 20px;
        }
        .carousel-control.left {
            left: 0;
            right: auto;
            background-repeat: repeat-x;
            background-image: linear-gradient(to left,rgba(0, 0, 0, .0001) 0%, rgba(0, 0, 0, 0) 100%)!important;
        }
        .carousel-control.right {
            right: 0;
            left: auto;
            background-repeat: repeat-x;
            background-image: linear-gradient(to right,rgba(0, 0, 0, .0001) 0%, rgba(0, 0, 0, 0) 100%)!important;
        }
        .carousel-indicators li {
            border:5px solid #FFF;
            width:20px;
            height:20px;
        }
        .carousel-indicators .active {
            border:5px solid rgba(0, 231, 222, 0.72);
            width:20px;
            height:20px;
            background-color:transparent;

        }

        /* =============================================================
           BUTTON STYLES
         ============================================================ */

        .custom-btn-1 {
            border-radius:0px;
            background-color:transparent;
            border:2px solid rgba(0, 231, 222, 0.72);
            margin:5px;
            color:#fff;
        }
        .custom-btn-1:hover {
            color:#fff;
            background-color:rgba(0, 0, 0,  0.42);
        }

        /* =============================================================
           CONTACT STYLES
         ============================================================ */
        #contact  .form-control{
            background-color:transparent;
        }
        #contact label {
            padding:15px;
        }
        /* =============================================================
         FOOTER STYLES
       ============================================================ */
        .footer {
            text-align:right;
            color:#fff;
            background-color:rgb(27, 106, 131);
            padding:20px;
        }
    </style>
</head>
<body>

<input name="msg" value="${msg}" type="hidden">
    <div class="container-fluid">
        <c:import url="../../../common/include.jsp"></c:import>
        <div class="row">
            <c:import url="../../../common/header.jsp"></c:import>
        </div>
        <div class="row">
            <div class="col-md-2 leftdiv">
            </div>
            <div class="col-md-10">
                <div id="home" >
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 ">
                                <div id="carousel-slider" data-ride="carousel" class="carousel slide">

                                    <div class="carousel-inner">
                                        <div class="item active">

                                            <h1 >  学生管理  </h1>
                                        </div>
                                        <div class="item">
                                            <h1 > 学生分配作业</h1>
                                        </div>
                                        <div class="item">
                                            <h1>  班级管理</h1>
                                        </div>
                                    </div>
                                    <!--INDICATORS-->
                                    <ol class="carousel-indicators">
                                        <li data-target="#carousel-slider" data-slide-to="0" class="active"></li>
                                        <li data-target="#carousel-slider" data-slide-to="1" class=""></li>
                                        <li data-target="#carousel-slider" data-slide-to="2" class=""></li>
                                    </ol>

                                </div>


                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</body>