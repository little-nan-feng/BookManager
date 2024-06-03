<body class="hold-transition skin-green sidebar-mini">
<div class="wrapper">
    <header class="main-header">
        <a href="${pageContext.request.contextPath}/mian" class="logo">
            <span class="logo-lg"><b>学校图书管理系统</b></span>
        </a>
        <nav class="navbar navbar-static-top">
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user-menu">
                        <a>
                            <img src="${pageContext.request.contextPath}/img/user.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">${USER_SESSION.name}</span>
                        </a>
                    </li>

                    <li class="dropdown user user-menu">
                        <a href="${pageContext.request.contextPath}/logout">
                            <span class="hidden-xs">退出登录</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <aside class="main-sidebar">
        <section class="sidebar">
            <ul class="sidebar-menu">
                <li>
                    <a href="${pageContext.request.contextPath}/queryBook" target="iframe">
                        <i class="fa fa-circle-o"></i>图书查询
                    </a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/manageRecord" target="iframe">
                        <i class="fa fa-circle-o"></i>借阅记录
                    </a>
                </li>

                <li>
                    <c:if test="${USER_SESSION.identity=='管理员'}">
                    <a href="${pageContext.request.contextPath}/manageBook" target="iframe">
                        <i class="fa fa-circle-o"></i>图书管理
                    </a>
                    </c:if>

                    <c:if test="${USER_SESSION.identity=='学生'||USER_SESSION.identity=='教师'}">
                        <a href="javascript:void(0)" target="iframe">
                            <i class="fa fa-circle-o"></i>图书管理
                        </a>
                    </c:if>
                </li>
            </ul>
        </section>
    </aside>

    <div class="content-wrapper">
        <iframe width="100%" id="iframe" name="iframe" onload="SetIFrameHeight()"></iframe>
    </div>
</div>
</body>