# 秒杀系统

参考 4.30 OkC:/ OTA架构师带你搭建高并发秒杀系统解决方案  https://v.douyin.com/YfnjMJK/ 复制此链接，打开Dou音搜索，直接观看视频！

# 业务场景

商品秒杀
商品抢购
群红包
抢优惠券
抽奖

# 业务特点

秒杀价格低
瞬时售空
定时上架
持续时间短

# 技术特点

读多写少
高并发
资源冲突

# 架构

### 应用层

浏览器点击频率限制 浏览器本地缓存

### 网络层 cdn

静态缓存 图片

### 负载层 网关

- nginx 负载均衡、动静分离 反向代理
    - [nginx限流](https://blog.csdn.net/lt326030434/article/details/122989403)
- 漏桶
- 令牌 limit_req
- guava.rateLimte
max_connection
- 

### 服务层
锁

### 数据库




