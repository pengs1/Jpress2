# JPress文档



## 开始
演示站点：[http://www.yangfuhai.com](http://www.yangfuhai.com) （也是作者博客）

JPress官网：[http://jpress.io](http://jpress.io) 

### 简介
JPress，一个wordpress的java代替版本，使用JFinal开发。支持类似wordpress的几乎所有功能，比如：模板，插件等。同时在模板上，JPress提出了“模板即模型”的概念，方便模板制作人灵活制作业务模型，移除了widget等繁杂功能，同时在模板和插件制作上比wordpress更加灵活简洁。

但是，JPress又不是wordpress的java版本，它天生融合了微信公众平台，整合了国内众多云平台、短信发送、邮件发送平台，独创的“模板即模型”概念是wordpress所不具备的，只有资深的wordpress玩家才能体会里面的微妙关系。同时后续会添加微信文章同步，QQ公众平台，今日头条，一点资讯等新媒体的文章同步功能，更加国产和本地化。


### 下载
目前JPress托管在github和git.oschina.net上，网址分别是：

* [https://github.com/JpressProjects/jpress](https://github.com/JpressProjects/jpress)
* [http://git.oschina.net/fuhai/jpress](http://git.oschina.net/fuhai/jpress)

可以通过以上网址查看JPress的更新情况。

目前下载可以进入以上两个网站直接通过浏览器下载ZIP压缩包，也可以通过以下git命令下载到本地。

<center> `git clone https://github.com/JpressProjects/jpress.git` </center>
或
<center> `git clone https://git.oschina.net/fuhai/jpress.git` </center>


## 部署
### 环境配置

#### JAVA环境配置
目前假定您已经配置好了JAVA环境，若不会配置JAVA环境，请自行通过搜索引擎搜索相关知识。

#### Maven环境配置
暂略...

### JPress安装

#### tomcat安装
暂略...

#### JPress安装
如果您已经在您的服务器配置好了相关应用，比如tomcat，nginx等，就可以进行JPress安装了。

主要有一下三个步骤：

##### 第1步：生成war包
下载到本地后，进入jpress-web目录，执行`mvn package`命令，稍等片刻，命令执行完毕后会在jpress-web目录生成一个jpress-web-1.0.war的war包（可能今后jpress升级后，版本可能不是1.0了），拷贝war包放到tomcat的webapp目录下即可运行。

##### 第2步：拷贝war到tomcat并运行
拷贝第一个生成的war包到tomcat的webapp目录，启动tomcat。

##### 第3步：浏览器访问tomcat，进行配置
当jpress第一次运行的时候，jpress会去检测`class path`目录下是否有db.properties数据库配置文件，如果没有该文件，证明jpress是第一次运行。当浏览器访问jpress时，jpress会自动跳转到安装页面，让用户进行安装。


#### JPress安装注意事项
1. JPress要求数据库 ***必须*** 在5.5以上，建议最好是`5.6`或`5.6以上`。
2. JPress在安装的过程中，需要用用户自己创建好数据库，JPress在安装的过程中只做建表工作。


## 后台管理

### 进入后台
当JPress安装完毕后，访问 `http://yoursite.com/admin`（本地：`http://127.0.0.1/admin`），输入安装配置的账号密码，即可进入管理后台。

### 内容发布
### 网站配置
#### 常规
#### 评论
#### 通知
#### SEO
#### 水印
#### 连接形式

### 微信相关

#### 自动回复
#### 默认回复
#### 菜单设置
#### 微信配置



## 模板开发

###开发一个模板的helloworld

如果您是新手，可以先看下视频教程 ： [http://www.yangfuhai.com/post/22.html](http://www.yangfuhai.com/post/22.html)

开发一个全新的模板，主要有以下几个步骤：
> 1. 建立模板配置文件 tpl_config.xml，用来说明模板的作者和模型。
> 2. 建立一个tpl_screenshot.png图片，用来在JPress后台显示模板截图。
> 3. 建立index.html 用来显示网站首页。

###模板结构
JPress的模板主要分为如下几类：
> * 首页模板  (index.html)
> * 分类页面模板 (taxonomy.html)
> * 详情页模板 (content.html)
> * 错误页模板 (404.html)
> * 用户中心模板 (user_*.html)
> * 搜索结果模板 (search.html)


JPress的模板结构大概如下：

```
index.html
taxonomy.html
content.html
404.html
user_center.html
user_detail.html
user_login.html
user_register.html
page_test.html
tpl_config.xml
tpl_screenshot.png
tpl_setting.html
```

* **index.html** 首页
* **404.html** 404页面，当JPress有404错误的时候会渲染此页面。
* **content.html** 详情页，文章、论坛、商城等详情内容会调用此页面进行渲染。同时，content.html 可以扩展为例如：`content_article.html`、`content_bbs.html`、`content_article_blog.html`、`content_article_music.html` 等。扩展的规则为：`content_module_style.html` 其中的module为模型的名称，style为样式。当模板有文件有多个样式的时候，在发布内容（比如：文章）的时候会有一个样式的选择。当用户发布了内容，选择的样式为blog，那么，JPress会自动去找`content_article_blog.html`的页面进行渲染，若当模板中由于某些原因（比如：更改了模板）导致`content_article_blog.html`不存在了，JPress会自动去找`content_article.html`渲染，若`content_article.html` 也不存在了，JPress会自动找 `content.html`渲染，若`content.html`也不存在了，JPress会报404错误。
* **taxonomy.html** 分类页，和content.html一样，也可以扩展作为`taxonomy_article.html` 、`taxonomy_bbs.html`、`taxonomy_article_news.html`、`taxonomy_article_xxx.html` 等。其中，taxonomy.html的扩展规则为：`taxonomy_module_slug.html`,其中module为模型，slug为后台填写。
* **user_center.html** 用户中心
* **user_detail.html** 用户详情
* **user_login.html** 用户注册
* **user_register.html** 用户登录
* **page_test.html** 当访问`http://www.xxx.com/test`的时候回调用这个文件渲染。

其中以tpl_开头的是模板的系统文件。

* **tpl_screenshot.png** 模板缩略图
* **tpl_setting.html** 模板设置文件，后台的模板设置功能将会调用这个页面进行渲染。
* **tpl_config.xml** 模板配置文件



其中最为重要的是 **tpl_config.xml** 文件，tpl_config.xml是模板的核心配置文件，大概内容如下：

```
<?xml version="1.0" encoding="UTF-8"?>
<config>
	<infos>
		<title>JBlog</title>
		<id>JBlog</id>
		<description>JBlog是JPress内置的博客模板，后续会持续升级。</description>
		<author>jpress</author>
		<authorWebsite>http://www.jpress.io</authorWebsite>
		<version>v1.0</version>
		<versionCode>1</versionCode>
		<updateUrl>http://www.jpress.io</updateUrl>
	</infos>

	<module title="文章" name="article" list="所有文章" add="撰写文章" comment="评论">
		<taxonomy title="分类" name="category" formType="select" />
		<taxonomy title="专题" name="feature" formType="select" />
		<taxonomy title="标签" name="tag" formType="input" />
		
		<metadata dataType="input" name="_meta1" text="元数据1"  placeholder="元数据测试1"/>
		<metadata dataType="input" name="_meta2" text="元数据2"  placeholder="元数据测试2"/>
	</module>

	<module title="页面" name="page" list="所有页面" add="新建页面" comment="评论">
	</module>

	<thumbnail name="t1" size="780 x 240" />
	<thumbnail name="t2" size="240 x 140" />
	<thumbnail name="t3" size="600 x 300" />
	<thumbnail name="t4" size="300 x 300" />

</config>
```
* infos 标签是模板的基本信息，其中id是整个JPress系统中具有唯一性，如果系统已经有了该ID，则这个模板无法安装成功。
* module 是JPress的“模板即模型”设计的设计理念的基本体现，在模板中有多少个模型，后台的管理就有多个模型的菜单管理。同时，module中的name属性在同一个模板中是具有唯一性的。
* thumbnail 是缩略图，name是缩略图的名称，size是缩略图的大写。模板配置好缩略图后，当用户或管理员上传图片，图片会被剪切成模板定义的缩略图。

###模板标签
目前JPress提供的有如下标签，今后会一直更新，所以标签有可能一直在增加或修改：

```
IndexPageTag
ContentPageTag
CommentPageTag
ContentsTag
TaxonomysTag
TagsTag
UsersTag
UserContentPageTag
ModulesTag
MenuTag
ImageTag
```
其中：

* **IndexPageTag** 用于在首页或单页面，即 index.html模板或page_*.html模板
* **ContentPageTag** 内容列表页，也就是分类页，即taxonomy.html 或 taxonomy_*.html
* **CommnetPageTag** 评论分页列表，只能用在内容详情页。即content.html 或 content_*.html
* **UserContentPageTag** 用户内容列表，只能用户用户中心，用来显示用户`发布的`、`收藏的`和`评论的`内容。
* **ContentsTag** 文本列表（没有分页），可以用于任何页面
* **UsersTag** 用户列表（没有分页），可以用于任何页面
* **MenuTag** 网站菜单，可以用于任何页面
* **TaxonomysTag** 分类列表，可以用于任何页面
* **TagsTag** 标签列表，可以用于任何页面

###标签的使用

####IndexPageTag

IndexPageTag标签 只能用在首页即index.html和单页即page_*.html。

代码如下：

```
<@indexPage module="article"> 
	<#list page.getList() as content>
		<a href="${content.url}">${content.title}</a> <br />
	</#list>
	
	<@pagination>
		<#list pageItems as pItem>
			<a href="${pItem.url}">${pItem.text}</a>
		</#list>
	</@pagination>
</@indexPage>
```


代码解释：
> * \<@indexPage> </@indexPage> 是 **IndexPageTag** 标签的开头和结尾。
> * <#list> </#list> 是循环标签，会循环输出 **指定列表** 的所有内容，此标签属于freemarker模板引擎的自带标签。
> * \<@pagination> </@pagination> 是 **IndexPageTag** 标签的 **子标签**，用于显示 **页码** 列表。

indexPage标签属性：
> * module ： 指定读取模型的内容。在如上代码中`module="article"`表示读取article模型的内容。
> * pagesize ： 指定每页显示的条数，默认为10。
> * orderby ： 指定当前页面数据的排序方式，根据什么来排序。

备注：
> JPress的标签体系基于freemarker模板引擎的标签，


#### ContentPageTag 

ContentPageTag标签 和 IndexPageTag标签 的用法完全一样，唯一的区别是：
ContentPageTag标签 只能在分类页使用，即只能在taxonomy.html 或 taxonomy_*.html上使用。

ContentPageTag标签支持的属性如下：
> * pagesize ： 每页显示的条数
> * orderby ：排序的字段或方法

#### UserContentPageTag 
UserContentPageTag标签 和 IndexPageTag标签 的用法完全一样，唯一的区别是：
UserContentPageTag标签 只能在用户中心使用，用于显示**登陆用户**的文章。

UserContentPageTag标签支持的属性如下：
> * pagesize ： 每页显示的条数
> * orderby ：内容列表排序的字段或方法
> * module ：指定 **登陆用户** 发布的内容列表模型
> * taxonomyid ：指定 **登陆用户** 发布的内容列表的类型ID 或 tagId
> * status ： 指定 **登陆用户** 发布的内容列表的状态

#### CommnetPageTag
CommnetPageTag标签用于显示内容的回复列表（或叫评论列表），只能在内容详情页面使用，即只能在content.html 或 content_*.html 上使用。

CommnetPageTag标签支持的属性如下：
> * pagesize ： 每页显示的条数。



#### ContentsTag
文章列表标签，可以在任意页面使用此标签。此标签不带分页功能。

代码如下：

```
<@jp_contents module="article" count="3" orderby="comment_count" hasThumbnail="true"> 
	<#list contents as content>
		<a href="${content.url}">${content.title}</a> <br />
	</#list> 
</@jp_contents>
```

代码解释：
> * `module="article"` 表示内容列表为`article`模型的内容。
> * `count="3"` 表示内容列表的数量为3条内容。
> * `orderby="comment_count"` 表示内容列表根据`comment_count`字段排序。
> * `hasThumbnail="true"`表示内容列表必须有缩略图。

ContentsTag标签支持的属性如下：
> * module ：指定内容列表的模型
> * style ： 指定内容列表的样式。
> * flag ： 指定内容列表的flag标示。
> * userid ： 指定内容列表的用户，即哪个用户发布的内容。
> * parentid ： 
> * hasThumbnail ：指定内容列表是否必须包含或不包含缩略图。
> * tag ： 指定哪个tag的内容列表。
> * typeslug ：指定哪个分类下的内容列表。通过分类的slug来指定。
> * typeid ： 指定哪个分类下的内容列表。通过分类的id来指定。
> * keyword ： 指定哪个关键字的内容列表。
> * orderby ： 指定内容列表的排序方式。
> * count ： 指定内容列表的总数量。


#### TaxonomysTag
#### TagsTag
#### UsersTag

#### MenuTag
网站菜单的标签。可以在任意页面使用，用于显示网站菜单导航。

代码如下：

```
<@jp_menu>
	<#list menus as menu>
		<li >
	        <a  href="${menu.url!}">
	        	${menu.title!}
        		<#if menu.isActive() >
        			<span class="x-a-border"></span>
        		</#if>
        	</a>
       </li>
	</#list>
</@jp_menu>
```
代码解释：

```
<#if menu.isActive() >
	<span class="x-a-border"></span>
</#if>
```
这段代码表示当前页面是否属于该菜单下的内容，如果属于该菜单，则输出`<span class="x-a-border"></span>`，不属于则不输出。常用来显示导航高亮。

###模板设置

## 插件开发
### helloworld
### 规范
### 钩子

## 高级
### 二次开发
### 数据库操作

## 关于
### 开发者
### JPress