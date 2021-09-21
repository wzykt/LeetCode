# LeetCode
LeetCode刷题笔记

时间复杂度：以最差情况估计

##二分法
将排序好的数组分为蓝色区域和红色区域，满足ISBULE，蓝色区域边界来到m处，不满足，r来到
m处，不停二分来缩小范围，直到红蓝两区域相邻，最后根据结果来返回蓝色区域边界l或者红色区域边界r

典型代码:demo/_34
```java
//伪代码
{
    l = -1，r = N
    while l + 1≠r
      m = (l+r) /2
      if ISBLUE(m)
        l = m
      else
        r = m
    return l or r
}
