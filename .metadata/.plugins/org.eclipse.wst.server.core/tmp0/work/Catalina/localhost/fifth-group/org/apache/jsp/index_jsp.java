/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.73
 * Generated at: 2017-07-14 07:19:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/Head.jsp", Long.valueOf(1499992423675L));
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>电商后台 -管理中心</title>\r\n");
      out.write("<meta name=\"Copyright\" content=\"Douco Design.\" />\r\n");
      out.write("<link href=\"css/public.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/global.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"dcWrap\"> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>电商后台 -管理中心</title>\r\n");
      out.write("<meta name=\"Copyright\" content=\"Douco Design.\" />\r\n");
      out.write("<link href=\"css/public.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/global.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" <div id=\"dcHead\">\r\n");
      out.write("\t<div id=\"head\">\r\n");
      out.write("  \t<div class=\"logo\"><a href=\"index.jsp\"><img src=\"images/dclogo.gif\" alt=\"logo\"></a></div>\r\n");
      out.write("  \t<div class=\"nav\">\r\n");
      out.write("   \t<ul>\r\n");
      out.write("    \t<li class=\"M\"><a href=\"JavaScript:void(0);\" class=\"topAdd\">新建</a>\r\n");
      out.write("     \t\t<div class=\"drop mTopad\"><a href=\"product.php?rec=add\">商品</a> <a href=\"article.php?rec=add\">文章</a> <a href=\"nav.php?rec=add\">自定义导航</a> <a href=\"show.jsp\">首页幻灯</a> <a href=\"page.php?rec=add\">单页面</a> <a href=\"manager.php?rec=add\">管理员</a> <a href=\"link.jsp\"></a> </div>\r\n");
      out.write("    \t</li>\r\n");
      out.write("    \t<li><a href=\"../index.php\" target=\"_blank\">查看站点</a></li>\r\n");
      out.write("    \t<li><a href=\"index.php?rec=clear_cache\">清除缓存</a></li>\r\n");
      out.write("    \t<li><a href=\"http://www.mycodes.net\" target=\"_blank\">帮助</a></li>\r\n");
      out.write("    \t<li class=\"noRight\"><a href=\"module.jsp\">DouPHP+</a></li>\r\n");
      out.write("   \t</ul>\r\n");
      out.write("    <ul class=\"navRight\">\r\n");
      out.write("    \t<li class=\"M noLeft\"><a href=\"JavaScript:void(0);\">您好，admin</a>\r\n");
      out.write("     \t\t<div class=\"drop mUser\">\r\n");
      out.write("      \t\t<a href=\"manager.php?rec=edit&id=1\">编辑我的个人资料</a>\r\n");
      out.write("      \t\t<a href=\"manager.php?rec=cloud_account\">设置云账户</a>\r\n");
      out.write("     \t\t</div>\r\n");
      out.write("    \t</li>\r\n");
      out.write("    \t<li class=\"noRight\"><a href=\"login.php?rec=logout\">退出</a></li>\r\n");
      out.write("   </ul>\r\n");
      out.write("   </div>\r\n");
      out.write("   </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- dcHead 结束 --> \r\n");
      out.write("\r\n");
      out.write("<div id=\"dcLeft\"><div id=\"menu\">\r\n");
      out.write("\t<ul class=\"top\">\r\n");
      out.write("  \t\t<li><a href=\"index.jsp\"><i class=\"home\"></i><em>管理首页</em></a></li>\r\n");
      out.write(" \t</ul>\r\n");
      out.write(" \t<ul>\r\n");
      out.write("  \t\t<li><a href=\"system.jsp\"><i class=\"system\"></i><em>系统设置</em></a></li>\r\n");
      out.write("  \t\t<li><a href=\"usercenter.jsp\"><i class=\"nav\"></i><em>用户中心</em></a></li>\r\n");
      out.write("  \t\t<li><a href=\"usercontrol.jsp\"><i class=\"show\"></i><em>用户管理</em></a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("    <ul>\r\n");
      out.write("\t\t<li><a href=\"ordercontrol.jsp\"><i class=\"productCat\"></i><em>订单管理</em></a></li>\r\n");
      out.write("\t  \t<li><a href=\"goodcontrol.jsp\"><i class=\"product\"></i><em>商品管理</em></a>\r\n");
      out.write("\t  \t\t<ul>\r\n");
      out.write("\t  \t\t\t<li><a href=\"usercenter.jsp\"><i class=\"nav\"></i><em>用户中心</em></a></li>\r\n");
      out.write("  \t\t\t\t<li><a href=\"usercontrol.jsp\"><i class=\"show\"></i><em>用户管理</em></a></li>\r\n");
      out.write("\t  \t\t</ul>\r\n");
      out.write("\t  \t</li>\r\n");
      out.write(" \t</ul>\r\n");
      out.write("  \t<ul>\r\n");
      out.write("  \t\t<li><a href=\"statistical!index.action\"><i class=\"articleCat\"></i><em>统计管理</em></a></li>\r\n");
      out.write("  \t\t<li><a href=\"noticecontrol.jsp\"><i class=\"article\"></i><em>公告管理</em></a></li>\r\n");
      out.write(" \t</ul>\r\n");
      out.write(" \t<ul class=\"bot\">\r\n");
      out.write("  \t\t<li><a href=\"shujubfnoticecontrol.jsp\"><i class=\"backup\"></i><em>数据备份</em></a></li>\r\n");
      out.write("  \t\t<li><a href=\"manager.jsp\"><i class=\"manager\"></i><em>网站管理员</em></a></li>\r\n");
      out.write(" \t</ul>\r\n");
      out.write("</div></div>\r\n");
      out.write("<!-- 左侧导航栏结束 -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<div id=\"dcMain\">\r\n");
      out.write("<div id=\"urHere\">电商后台 管理中心</div>  \r\n");
      out.write("<div id=\"index\" class=\"mainBox\" style=\"padding-top:18px;height:auto!important;height:550px;min-height:550px;\">\r\n");
      out.write("   <div id=\"douApi\"></div>\r\n");
      out.write("      <div class=\"indexBox\">\r\n");
      out.write("    <div class=\"boxTitle\">杰仔专卖网-简介</div>\r\n");
      out.write("    <ul class=\"ipage\">\r\n");
      out.write("     \t<li><a href=\"usercenter.jsp\">用户中心</a></li>\r\n");
      out.write("     \t<li><a href=\"usercontrol.jsp\">用户管理</a></li>\r\n");
      out.write("     \t<li><a href=\"ordercontrol.jsp\">订单管理</a></li>\r\n");
      out.write("     \t<li><a href=\"goodcontrol.jsp\">商品管理</a></li>\r\n");
      out.write("     \t<li><a href=\"statisticalcontrol.jsp\">统计管理</a></li>\r\n");
      out.write("     \t<li><a href=\"noticecontrol.jsp\">公告管理</a></li>\r\n");
      out.write("     \t<li><a href=\"shujubfnoticecontrol.jsp\">数据备份</a></li>\r\n");
      out.write("     \t<li><a href=\"manager.jsp\">网站管理员</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"indexBoxTwo\">\r\n");
      out.write("    <tr>\r\n");
      out.write("    \t<td width=\"65%\" valign=\"top\" class=\"pr\">\r\n");
      out.write("      \t<div class=\"indexBox\">\r\n");
      out.write("       \t<div class=\"boxTitle\">网站基本信息</div>\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"7\" class=\"tableBasic\">\r\n");
      out.write("        <tr>\r\n");
      out.write("        \t<td width=\"120\">单页面数：</td>\r\n");
      out.write("         \t<td><strong>6</strong></td>\r\n");
      out.write("          \t<td width=\"100\">文章总数：</td>\r\n");
      out.write("          \t<td><strong>10</strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("        \t<td>商品总数：</td>\r\n");
      out.write("        \t<td><strong>15</strong></td>\r\n");
      out.write("        \t<td>系统语言：</td>\r\n");
      out.write("        \t<td><strong>zh_cn</strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>URL 重写：</td>\r\n");
      out.write("          \t<td><strong>关闭<a href=\"system.php\" class=\"cueRed ml\">（点击开启）</a> \r\n");
      out.write("           \t</strong></td>\r\n");
      out.write("          \t<td>编码：</td>\r\n");
      out.write("          \t<td><strong>UTF-8</strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          \t<td>站点地图：</td>\r\n");
      out.write("          \t<td><strong>开启</strong></td>\r\n");
      out.write("          \t<td>站点模板：</td>\r\n");
      out.write("          \t<td><strong>default</strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          \t<td>DouPHP版本：</td>\r\n");
      out.write("          \t<td><strong>v1.3 Release 20160125</strong></td>\r\n");
      out.write("          \t<td>安装日期：</td>\r\n");
      out.write("          \t<td><strong>2016-02-25</strong></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    \t</table>\r\n");
      out.write("        </div>\r\n");
      out.write("        </td>\r\n");
      out.write("        \r\n");
      out.write("     \t<td valign=\"top\" class=\"pl\">\r\n");
      out.write("      \t<div class=\"indexBox\">\r\n");
      out.write("        <div class=\"boxTitle\">管理员  登录记录</div>\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"7\" class=\"tableBasic\">\r\n");
      out.write("        \t<tr>\r\n");
      out.write("          \t\t<th width=\"45%\">IP地址</th>\r\n");
      out.write("          \t\t<th width=\"55%\">操作时间</th>\r\n");
      out.write("         \t</tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("          \t\t<td align=\"center\">127.0.0.1</td>\r\n");
      out.write("          \t\t<td align=\"center\">2016-02-25 23:29:08</td>\r\n");
      out.write("         \t</tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("          \t\t<td align=\"center\">127.0.0.1</td>\r\n");
      out.write("          \t\t<td align=\"center\">2016-02-25 13:48:48</td>\r\n");
      out.write("         \t</tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("          \t\t<td align=\"center\">127.0.0.1</td>\r\n");
      out.write("          \t\t<td align=\"center\">2013-10-16 09:43:01</td>\r\n");
      out.write("         \t</tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("          \t\t<td align=\"center\">127.0.0.1</td>\r\n");
      out.write("          \t\t<td align=\"center\">2013-10-16 09:42:58</td>\r\n");
      out.write("         \t</tr>\r\n");
      out.write("       </table>\r\n");
      out.write("       </div>\r\n");
      out.write("       </td>\r\n");
      out.write("       </tr>\r\n");
      out.write("   </table>\r\n");
      out.write("   \r\n");
      out.write("   <div class=\"indexBox\">\r\n");
      out.write("   \t<div class=\"boxTitle\">服务器信息</div>\r\n");
      out.write("    \t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"7\" class=\"tableBasic\">\r\n");
      out.write("      \t\t<tr>\r\n");
      out.write("       \t\t\t<td width=\"120\" valign=\"top\">PHP 版本：</td>\r\n");
      out.write("       \t\t\t<td valign=\"top\">5.3.29 </td>\r\n");
      out.write("\t\t       <td width=\"100\" valign=\"top\">MySQL 版本：</td>\r\n");
      out.write("\t\t       <td valign=\"top\">5.5.40</td>\r\n");
      out.write("\t\t       <td width=\"100\" valign=\"top\">服务器操作系统：</td>\r\n");
      out.write("\t\t       <td valign=\"top\">WINNT(127.0.0.1)</td>\r\n");
      out.write("      \t\t</tr>\r\n");
      out.write("      \t\t<tr>\r\n");
      out.write("\t\t       <td valign=\"top\">文件上传限制：</td>\r\n");
      out.write("\t\t       <td valign=\"top\">2M</td>\r\n");
      out.write("\t\t       <td valign=\"top\">GD 库支持：</td>\r\n");
      out.write("\t\t       <td valign=\"top\">是</td>\r\n");
      out.write("\t\t       <td valign=\"top\">Web 服务器：</td>\r\n");
      out.write("\t\t       <td valign=\"top\">Apache/2.4.10 (Win32) OpenSSL/0.9.8zb mod_fcgid/2.3.9</td>\r\n");
      out.write("      \t\t</tr>\r\n");
      out.write("     \t</table>\r\n");
      out.write("   \t</div>\r\n");
      out.write("   \t\r\n");
      out.write("   <div class=\"indexBox\">\r\n");
      out.write("    <div class=\"boxTitle\">系统开发</div>\r\n");
      out.write("\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"7\" class=\"tableBasic\">\r\n");
      out.write("      \t\t<tr>\r\n");
      out.write("       \t\t\t<td width=\"120\"> DouPHP官网： </td>\r\n");
      out.write("       \t\t\t<td><a href=\"http://www.mycodes.net\" target=\"_blank\">http://www.mycodes.net</a></td>\r\n");
      out.write("      \t\t</tr>\r\n");
      out.write("     \t\t<tr>\r\n");
      out.write("\t\t    \t<td> 开发者社区： </td>\r\n");
      out.write("\t\t        <td><a href=\"http://www.mycodes.net\" target=\"_blank\">http://www.mycodes.net </a><em>（安装使用 模板交流 BUG反馈 意见建议）</em></td>\r\n");
      out.write("      \t\t</tr>\r\n");
      out.write("      \t\t<tr>\r\n");
      out.write("      \t\t\t<td> 贡献者： </td>\r\n");
      out.write("       \t\t\t<td>Wooyun.org, Pany, Tea</td>\r\n");
      out.write("      \t\t</tr>\r\n");
      out.write("      \t\t<tr>\r\n");
      out.write("       \t\t\t<td> 系统使用协议： </td>\r\n");
      out.write("       \t\t\t<td><a href=\"http://www.mycodes.net/license.jsp\" target=\"_blank\">http://www.mycodes.net/license.jsp</a><em>（您可以免费使用DouPHP（不限商用），但必须保留相关版权信息。）</em></td>\r\n");
      out.write("      \t\t</tr>\r\n");
      out.write("     \t</table>\r\n");
      out.write("   </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"clear\"></div>\r\n");
      out.write("\t<div id=\"dcFooter\">\r\n");
      out.write(" \t<div id=\"footer\">\r\n");
      out.write("    <div class=\"line\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div><!-- dcFooter 结束 -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"clear\"></div> </div>\r\n");
      out.write("<script src=\"http://www.mycodes.net/js/tongji.js\"></script>\r\n");
      out.write("<script src=\"http://www.mycodes.net/js/youxia.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
