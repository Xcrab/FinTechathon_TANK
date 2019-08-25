# FinTechathon
微众区块链比赛

## 项目介绍
本作品旨在通过区块链构建排污权许可证交易平台，配合交易纠纷仲裁，黑名单监督审计等链上机制

## 本地开发方式
拉取`github`项目代码，在本地搭建区块链来进行开发和测试，推荐使用`WeBase`的[一键部署](https://webasedoc.readthedocs.io/zh_CN/latest/docs/WeBASE/install.html)整合底层链和区块链浏览器

1.使用IntellJ的IDEA打开

2.安装lombok插件

3.从部署的BCOS链下的`nodes/127.0.0.1/node0/conf/`拷贝ca.crt, node.crt, node.key替换main/resources

后台代码主要分为三个部分:

src/main/java/org/fisco/bcos/controller 编写控制器

src/main/java/org/fisco/bcos/server 编写业务逻辑，主要是通过Web3j和credentials进行合约部署和合约调用

src/main/java/org/fisco/bcos/contracts 存放智能合约（利用工具编译为java类）

前端代码存放在：src/main/webapp/WEB-INF/web


## 服务器开发方式
在服务器`/home/nas/`上下载了当前的项目文件，及配置了`WeBase`，可以在本地机器上通过`39.98.173.128:8099`访问`WeBase`进行区块查询、账户创建、合约编辑、编译和部署等操作。服务器上的`FinTechathon`及`WeBase`是一个整体的开发环境，即`WeBase`作为一条区块链方便`FinTechathon`进行开发和测试。

如果要编辑服务器上的`FinTechathon`代码，可以在本地直接通过配置`IDEA`的[`Remote server configuration`](https://www.jetbrains.com/help/idea/creating-a-remote-server-configuration.html)来对服务器上的代码进行编辑，在编辑前可以先创建好自己所需要的本地分支，开发完毕后再`merge`进去本地的`dev`分支即可(自行解决冲突)。
