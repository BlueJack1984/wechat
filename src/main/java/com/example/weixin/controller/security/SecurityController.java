package com.example.weixin.controller.security;

import com.alibaba.fastjson.JSONObject;
import com.example.weixin.io.request.LoginInput;
import com.example.weixin.utils.HttpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/security")
@RequiredArgsConstructor
@Slf4j
public class SecurityController {

    @GetMapping("/page")
    public String getLoginPage() {
        return "/less/index.html";
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginInput loginInput) {

        String loginInfo = JSONObject.toJSONString(loginInput);

        String result = HttpUtil.post("https://www.baidu.com", loginInfo);


    }
}
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private IEmployeeService service = new EmployeeServiceImpl();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Employee currentUser = service.login(name, password);
        if(currentUser==null){
            //登录失败
            req.setAttribute("errorMsg","亲,账户或者密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }else{
            //登录成功
            req.getSession().setAttribute("USER_IN_SESSION",currentUser);
            resp.sendRedirect("/employee");
            return;
        }

        用户注销
                用户注销功能的主要作用是保护用户的账户安全,在用户点击安全退出的时候,我们需要将本次会话相关的session信息删除
        删除的方式有下面两种:
        1.删除当前登录的用户信息
        存在问题:本次会话的其他信息还是保存在内存中,没有及时清理
        @WebServlet("/logout")
        public class LogoutServlet extends HttpServlet {
            private IEmployeeService service = new EmployeeServiceImpl();
            protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.getSession().removeAttribute("USER_IN_SESSION");
                resp.sendRedirect("/login.jsp");
            }
        }

        2.销毁整个session(推荐)
        @WebServlet("/logout")
        public class LogoutServlet extends HttpServlet {
            private IEmployeeService service = new EmployeeServiceImpl();
            protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.getSession().invalidate();
                resp.sendRedirect("/login.jsp");
            }
        }