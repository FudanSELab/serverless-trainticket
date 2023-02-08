# Serverless TrainTicket

[TrainTicket](https://github.com/FudanSELab/train-ticket) 是复旦大学 CodeWisdom 团队按照工业界微服务实践所开发的一个开源微服务基准系统，是基于微服务架构的一个火车订票系统，包含了 41 种微服务。本项目使用开源函数计算框架 OpenFaaS、基于 Serverless 架构提取并改造开源微服务系统 TrainTicket 中高并发的订票业务，部署并运行在 Kubernetes 集群中。主要使用的开发技术框架如下：

- Java - OpenFaaS、OkHttp、*Spring Boot
- DB - MongoDB、MongoBD JDBC



## 快速开始

本项目基于 Kubernetes 集群并使用开源函数计算框架 OpenFaaS 来部署我们的 Serverless TrainTicket 系统。

### 先决条件

由于本项目选择Kubernetes 来构建 OpenFaaS 的 Serverless 平台，因此你需要至少两台服务器以构建 Kubernetes 集群。[集群部署教程](https://blog.csdn.net/lbw520/article/details/96446272)

#### 服务器系统要求

- CPU和内存：双核，4GB以上。
- 操作系统：基于x86_64的各种Linux发行版，包括CentOS，Federa，Ubuntu等，但内核要求在3.10及以上。
- 容器运行时：一般情况下使用Docker作为容器运行时。

### 1. 登录Docker Hub

```shell
docker login -u <username> -p <password>
```

### 2. 安装NFS

详细步骤参考[该链接](https://qizhanming.com/blog/2018/08/08/how-to-install-nfs-on-centos-7)，本项目中master节点为nfs服务端、所有node节点为nfs客户端，挂载路径为`/var/nfs/data/`。

### 2. 安装OpenFaaS

详细步骤参考[OpenFaaS官方文档](https://docs.openfaas.com/deployment/kubernetes/)。官方提供了三种安装OpenFaaS的方法，建议使用 helm（arkade不够成熟，yaml文件支持定制自定义安装方案但过于繁琐）。

### 3. 克隆项目仓库

```sh
git clone https://github.com/GitHubDiom/serverless-trainticket
```

### 4. 手动下载OpenFaaS的Java8模板


```shell
cd serverless_trainticket/

# 新版OpenFaaS取消了对Java8的模板支持，这里手动下载旧版的Java8模板
wget https://github.com/openfaas/templates/archive/refs/tags/1.9.0.tar.gz
tar -zxvf 1.9.0.tar.gz
mv templates-1.9.0/template ./
rm -rf *1.9.0*
```

### 5. 执行数据库自动部署脚本文件
```shell
export MASTER_IP=<master_ip_addr> # master节点的IP地址
export DOCKER_USERNAME=<docker_username> # dockerhub的用户名
```

```shell
# 部署数据库
chmod u+x part01_DataBaseDeployment.sh
./part01_DataBaseDeployment.sh
```

运行 `kubectl get pods`和`kubectl get pods -n openfaas-fn` 等待所有数据库初始化函数 Pods 都是 Ready 状态，再运行以下命令

```shell
# 数据内容初始化
chmod u+x part01_DataInitiation.sh
./part01_DataInitiation.sh
```

### 6. 执行后端自动部署脚本文件

```shell
# BaaS服务部署
chmod u+x part02_BaaSServices.sh
./part02_BaaSServices.sh
```

```shell
# FaaS函数部署
chmod u+x part02_FaaSFunctions.sh
./part02_FaaSFunctions.sh
```

### 7. 执行前端自动部署脚本文件

```shell
# 前端部署
chmod u+x part03_Frontend.sh
./part03_Frontend.sh
```

### 8. 运行 `kubectl get pods --all-namespaces` 等待所有 Pods 都是 Ready 状态

### 9. 访问 Serverless TrainTicket 主页 http://[Node-IP]:32677


