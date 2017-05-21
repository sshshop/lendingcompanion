var pageSize=0;//每页显示行数
var currentPage_=1;//当前页全局变量，用于跳转时判断是否在相同页，在就不跳，否则跳转。
function goPage(pno,psize){
    var divNum = document.getElementById("count");
    var num = divNum.getElementsByClassName("book-content").length;
    var divCount = divNum.getElementsByClassName("book-content");
    pageSize = psize;//每页显示行数
    //总共分几页
    if(num/pageSize > parseInt(num/pageSize)){
        totalPage=parseInt(num/pageSize)+1;
    }else{
        totalPage=parseInt(num/pageSize);
    }
    var currentPage = pno;//当前页数
    currentPage_=currentPage;
    var startRow = (currentPage - 1) * pageSize+1;
    var endRow = currentPage * pageSize;
    endRow = (endRow > num)? num : endRow;
    //遍历显示数据实现分页
    for(var i=1;i<(num+1);i++){
        var irow = divCount[i-1];
        if(i>=startRow && i<=endRow){
            irow.style.display = "";
        }else{
            irow.style.display = "none";
        }
    }
    var tempLi="";
    for(var i=1;i<=totalPage;i++)

    {
        tempLi+='<li value='+i+'><a href="#comment" onclick="jumpPage('+i+')"> '+i+'</a></li>'
    }
    $("#jumpWhere").html(tempLi);
    $("#jumpWhere").val(currentPage);
    $("#jumpWhere1").html(tempLi);
    $("#jumpWhere1").val(currentPage);
    $("#jumpWhere2").html(tempLi);
    $("#jumpWhere2").val(currentPage);
}


function jumpPage(i)
{
    var num=parseInt(i);
    console.log(pageSize);
    if(num!=currentPage_)
    {
        goPage(num,pageSize);
    }
}