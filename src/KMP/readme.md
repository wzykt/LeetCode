# KMP
字符串匹配的KMP算法，传统bp的时间复杂度是o（m*n），kmp的时间复杂度o（m+n），但是空间复杂度是o（n）

了解KMP，先了解两个概念："前缀"和"后缀"。 "前缀"指除了最后一个字符以外，一个字符串的全部头部组合；"后缀"指除了第一个字符以外，一个字符串的全部尾部组合。

以"ABCDABD"为例

    －　"A"的前缀和后缀都为空集，共有元素的长度为0；
    －　"AB"的前缀为[A]，后缀为[B]，共有元素的长度为0；
    －　"ABC"的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0；
    －　"ABCD"的前缀为[A, AB, ABC]，后缀为[BCD, CD, D]，共有元素的长度为0；
    －　"ABCDA"的前缀为[A, AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为"A"，长度为1；
    －　"ABCDAB"的前缀为[A, AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为"AB"，长度为2；
    －　"ABCDABD"的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为[BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为0。

重点就是获取部分匹配值表

以"ABCDABD"为例的分匹配值表 [0,0,0,0,1,2,0]，结合分匹配值表进行字符匹配

也可以使用下面两个字符串来进行举例，以BP和KMP

文本串：abcxabcdabxabcdabcdabcy

模式串：abcdabcy

