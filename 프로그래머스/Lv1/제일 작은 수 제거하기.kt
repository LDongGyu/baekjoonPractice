class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer = intArrayOf()
        var list = arr.toMutableList()
        arr.min()?.let { list.remove(it) }

        if(list.isEmpty()) answer = intArrayOf(-1)
        else answer = list.toIntArray()

        return answer
    }

//    fun solution(arr: IntArray): IntArray = if(arr.size == 1) arrayOf(-1).toIntArray()
//                                            else arr.filter { it != arr.min() }.toIntArray()
}

fun main() {
    var sol = Solution()

    print(sol.solution(intArrayOf(4,3,2,1)))
}