function urlHtml() {//获取地址最后一个“/”的下标
    var ts_href = window.location.href;//获取url地址
    var ts_htmlStart = ts_href.lastIndexOf("/");//获取地址“/”之后的的内
    var ts_htmlEnd = ts_href.indexOf(".html");//获取“/”到".html"之间的内容
    return ts_href.substring(ts_htmlStart + 1, ts_htmlEnd);
}

function setCookie(name, value) {
    var Days = 30; //此 cookie 将被保存 30 天
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}

/**
 * 删除cookie
 * @param name
 */
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

/**
 * 读取cookie
 * @param name
 * @returns
 */
function getCookie(name) {
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if (arr != null)
        return unescape(arr[2]);
    return null;
}


/**
 * 根据name获取单选框的值
 * @param name
 * @returns
 */
function getRadioByName(name) {
    return $('input:radio[name="' + name + '"]:checked').val();
}

function register() {
    if ($("#exampleInputName").val() == null || $("#exampleInputName").val() === "") {
        toastr["error"]("用户名不能为空！", "出错啦~");
    } else if ($("#exampleInputEmail").val() == null || $("#exampleInputEmail").val() === "") {
        toastr["error"]("邮箱不能为空！", "出错啦~");
    } else if ($("#exampleInputPassword").val() == null || $("#exampleInputPassword").val() === "") {
        toastr["error"]("密码不能为空！", "出错啦~");
    } else {
        var identity = 0;
        if (getRadioByName("exampleInputId") === "teacher") {
            identity = 2;
        } else if (getRadioByName("exampleInputId") === "student") {
            identity = 1;
        }
        $.ajax({
            type: "post",
            url: "userRegister",
            async: true,
            dataType: "json",
            data: {
                "username": $("#exampleInputName").val(),
                "email": $("#exampleInputEmail").val(),
                "password": $("#exampleInputPassword").val(),
                "identity": identity
            },
            success: function (data) {
                if (data.result === true) {
                    toastr["success"]("账户注册成功，自动登录中~");
                    setCookie('USER', JSON.stringify(data.user));
                    setInterval(go, 3000);

                    function go() {
                        window.location.href = "index.html";
                    }
                } else {
                    toastr["warning"]("账户注册失败，换个邮箱试一试~", "出错啦~");
                }
            },
            error: function (data) {
                toastr["warning"]("账户注册失败，换个邮箱试一试~", "出错啦~");
            }
        })
    }

}

function login() {
    if ($("#exampleInputEmail1").val() == null || $("#exampleInputEmail1").val() === "") {
        toastr["error"]("用户名或邮箱不能为空！", "出错啦~");
    } else if ($("#exampleInputPassword1").val() == null || $("#exampleInputPassword1").val() === "") {
        toastr["error"]("密码不能为空！", "出错啦~");
    } else {
        $.ajax({
            type: "post",
            url: "userLogin",
            async: true,
            dataType: "json",
            data: {
                "username": $("#exampleInputEmail1").val(),
                "password": $("#exampleInputPassword1").val()
            },
            success: function (data) {
                if (data.result === true) {
                    setCookie("USER", JSON.stringify(data.user));
                    window.location = "index.html";
                } else {
                    toastr["warning"]("账号或密码错误！", "出错啦~");
                }
            },
            error: function (data) {
                toastr["warning"]("账号或密码错误！", "出错啦~");
            }
        })
    }
}

function logout() {
    delCookie("USER");
    window.location.href = "login.html"
}

//flag=0: 不显示 ,flag=1 : 开始做题，flag=2 :修改 删除 开始做题

function myPaper(begin, num, flag) {
    $.ajax({
        type: "get",
        url: "loadPaper",
        async: true,
        dataType: "json",
        data: {
            "id": JSON.parse(getCookie("USER")).id,
            "begin": begin,
            "num": num
        },
        success: function (data) {
            if (data.result === true) {
                if (begin === 0) {
                    sessionStorage.setItem("countPaper", data.countPaper);
                }
                var tbodyObj = "";
                $.each(data.papers, function (index, paper) {
                    tbodyObj = tbodyObj + "<tr id='eptr" + paper.eid + "'><th scope=\"row\">" + (index + 1) + "</th>" +
                        "<td id='eptd" + paper.eid + "'>" + paper.exampapername + "</td>" +
                        "<td>" + paper.questionnumber + "</td>" +
                        "<td>" + paper.creattime + "</td>" +
                        "<td>" + paper.creatperson + "</td>";
                    if (flag === 1) {
                        tbodyObj = tbodyObj + "<td>" +
                            "<button onclick='updExamOrPaper(" + paper.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">修改</button>" +
                            "<button onclick='isdeletePaperOrExam(" + paper.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                            "<a href='paperDetail.html?id=" + paper.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看題目</a>" +
                            "<a " + ((paper.questionnumber === 0) ? 'disabled style="pointer-events: none"' : '') + " href='doexam.html?id=" + paper.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">开始做题</a>" +
                            "</td>";
                    } else if (flag === 2) {
                        tbodyObj = tbodyObj + "<td>" +
                            "<button onclick='updExamOrPaper(" + paper.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">修改</button>" +
                            "<button onclick='isdeletePaperOrExam(" + paper.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                            "<a href='paperDetail.html?id=" + paper.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看題目</a>" +
                            "</td>";
                    }
                    if (urlHtml() === "classDetail") {
                        tbodyObj = tbodyObj + "<td><input type='checkbox' name='checkbox' value='" + paper.eid + "'></td>";
                    }
                    tbodyObj = tbodyObj + "</tr>";
                })
                $("#mypaper").html(tbodyObj);
            } else {
                $("#mypaper").html("<tr><th scope='row'>1</th><td>你还没有创建过试卷哦~</td></tr>");
            }
        },
        error: function (data) {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    })
}

function myClass(begin, num, flag) {
    $.ajax({
        type: "get",
        url: "loadClass",
        async: true,
        dataType: "json",
        data: {
            "id": JSON.parse(getCookie("USER")).id,
            "begin": begin,
            "num": num
        },
        success: function (data) {
            if (data.result === true) {
                if (begin === 0) {
                    sessionStorage.setItem("countClass", data.countClass);
                }
                var tbodyObj = "";
                $.each(data.clazzes, function (index, clazz) {
                    tbodyObj = tbodyObj + "<tr id='classtr" + clazz.cid + "'><th scope=\"row\">" + (index + 1) + "</th>" +
                        "<td id='classtdn" + clazz.cid + "'>" + clazz.classname + "</td>" +
                        "<td id='classtdd" + clazz.cid + "'>" + clazz.classdetails + "</td>" +
                        "<td>" + clazz.classnumber + "</td>" +
                        "<td>" + clazz.creattime + "</td>" +
                        "<td>" + clazz.creatperson + "</td>";
                    if (flag === 1) {
                        tbodyObj = tbodyObj + "<td>" +
                            "<a href='classDetail.html?id=" + clazz.cid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看班级</a>" +
                            "</td>";
                    } else if (flag === 2) {
                        tbodyObj = tbodyObj + "<td>" +
                            "<button onclick='updClazz(" + clazz.cid + ")' type=\"button\" class=\"btn btn-default btn-xs\">修改</button>" +
                            "<button onclick='isdeleteClass(" + clazz.cid + "," + clazz.uid + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                            "<a href='classDetail.html?id=" + clazz.cid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看班级</a>" +
                            "</td>";
                    }
                    tbodyObj = tbodyObj + "</tr>";
                })
                $("#myclass").html(tbodyObj);
            } else {
                $("#myclass").html("<tr><th scope='row'>1</th><td>你还没有加入过班级哦~</td></tr>");
            }
        },
        error: function (data) {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    })
}

function myExam(begin, num, flag) {
    $.ajax({
        type: "get",
        url: "loadExam",
        async: true,
        dataType: "json",
        data: {
            "id": JSON.parse(getCookie("USER")).id,
            "begin": begin,
            "num": num
        },
        success: function (data) {
            if (data.result === true) {
                if (begin === 0) {
                    sessionStorage.setItem("countExam", data.countExam);
                }
                var tbodyObj = "";
                $.each(data.exams, function (index, exam) {
                    tbodyObj = tbodyObj + "<tr id='eptr" + exam.eid + "'><th scope=\"row\">" + (index + 1) + "</th>" +
                        "<td id='eptd" + exam.eid + "'>" + exam.exampapername + "</td>" +
                        "<td>" + exam.questionnumber + "</td>" +
                        "<td>" + exam.creattime + "</td>" +
                        "<td>" + exam.classname + "</td>";
                    if (flag === 1) {
                        tbodyObj = tbodyObj + "<td>" +
                            "<a " + ((exam.questionnumber === 0) ? 'disabled style="pointer-events: none"' : '') + " href='doexam.html?id=" + exam.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">开始考试</a>" +
                            "</td>";
                    } else if (flag === 2) {
                        tbodyObj = tbodyObj + "<td>" +
                            "<button onclick='updExamOrPaper(" + exam.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">修改</button>" +
                            "<button onclick='isdeletePaperOrExam(" + exam.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                            "<a href='paperDetail.html?id=" + exam.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看题目</a>" +
                            "</td>";
                    }
                    tbodyObj = tbodyObj + "</tr>";
                })
                $("#myExam").html(tbodyObj);
            } else {
                $("#myExam").html("<tr><th scope='row'>1</th><td>你还没有考试哦~</td></tr>");
            }
        },
        error: function (data) {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    })
}

function myQuestion(begin, num, flag) {
    $.ajax({
        type: "get",
        url: "loadQuestion",
        async: true,
        dataType: "json",
        data: {
            "id": JSON.parse(getCookie("USER")).id,
            "begin": begin,
            "num": num
        },
        success: function (data) {
            if (data.result === true) {
                if (begin === 0) {
                    sessionStorage.setItem("countQuestion", data.countQuestion);
                }
                var tbodyObj = "";
                $.each(data.questions, function (index, question) {
                    var strnum = 30;
                    if (urlHtml() === "question") {
                        strnum = 90;
                    }
                    tbodyObj = tbodyObj + "<tr id='questr" + question.id + "' ><th scope=\"row\">" + (index + 1) + "</th>" +
                        "<td>" + JSON.stringify(question.question).substring(0, strnum) + "...</td>" +
                        "<td>" + question.typename + "</td>";

                    if (flag !== 0) {
                        tbodyObj = tbodyObj + "<td>" +
                            "<a href='questionDetail.html?id=" + question.id + "' type=\"button\" class=\"btn btn-default btn-xs\">查看</a>" +
                            "<button onclick='isdeleteQuestion(" + question.id + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                            // "<button href='doexam.html?id=" + question.id + "' type=\"button\" class=\"btn btn-default btn-xs\">开始做题</button>";
                            "</td>";
                        if (urlHtml() === "paperDetail") {
                            tbodyObj = tbodyObj + "<td><input type='checkbox' name='checkbox' value='" + question.id + "'></td>";
                        }
                    } else if (flag === 0) {
                        tbodyObj = tbodyObj + "<td>" + question.creatperson + "</td>";
                    }
                    tbodyObj = tbodyObj + "</tr>";
                })
                $("#myQuestion").html(tbodyObj);
            } else {
                $("#myQuestion").html("<tr><th scope='row'>1</th><td>你还没有题目哦~</td></tr>");
            }
        },
        error: function (data) {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    })
}

function deleteQuestion(id) {
    $.ajax({
        type: "get",
        url: "delQuestion",
        async: true,
        dataType: "json",
        data: {
            "id": id
        },
        success: function (data) {
            if (data.result === true) {
                toastr["success"]("删除成功！", "成功啦~");
                $("#questr" + id).css("display", "none");
            } else {
                toastr["error"]("题目不存在！", "失败啦~");
            }
        },
        error: function () {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    });
}

function deleteQuestionFromExamPaper(qid, eid) {
    $.ajax({
        type: "get",
        url: "delQuestionFromExamPaper",
        async: true,
        dataType: "json",
        data: {
            "qId": qid,
            "eId": eid
        },
        success: function (data) {
            if (data.result === true) {
                toastr["success"]("删除成功！", "成功啦~");
                $("#questr" + qid).css("display", "none");
            } else {
                toastr["error"]("题目不存在！", "失败啦~");
            }
        },
        error: function () {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    });
}

function deleteClass(id, creatperson) {
    $.ajax({
        type: "get",
        url: "delClass",
        async: true,
        dataType: "json",
        data: {
            "id": id,
            "creatperson": creatperson
        },
        success: function (data) {
            if (data.result === true) {
                toastr["success"]("删除成功！", "成功啦~");
                $("#classtr" + id).css("display", "none");
            } else {
                toastr["error"]("班级不存在！", "失败啦~");
            }
        },
        error: function () {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    });
}

function removeStudent(uid, cid) {
    $.ajax({
        type: "get",
        url: "delStudent",
        async: true,
        dataType: "json",
        data: {
            "cId": cid,
            "uId": uid
        },
        success: function (data) {
            if (data.result === true) {
                toastr["success"]("移除成功！", "成功啦~");
                $("#usertr" + uid).css("display", "none");
            } else {
                toastr["error"]("学生不存在！", "失败啦~");
            }
        },
        error: function () {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    });
}

function deletePaperOrExam(id) {
    $.ajax({
        type: "get",
        url: "delPaperOrExam",
        async: true,
        dataType: "json",
        data: {
            "id": id
        },
        success: function (data) {
            if (data.result === true) {
                toastr["success"]("删除成功！", "成功啦~");
                $("#eptr" + id).css("display", "none");
            } else {
                toastr["error"]("试卷不存在！", "失败啦~");
            }
        },
        error: function () {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    });
}

function deleteExamFromClass(eid, cid) {
    $.ajax({
        type: "get",
        url: "delExamFromClass",
        async: true,
        dataType: "json",
        data: {
            "eId": eid,
            "cId": cid
        },
        success: function (data) {
            if (data.result === true) {
                toastr["success"]("删除成功！", "成功啦~");
                $("#eptr" + eid).css("display", "none");
            } else {
                toastr["error"]("试卷不存在！", "失败啦~");
            }
        },
        error: function () {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    });
}

function countQuestion(uid) {
    var num = 0;
    $.ajax({
        type: "get",
        url: "countQuestion",
        async: true,
        dataType: "json",
        data: {
            "id": uid
        },
        success: function (data) {
            if (data.result === true) {
                num = data.count;
                return num;
            }
        }
    });
    return 0;
}

function creatpagechose(count, num) {
    var allpagenum = Math.ceil(count / 10);
    var page = "<button disabled style='width: 22px;background-color: #9acfea' class='btn btn-default btn-xs'>" + num + "</>";
    for (var i = Number(num) - 1, j = 0; i > 0 && j < 2; j++, i--) {
        page = "<button onclick='pageList(" + i + ")'  class='btn btn-default btn-xs'>" + i + "</button>" + page;
    }
    for (var i = Number(num) + 1, j = 0; i <= allpagenum && j < 2; j++, i++) {
        page = page + "<button onclick='pageList(" + i + ")' class='btn btn-default btn-xs'>" + i + "</button>";
    }
    page = "<button " + (num == 1 ? " disabled " : (" onclick='pageList(1)'")) + " class='btn btn-default btn-xs'>\<\<</button>" + page;
    page = page + "<button " + (allpagenum == num ? " disabled " : (" onclick='pageList(" + allpagenum + ")'")) + "class='btn btn-default btn-xs'>\>\></button>";
    return page;
}

function isdeleteQuestion(id) {
    if (confirm("确定要删除这道题目吗？")) {
        deleteQuestion(id);
    }
}

function isdeleteQuestionFromExamPaper(qid, eid) {
    if (confirm("确定要从这个试卷中删除这道题目吗？")) {
        deleteQuestionFromExamPaper(qid, eid);
    }
}

function isdeleteClass(id, creatperson) {
    if (confirm("确定要删除这个班级吗？")) {
        deleteClass(id, creatperson);
    }
}

function isremoveStudent(uid, cid) {
    if (confirm("确定要移除这名学生吗？")) {
        removeStudent(uid, cid);
    }
}

function isdeletePaperOrExam(id) {
    if (confirm("确定要删除这份卷子吗？（题目并不会删除）")) {
        deletePaperOrExam(id);
    }
}

function isdeleteExamFromClass(eid, cid) {
    if (confirm("确定要从班级中删除这份卷子吗？")) {
        deleteExamFromClass(eid, cid);
    }
}

//从浏览器的地址栏中获取查询参数
function getUrlParams(name) {
    var paramsAry = location.search.substr(1).split('&');
    //循环数据
    for (var i = 0; i < paramsAry.length; i++) {
        var tmp = paramsAry[i].split('=');
        if (tmp[0] === name) {
            return tmp[1]
        }
    }
    return null;
}

// function addExamOrPaper() {
//     $.ajax({
//         type: "post",
//         url: "addExamOrPaper",
//         async: true,
//         dataType: "json",
//         data: {
//             "name": $("#paperName").val(),
//             "creatperson": JSON.parse(getCookie("USER")).id,
//             "qName": $("#questionName").val(),
//             "qAnsa": $("#ansA").val(),
//             "qAnsb": $("#ansB").val(),
//             "qAnsc": $("#ansC").val(),
//             "qAnsd": $("#ansD").val(),
//             "qAns": $("#ans").val(),
//             "qType": $("#questiontype").val()
//         },
//         success: function (data) {
//             if (data.result === true) {
//                 toastr["success"]("试卷创建成功！", "成功啦~");
//                 $("input:reset").click();
//             } else {
//                 toastr["error"]("试卷创建失败！", "出错啦~");
//             }
//         }, error: function () {
//             toastr["error"]("试卷创建失败！", "出错啦~");
//         }
//     });
// }

function addQuestion() {
    var flag = true;
    if ($("#questionName").val() === "") {
        flag = false;
        toastr["warning"]("题目名称不能为空！", "出错啦~");
    } else if ($("#ans").val() === "") {
        flag = false;
        toastr["warning"]("答案不能为空！", "出错啦~");
    } else if ($("#questiontype").val() == 1 || $("#questiontype").val() == 2) {
        if ($("#ansA").val() === "") {
            flag = false;
            toastr["warning"]("答案A不能为空！", "出错啦~");
        } else if ($("#ansB").val() === "") {
            flag = false;
            toastr["warning"]("答案B不能为空！", "出错啦~");
        } else if ($("#ansC").val() === "") {
            flag = false;
            toastr["warning"]("答案C不能为空！", "出错啦~");
        } else if ($("#ansD").val() === "") {
            flag = false;
            toastr["warning"]("答案D不能为空！", "出错啦~");
        }
    }
    if (flag) {
        $.ajax({
            type: "post",
            url: "addQuestion",
            async: true,
            dataType: "json",
            data: {
                "qName": $("#questionName").val(),
                "qAnsa": $("#ansA").val(),
                "qAnsb": $("#ansB").val(),
                "qAnsc": $("#ansC").val(),
                "qAnsd": $("#ansD").val(),
                "qAns": $("#ans").val(),
                "qType": $("#questiontype").val(),
                "creatperson": JSON.parse(getCookie("USER")).id
            },
            success: function (data) {
                if (data.result === true) {
                    toastr["success"]("题目创建成功！", "成功啦~");
                    $("input:reset").click();
                } else {
                    toastr["error"]("题目创建失败！", "出错啦~");
                }
            }, error: function () {
                toastr["error"]("题目创建失败！", "出错啦~");
            }
        });
    }
}

function hidechose() {
    if ($("#questiontype").val() == 1 || $("#questiontype").val() == 2) {
        $(".hidechose").show();
    } else {
        $(".hidechose").hide();
    }
}

function addClass() {
    var flag = true;
    if ($("#className").val() === "") {
        flag = false;
        toastr["warning"]("班级名称不能为空！", "出错啦~");
    } else if ($("#classDetail").val() === "") {
        flag = false;
        toastr["warning"]("班级详情不能为空！", "出错啦~");
    }
    if (flag) {
        $.ajax({
            type: "post",
            url: "addClass",
            async: true,
            dataType: "json",
            data: {
                "cName": $("#className").val(),
                "cDetails": $("#classDetail").val(),
                "creatperson": JSON.parse(getCookie("USER")).id
            },
            success: function (data) {
                if (data.result === true) {
                    toastr["success"]("班级创建成功！", "成功啦~");
                    $("input:reset").click();
                } else {
                    toastr["error"]("班级创建失败！", "出错啦~");
                }
            }, error: function () {
                toastr["error"]("班级创建失败！", "出错啦~");
            }
        })
    }
}

function myPaperQuestion(eid) {
    $.ajax({
        type: "get",
        url: "loadPaperQuestion",
        async: true,
        dataType: "json",
        data: {
            "id": eid
        },
        success: function (data) {
            if (data.result === true) {
                $("#paperName").text(data.questions[0].exampapername);
                var tbodyObj = "";
                $.each(data.questions, function (index, question) {
                    tbodyObj = tbodyObj + "<tr id='questr" + question.qid + "'><th scope=\"row\">" + (index + 1) + "</th>" +
                        "<td>" + JSON.stringify(question.question).substring(0, 90) + "...</td>" +
                        "<td>" + question.typename + "</td>";

                    tbodyObj = tbodyObj + "<td>" +
                        "<a href='questionDetail.html?id=" + question.qid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看</a>" +
                        "<button onclick='isdeleteQuestionFromExamPaper(" + question.qid + "," + question.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                        // "<button href='doexam.html?id=" + question.qid + "' type=\"button\" class=\"btn btn-default btn-xs\">开始做题</button>" +
                        "</td>";

                    tbodyObj = tbodyObj + "</tr>";
                })
                $("#myPaperQuestion").html(tbodyObj);
            } else {
                $("#myPaperQuestion").html("<tr><th scope='row'>1</th><td>你还没有题目哦~</td></tr>");
            }

        }, error: function () {
            toastr["error"]("班级创建失败！", "出错啦~");
        }
    })
}

function myclassDetail(cid) {
    $.ajax({
        type: "get",
        url: "loadclassDetail",
        async: true,
        dataType: "json",
        data: {
            "id": cid
        },
        success: function (data) {
            if (data.result === true) {
                $("#className").text(data.clazzes[0].classname);
                $("#classID").text("班级ID: " + data.clazzes[0].cid);
                var tbodyObj = "";
                $.each(data.clazzes, function (index, user) {
                    tbodyObj = tbodyObj + "<tr id='usertr" + user.uid + "'>" +
                        "<th scope=\"row\">" + (index + 1) + "</th>" +
                        "<td>" + user.username + "</td>" +
                        "<td>" + user.identity + "</td>" +
                        "<td>" + user.email + "</td>";
                    tbodyObj = tbodyObj + "<td>" +
                        "<button";
                    if (JSON.parse(getCookie("USER")).identity == 1 || user.identity == "老师") {
                        tbodyObj = tbodyObj + " disabled ";
                    }
                    tbodyObj = tbodyObj + " onclick='isremoveStudent(" + user.uid + "," + user.cid + ")' type=\"button\" class=\"btn btn-default btn-xs\">移除班级</button>" +
                        "</td>";
                    tbodyObj = tbodyObj + "</tr>";
                })
                if (tbodyObj != "") {
                    $("#myClass").html(tbodyObj);
                } else {
                    $("#myClass").html("<tr><th scope='row'>1</th><td>班级里还没有学生哦~</td></tr>");
                }
            } else {
                $("#myClass").html("<tr><th scope='row'>1</th><td>班级里还没有学生哦~</td></tr>");
            }
        },
        error: function (data) {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    })
}

function myClassExampaper(cid) {
    $.ajax({
        type: "get",
        url: "loadClassExampaper",
        async: true,
        dataType: "json",
        data: {
            "id": cid
        },
        success: function (data) {
            if (data.result === true) {
                var tbodyObj = "";
                $.each(data.clazzes, function (index, exam) {
                    tbodyObj = tbodyObj + "<tr id='eptr" + exam.eid + "'><th scope=\"row\">" + (index + 1) + "</th>" +
                        "<td id='eptd" + exam.eid + "'>" + exam.exampapername + "</td>" +
                        "<td>" + exam.questionnumber + "</td>" +
                        "<td>" + exam.creattime + "</td>" +
                        "<td>" + exam.creatperson + "</td>";
                    var iden = JSON.parse(getCookie("USER")).identity;
                    if (iden === 1) {
                        tbodyObj = tbodyObj + "<td>" +
                            "<a " + ((exam.questionnumber === 0) ? 'disabled style="pointer-events: none"' : '') + " href='doexam.html?id=" + exam.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">开始考试</a>" +
                            "</td>";
                    } else if (iden === 2) {
                        tbodyObj = tbodyObj + "<td>" +
                            "<button onclick='updExamOrPaper(" + exam.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">修改</button>" +
                            "<button onclick='isdeleteExamFromClass(" + exam.eid + "," + exam.cid + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                            "<a href='paperDetail.html?id=" + exam.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看题目</a>" +
                            "</td>";
                    }
                    tbodyObj = tbodyObj + "</tr>";
                })
                $("#myExampaper").html(tbodyObj);
            } else {
                $("#myExampaper").html("<tr><th scope='row'>1</th><td>班级里还没有考试哦~</td></tr>");
            }
        },
        error: function (data) {
            toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
        }
    })
}

function getQuestionById(id) {
    $.ajax({
        type: "post",
        url: "getQuestionById",
        async: true,
        dataType: "json",
        data: {
            "id": id
        },
        success: function (data) {
            if (data.result === true) {
                if (JSON.parse(getCookie("USER")).id === data.question.uid) {
                    var opval = 1;
                    if (data.question.typename == "简答题") {
                        opval = 4;
                    } else if (data.question.typename == "填空题") {
                        opval = 3;
                    } else if (data.question.typename == "多选题") {
                        opval = 2;
                    } else if (data.question.typename == "单选题") {
                        opval = 1;
                    }
                    $("#questiontype").val(opval);
                    hidechose();
                    $("#questionName").val(data.question.question);
                    $("#ansA").val(data.question.a);
                    $("#ansB").val(data.question.b);
                    $("#ansC").val(data.question.c);
                    $("#ansD").val(data.question.d);
                    $("#ans").val(data.question.ans);
                } else {
                    toastr["error"]("这个题目不是你的哟！", "非法访问~");
                }
            } else {
                toastr["error"]("这个题目并不存在！", "出错啦~");
            }
        }, error: function () {
            toastr["error"]("这个题目并不存在！", "出错啦~");
        }
    });
}

function updQuestion() {
    var flag = true;
    if ($("#questionName").val() === "") {
        flag = false;
        toastr["warning"]("题目名称不能为空！", "出错啦~");
    } else if ($("#ans").val() === "") {
        flag = false;
        toastr["warning"]("答案不能为空！", "出错啦~");
    } else if ($("#questiontype").val() == 1 || $("#questiontype").val() == 2) {
        if ($("#ansA").val() === "") {
            flag = false;
            toastr["warning"]("答案A不能为空！", "出错啦~");
        } else if ($("#ansB").val() === "") {
            flag = false;
            toastr["warning"]("答案B不能为空！", "出错啦~");
        } else if ($("#ansC").val() === "") {
            flag = false;
            toastr["warning"]("答案C不能为空！", "出错啦~");
        } else if ($("#ansD").val() === "") {
            flag = false;
            toastr["warning"]("答案D不能为空！", "出错啦~");
        }
    }
    if (flag) {
        $.ajax({
            type: "post",
            url: "updQuestion",
            async: true,
            dataType: "json",
            data: {
                "id": getUrlParams("id"),
                "qName": $("#questionName").val(),
                "qAnsa": $("#ansA").val(),
                "qAnsb": $("#ansB").val(),
                "qAnsc": $("#ansC").val(),
                "qAnsd": $("#ansD").val(),
                "qAns": $("#ans").val(),
                "qType": $("#questiontype").val()
            },
            success: function (data) {
                if (data.result === true) {
                    toastr["success"]("题目修改成功！", "成功啦~");
                    isDisabledQuestion();
                } else {
                    toastr["error"]("题目修改失败！", "出错啦~");
                }
            }, error: function () {
                toastr["error"]("题目修改失败！", "出错啦~");
            }
        });
    }
}

function updExamOrPaper(eid) {
    if ($("#eptd" + eid).text() != "提交") {
        $("#eptd" + eid).html("<input id='tdinput" + eid + "' type='text' value='' placeholder='" + $("#eptd" + eid).text() + "'><button onclick='updExamOrPaper2(" + eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">提交</button>");
    } else {
        $("#eptd" + eid).html($("#tdinput" + eid).prop("placeholder"));
    }
}

function updExamOrPaper2(eid) {
    if ($("#tdinput" + eid).val() === "") {
        toastr["warning"]("名称不能为空！", "警告啦~");
    } else {
        $.ajax({
            type: "get",
            url: "updExamOrPaper",
            async: true,
            dataType: "json",
            data: {
                "id": eid,
                "name": $("#tdinput" + eid).val()
            },
            success: function (data) {
                if (data.result === true) {
                    toastr["success"]("试卷修改成功！", "成功啦~");
                    $("#eptd" + eid).html($("#tdinput" + eid).val());
                } else {
                    toastr["error"]("试卷修改失败！", "出错啦~");
                }
            }, error: function () {
                toastr["error"]("试卷修改失败！", "出错啦~");
            }
        })
    }
}

function updClazz(cid) {
    if ($("#classtdn" + cid).text() != "") {
        $("#classtdn" + cid).html("<input id='tdinputn" + cid + "' type='text' value='' placeholder='" + $("#classtdn" + cid).text() + "'>");
    } else {
        $("#classtdn" + cid).html($("#tdinputn" + cid).prop("placeholder"));
    }
    if ($("#classtdd" + cid).text() != "提交") {
        $("#classtdd" + cid).html("<input id='tdinputd" + cid + "' type='text' value='' placeholder='" + $("#classtdd" + cid).text() + "'><button onclick='updClazz2(" + cid + ")' type=\"button\" class=\"btn btn-default btn-xs\">提交</button>");
    } else {
        $("#classtdd" + cid).html($("#tdinputd" + cid).prop("placeholder"));
    }
}

function updClazz2(cid) {
    if ($("#tdinputn" + cid).val() === "") {
        toastr["warning"]("班级名称不能为空！", "警告啦~");
    } else if ($("#tdinputd" + cid).val() === "") {
        toastr["warning"]("班级详情不能为空！", "警告啦~");
    } else {
        $.ajax({
            type: "get",
            url: "updClass",
            async: true,
            dataType: "json",
            data: {
                "id": cid,
                "cName": $("#tdinputn" + cid).val(),
                "cDetails": $("#tdinputd" + cid).val()
            },
            success: function (data) {
                if (data.result === true) {
                    toastr["success"]("班级修改成功！", "成功啦~");
                    $("#classtdn" + cid).html($("#tdinputn" + cid).val());
                    $("#classtdd" + cid).html($("#tdinputd" + cid).val());
                } else {
                    toastr["error"]("班级修改失败！", "出错啦~");
                }
            }, error: function () {
                toastr["error"]("班级修改失败！", "出错啦~");
            }
        })
    }
}

function isJoinClass() {
    if ($("#joinClass").text() != "提交加入班级") {
        $("#joinClass").html("<input id='classinput' placeholder='请输入班级ID' type='text' value=''><button  type=\"button\" onclick='joinClass()' class=\"btn btn-default btn-xs\">提交</button><button onclick='isJoinClass()' type=\"button\" class=\"btn btn-default btn-xs\">加入班级</button>");
    } else {
        $("#joinClass").html("<button onclick='isJoinClass()' type=\"button\" class=\"btn btn-default btn-xs\">加入班级</button>");
    }
}

function joinClass() {
    if ($("#classinput").val() === "") {
        toastr["warning"]("班级ID不能为空！", "警告啦~");
    } else {
        $.ajax({
            type: "get",
            url: "joinClass",
            async: true,
            dataType: "json",
            data: {
                "uId": JSON.parse(getCookie("USER")).id,
                "cId": $("#classinput").val()
            },
            success: function (data) {
                if (data.result === true) {
                    toastr["success"]("加入班级成功！", "成功啦~");
                    $("#joinClass").html("<a id=\"joinOrCreatClass\" type=\"button\" class=\"btn btn-default btn-xs\">加入班级</a>");
                } else {
                    toastr["error"]("加入班级失败！", "出错啦~");
                }
            }, error: function () {
                toastr["error"]("加入班级失败！", "出错啦~");
            }
        })
    }
}

function isCreatPaper() {
    if ($("#divCreatPaper").text() != "提交创建试卷") {
        $("#divCreatPaper").html("<input id='paperinput' placeholder='请输入试卷名称' type='text' value=''><button  type=\"button\" onclick='creatPaper()' class=\"btn btn-default btn-xs\">提交</button><button onclick=\"isCreatPaper()\" type=\"button\" class=\"btn btn-default btn-xs\">创建试卷</button>");
    } else {
        $("#divCreatPaper").html("<button onclick=\"isCreatPaper()\" type=\"button\" class=\"btn btn-default btn-xs\">创建试卷 </button>");
    }
}

function creatPaper() {
    if ($("#paperinput").val() === "") {
        toastr["warning"]("试卷名称不能为空！", "警告啦~");
    } else {
        $.ajax({
            type: "get",
            url: "addPaper",
            async: true,
            dataType: "json",
            data: {
                "name": $("#paperinput").val(),
                "creatperson": JSON.parse(getCookie("USER")).id
            },
            success: function (data) {
                if (data.result === true) {
                    toastr["success"]("试卷创建成功！", "成功啦~");
                    $("#divCreatPaper").html("<button onclick=\"creatPaper()\" type=\"button\" class=\"btn btn-default btn-xs\">创建试卷</button>");
                } else {
                    toastr["error"]("试卷创建失败！", "出错啦~");
                }
            }, error: function () {
                toastr["error"]("试卷创建失败！", "出错啦~");
            }
        })
    }
}

function pageList(pagenum) {
    var begin = (pagenum - 1) * 10;
    var user = getCookie("USER");
    var allcount = 0;
    if (urlHtml() == "paper" || urlHtml() == "classDetail") {
        allcount = sessionStorage.getItem("countPaper");
    } else if (urlHtml() == "exam") {
        allcount = sessionStorage.getItem("countExam");
    } else if (urlHtml() == "class") {
        allcount = sessionStorage.getItem("countClass");
    } else if (urlHtml() == "question" || urlHtml() == "paperDetail") {
        allcount = sessionStorage.getItem("countQuestion");
    }
    if (user !== null) {
        user = JSON.parse(user);
        if (user.identity === 1) {
            if (urlHtml() == "paper" || urlHtml() == "classDetail") {
                myPaper(begin, 10, 1);
            } else if (urlHtml() == "exam") {
                myExam(begin, 10, 1);
            } else if (urlHtml() == "class") {
                myClass(begin, 10, 1);
            } else if (urlHtml() == "question" || urlHtml() == "paperDetail") {
                myQuestion(begin, 10, 1);
            }
        } else if (user.identity === 2) {
            if (urlHtml() == "paper" || urlHtml() == "classDetail") {
                myPaper(begin, 10, 2);
            } else if (urlHtml() == "exam") {
                myExam(begin, 10, 2);
            } else if (urlHtml() == "class") {
                myClass(begin, 10, 2);
            } else if (urlHtml() == "question" || urlHtml() == "paperDetail") {
                myQuestion(begin, 10, 2);
            }
        }
        var pagechose = creatpagechose(allcount, pagenum);
        $("#tableparent").html(pagechose)
    } else {
        window.location.href = "login.html";
    }
}

function showQuestionList() {
    if ($("#questionList").css("display") !== 'none') {
        $("#questionList").hide();
    } else {
        $("#questionList").show();
        pageList(1);
    }
}

function showPaperList() {
    if ($("#paperList").css("display") === 'none') {
        $("#paperList").show();
        pageList(1);
    } else {
        $("#paperList").hide();
    }
}

function addQuestionToExampaper() {
    var arr = [];
    $("[name='checkbox']:checked").each(function () {
        arr.push($(this).val());
    })
    if (arr.length !== 0) {
        $.ajax({
            type: "post",
            url: "addQuestionToExampaper",
            async: true,
            contentType: "application/json",
            // dataType: "application/json",
            data: JSON.stringify({
                "id": getUrlParams("id"),
                "arr": arr
            }),
            success: function (data) {
                if (data.result === true) {
                    toastr["success"]("题目添加成功！", "成功啦~");
                    myPaperQuestion(getUrlParams("id"));
                } else {
                    toastr["error"]("题目添加失败！", "出错啦~");
                }
            }, error: function () {
                toastr["error"]("题目添加失败！", "出错啦~");
            }
        })
    }

}

function addExamToClass() {
    var arr = [];
    $("[name='checkbox']:checked").each(function () {
        arr.push($(this).val());
    })
    if (arr.length !== 0) {
        $.ajax({
            type: "post",
            url: "addExamToClass",
            async: true,
            contentType: "application/json",
            // dataType: "application/json",
            data: JSON.stringify({
                "id": getUrlParams("id"),
                "arr": arr
            }),
            success: function (data) {
                if (data.result === true) {
                    toastr["success"]("考试添加成功！", "成功啦~");
                    myClassExampaper(getUrlParams("id"));
                } else {
                    toastr["error"]("考试已经存在！", "出错啦~");
                }
            }, error: function () {
                toastr["error"]("考试添加失败！", "出错啦~");
            }
        })
    }

}

function selectAll() {
    if ($("[name='checkbox']:checked").length < $("[name='checkbox']").length) {
        $("[name='checkbox']").each(function () {
            $(this).prop('checked', true);
        })
    } else {
        $("[name='checkbox']").each(function () {
            $(this).prop('checked', false);
        })
    }

}

function isDisabledQuestion() {
    if ($("input:disabled").length === 0) {
        $("input").prop("disabled", true);
        $("select").prop("disabled", true);
        $("input[type='reset']").hide();
        $("input[value='提交']").hide();
    } else {
        $("input").prop("disabled", false);
        $("select").prop("disabled", false);
        $("input[type='reset']").show();
        $("input[value='提交']").show();
    }

}

function loaddoexamlist(eid) {
    $.ajax({
        type: "get",
        url: "loadPaperQuestion",
        async: true,
        dataType: "json",
        data: {
            "id": eid
        },
        success: function (data) {
            if (data.result === true) {
                $("#paperName").text(data.questions[0].exampapername);
                var arr = [];
                var tbodyObj = "";
                var choseObj = "";
                $.each(data.questions, function (index, question) {
                    arr.push(question.qid);
                    choseObj = choseObj + "<button  onclick='choseques(" + (index + 1) + ")' class=\"butline btn btn-default btn-xs\">" + (index + 1) + "</button>";
                    tbodyObj = tbodyObj + "<tbody class='questr' id='questr" + (index + 1) + "'><tr>" +
                        "<th style='width: 100%;'>" + (index + 1) + "." + JSON.stringify(question.question) + "</th></tr>";
                    if (question.typename === "单选题") {
                        tbodyObj = tbodyObj +
                            "<tr><td><input type='radio' name='" + question.qid + "' value='A'> A. " + question.a + "</td></tr>" +
                            "<tr><td><input type='radio' name='" + question.qid + "' value='B'> B. " + question.b + "</td></tr>" +
                            "<tr><td><input type='radio' name='" + question.qid + "' value='C'> C. " + question.c + "</td></tr>" +
                            "<tr><td><input type='radio' name='" + question.qid + "' value='D'> D. " + question.d + "</td></tr>";
                    } else if (question.typename === "多选题") {
                        tbodyObj = tbodyObj +
                            "<tr><td><input type='checkbox' name='" + question.qid + "' value='A'> A. " + question.a + "</td></tr>" +
                            "<tr><td><input type='checkbox' name='" + question.qid + "' value='B'> B. " + question.b + "</td></tr>" +
                            "<tr><td><input type='checkbox' name='" + question.qid + "' value='C'> C. " + question.c + "</td></tr>" +
                            "<tr><td><input type='checkbox' name='" + question.qid + "' value='D'> D. " + question.d + "</td></tr>";
                    } else if (question.typename === "填空题" || question.typename === "简答题") {
                        tbodyObj = tbodyObj + "<tr><td colspan='2'><textarea style='width: 100%' name='" + question.qid + "' placeholder='请输入答案'></textarea></tr>";
                    }
                    tbodyObj = tbodyObj +
                        "<tr><td style='width: 5%'><button " + ((index === 0) ? 'disabled' : '') + " onclick='choseques(" + index + ")' class='btn btn-default btn-xs'>上一题</button> &nbsp;&nbsp;&nbsp;" +
                        "<button " + ((index + 1 === data.questions.length) ? 'disabled' : '') + " onclick='choseques(" + (index + 2) + ")' class='btn btn-default btn-xs'>下一题</button></td>" +
                        "</tr></tbody >";
                })
                $("#myPaperQuestion").html(tbodyObj);
                $("#choselist").html(choseObj);
                $("#commitExam").html("<button onclick=\"commitExam(" + (arr) + ")\" class=\"btn btn-default btn-xs\" >提交答案</button>")
            } else {
                $("#myPaperQuestion").html("<tr><th scope='row'>1</th><td>你还没有题目哦~</td></tr>");
            }
            $(".questr").hide();
            $("#questr1").show();
            $(".butline").css({"width": "30px", "line-height": "28px", "margin-right": "10px", "margin-bottom": "10px"})
            $("tr").on("click", function () {
                if ($(this).children("td").children("input").prop("checked") === true) {
                    $(this).children("td").children("input").prop("checked", false);
                } else {
                    $(this).children("td").children("input").prop("checked", true);
                }
            })
        }, error: function () {
            toastr["error"]("服务器炸了，请稍后再试！", "出错啦~");
        }
    })
}

function choseques(id) {
    $(".questr").hide();
    $("#questr" + id).show();
}

function commitExam(...arr) {
    if (arr.length === 0) {
        toastr["info"]("没有题目可以提交哦！", "出错啦~");
    } else {
        var anss = [];
        arr.forEach(function (value) {
            if ($("input[name='" + value + "']:checked").length <= 1) {
                if ($("input[name='" + value + "']:checked").val() != null) {
                    anss.push($("input[name='" + value + "']:checked").val())
                } else {
                    anss.push($("textarea[name='" + value + "']").val())
                }
            } else {
                var ans = '';
                $("input[name='" + value + "']:checked").each(function () {
                    ans = ans + $(this).val();
                })
                anss.push(ans);
            }
        })
        var flag = true;
        anss.forEach(function (value, index) {
            if (flag && (value == null || value === '')) {
                toastr["info"]("还有题目没做完呢！", "不行哦~");
                choseques(index + 1)
                flag = false;
            }
        })
        if (flag && confirm("确定提交吗")) {
            var uid = JSON.parse(getCookie("USER")).id;
            var isFlag = true;
            anss.forEach(function (value, index) {
                $.ajax({
                    type: "post",
                    url: "doExamCommit",
                    async: true,
                    dataType: "json",
                    data: {
                        "eId": getUrlParams("id"),
                        "uId": uid,
                        "qId": arr[index],
                        "choose": value
                    },
                    success: function (data) {
                        isFlag = data.result;
                    }, error: function () {
                        isFlag = false;
                    }
                })
            })
            if (isFlag) {
                toastr["success"]("提交成功啦！", "成功啦~");
            } else {
                toastr["error"]("服务器炸了啦，请稍后再试！", "出错啦~");
            }
        }
    }
}

function getExamHistroy() {
    var user = JSON.parse(getCookie("USER"));
    $.ajax({
        type: "post",
        url: "getDoExamHistory",
        async: true,
        // contentType: "application/json",
        dataType: "json",
        data: {
            "id": user.id,
            "username": user.username
        },
        success: function (data) {
            if (data.result === true) {
                var tbodyObj = "";
                $.each(data.examhistorys, function (index, paper) {
                    tbodyObj = tbodyObj + "<tr id='eptr" + paper.eid + "'><th scope=\"row\">" + (index + 1) + "</th>" +
                        "<td id='eptd" + paper.eid + "'>" + paper.exampapername + "</td>" +
                        "<td>" + paper.questionNumber + "</td>" +
                        "<td>" + paper.time + "</td>" +
                        "<td><a href='examhistory.html?id=" + paper.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看详情</a>" +
                        "</td></tr>";
                })
                $("#dopaper").html(tbodyObj);
            } else {
                $("#dopaper").html("<tr><th scope='row'>1</th><td colspan='4'>你还没有做过试卷哦~</td></tr>");
            }
        }, error: function () {
            toastr["error"]("服务器炸了！请稍后再试哦~", "出错啦~");
        }
    })
}

function getPaperHistroy() {
    var user = JSON.parse(getCookie("USER"));
    $.ajax({
        type: "post",
        url: "getDoPaperHistory",
        async: true,
        // contentType: "application/json",
        dataType: "json",
        data: {
            "id": user.id,
            "username": user.username
        },
        success: function (data) {
            if (data.result === true) {
                var tbodyObj = "";
                $.each(data.paperhistorys, function (index, paper) {
                    tbodyObj = tbodyObj + "<tr id='eptr" + paper.eid + "'><th scope=\"row\">" + (index + 1) + "</th>" +
                        "<td id='eptd" + paper.eid + "'>" + paper.exampapername + "</td>" +
                        "<td>" + paper.questionNumber + "</td>" +
                        "<td>" + paper.time + "</td>" +
                        "<td><a href='examhistory.html?id=" + paper.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看详情</a>" +
                        "</td></tr>";
                })
                $("#dopaper").html(tbodyObj);
            } else {
                $("#dopaper").html("<tr><th scope='row'>1</th><td colspan='4'>你还没有做过试卷哦~</td></tr>");
            }
        }, error: function () {
            toastr["error"]("服务器炸了！请稍后再试哦~", "出错啦~");
        }
    })
}

function loadExamHistoryList(eid) {
    $.ajax({
        type: "get",
        url: "loadExamHistoryList",
        async: true,
        dataType: "json",
        data: {
            "eid": eid,
            "uid": JSON.parse(getCookie("USER")).id
        },
        success: function (data) {
            if (data.result === true) {
                $("#examname").html(data.exampaperhistorys[0].exampapername);
                var tbodyObj = "";
                $.each(data.exampaperhistorys, function (index, question) {
                    tbodyObj = tbodyObj + "<tbody class='questr' id='questr" + (index + 1) + "'><tr>" +
                        "<th>" + (index + 1) + "." + JSON.stringify(question.question) + "</th></tr>";
                    if (question.typename === "单选题") {
                        tbodyObj = tbodyObj +
                            "<tr><td colspan='2'>A. " + question.a + "</td></tr>" +
                            "<tr><td colspan='2'>B. " + question.b + "</td></tr>" +
                            "<tr><td colspan='2'>C. " + question.c + "</td></tr>" +
                            "<tr><td colspan='2'>D. " + question.d + "</td></tr>" +
                            "<tr><th>所选答案： " + question.choose + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正确答案： " + question.ans + "</th></tr>";
                    } else if (question.typename === "多选题") {
                        tbodyObj = tbodyObj +
                            "<tr><td>A. " + question.a + "</td></tr>" +
                            "<tr><td>B. " + question.b + "</td></tr>" +
                            "<tr><td>C. " + question.c + "</td></tr>" +
                            "<tr><td>D. " + question.d + "</td></tr>" +
                            "<tr><th >所选答案： " + question.choose + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正确答案： " + question.ans + "</th></tr>";
                    } else if (question.typename === "填空题" || question.typename === "简答题") {
                        tbodyObj = tbodyObj +
                            "<tr><td colspan='2'><textarea disabled style='width: 100%' placeholder='" + question.choose + "' name='" + question.qid + "'></textarea></tr>" +
                            "<tr><td style='width: 100%'>正确答案：" + question.ans + "</td></tr>";
                    }
                })
                $("#myPaperQuestion").html(tbodyObj);
            } else {
                $("#myPaperQuestion").html("<tr><th scope='row'>1</th><td>你还没有题目哦~</td></tr>");
            }
            $("tr").on("click", function () {
                if ($(this).children("td").children("input").prop("checked") === true) {
                    $(this).children("td").children("input").prop("checked", false);
                } else {
                    $(this).children("td").children("input").prop("checked", true);
                }
            })
        }, error: function () {
            toastr["error"]("服务器炸了，请稍后再试！", "出错啦~");
        }
    })
}

function updpassword() {
    var user = JSON.parse(getCookie("USER"));
    if ($("#exampleInputPassword").val() === '') {
        toastr["info"]("请输入新密码！", "出错啦~");
    } else if ($("#exampleInputNewPassword").val() === '') {
        toastr["info"]("请再次输入新密码！", "出错啦~");
    } else if ($("#exampleInputNewPassword").val() !== $("#exampleInputPassword").val()) {
        toastr["info"]("两次密码不同！", "出错啦~");
    } else {
        $.ajax({
            type: "post",
            url: "updUser",
            async: true,
            // contentType: "application/json",
            dataType: "json",
            data: {
                "id": user.id,
                "password": $("#exampleInputNewPassword").val()
            },
            success: function (data) {
                if (data.result === true) {
                    toastr["success"]("密码修改成功！3秒后返回主页~", "成功啦~");
                    setInterval(go, 3000);

                    function go() {
                        window.location.href = "index.html";
                    }
                }
            }, error: function () {
                toastr["error"]("服务器炸了！请稍后再试哦~", "出错啦~");
            }
        })
    }
}


function searchList(flag) {
    var search = decodeURI(getUrlParams("search"));
    if (getUrlParams("search") !== '') {
        $.ajax({
            type: "get",
            url: "searchPaper",
            async: true,
            dataType: "json",
            data: {
                "name": "%" + search + "%",
                "creatPerson": JSON.parse(getCookie("USER")).username
            },
            success: function (data) {
                if (data.result === true) {
                    var tbodyObj = "";
                    $.each(data.papers, function (index, paper) {
                        tbodyObj = tbodyObj + "<tr id='eptr" + paper.eid + "'><th scope=\"row\">" + (index + 1) + "</th>" +
                            "<td id='eptd" + paper.eid + "'>" + paper.exampapername + "</td>" +
                            "<td>" + paper.questionnumber + "</td>" +
                            "<td>" + paper.creattime + "</td>" +
                            "<td>" + paper.creatperson + "</td>";
                        if (flag === 1) {
                            tbodyObj = tbodyObj + "<td>" +
                                "<button onclick='updExamOrPaper(" + paper.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">修改</button>" +
                                "<button onclick='isdeletePaperOrExam(" + paper.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                                "<a href='paperDetail.html?id=" + paper.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看題目</a>" +
                                "<a " + ((paper.questionnumber === 0) ? 'disabled style="pointer-events: none"' : '') + " href='doexam.html?id=" + paper.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">开始做题</a>" +
                                "</td>";
                        } else if (flag === 2) {
                            tbodyObj = tbodyObj + "<td>" +
                                "<button onclick='updExamOrPaper(" + paper.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">修改</button>" +
                                "<button onclick='isdeletePaperOrExam(" + paper.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                                "<a href='paperDetail.html?id=" + paper.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看題目</a>" +
                                "</td>";
                        }
                        tbodyObj = tbodyObj + "</tr>";
                    })
                    $("#mypaper").html(tbodyObj);
                } else {
                    $("#notsearchpaper").html("未搜到包含 “" + search + "” 的试卷哦~");
                }
            },
            error: function () {
                toastr["info"]("服务器挂啦，请稍等再试！", "出错啦~");
            }
        })
        $.ajax({
            type: "get",
            url: "searchClass",
            async: true,
            dataType: "json",
            data: {
                "id": JSON.parse(getCookie("USER")).id,
                "username": "%" + search + "%"
            },
            success: function (data) {
                if (data.result === true) {
                    var tbodyObj = "";
                    $.each(data.clazzes, function (index, clazz) {
                        tbodyObj = tbodyObj + "<tr id='classtr" + clazz.cid + "'><th scope=\"row\">" + (index + 1) + "</th>" +
                            "<td id='classtdn" + clazz.cid + "'>" + clazz.classname + "</td>" +
                            "<td id='classtdd" + clazz.cid + "'>" + clazz.classdetails + "</td>" +
                            "<td>" + clazz.classnumber + "</td>" +
                            "<td>" + clazz.creattime + "</td>" +
                            "<td>" + clazz.creatperson + "</td>";
                        if (flag === 1) {
                            tbodyObj = tbodyObj + "<td>" +
                                "<a href='classDetail.html?id=" + clazz.cid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看班级</a>" +
                                "</td>";
                        } else if (flag === 2) {
                            tbodyObj = tbodyObj + "<td>" +
                                "<button onclick='updClazz(" + clazz.cid + ")' type=\"button\" class=\"btn btn-default btn-xs\">修改</button>" +
                                "<button onclick='isdeleteClass(" + clazz.cid + "," + clazz.uid + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                                "<a href='classDetail.html?id=" + clazz.cid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看班级</a>" +
                                "</td>";
                        }
                        tbodyObj = tbodyObj + "</tr>";
                    })
                    $("#myclass").html(tbodyObj);
                } else {
                    $("#notsearchclass").html("未搜到包含 “" + search + "” 班级哦~");
                }
            }
        })
        $.ajax({
            type: "get",
            url: "searchExam",
            async: true,
            dataType: "json",
            data: {
                "id": JSON.parse(getCookie("USER")).id,
                "username": "%" + search + "%"
            },
            success: function (data) {
                if (data.result === true) {
                    var tbodyObj = "";
                    $.each(data.exams, function (index, exam) {
                        tbodyObj = tbodyObj + "<tr id='eptr" + exam.eid + "'><th scope=\"row\">" + (index + 1) + "</th>" +
                            "<td id='eptd" + exam.eid + "'>" + exam.exampapername + "</td>" +
                            "<td>" + exam.questionnumber + "</td>" +
                            "<td>" + exam.creattime + "</td>" +
                            "<td>" + exam.classname + "</td>";
                        if (flag === 1) {
                            tbodyObj = tbodyObj + "<td>" +
                                "<a " + ((exam.questionnumber === 0) ? 'disabled style="pointer-events: none"' : '') + " href='doexam.html?id=" + exam.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">开始考试</a>" +
                                "</td>";
                        } else if (flag === 2) {
                            tbodyObj = tbodyObj + "<td>" +
                                "<button onclick='updExamOrPaper(" + exam.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">修改</button>" +
                                "<button onclick='isdeletePaperOrExam(" + exam.eid + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                                "<a href='paperDetail.html?id=" + exam.eid + "' type=\"button\" class=\"btn btn-default btn-xs\">查看题目</a>" +
                                "</td>";
                        }
                        tbodyObj = tbodyObj + "</tr>";
                    })
                    $("#myExam").html(tbodyObj);
                } else {
                    $("#notsearchexam").html("未搜到包含 “" + search + "” 考试哦~");
                }
            }
        })
        $.ajax({
            type: "get",
            url: "searchQuestion",
            async: true,
            dataType: "json",
            data: {
                "id": JSON.parse(getCookie("USER")).id,
                "username": "%" + search + "%"
            },
            success: function (data) {
                if (data.result === true) {
                    var tbodyObj = "";
                    $.each(data.questions, function (index, question) {
                        strnum = 90;
                        tbodyObj = tbodyObj + "<tr id='questr" + question.id + "' ><th scope=\"row\">" + (index + 1) + "</th>" +
                            "<td>" + JSON.stringify(question.question).substring(0, strnum) + "...</td>" +
                            "<td>" + question.typename + "</td>";
                        if (flag !== 0) {
                            tbodyObj = tbodyObj + "<td>" +
                                "<a href='questionDetail.html?id=" + question.id + "' type=\"button\" class=\"btn btn-default btn-xs\">查看</a>" +
                                "<button onclick='isdeleteQuestion(" + question.id + ")' type=\"button\" class=\"btn btn-default btn-xs\">删除</button>" +
                                // "<button href='doexam.html?id=" + question.id + "' type=\"button\" class=\"btn btn-default btn-xs\">开始做题</button>";
                                "</td>";
                            if (urlHtml() === "paperDetail") {
                                tbodyObj = tbodyObj + "<td><input type='checkbox' name='checkbox' value='" + question.id + "'></td>";
                            }
                        } else if (flag === 0) {
                            tbodyObj = tbodyObj + "<td>" + question.creatperson + "</td>";
                        }
                        tbodyObj = tbodyObj + "</tr>";
                    })
                    $("#myQuestion").html(tbodyObj);
                } else {
                    $("#notsearchques").html("未搜到包含 “" + search + "” 题目哦~");
                }
            }
        })
    }
}

function clickEffect() {
    let balls = [];
    let longPressed = false;
    let longPress;
    let multiplier = 0;
    let width, height;
    let origin;
    let normal;
    let ctx;
    const colours = ["#F73859", "#14FFEC", "#00E0FF", "#FF99FE", "#FAF15D"];
    const canvas = document.createElement("canvas");
    document.body.appendChild(canvas);
    canvas.setAttribute("style", "width: 100%; height: 100%; top: 0; left: 0; z-index: 99999; position: fixed; pointer-events: none;");
    const pointer = document.createElement("span");
    pointer.classList.add("pointer");
    document.body.appendChild(pointer);

    if (canvas.getContext && window.addEventListener) {
        ctx = canvas.getContext("2d");
        updateSize();
        window.addEventListener('resize', updateSize, false);
        loop();
        window.addEventListener("mousedown", function(e) {
            pushBalls(randBetween(10, 20), e.clientX, e.clientY);
            document.body.classList.add("is-pressed");
            longPress = setTimeout(function(){
                document.body.classList.add("is-longpress");
                longPressed = true;
            }, 500);
        }, false);
        window.addEventListener("mouseup", function(e) {
            clearInterval(longPress);
            if (longPressed === true) {
                document.body.classList.remove("is-longpress");
                pushBalls(randBetween(50 + Math.ceil(multiplier), 100 + Math.ceil(multiplier)), e.clientX, e.clientY);
                longPressed = false;
            }
            document.body.classList.remove("is-pressed");
        }, false);
        window.addEventListener("mousemove", function(e) {
            let x = e.clientX;
            let y = e.clientY;
            pointer.style.top = y + "px";
            pointer.style.left = x + "px";
        }, false);
    } else {
        console.log("canvas or addEventListener is unsupported!");
    }


    function updateSize() {
        canvas.width = window.innerWidth * 2;
        canvas.height = window.innerHeight * 2;
        canvas.style.width = window.innerWidth + 'px';
        canvas.style.height = window.innerHeight + 'px';
        ctx.scale(2, 2);
        width = (canvas.width = window.innerWidth);
        height = (canvas.height = window.innerHeight);
        origin = {
            x: width / 2,
            y: height / 2
        };
        normal = {
            x: width / 2,
            y: height / 2
        };
    }
    class Ball {
        constructor(x = origin.x, y = origin.y) {
            this.x = x;
            this.y = y;
            this.angle = Math.PI * 2 * Math.random();
            if (longPressed === true) {
                this.multiplier = randBetween(14 + multiplier, 15 + multiplier);
            } else {
                this.multiplier = randBetween(6, 12);
            }
            this.vx = (this.multiplier + Math.random() * 0.5) * Math.cos(this.angle);
            this.vy = (this.multiplier + Math.random() * 0.5) * Math.sin(this.angle);
            this.r = randBetween(8, 12) + 3 * Math.random();
            this.color = colours[Math.floor(Math.random() * colours.length)];
        }
        update() {
            this.x += this.vx - normal.x;
            this.y += this.vy - normal.y;
            normal.x = -2 / window.innerWidth * Math.sin(this.angle);
            normal.y = -2 / window.innerHeight * Math.cos(this.angle);
            this.r -= 0.3;
            this.vx *= 0.9;
            this.vy *= 0.9;
        }
    }

    function pushBalls(count = 1, x = origin.x, y = origin.y) {
        for (let i = 0; i < count; i++) {
            balls.push(new Ball(x, y));
        }
    }

    function randBetween(min, max) {
        return Math.floor(Math.random() * max) + min;
    }

    function loop() {
        ctx.fillStyle = "rgba(255, 255, 255, 0)";
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        for (let i = 0; i < balls.length; i++) {
            let b = balls[i];
            if (b.r < 0) continue;
            ctx.fillStyle = b.color;
            ctx.beginPath();
            ctx.arc(b.x, b.y, b.r, 0, Math.PI * 2, false);
            ctx.fill();
            b.update();
        }
        if (longPressed === true) {
            multiplier += 0.2;
        } else if (!longPressed && multiplier >= 0) {
            multiplier -= 0.4;
        }
        removeBall();
        requestAnimationFrame(loop);
    }

    function removeBall() {
        for (let i = 0; i < balls.length; i++) {
            let b = balls[i];
            if (b.x + b.r < 0 || b.x - b.r > width || b.y + b.r < 0 || b.y - b.r > height || b.r < 0) {
                balls.splice(i, 1);
            }
        }
    }
}


$(document).ready(function () {
    var user = JSON.parse(getCookie("USER"));
    if (user.username != null) {
        $("#loginname").css('display', 'none');
        $("#loginli").css('display', 'block');
        $("#uname").html(user.username);
        var mytime = new Date().getHours(); //获取当前时间
        var myname = user.identity === 1 ? "同学" : "老师";
        if (mytime < 8) {
            $("#timename").html("早上好，" + user.username + myname + "!");
        } else if (mytime < 12) {
            $("#timename").html("上午好，" + user.username + myname + "!");
        } else if (mytime < 18) {
            $("#timename").html("下午好，" + user.username + myname + "!");
        } else if (mytime < 24) {
            $("#timename").html("晚上好，" + user.username + myname + "!");
        }
    }
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "newestOnTop": true,
        "progressBar": true,
        "positionClass": "toast-top-center",
        "preventDuplicates": true,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "3000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }
    // toastr["warning"]("用户名不能为空", "警告")
    // success     info    warning    error

    // var urlname = urlHtml();
    // if (getCookie("USER") == null) {
    //     window.location.href = "login.html";
    // }

})

window.onload = function () {
    //点击特效
    clickEffect();
    // 窗口加载事件
    /*
    功能分析：
        1、滚动条滚动到指定位置显示或隐藏返回顶部按钮(事件源：window)
        2、点击返回顶部按钮实现滚动条回到顶部(事件源：box)
    */
    // 给window对象绑定滚动事件
    window.addEventListener('scroll', function () {
        // 获取滚动条距离顶部的位置
        let sTop = document.documentElement.scrollTop ||
            document.body.scrollTop
        // 判断按钮的显示和隐藏
        if (sTop >= 200) {
            box.style.display = 'block'
        } else {
            box.style.display = 'none'
        }
    })
    // 给按钮绑定点击事件
    box.addEventListener('click', function () {
        // 设置定时器动态回到顶部
        let timeId = setInterval(function () {
            // 动态获取滚动条距离顶部的距离
            let sTop = document.documentElement.scrollTop ||
                document.body.scrollTop
            // 进行值操作
            document.documentElement.scrollTop = sTop - 10
            document.body.scrollTop = sTop - 10
            // 判断滚动条是否回到顶部
            if (sTop <= 0) {
                clearInterval(timeId)
            }
        }, 10)
    })
}
