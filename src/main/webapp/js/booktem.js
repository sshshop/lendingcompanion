function checkbtname() {
    var msg = document.getElementById("msg");
    var name = document.getElementById("btname").value;
    if (name == null || name == "") {
        msg.innerHTML = "请填入图书名！";
        document.getElementById("addsumbit").disabled = true;
        return false;
    } else {
        msg.innerHTML = "";
        document.getElementById("addsumbit").disabled = false;
        return false;
    }
}

function checkauthor() {
    var msg = document.getElementById("msg");
    var name = document.getElementById("author").value;
    if (name == null || name == "") {
        document.getElementById("addsumbit").disabled = true;
        msg.innerHTML = "请填入作者名！";
        return false;
    } else {
        document.getElementById("addsumbit").disabled = false;
        msg.innerHTML = "";
        return false;
    }
}


function checkbtcid() {
    var msg = document.getElementById("msg");
    var name = document.getElementById("tcid").value;
    if (name == null || name == "") {
        document.getElementById("addsumbit").disabled = true;
        msg.innerHTML = "请选择分类！";
        return false;
    } else {
        document.getElementById("addsumbit").disabled = false;
        msg.innerHTML = "";
        return false;
    }
}


function checkbadr() {
    var msg = document.getElementById("msg");
    var name = document.getElementById("adr").value;
    if (name == null || name == "") {
        document.getElementById("addsumbit").disabled = true;
        msg.innerHTML = "请填入出版社！";
        return false;
    } else {
        document.getElementById("addsumbit").disabled = false;
        msg.innerHTML = "";
        return false;
    }
}


function checkbnum() {
    var msg = document.getElementById("msg");
    var name = document.getElementById("num").value;
    if (name == null || name == "") {
        document.getElementById("addsumbit").disabled = true;
        msg.innerHTML = "请填入图书编号！";
        return false;
    } else {
        document.getElementById("addsumbit").disabled = false;
        msg.innerHTML = "";
        return false;
    }
}

function checkbcover() {
    var msg = document.getElementById("msg");
    var name = document.getElementById("cover").value;
    if (name == null || name == "") {
        document.getElementById("addsumbit").disabled = true;
        msg.innerHTML = "请选择图书封面上传！";
        return false;
    } else {
        document.getElementById("addsumbit").disabled = false;
        msg.innerHTML = "";
        return false;
    }
}

function checksequence() {
    var msg = document.getElementById("msg");
    var name = document.getElementById("sequence").value;
    if (name == null || name == "") {
        document.getElementById("addsumbit").disabled = true;
        msg.innerHTML = "请填入图书的序！";
        return false;
    } else {
        document.getElementById("addsumbit").disabled = false;
        msg.innerHTML = "";
        return false;
    }
}

function checkidt() {
    var msg = document.getElementById("msg");
    var name = document.getElementById("idt").value;
    if (name == null || name == "") {
        document.getElementById("addsumbit").disabled = true;
        msg.innerHTML = "请填入图书的导读！";
        return false;
    } else {
        document.getElementById("addsumbit").disabled = false;
        msg.innerHTML = "";
        return false;
    }
}

function checkbbtcontent() {
    var msg = document.getElementById("msg");
    var name = document.getElementById("btcontent").value;
    if (name == null || name == "") {
        document.getElementById("addsumbit").disabled = true;
        msg.innerHTML = "请填入图书内容简介！";
        return false;
    } else {
        document.getElementById("addsumbit").disabled = false;
        msg.innerHTML = "";
        return false;
    }
}

function checkbcobn() {
    var msg = document.getElementById("msg");
    var name = document.getElementById("cobn").value;
    var reg = new RegExp("^[0-9]*$");
    if (name == null || name == "") {
        document.getElementById("addsumbit").disabled = true;
        msg.innerHTML = "请填入图书藏书量！";
        return false;
    }
    if (!reg.test(name)) {
        msg.innerHTML = "请在藏书量输入正确的数字！";
        return false;
    }
    else {
        document.getElementById("addsumbit").disabled = false;
        msg.innerHTML = "";
        return false;
    }
}

function checkbsubmit() {
    var msg = document.getElementById("msgsu");
    var arr0 = document.getElementById("btname").value;
    var arr1 = document.getElementById("btcontent").value;
    var arr2 = document.getElementById("idt").value;
    var arr3 = document.getElementById("sequence").value;
    var arr4 = document.getElementById("cover").value;
    var arr5 = document.getElementById("num").value;
    var arr6 = document.getElementById("adr").value;
    var arr7 = document.getElementById("cover").value;
    var arr8 = document.getElementById("cobn").value;
    var arr9 = document.getElementById("author").value;
    var arr10 = document.getElementById("tcid").value;
    var a = checkbtname();
    var b = checkbadr();
    var c = checkbbtcontent();
    var d = checkbcobn();
    var e = checkbcover();
    var f = checkbnum();
    var g = checkbtcid();
    var h = checkbtname();
    var i = checksequence();
    var j = checkidt();
    if (arr0!=null&&arr0!=""&&arr1!=null&&arr1!=""&&arr2!=null
        &&arr3!=""&&arr3!=null&&arr4!=null&&arr5!=null&&arr6!=null
        &&arr7!=null&&arr8!=null&&arr9!=null&&arr10!=null) {
    /*if(a==true&&b==true&&c==true&&d==true&&e==true&&f==true&&g==true&&h==true&&i==true&&j==true){*/

        document.getElementById("addsumbit").disable = false;
    } else {
        msg.innerHTML = "信息未填完整！";
        document.getElementById("addsumbit").disabled = true;
        return false;

    }
}