
# zain
实验项目
struts2与spring不整合相互之间也能工作，但是整合之后可以将struts2中的对象交给spring容器管理，
否则struts2中的对象属性因为不在容器中而无法管理，不能自动注入从而导致空指针等常见异常
<h3>s1sh changelog</h3>
Hibernate4.3.X中，org.hibernate.service.jta.platform.spi.JtaPlatform类换成了：
org.hibernate.engine.transaction.jta.platform.spi.JtaPlatform;故使用hibernate 4.2.21.Final

ps:struts1只能兼容spring3，而spring3只支持hibernate到4，故采用版本struts 1.3.10+spring 3.2.17.RELEASE + hibernate 4.3.11.Final


<h5>version: 684706b464b1be37d99bea448586ef9a807292eb 2016-09-05 21:00:00</h5>
<h6>基于ActionProxy集成struts和spring 创建分支 struts1PlusSpringByActionProxy</h6><br>

<h5>version: c688551e7d6c5e970cd9bf486c5ad0214cf5a7b1 2016-09-05 20:30:00</h5>
<h6>基于RequestProcessor集成struts和spring，创建分支 struts1PlusSpringByRequestProcessor</h6><br>

<h5>version: eb4ca85281e8643c9ec0036b7f123e5bb1a4dd12 2016-09-05 16:51:00</h5>
<h6>基于ActionSupport集成struts和spring，创建分支 struts1PlusSpringByActionSupport</h6><br>


<h3>s2sh changelog</h3>
FilterDispatcher是struts2.0.x到2.1.2版本的核心过滤器.
StrutsPrepareAndExecuteFilter是自2.1.3开始就替代了FilterDispatcher