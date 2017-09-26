<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    /*
 * Glyphicons
 *
 * Special styles for displaying the icons and their classes in the docs.
 */

    .bs-glyphicons {
        margin: 0 -10px 20px;
        overflow: hidden;
    }
    .bs-glyphicons-list {
        padding-left: 0;
        list-style: none;
    }
    .bs-glyphicons li {
        float: left;
        width: 25%;
        height: 115px;
        padding: 10px;
        line-height: 1.4;
        text-align: center;
        background-color: #f9f9f9;
        border: 1px solid #fff;
    }
    .bs-glyphicons .glyphicon {
        margin-top: 5px;
        margin-bottom: 10px;
        font-size: 24px;
    }
    .bs-glyphicons .glyphicon-class {
        display: block;
        text-align: center;
        word-wrap: break-word; /* Help out IE10+ with class names */
    }
    .bs-glyphicons li:hover {
        color: #fff;
        background-color: #563d7c;
    }
    .selecticon{
        background-color: #563d7c!important;
    }
    .wfff{
        color: #fff;
    }

</style>
<div class="bs-glyphicons">
    <ul class="bs-glyphicons-list">

        <li>
            <span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-asterisk</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-plus</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-euro" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-euro</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-eur" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-eur</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-minus</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-cloud" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-cloud</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-envelope</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-pencil</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-glass" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-glass</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-music" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-music</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-search</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-heart</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-star</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-star-empty</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-user</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-film" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-film</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-th-large</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-th" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-th</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-th-list</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-ok</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-remove</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-zoom-in</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-zoom-out" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-zoom-out</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-off</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-signal" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-signal</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-cog</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-trash</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-home</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-file" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-file</span>
        </li>

        <li>
            <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
            <span class="glyphicon-class">glyphicon glyphicon-time</span>
        </li>

    </ul>
</div>
<script>
    $('.bs-glyphicons-list li').on('click',function () {

        $(this).addClass('selecticon');
        $(this).children('.glyphicon-class').addClass('wfff');
        $(this).siblings('li').removeClass('selecticon');
        $(this).siblings('li').children('.glyphicon-class').removeClass('wfff');
        $('#icon').val($(this).children('.glyphicon-class').text());
    })
</script>