<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .back{
        background: #c12c42;
    }
</style>

<input name="msg" class="selectmsg" value="${msg}" type="hidden">
<ul id="accordion" class="accordion">
<c:forEach items="${leftmenus}" var="menu">
    <li>
            ${menu.parentdiv}
            ${menu.childreli}
    </li>
</c:forEach>
</ul>

<script>
    $(function() {
        $(".submenu li").each(function () {
            if($(this).attr("msg")==$('.selectmsg').val()){
                $(this).addClass("back");
                $(this).parent('.submenu').show();
            }
        })
        var Accordion = function(el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;

            // Variables privadas
            var links = this.el.find('.link');
            // Evento
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
        }

        Accordion.prototype.dropdown = function(e) {
            var $el = e.data.el;
            $this = $(this),
                    $next = $this.next();

            $next.slideToggle();
            $this.parent().toggleClass('open');

            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
            };
        }

        var accordion = new Accordion($('#accordion'), false);
    });
</script>