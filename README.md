### _3

1.创建一个set

2.两个指针,第一个指向字符串的开头-j，第二个随着for循环遍历字符串-i

3.如果set里没有s[i]，说明目前为止还没有重复的字符，把s[i]添加到set里,然后更新最大不重复字符的数量。

4.如果set里有s[i]，则从set里开始删除s[j],并且递增j，再检查set里是否有s[i],如此反复直到set里没有si]为止。

5.重复步骤3和4，直到遍历完整个字符串

### _328

参考图片理解

![image-20211124214111820](https://gitee.com/kisstt/typora/raw/master/img/image-20211124214111820.png)

### _5

1.如果字符串长度小于2，直接返回原字符串

2.定义两个变量，一个start存储当前找到的最大回文字符串的起始位置，另一个maxLength记录字符串的长度(终止位置就是start+maxLength

3.while循环，判断左边和右边是否越界，同时最左边的字符是否等于最右边的字符。如果以上3个三个条件都满足，则判断是否需要更新回文字符串最大长度及最大字符串的起始位置。然后将left--,right++，继续判断，直到不满足三个条件之一。

4.遍历字符串，每个位置调用while循环判断两遍，第—遍检查i-1,i+1，第二遍检查i,i+1

(为什么要检查2遍?)字符串可能是单数或者双数
