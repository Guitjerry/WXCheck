$(function () {
 $.ajax({
  url:rootPath+"/init/leftinit?userid="+$('#loginuserid').val(),
  success:function (data) {
   var obj = eval('('+data+')');
   var childResource = obj.childResource;
   var parentResource = obj.parentResource;

   var leftdiv = '<ul id="accordion" class="accordion">';
   for(var i=0;i<parentResource.length;i++){
    var childrenli ='<ul class="submenu">';
    var  parentdiv="";
    parentdiv = "<div class=\"link\">"+"<i class='"+parentResource[i].icon+"'"+"></i>"+parentResource[i].name+"</div>";
    for(var j=0;j<childResource.length;j++){
     if(parentResource[i].id==childResource[j].parentid){
      var link = childResource[j].link;
      if(link!=null&&link!=undefined&&link.indexOf('?')>-1){
       var linkmsg = link.substring(link.indexOf("?"));
       var limsg = link.substring(link.indexOf("?")+1);
       childrenli += "<li "+limsg+">"+" <a href="+rootPath+childResource[j].link+">"+childResource[j].name+"</a></li>";
      }
     }
    }
    childrenli = childrenli+"</ul>";
    parentdiv = "<li>"+parentdiv+childrenli+"</li>";
    leftdiv +=parentdiv;
   }
   leftdiv=leftdiv+"</ul>";

   $('.leftdiv').html(leftdiv);

   initLeft();
  }



 })



})

function initLeft() {
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
}