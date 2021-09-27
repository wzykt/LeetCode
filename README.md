# LeetCode
LeetCode刷题笔记

###审题
先把可能出现的情况尽可能想出来，有些题目例子给的情况并不一定是全的，根据参照给的例子写的代码，不一定能AC。

###时间复杂度
以最差情况估计

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
```

## 函数
Arrays.sort(数组, lamaba表达式  eg:(v1, v2) -> v1[0] - v2[0]);

System.arraycopy() 和 Arrays.copyOf(),复制数组，可以用来复制指定长度的数组，可以用来剔除数组中无关的值