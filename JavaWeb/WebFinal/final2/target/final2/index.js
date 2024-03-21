function showinfo() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            // 获取表格信息
            var info = xmlhttp.responseText;
            // 转换为json字符串
            var obj = JSON.parse(info);
            // 获取表格元素
            var tbody = document.getElementById('showtable');
            // 动态创建表格
            for (var i = 0; i < obj.info.length; i++) {
                var tr = document.createElement("tr");
                tbody.appendChild(tr);
                // 插入数据
                for (var k in obj.info[i]) {
                    var td = document.createElement("td");
                    td.innerHTML = obj.info[i][k];
                    tr.appendChild(td);
                }
                // 最后一列的动态创建
                var td = document.createElement("td");
                td.innerHTML = "设置为已缴费";

                if (obj.info[i].isPaid == "否") {
                    td.setAttribute("class", "paidState");
                    td.setAttribute("onClick", "setPaid(this)");
                }
                else {
                    td.setAttribute("class", "paid");
                }

                // 将创建好的对象插进文档流
                tr.appendChild(td);
                tbody.appendChild(tr);
            }
        }
    }
    xmlhttp.open('GET', 'indexjava');
    xmlhttp.send();
}
window.onload = showinfo;

function setPaid(thisnode) {
    // 获取更新记录的id
    var id = thisnode.parentNode.firstElementChild.innerHTML;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            // 获取返回的提示字符串
            var rtn = xmlhttp.responseText;
            // 解析为json字符串
            var obj = JSON.parse(rtn);
            // 更改页面显示
            if (obj.result == "ok") {
                thisnode.setAttribute("class", "paid");
                thisnode.removeAttribute("onClick");
                thisnode.parentNode.children[3].innerHTML = "是";
            }
            else {
                alert("更新失败！");
            }
        }
    }
    xmlhttp.open('GET', 'setPaid?id=' + id, true);
    xmlhttp.send();
}