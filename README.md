# limit-manager

## 需求

+ 独立完成基于java spring boot的项目，开发工具可以用IntelliJ，包含文档说明、源码、测试用例。
+ 功能： 实现一个额度管理功能，模拟多用户进行不同类型额度申请、扣减的功能。
+ 具体包括初始化额度、增加额度、扣减额度、查询额度，用例和代码需要包含额度管理模块、模拟多用户操作的定时任务代码、测试用例。
+ db可以用sqlite或者mysql。

### 1. 额度管理模块

+ 支持多个额度账户管理
+ 支持额度（double类型即可）
    + 初始化
    + 增加
    + 扣减
    + 查询

### 2. 定时任务功能

+ 定时进行对额度操作
+ 模拟多用户发起

### 3. 测试用例

+ 覆盖管理额度管理功能

## 项目概览

### 1. 运行环境

1. `java -version`
    + java version "1.8.0_152"
    + Java(TM) SE Runtime Environment (build 1.8.0_152-b16)
    + Java HotSpot(TM) 64-Bit Server VM (build 25.152-b16, mixed mode)
2. `sqlite3 -version`
    + 3.39.5 2022-10-14 20:58:05 554764a6e721fab307c63a4f98cd958c8428a5d9d8edfde951858d6fd02daapl

### 2. 核心类

+ `org.example.service.LimitService` 额度管理模块接口
+ `org.example.service.impl.LimitServiceImpl` 额度管理模块实现类
+ `org.example.service.LimitServiceTest` 额度管理模块测试类
+ `org.example.job.TimedJob` 模拟多用户操作的定时任务