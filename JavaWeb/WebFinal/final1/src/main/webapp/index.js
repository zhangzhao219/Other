// 获取服务器上圆圈的状态
function getMachinestate() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var info = xmlhttp.responseText;
            var obj = JSON.parse(info);
            // 获取圆圈集合
            var circleset = document.getElementById("circleset");
            // 移除掉所有的圆圈
            while (circleset.firstChild) {
                circleset.removeChild(circleset.firstChild);
            }
            for (var i = 0; i < obj.info.length; i++) {
                // 动态创建圆圈
                var div = document.createElement("div");
                // 给一个类，让它变成圆
                div.setAttribute("class", "circle");
                div.setAttribute("id", obj.info[i].id);
                // 鼠标移入移出加js效果
                div.setAttribute("onMouseOver", "showName(this)");
                div.setAttribute("onMouseOut", "noName(this)");
                // 变换颜色
                if (obj.info[i].state == 1) {
                    div.style.backgroundColor = 'green';
                }
                else {
                    div.style.backgroundColor = 'red';
                }

                // 增加提示框，默认不显示
                tips = '<div style="display: none;">' + obj.info[i].name + '</div>';
                // 加入提示框的代码
                div.innerHTML = tips;
                // 在圆圈集里面加入圆圈
                circleset.appendChild(div);
            }
        }
    }
    xmlhttp.open('GET', 'indexjava');
    xmlhttp.send();
}
// 定时器
function getMSinterval() {
    getMachinestate();
    setInterval("getMachinestate()", 5000);
}
// 鼠标移上显示名字
function showName(thisnode) {
    if (thisnode.firstChild) {
        thisnode.firstChild.style.display = "block";
    }
}
// 鼠标移开不显示名字
function noName(thisnode) {
    if (thisnode.firstChild) {
        thisnode.firstChild.style.display = "none";
    }
}